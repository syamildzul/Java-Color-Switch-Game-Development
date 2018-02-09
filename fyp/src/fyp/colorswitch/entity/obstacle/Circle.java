package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
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
	private int color;
	
	private Arc arc1, arc2, arc3, arc4;
	
	public Circle(Handler handler, float y, int diameter, int angularSpeed) {
		super(handler, y - diameter / 2);
		x = midPos - diameter / 2;
		this.diameter = diameter;
		this.thickness = DEFAULT_CIRCLE_THICKNESS;
		this.currentAngle = 0;
		this.angularSpeed = angularSpeed;
	}
	
	public void updateAngle() {
		currentAngle = (currentAngle + angularSpeed) % 360;
	}

	@Override
	public void tick() {
		updateAngle();
		//updateyPosition();
		//System.out.println(yPosition);
	}
	
	@Override
	public void render(Graphics2D g) {
		int xPos = (int) x;//( (handler.getWidth() / 2) - (diameter / 2) );
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		g.setStroke(new BasicStroke((float) thickness));
		/*
		arc1 = new Arc(handler, yPos, diameter, currentAngle, 0);
		arc2 = new Arc(handler, yPos, diameter, currentAngle + 90, 1);
		arc3 = new Arc(handler, yPos, diameter, currentAngle + 180, 2);
		arc4 = new Arc(handler, yPos, diameter, currentAngle + 270, 3);
	
		
		arc1.render(g);
		arc2.render(g);
		arc3.render(g);
		arc4.render(g);
		*/
		g.setColor(Obstacle.colors[0]);
		g.drawArc(xPos, yPos, diameter, diameter, (int) currentAngle, 90);
		g.setColor(Obstacle.colors[1]);
		g.drawArc(xPos, yPos, diameter, diameter, (int) currentAngle + 90, 90);
		g.setColor(Obstacle.colors[2]);
		g.drawArc(xPos, yPos, diameter, diameter, (int) currentAngle + 180, 90);
		g.setColor(Obstacle.colors[3]);
		g.drawArc(xPos, yPos, diameter, diameter, (int) currentAngle + 270, 90);
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
