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
	private Ellipse2D.Double innerCircle;
	
	private ArrayList<Arc> lesArc;
	
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
		
		innerCircle = new Ellipse2D.Double(x + thickness, yPosition + thickness, diameter - thickness*2, diameter - thickness*2);	
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
		
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		innerCircle.setFrame(x + thickness, yPos + thickness, diameter - thickness*2, diameter - thickness*2);
		
		for (int i = 0; i < lesArc.size(); i++) {
			lesArc.get(i).render(g);
		}
		
		//g.setColor(Color.WHITE);
		//g.draw(innerCircle);
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {
		
		for (int i = 0; i < lesArc.size(); i++) {
			Area playerArea = new Area(body);
	        Area arcArea = new Area(lesArc.get(i).getArc());
	        
	        playerArea.intersect(arcArea); 
	        if (!playerArea.isEmpty()) {
	        	if(color != lesArc.get(i).getColorType())
	        		return true;
	        }
	        else 
	        	continue;
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
	 
}
