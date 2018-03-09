package fyp.colorswitch.entity.actor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Arc;

public class Switcher extends Actor {
	
	private static final int DEFAULT_DIAMETER = 20;
	
	private Ellipse2D.Double switcherBody;
	
	public Switcher(Handler handler, float yPosition) {
		super(handler, yPosition);
		
		switcherBody = new Ellipse2D.Double(x - DEFAULT_DIAMETER / 2, yPosition, DEFAULT_DIAMETER, DEFAULT_DIAMETER);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics2D g) {
		int xPos = (int) midPos - DEFAULT_DIAMETER/2;
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset() + 100); // test

		g.setColor(Entity.colors[0]);
		g.fillArc(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER, 0, 90);
		g.setColor(Entity.colors[1]);
		g.fillArc(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER, 90, 90);
		g.setColor(Entity.colors[2]);
		g.fillArc(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER, 180, 90);
		g.setColor(Entity.colors[3]);
		g.fillArc(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER, 270, 90);
		
		switcherBody.setFrame(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER);
		g.setColor(Color.white);
		//g.fill(switcherBody);
		
	}
	
	@Override
	public boolean collidesWith(Double body, int color) {
		Area playerArea = new Area(body);
		Area switcherArea = new Area(switcherBody);
		switcherArea.intersect(playerArea);
		if(switcherArea.isEmpty())
			return true;
		else 
			return false;
	}

}
