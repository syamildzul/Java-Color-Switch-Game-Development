package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Rectangle extends Obstacle {

	public Rectangle(Handler handler, float yPosition) {
		super(handler, yPosition);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		updateyPosition();
	}

	@Override
	public void render(Graphics2D g) {
		int xPos = (int) x; //( (handler.getWidth() / 2) - (diameter / 2) );
		int yPos = (int) yPosition;//( (handler.getHeight() / 2) - diameter );
		g.setStroke(new BasicStroke((float) 20)); // midW 250 midH 350
		// (startX, startY, endX, endY)
		g.setColor(Entity.colors[0]);
		g.drawLine(150, 100, 300, 100);
		g.setColor(Entity.colors[1]);
		g.drawLine(150, 100, 150, 250);
		g.setColor(Entity.colors[2]);
		g.drawLine(150, 250, 300, 250);
		g.setColor(Entity.colors[3]);
		g.drawLine(300, 100, 300, 250);
	}

	@Override
	public boolean collidesWith(Double body, int bodyColor) {
		// TODO Auto-generated method stub
		return false;
	}

}
