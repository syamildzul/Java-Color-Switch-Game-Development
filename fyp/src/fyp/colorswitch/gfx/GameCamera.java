package fyp.colorswitch.gfx;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class GameCamera {
	
	private Handler handler;
	private float yOffset;
	
	public GameCamera(Handler handler, float yOffset) {
		this.handler = handler;
		this.yOffset = yOffset;
	}

	public void playerCamera(Entity e) {
		yOffset = e.getY() - handler.getGame().getHeight() / 2;
	}
	
	public void move(float yAmt) {
		yOffset -= yAmt;
	}
	
	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
