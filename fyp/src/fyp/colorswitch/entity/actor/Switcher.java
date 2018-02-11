package fyp.colorswitch.entity.actor;

import java.awt.Graphics2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Switcher extends Actor {
	
	private static final int DEFAULT_DIAMETER = 20;
	
	public Switcher(Handler handler, float yPosition) {
		super(handler, yPosition);
		// TODO Auto-generated constructor stub
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
		
	}

}
