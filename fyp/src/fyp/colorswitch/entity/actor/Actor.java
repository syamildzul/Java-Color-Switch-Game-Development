package fyp.colorswitch.entity.actor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.Random;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public abstract class Actor extends Entity {

	private static final float DEFAULT_SPEED = 5.0f;
	
	protected float xMove, yMove, speed, fall;
	protected int color = 1;
	protected ScoreStar star = null;
	protected Switcher switcher = null;
	protected double position;

	public Actor(Handler handler, float yPosition) {
		super(handler, yPosition);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		if(handler.getMouseManager().leftPressed)
			moveY();
		fall();
	}
	
	public void moveX() {
		
	}
	
	public void moveY() {
		yPosition += yMove;
	}
	
	public void fall() {
		yPosition += fall;
	}
	
	protected Color getColor() {
        switch (color) {
            case 1:
                return Entity.colors[0];
            case 2:
                return Entity.colors[1];
            case 3:
                return Entity.colors[2];
            case 4:
                return Entity.colors[3];
            default:
                return Color.WHITE;
        }
    }
	
	public void switchColor(Graphics2D g) {
		int x = randomInt();
		setColor(g, x);
	}
	
	public void setColor(Graphics2D g, int c) {
		switch(c) {
			case 1 : g.setColor(Entity.colors[0]); break;
			case 2 : g.setColor(Entity.colors[1]); break;
			case 3 : g.setColor(Entity.colors[2]); break;
			case 4 : g.setColor(Entity.colors[3]); break;
		}
	}
	
	public int randomInt() {
		Random ran = new Random();
		int x = ran.nextInt(4);
		return x;
	}
	
	public void update(double moveDownDistance) {
        position += moveDownDistance;
        if (star != null) {
            star.update(moveDownDistance);
        }
        if (switcher != null) {
            switcher.update(moveDownDistance);
        }
    }
	/*
	public boolean starCollision(Ellipse2D.Double body, int bodyColor) {
        if (star != null && star.collidesWith(body, bodyColor)) {
            star = null;
            return true;
        }
        return false;
    }
	*/
    public boolean switcherCollision(Ellipse2D.Double body, int bodyColor) {
        if (switcher != null && switcher.collidesWith(body, bodyColor)) {
            switcher = null;
            return true;
        }
        return false;
    }
	public abstract boolean collidesWith(Ellipse2D.Double body, int color);
    
	// Getters & Setters 
	
	public float getxMove() {
		return xMove;
	}
	
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
