package fyp.colorswitch;

import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.entity.obstacle.Obstacle;
import fyp.colorswitch.gfx.GameCamera;
import fyp.colorswitch.input.KeyManager;
import fyp.colorswitch.input.MouseManager;

public class Handler {

	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
}
