package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Arc extends Obstacle {
	
	private int diameter, colorType;
	private double currentAngle;
	private Arc2D arc;
	
	public Arc (Handler handler, float yPosition, int diameter, double currentAngle, int color) {
		super(handler, yPosition);
		this.diameter = diameter;
		this.currentAngle = currentAngle;
		this.colorType = color;
		x = midPos - diameter / 2;
		arc = new Arc2D.Double(x, yPosition, diameter, diameter, (int) currentAngle, 90, 0);
	}

	@Override
	public void tick() {
		
	}
	
	

	@Override
	public void render(Graphics2D g) {
		g.setStroke(new BasicStroke(20));
		g.setColor(Entity.colors[colorType]);
		g.draw(arc);
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int bodyColor) {
		
		return false;
	}

}
