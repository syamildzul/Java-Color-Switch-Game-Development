package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Line;

public class Cross extends Obstacle {

	private Line2D line, line2, line3, line4;
	private int ha1, ha2, ha3, ha4;
	private int hb1, hb2, hb3, hb4;
	
	private float leftX, midX, rightX;
	private float upY, midY, downY;
	
	private int side; // le côté gauche ou droit
	
	private Line l;
	
	public Cross(Handler handler, float yPosition, int length, int side) {
		super(handler, yPosition, length);
		this.side = side; // 0 pour le côté gauche et 1 pour le côté droit 	
		x = 0;
		if(side == 0) {
			
			this.midX = handler.getWidth() / 2 - length;
			this.leftX = midX - length;			
			this.rightX = midX + length;
			this.midY = yPosition;
			this.upY = midY - length;
			this.downY = midY + length;
			
		} else if(side == 1) {
			
			this.midX = handler.getWidth() / 2 + length;
			this.leftX = midX - length;			
			this.rightX = midX + length;
			this.midY = yPosition;
			this.upY = midY - length;
			this.downY = midY + length;
			
		}
		
		line = new Line2D.Double(midX, upY, 5, length);
		line2 = new Line2D.Double(midX, midY, length, 5);
		line3 = new Line2D.Double(midX, downY, 5, length);
		line4 = new Line2D.Double(leftX, midY, length, 5);
		
		
	}

	@Override
	public void tick() {
		
	}
	
	int i = 0;
	public void rotateLine(Graphics2D g) {		
		
	    AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(i), 
	    		line.getX2(), line.getY2());
	    AffineTransform at2 = AffineTransform.getRotateInstance(Math.toRadians(i), 
	    		line2.getX1(), line2.getY1());
	    AffineTransform at3 = AffineTransform.getRotateInstance(Math.toRadians(i),
	    		line3.getX1(), line3.getY1());
	    AffineTransform at4 = AffineTransform.getRotateInstance(Math.toRadians(i),
	    		line4.getX2(), line4.getY2());

	    // Draw the rotated line
	    g.setColor(Entity.colors[0]);
	    g.draw(at.createTransformedShape(line));
	    g.setColor(Entity.colors[1]);
	    g.draw(at2.createTransformedShape(line2));
	    g.setColor(Entity.colors[2]);
	    g.draw(at3.createTransformedShape(line3));
	    g.setColor(Entity.colors[3]);
	    g.draw(at4.createTransformedShape(line4));
	    i++;
	}
	
	@Override
	public void render(Graphics2D g) {
		line.setLine(midX, upY - handler.getGameCamera().getyOffset(), 5, width  - handler.getGameCamera().getyOffset());
		line2.setLine(midX, midY  - handler.getGameCamera().getyOffset(), width, 5  - handler.getGameCamera().getyOffset());
		line3.setLine(midX, downY  - handler.getGameCamera().getyOffset(), 5, width  - handler.getGameCamera().getyOffset());
		line4.setLine(leftX, midY  - handler.getGameCamera().getyOffset(), width, 5  - handler.getGameCamera().getyOffset());
		g.setStroke(new BasicStroke(20)); 		
		//l.render(g);
		rotateLine(g);
	}
	
	public boolean collides(Line2D.Double body, int color) {
		if(body.intersectsLine(line)  )
			return true;
		else
			return false;
	}

	@Override
	public boolean collidesWith(Double body, int bodycolor) {
		
		
		return false;
	}


}
