package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.obstacle.frames.Line;

public class Rectangle extends Obstacle {
	
	private float leftX, rightX;
	private float upY, downY;
	private ArrayList<Line> lesLines;
	
	public Rectangle(Handler handler, float yPosition, int width) {
		super(handler, yPosition, width);
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
		//lesLines.get(0)
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setStroke(new BasicStroke(20)); // midW 250 midH 350
		//g2d.translate(0, yPosition - handler.getGameCamera().getyOffset());
		for (Line l : lesLines) {
			l.render(g2d);
		}
		Line2D currentLine = lesLines.get(0).getLine(0);
		g.setColor(Color.WHITE);
		g.draw(currentLine.getBounds());
		g2d.dispose();
		
		
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int bodycolor) {		
		
		for (int i = 0; i < lesLines.size(); i++) {
			Line2D currentLine = lesLines.get(i).getLine(i);
			Area playerArea = new Area(body);
			Area lineArea = new Area(currentLine);
			playerArea.intersect(lineArea);
			//System.out.println(playerArea);
			if(!playerArea.isEmpty()) {
				System.out.println("collision YEEEEEEEEEEEEEEEEEE");
				return true;
			}
				body.intersects(currentLine.getBounds2D());
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
