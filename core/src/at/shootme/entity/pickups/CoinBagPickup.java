package at.shootme.entity.pickups;

import at.shootme.SM;
import at.shootme.entity.general.SimpleDrawableEntity;
import at.shootme.entity.player.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import static at.shootme.SM.world;
import static at.shootme.ShootMeConstants.METERS_TO_PIXELS;
import static at.shootme.ShootMeConstants.PIXELS_TO_METERS;

/**
 * Created by Steffi on 04.02.2018.
 */
public class CoinBagPickup extends SimpleDrawableEntity implements Pickup{

    public static final Vector2 SIZE = new Vector2(90, 90).scl(PIXELS_TO_METERS);
    public static final int SCORE_PER_GOLDBAG = 500;
    private Sound pickupSound = Gdx.audio.newSound(Gdx.files.internal("assets/coinBagPickup.wav"));

    public CoinBagPickup(Vector2 position) {
        sprite = new Sprite(SM.textureStore.getOrLoadTexture("assets/goldbag.png"));
        sprite.setSize(SIZE.cpy().scl(METERS_TO_PIXELS).x, SIZE.cpy().scl(METERS_TO_PIXELS).y);
        sprite.setOriginCenter();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        bodyDef.position.set(position.x, position.y);

        body = world.createBody(bodyDef);
        body.setUserData(this);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(SIZE.x / 2, SIZE.y / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        fixture = body.createFixture(fixtureDef);
        shape.dispose();
    }

    @Override
    public void pickedUpBy(Player player) {
        if (SM.isClient() && SM.gameScreen.getPlayer() == player) {
            player.setScore(player.getScore() + SCORE_PER_GOLDBAG);
        }
        if (SM.isClient()) pickupSound.play();
        SM.level.queueForRemoval(this);
    }

    @Override
    protected void finalize() throws Throwable {
        pickupSound.dispose();
        super.finalize();
    }
}
