package at.shootme.levels;

import at.shootme.ShootMeConstants;
import at.shootme.entity.level.Background;
import at.shootme.entity.level.Platform;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Alexander Dietrich on 05.05.2017.
 */
public class LevelUtility implements ShootMeConstants {


    /**
     * Creates a platform
     * @param position
     * @param size
     * @param texture
     * @param world
     * @return
     */
    public static Platform createPlatform(Vector2 position, Vector2 size, Texture texture, World world) {
        return new Platform(position, size, texture, world);
    }

    /**
     * Creates a level background.
     * @param position
     * @param size
     * @param texture
     * @return
     */
    public static Background createLevelBackground(Vector2 position, Vector2 size, Texture texture) {
        return new Background(position, size, texture);
    }

}
