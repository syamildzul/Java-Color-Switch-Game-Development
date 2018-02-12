package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;

public class Circle extends Obstacle {

	private static final int DEFAULT_CIRCLE_DIAMETER = 200;
	private static final int DEFAULT_CIRCLE_THICKNESS = 15;
	private static final int DEFAULT_CIRCLE_ANGULARSPEED = 1;
	
	private int diameter = DEFAULT_CIRCLE_DIAMETER;
	private int angularSpeed = DEFAULT_CIRCLE_ANGULARSPEED;
	private int thickness;
	private double currentAngle;
	private int c1, c2, c3, c4;
	
	private Arc2D a1, a2, a3, a4;
	
	public Circle(Handler handler, float y, int diameter, int angularSpeed) {
		super(handler, y - diameter / 2);
		x = midPos - diameter / 2;
		this.diameter = diameter;
		this.thickness = DEFAULT_CIRCLE_THICKNESS;
		this.currentAngle = 0;
		this.angularSpeed = angularSpeed;
		this.c1 = 0;
		this.c2 = 0;
		this.c3 = 0;
		this.c4 = 0;
	}
	
	public void updateAngle() {
		currentAngle = (currentAngle + angularSpeed) % 360;
	}

	@Override
	public void tick() {
		updateAngle();
	}
	
	@Override
	public void render(Graphics2D g) {
		int xPos = (int) x;
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		g.setStroke(new BasicStroke((float) thickness));
		
		g.setColor(Obstacle.colors[0]);
		c1 = 0;
		a1 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle, 90, 0);
		g.draw(a1);
		
		g.setColor(Obstacle.colors[1]);
		c2 = 1;
		a2 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle + 90, 90, 0);
		g.draw(a2);
		
		g.setColor(Obstacle.colors[2]);
		c3 = 2;
		a3 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle + 180, 90, 0);
		g.draw(a3);
		
		g.setColor(Obstacle.colors[3]);
		c4 = 3;
		a4 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle + 270, 90, 0);
		g.draw(a4);
		
		g.setStroke(new BasicStroke(1));
		
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getAngularSpeed() {
		return angularSpeed;
	}

	public void setAngularSpeed(int angularSpeed) {
		this.angularSpeed = angularSpeed;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public double getCurrentAngle() {
		return currentAngle;
	}

	public void setCurrentAngle(double currentAngle) {
		this.currentAngle = currentAngle;
	}

	@Override
	public boolean collidesWith(Double body, int bodyColor) {
		return false;
	}
	
}
