package fyp.colorswitch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.entity.obstacle.Obstacle;
import fyp.colorswitch.gfx.GameCamera;
import fyp.colorswitch.input.KeyManager;
import fyp.colorswitch.input.MouseManager;
import fyp.colorswitch.state.State;

public class Handler implements ActionListener {

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

	@Override
	public void actionPerformed(ActionEvent event) {
		//State.setState(getGame().gameState);
	}

}
