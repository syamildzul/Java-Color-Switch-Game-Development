package fyp.colorswitch.entity.obstacle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public abstract class Obstacle extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	
	protected float xMove, yMove, speed;
	
	public Obstacle(Handler handler, float yPosition, int width) {
		super(handler, yPosition, width);
		xMove = 0;
		yMove = 0;
		speed = DEFAULT_SPEED;
	}
	
	// Methods
	public void obstacleView(float yOffset) {
		
	}
	
	
	// GETTERS & SETTERS
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
}
