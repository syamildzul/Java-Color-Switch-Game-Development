package fyp.colorswitch.entity.actor;

import java.awt.Color;
import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

// La classe Actor est pour les entités qui vont changer quelque chôse dans le jeu 

public abstract class Actor extends Entity {

	private static final float DEFAULT_SPEED = 5.0f;
	
	protected float xMove, yMove, speed, fall;
	protected int color = 1;
	protected double position;

	public Actor(Handler handler, float yPosition, int diameter) {
		super(handler, yPosition, diameter);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	// méthode pour le déplacement
	public void move() {
		if(handler.getMouseManager().leftPressed)
			moveY();
		fall();
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
