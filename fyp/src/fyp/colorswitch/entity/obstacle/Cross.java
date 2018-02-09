package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Cross extends Obstacle {

	private int ha1, ha2, ha3, ha4;
	private int hb1, hb2, hb3, hb4;
	
	public Cross(Handler handler, float yPosition) {
		super(handler, yPosition);
		ha1 = 200; hb1 = 350;
		ha2 = 350; hb2 = 350;
		ha3 = 350; hb3 = 500;
		ha4 = 350; hb4 = 350;
	}

	@Override
	public void tick() {
		
	}
	
	public void updatePosition() {
		ha1 = (int) (ha1 - handler.getGameCamera().getyOffset());
		ha2 = (int) (ha2 - handler.getGameCamera().getyOffset());
		ha3 = (int) (ha3 - handler.getGameCamera().getyOffset());
		ha4 = (int) (ha4 - handler.getGameCamera().getyOffset());
		hb1 = (int) (hb1 - handler.getGameCamera().getyOffset());
		hb2 = (int) (hb2 - handler.getGameCamera().getyOffset());
		hb3 = (int) (hb3 - handler.getGameCamera().getyOffset());
		hb4 = (int) (hb4 - handler.getGameCamera().getyOffset());
	}
	
	int i = 0;
	public void rotateLine(Graphics2D g) {
		
		Line2D line = new Line2D.Double(250, 200, 250, 350);
		Line2D line2 = new Line2D.Double(250, 350, 400, 350);
		Line2D line3 = new Line2D.Double(250, 350, 250, 500);
		Line2D line4 = new Line2D.Double(100, 350, 250, 350);
		
		/*updatePosition();
		
		Line2D line = new Line2D.Double(250, ha1, 250, hb1);
		Line2D line2 = new Line2D.Double(250, ha2, 400, hb2);
		Line2D line3 = new Line2D.Double(250, ha3, 250, hb3);
		Line2D line4 = new Line2D.Double(100, ha4, 250, hb4);
		*/
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
		
		g.setStroke(new BasicStroke((float) 20)); 		
		
		rotateLine(g);
	}

	@Override
	public boolean collidesWith(Double body, int bodyColor) {
		// TODO Auto-generated method stub
		return false;
	}


}
