package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Line;

public class Rectangle extends Obstacle {
	
	private float leftX, rightX;
	private float upY, downY;
	private ArrayList<Line> lesLines;
	
	public Rectangle(Handler handler, float yPosition) {
		super(handler, yPosition);
		this.leftX = handler.getWidth() / 2 - 85;
		this.rightX = handler.getWidth() / 2 + 85;
		this.upY = yPosition - 85;
		this.downY = yPosition + 85;		
		
		lesLines = new ArrayList<Line>();
		// 
		lesLines.add(new Line(handler, yPosition, leftX, upY, rightX, upY, 0));
		lesLines.add(new Line(handler, yPosition, rightX, upY, rightX, downY, 1));
		lesLines.add(new Line(handler, yPosition, leftX, downY, rightX, downY, 2));
		lesLines.add(new Line(handler, yPosition, leftX, upY, leftX, downY, 3));
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setStroke(new BasicStroke((float) 20)); // midW 250 midH 350
		g2d.translate(0, yPosition - handler.getGameCamera().getyOffset());
		for (Line l : lesLines) {
			l.render(g2d);
		}
		g2d.dispose();

	}

	@Override
	public boolean collidesWith(Double body, int bodycolor) {
		// TODO Auto-generated method stub
		return false;
	}

}
