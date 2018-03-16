package fyp.colorswitch.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import fyp.colorswitch.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x, yPosition;
	protected float midPos;
	protected int width;
	
	// Turquoise, Vivid Yellow, Electric Violet, Bright Pink
    public static final Color colors[] = {new Color(50, 226, 241),
        new Color(244, 222, 14), new Color(140, 18, 251), new Color(255, 0, 128)};
	
	public Entity(Handler handler, float yPosition, int width) {
		this.handler = handler;
		this.yPosition = yPosition;
		this.width = width;
		this.midPos = handler.getWidth() / 2;
		this.x = midPos;
	}
	
	// Abstract functions
	
	public abstract void tick();
	public abstract void render(Graphics2D g);
	public abstract boolean collidesWith(Ellipse2D.Double body, int bodycolor);

	// Getters & Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getyPosition() {
		return yPosition;
	}

	public void setyPosition(float yPosition) {
		this.yPosition = yPosition;
	}

	public float getMidPos() {
		return midPos;
	}

	public void setMidPos(float midPos) {
		this.midPos = midPos;
	}

	public static Color[] getColors() {
		return colors;
	}

	
	

}
