package fyp.colorswitch.state;

import java.awt.Graphics2D;

import fyp.colorswitch.Handler;

public abstract class State {
	
	public static State currentState = null;

	public static void setState(State state) {
		State.currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	// Class 
	
	protected Handler handler;
	
	protected float midWidth;
	protected float midHeight;
	
	public State(Handler handler) {
		this.handler = handler;
		this.midWidth = handler.getWidth()/2;
		this.midHeight = handler.getHeight()/2;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);

}
