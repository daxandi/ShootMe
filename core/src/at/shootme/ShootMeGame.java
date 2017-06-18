package at.shootme;

import at.shootme.state.data.GameState;
import at.shootme.state.data.GameStateType;
import com.badlogic.gdx.Game;

public class ShootMeGame extends Game {

    public ShootMeGame() {
        SM.game = this;
    }

    @Override
    public void create() {
        GameState gameState = new GameState();
        gameState.setStateType(GameStateType.LEVEL_SELECTION);
        SM.gameStateManager.apply(gameState);
    }

}
