package fyp.colorswitch.gfx;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class GameCamera {
	
	private Handler handler;
	private float yOffset, obsyOffset;
	private float lowerCheck;
	
	public GameCamera(Handler handler, float yOffset) {
		this.handler = handler;
		this.yOffset = yOffset;
		this.obsyOffset = yOffset;
		lowerCheck = handler.getHeight() - 300;
	}

	public void updatePlayerView(Entity e) {
		yOffset = e.getyPosition() - handler.getHeight() / 2;
		/*
		if(e.getyPosition() >= handler.getHeight() / 2) {
			yOffset = e.getyPosition() - handler.getHeight() / 2;
		}
		if(e.getyPosition() <= handler.getHeight() / 2) {
			
		}
		*/
	}
	
	public void updateObsracleView(Entity e) {
		obsyOffset = yOffset;
	}
	
	public float getObsyOffset() {
		return obsyOffset;
	}

	public void setObsyOffset(float obsyOffset) {
		this.obsyOffset = obsyOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
