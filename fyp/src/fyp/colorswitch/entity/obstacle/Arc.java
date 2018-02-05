package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Arc extends Obstacle {
	
	private int diameter, colorType;
	private double angle;
	private double currentAngle;
	
	public Arc(Handler handler, float yPosition, int diameter, double angle, int color) {
		super(handler, yPosition);
		this.diameter = diameter;
		this.angle = angle;
		this.colorType = colorType;
		x = midPos - diameter / 2;
	}

	@Override
	public void tick() {
		
	}
	
	

	@Override
	public void render(Graphics2D g) {
		renderArc(g, (int) angle);
	}
	
	public void renderArc(Graphics2D g, int angle) {
		g.setStroke(new BasicStroke(20));
		g.setColor(Entity.colors[colorType]);
		g.drawArc((int) x, (int) yPosition, diameter, diameter, (int) angle, colorType);
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int bodyColor) {
		
		return false;
	}

}
