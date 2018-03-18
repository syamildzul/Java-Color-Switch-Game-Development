package fyp.colorswitch.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import fyp.colorswitch.Handler;

public abstract class UIObject {
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	private Handler handler;
	
	public UIObject(Handler handler, float y, int width, int height) {
		this.handler = handler;
		this.x = handler.getWidth() / 2 - width / 2;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(), e.getY()))
			hovering = true; // boolean flottant est vrai 
		else 
			hovering = false;
	}
	
	public void onMouseRelease(MouseEvent e) {
		if(hovering)
			onClick();
	}
	
	// GETTERS & SETTERS
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
}
