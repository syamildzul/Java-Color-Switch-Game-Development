package fyp.colorswitch.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import fyp.colorswitch.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x, yPosition;
	protected Rectangle bounds;
	protected float midPos;
	protected float position;
	
	// Turquoise, Vivid Yellow, Electric Violet, Bright Pink
    public static final Color colors[] = {new Color(50, 226, 241),
        new Color(244, 222, 14), new Color(140, 18, 251), new Color(255, 0, 128)};
	
	public Entity(Handler handler, float yPosition) {
		this.handler = handler;
		this.yPosition = yPosition;
		this.midPos = handler.getWidth() / 2;
		this.x = midPos;
		//bounds = new Rectangle(0, 0, width, height);
	}
	
	public void renderCamera(Graphics2D g, int yOffset) {
		
	}
	
	// Abstract functions
	
	public abstract void tick();
	public abstract void render(Graphics2D g);
	public abstract boolean collidesWith(Ellipse2D.Double body, int bodyColor);
	
	// Getters & Setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return yPosition;
	}

	public void setY(float y) {
		this.yPosition = y;
	}

}
