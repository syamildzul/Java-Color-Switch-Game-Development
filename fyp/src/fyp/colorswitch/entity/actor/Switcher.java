package fyp.colorswitch.entity.actor;

import java.awt.Graphics2D;
import java.awt.Rectangle;
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
		a1 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 0, 0);
		a2 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 90, 1);
		a3 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 180, 2);
		a4 = new Arc(handler, yPosition, DEFAULT_DIAMETER, 360, 3);
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
		
		int xPos = (int) midPos - DEFAULT_DIAMETER/2;
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset() + 100); // test
		for (Arc a : lesArc) {
			a.render(g);
		}
		
	}
	
	public boolean collidesWith(Rectangle bounds, int color) {
		
		return true;
		
	}

}
