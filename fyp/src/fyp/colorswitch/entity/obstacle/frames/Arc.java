package fyp.colorswitch.entity.obstacle.frames;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.actor.Player;
import fyp.colorswitch.entity.obstacle.Obstacle;

public class Arc extends Arc2D {
	
	private int diameter, colorType;
	private double currentAngle, angularSpeed;
	private Arc2D arc;
	private int type = 0; // type 0 for drawArc | type 1 for fillArc
	private float x, yPosition;
	private Handler handler;
	
	public Arc (Handler handler, float yPosition, int diameter, double currentAngle, int color, int type) {
		this.handler = handler;
		this.x = handler.getWidth() / 2 - diameter / 2;
		this.yPosition = yPosition;
		this.diameter = diameter;
		this.currentAngle = currentAngle;
		this.colorType = color;
		this.angularSpeed = 1;
		this.type = type;
		arc = new Arc2D.Double(x, yPosition, diameter, diameter, (int) currentAngle, 90, type);
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		int xPos = (int) x;
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		arc.setArc(xPos, yPos, diameter, diameter, currentAngle, 90, 0);
		g.setStroke(new BasicStroke(20));
		g.setColor(Entity.colors[colorType]);
		if(type == 0)
			g.draw(arc);
		if(type == 1)
			g.fill(arc);
	}
	
	
	// Getters and Setters
	
	public int getColorType() {
		return colorType;
	}

	public void setColorType(int colorType) {
		this.colorType = colorType;
	}

	public boolean collidesWith(Double body, int bodycolor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getAngleExtent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAngleStart() {
		// TODO Auto-generated method stub
		return currentAngle;
	}

	@Override
	protected Rectangle2D makeBounds(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAngleExtent(double arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAngleStart(double arg0) {
		currentAngle = arg0;
		
	}

	@Override
	public void setArc(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
