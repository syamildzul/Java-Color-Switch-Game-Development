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

	public void centerOnEntity(Entity e) {
			yOffset = e.getyPosition() - handler.getHeight() / 2;
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
