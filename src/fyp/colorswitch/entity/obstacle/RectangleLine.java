package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Line;
import fyp.colorswitch.entity.obstacle.frames.RectLine;

public class RectangleLine extends Obstacle {
	
	private float leftX, rightX;
	private float upY, downY;
	private ArrayList<RectLine> lesLines;
	
	private Rectangle r1, r2, r3, r4;
	
	public RectangleLine(Handler handler, float yPosition, int length) {
		super(handler, yPosition, length);
		this.leftX = handler.getWidth() / 2 - 85;
		this.rightX = handler.getWidth() / 2 + 85;
		this.upY = yPosition - 85;
		this.downY = yPosition + 85;		
		
		lesLines = new ArrayList<RectLine>();
		// 
		lesLines.add(new RectLine(handler, yPosition, leftX, upY, length, 5, 0));
		lesLines.add(new RectLine(handler, yPosition, rightX, upY, 5, length, 1));
		lesLines.add(new RectLine(handler, yPosition, leftX, downY, length, 5, 2));
		lesLines.add(new RectLine(handler, yPosition, leftX, upY, 5, length, 3));
	
		//r1 = new Rectangle();
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics2D g) {
		//lesLines.get(0)
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setStroke(new BasicStroke((float) 20)); // midW 250 midH 350
		//g2d.translate(0, yPosition - handler.getGameCamera().getyOffset());
		for (RectLine l : lesLines) {
			l.render(g2d);
		}
		g2d.dispose();
		
		
		
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int bodycolor) {		
		
		for (int i = 0; i < lesLines.size(); i++) {
			Rectangle2D currentLine = lesLines.get(i).getRectLine();
			Area playerArea = new Area(body);
			Area lineArea = new Area(currentLine);
			
			playerArea.intersect(lineArea);
			if(!playerArea.isEmpty()) {
				if(lesLines.get(i).getColor() != bodycolor)
					return true;
				//System.out.println("collision YEEEEEEEEEEEEEEEEEE");
			}
			
			if(body.intersects(currentLine.getBounds2D()))
				return true;
			
			playerArea.intersect(lineArea);
			if(!playerArea.isEmpty()) {
				//if(lesLines.get(i).getColor() != bodycolor)
				System.out.println("collision YEEE");
					return true;
			}
			else
				continue;
		}
		//System.out.println("NOOOOOOOOOO collision");
		return false;
	}

}
