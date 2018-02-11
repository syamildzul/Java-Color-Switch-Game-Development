package fyp.colorswitch.entity.actor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Player extends Actor {
	
	private static final int DEFAULT_WIDTH = 20, DEFAULT_HEIGHT = 20;
	private static final int DEFAULT_DIAMETER = 20;
	
	private boolean start = false;
	private int i = 0, color;
	
	public Player(Handler handler, float yPosition, int color) {
		super(handler, yPosition);
		this.color = color;
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
		handler.getGameCamera().updateView(this);
		
	}
	
	@Override
	public void render(Graphics2D g) { 
		//if(this.collidesWith(switcher, color))
		switchColor(g);
		g.fill(new Ellipse2D.Double((int) x - DEFAULT_DIAMETER / 2,
				(int) (yPosition - handler.getGameCamera().getyOffset()),
				DEFAULT_DIAMETER, DEFAULT_DIAMETER));
		
		if(!start) {
			g.setColor(Color.WHITE);
			//g.setFont(Font.ROMAN_BASELINE);
			g.setStroke(new BasicStroke((float) 100));
			g.drawString("Click to start", (int) (x - DEFAULT_DIAMETER / 2 - 25), handler.getHeight() - 50);
		}
		
	}
	
	public boolean isStarted() {
		return start;
	}

}
