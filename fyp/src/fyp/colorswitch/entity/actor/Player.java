package fyp.colorswitch.entity.actor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Player extends Actor {
	
	private static final int DEFAULT_WIDTH = 20, DEFAULT_HEIGHT = 20;
	private static final int DEFAULT_DIAMETER = 20;
	
	private boolean start = false;
	private int i = 0, color, distance = 0;
	
	private Ellipse2D.Double p;
	
	public Player(Handler handler, float yPosition, int color) {
		super(handler, yPosition);
		this.color = color;
		p = new Ellipse2D.Double(x - DEFAULT_DIAMETER / 2, yPosition , DEFAULT_DIAMETER, DEFAULT_DIAMETER);
		bounds.x = (int) x + 10;
		bounds.y = (int) yPosition;
		bounds.width = 5;
		bounds.height = 20;
	}

	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().jump)
			yMove = -speed;
		if(handler.getMouseManager().leftPressed)
			yMove = -speed;
	}
	
	public void fall() {
		if(yPosition <= 680) {
			if(handler.getMouseManager().leftPressed) {
				start = true;
				i++;
			}
			if(i>1)
				if((start) && (yMove == 0) && !handler.getMouseManager().leftPressed)
					yPosition += speed * 0.15f;
		}
	}
	
	@Override
	public void tick() {
		getInput();
		move();
		fall();
		handler.getGameCamera().updatePlayerView(this);
	}
	
	@Override
	public void render(Graphics2D g) { 
		//if(this.collidesWith(switcher, color))
		//switchColor(g);
		int xPos = (int) (x - DEFAULT_DIAMETER / 2);
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		
		g.setColor(Color.blue);
		// switchColor(g);
		p.setFrame(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER);
		g.fill(p);
		g.setColor(Color.white);
		//g.fillRect((int) (xPos + bounds.x),
		//		(int) (yPosition + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		bounds.setBounds(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER);
		//g.fill(bounds);
		if(!start) {
			g.setColor(Color.WHITE);
			//g.setFont(Font.ROMAN_BASELINE);
			g.setStroke(new BasicStroke((float) 100));
			g.drawString("Click to start", (int) (x - DEFAULT_DIAMETER / 2 - 25), handler.getHeight() - 50);
		}
		
		distance = yPos;
	}
	
	public boolean stopObstacleTranslation() {
		if(p.getY() >= handler.getHeight() / 2)
			return true;
		return false;
	}
	
	public boolean isStarted() {
		return start;
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public boolean collidesWithObstacle(Entity entity, Color colors) {
		Area playerArea = new Area(bounds);
		//Area bodyArea = new Area((Shape) entity);
		//if(bodyArea.intersects(bounds))
			return true;
		//else
		//	return false;
	}

	@Override
	public boolean collidesWith(Double body, int color) {
		// TODO Auto-generated method stub
		return false;
	}

}
