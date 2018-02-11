package fyp.colorswitch.entity.obstacle;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;

public class Line {
	
	
	private int color;
	private float xStart, xEnd, yStart, yEnd;
	
	public Line(float xStart, float yStart, float xEnd, float yEnd, int color) {
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.color = color;
	}

	
	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
	}

	public boolean collidesWith(Double body, int bodyColor) {
		
		return false;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	public float getxStart() {
		return xStart;
	}


	public void setxStart(float xStart) {
		this.xStart = xStart;
	}


	public float getxEnd() {
		return xEnd;
	}


	public void setxEnd(float xEnd) {
		this.xEnd = xEnd;
	}


	public float getyStart() {
		return yStart;
	}


	public void setyStart(float yStart) {
		this.yStart = yStart;
	}


	public float getyEnd() {
		return yEnd;
	}


	public void setyEnd(float yEnd) {
		this.yEnd = yEnd;
	}

}
