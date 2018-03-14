package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Line;

public class Rectangle extends Obstacle {
	
	private int ha1, ha2, ha3, ha4;
	private int hb1, hb2, hb3, hb4;
	private Line line, line2, line3, line4;
	private ArrayList<Line2D> lesLines;
	
	public Rectangle(Handler handler, float yPosition) {
		super(handler, yPosition);
		
		ha1 = 100; hb1 = 100;
		ha2 = 100; hb2 = 250;
		ha3 = 250; hb3 = 250;
		ha4 = 100; hb4 = 250;
		
		lesLines = new ArrayList<Line2D>();
		/*
		line = new Line(150, ha1, 300, hb1, 0);
		line2 = new Line(150, ha2, 300, hb2, 1);
		line3 = new Line(150, ha3, 300, hb3, 2);
		line4 = new Line(150, ha4, 300, hb4, 3);
		*/
	}

	@Override
	public void tick() {
		
	}
	int theta = 0;
	@Override
	public void render(Graphics2D g) {

		Graphics2D g2d = (Graphics2D) g.create();
		g.setStroke(new BasicStroke((float) 20)); // midW 250 midH 350
		//rotateLine(g);
		
		lesLines.add(new Line2D.Double(150, ha1 - handler.getGameCamera().getyOffset(), 300, hb1 - handler.getGameCamera().getyOffset()));
		lesLines.add(new Line2D.Double(150, ha2 - handler.getGameCamera().getyOffset(), 150, hb2 - handler.getGameCamera().getyOffset()));
		lesLines.add(new Line2D.Double(150, ha3 - handler.getGameCamera().getyOffset(), 300, hb3 - handler.getGameCamera().getyOffset()));
		lesLines.add(new Line2D.Double(300, ha4 - handler.getGameCamera().getyOffset(), 300, hb4 - handler.getGameCamera().getyOffset()));
		
		AffineTransform at = AffineTransform.getRotateInstance(theta);
		for (Line2D l : lesLines) {
			g2d.translate(handler.getWidth() / 2, handler.getHeight() / 2);
			g2d.rotate(Math.toRadians(theta));
			g2d.draw(l);
			
			g2d.dispose();
		}
		theta++;
	}
	
	int i = 0;
	public void rotateLine(Graphics2D g) {
		
		Line2D line = new Line2D.Double(150, ha1 - handler.getGameCamera().getyOffset(), 300, hb1 - handler.getGameCamera().getyOffset());
		Line2D line2 = new Line2D.Double(150, ha2 - handler.getGameCamera().getyOffset(), 150, hb2 - handler.getGameCamera().getyOffset());
		Line2D line3 = new Line2D.Double(150, ha3 - handler.getGameCamera().getyOffset(), 300, hb3 - handler.getGameCamera().getyOffset());
		Line2D line4 = new Line2D.Double(300, ha4 - handler.getGameCamera().getyOffset(), 300, hb4 - handler.getGameCamera().getyOffset());
		
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
	public boolean collidesWith(Double body, int bodycolor) {
		// TODO Auto-generated method stub
		return false;
	}

}
