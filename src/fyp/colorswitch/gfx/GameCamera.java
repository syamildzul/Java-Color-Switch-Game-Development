package fyp.colorswitch.gfx;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class GameCamera {
	
	private Handler handler;
	private float yOffset; 
	private float lowerLine, midLine;
	
	public GameCamera(Handler handler, float yOffset) {
		this.handler = handler;
		this.yOffset = yOffset;
		lowerLine = handler.getHeight();
		midLine = lowerLine - handler.getHeight() / 2;
	}

	// cette méthode va mettre l'entité e (joueur) toujours en millieu
	public void updatePlayerView(Entity e) {
		yOffset = e.getyPosition() - handler.getHeight() / 2;
		
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
