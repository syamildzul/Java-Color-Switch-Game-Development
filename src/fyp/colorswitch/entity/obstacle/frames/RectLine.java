package fyp.colorswitch.entity.obstacle.frames;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class RectLine extends Rectangle2D {
	
	private double x, y, width, height;
	private float yPosition;
	private int color;
	
	private Handler handler;
	
	private Rectangle2D Rect;
	
	public RectLine(Handler handler, float yPosition, double x, double y, double width, double height, int color) {
		this.handler = handler;
		this.yPosition = yPosition;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		Rect = new Rectangle2D.Double(x, y, width, height);
	}
	
	public void tick() {
		
	}
	
	double theta = 0;
	
	public void render(Graphics2D g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(20));
		g2d.setColor(Entity.colors[color]);
		
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		//Rect.setRect(x, yPos, width, height);
		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(theta), handler.getWidth() / 2, yPosition);
		g2d.translate(0, yPos);
		g2d.draw(at.createTransformedShape(Rect));
	
		//g2d.dispose();
		theta += 2;
		theta++;
		g.setColor(Color.WHITE);
		//AffineTransform Tx = AffineTransform.getRotateInstance(Math.toRadians(theta), handler.getWidth() / 2, yPosition);
		//g.translate(0, yPos);
		//g.draw(Tx.createTransformedShape(Rect));
		
		//g.draw(Rect);
	}
	
	public Rectangle2D getRectLine() {
		return Rect;
	}
	
	public int getColor() {
		return this.color;
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRect(double arg0, double arg1, double arg2, double arg3) {
		Rect.setFrame(arg0, arg1, arg2, arg3);
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
	public double getWidth() {
		return this.getWidth();
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if(Rect == null)
			isEmpty = true;
		
		return isEmpty;
	}

}
