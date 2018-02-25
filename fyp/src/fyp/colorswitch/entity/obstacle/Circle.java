package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Arc;

public class Circle extends Obstacle {

	private static final int DEFAULT_CIRCLE_DIAMETER = 200;
	private static final int DEFAULT_CIRCLE_THICKNESS = 15;
	private static final int DEFAULT_CIRCLE_ANGULARSPEED = 1;
	
	private int diameter = DEFAULT_CIRCLE_DIAMETER;
	private int angularSpeed = DEFAULT_CIRCLE_ANGULARSPEED;
	private int thickness;
	private double currentAngle;
	
	private ArrayList<Arc> lesArc;
	private Arc a1, a2, a3, a4;
	
	public Circle(Handler handler, float y, int diameter, int angularSpeed) {
		super(handler, y - diameter / 2);
		x = midPos - diameter / 2;
		this.diameter = diameter;
		this.thickness = DEFAULT_CIRCLE_THICKNESS;
		this.currentAngle = 0;
		this.angularSpeed = angularSpeed;
		
		lesArc = new ArrayList<Arc>();
		
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle, 0, 0));
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle + 90, 1, 0));
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle + 180, 2, 0));
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle + 270, 3, 0));
		
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
		
		lesArc.get(0).setAngleStart(currentAngle);
		lesArc.get(1).setAngleStart(currentAngle + 90);
		lesArc.get(2).setAngleStart(currentAngle + 180);
		lesArc.get(3).setAngleStart(currentAngle + 270);
		
		for (int i = 0; i < lesArc.size(); i++) {
			lesArc.get(i).render(g);
		}
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {
		for (int i = 0; i < 4; i++) {
			Arc currentArc = lesArc.get(i);
            Area playerArea = new Area(body);
            Area arcArea = new Area((Shape) currentArc);
            arcArea.subtract(new Area(new Ellipse2D.Double(x + thickness / 2, yPosition + thickness / 2, diameter - thickness, diameter - thickness)));
            playerArea.intersect(arcArea);
            if (!(playerArea.isEmpty() || currentArc.getColorType() == color)) {
            	System.out.println("there's a collision");
                return true;
            } 	
		}
		
		return false;
	}
	
	
	
	
	
	
	// Getters and Setters
	
	public int getAngularSpeed() {
		return angularSpeed;
	}

	public void setAngularSpeed(int angularSpeed) {
		this.angularSpeed = angularSpeed;
	}

	public double getCurrentAngle() {
		return currentAngle;
	}

	public void setCurrentAngle(double currentAngle) {
		this.currentAngle = currentAngle;
	}

	
	
	/*
	 * int xPos = (int) x;
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		g.setStroke(new BasicStroke((float) thickness));
		
		g.setColor(Obstacle.colors[0]);
		a1 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle, 90, 0);
		g.draw(a1);
		
		g.setColor(Obstacle.colors[1]);
		a2 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle + 90, 90, 0);
		g.draw(a2);
		
		g.setColor(Obstacle.colors[2]);
		a3 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle + 180, 90, 0);
		g.draw(a3);
		
		g.setColor(Obstacle.colors[3]);
		a4 = new Arc2D.Double(xPos, yPos, diameter, diameter , (int) currentAngle + 270, 90, 0);
		g.draw(a4);
		
		g.setStroke(new BasicStroke(1));
		*/
	 
}
