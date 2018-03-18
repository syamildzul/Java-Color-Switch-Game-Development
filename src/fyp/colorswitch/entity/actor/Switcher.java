package fyp.colorswitch.entity.actor;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Switcher extends Actor {
	
	private static final int DEFAULT_DIAMETER = 20;
	
	private Ellipse2D.Double switcherBody; // le corps du switcher
										   // par contre, on vas pas l'utiliser pour l'affichage de switcher
										   // car le switcher a plusieur couleur
	
	public Switcher(Handler handler, float yPosition) {
		super(handler, yPosition, DEFAULT_DIAMETER);
		
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
		//g.setColor(Color.white);
		//g.fill(switcherBody);
		
	}
	
	@Override
	public boolean collidesWith(Double body, int color) {
		Area playerArea = new Area(body);
		Area switcherArea = new Area(switcherBody);
		switcherArea.intersect(playerArea); // donne l'aire de l'intersection
		if(!switcherArea.isEmpty()) 
			return true;
		else 
			return false;
	}

}
