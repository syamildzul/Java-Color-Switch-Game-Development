package fyp.colorswitch.entity.actor;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Arc;

public class Switcher extends Actor {
	
	private static final int DEFAULT_DIAMETER = 20;
	
	private Arc a1, a2, a3, a4;
	private ArrayList<Arc> lesArc;
	
	public Switcher(Handler handler, float yPosition) {
		super(handler, yPosition);
	}
	
	public void init() {
		a1 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 0, 0, 1);
		a2 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 90, 1, 1);
		a3 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 180, 2, 1);
		a4 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 360, 3, 1);
		lesArc = new ArrayList<Arc>();
		lesArc.add(a1);
		lesArc.add(a2);
		lesArc.add(a3);
		lesArc.add(a4);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics2D g) {
		init();
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
		
		/*for (Arc a : lesArc) {
			a.render(g);
		}
		*/
	}
	
	public boolean collidesWith(Double body, int color) {
		
		return true;
		
	}

}
