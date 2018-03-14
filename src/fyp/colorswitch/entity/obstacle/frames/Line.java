package fyp.colorswitch.entity.obstacle.frames;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Line extends Line2D{
	
	private int color;
	private float xStart, xEnd, yStart, yEnd, yPosition;
	
	private Handler handler;
	private Line2D line;
	
	public Line(Handler handler, float yPosition, float xStart, float yStart, float xEnd, float yEnd, int color) {
		this.handler = handler;
		this.yPosition = yPosition; // y coordinate of the center of rotation
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.color = color;
		
		line = new Line2D.Double(xStart, yStart, xEnd, yEnd);
	}

	public void tick() {
		
	}
	
	int theta = 0;
	public void render(Graphics2D g) {
		//int xPos = (int) x;
		//int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(20));
		g2d.setColor(Entity.colors[color]);
		
		g2d.rotate(Math.toRadians(theta), handler.getWidth()/2, yPosition);
		g2d.draw(line);
		g2d.dispose();
		theta++;

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

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		
	}

}
