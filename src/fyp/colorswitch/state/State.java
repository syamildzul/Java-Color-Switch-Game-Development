package fyp.colorswitch.state;

import java.awt.Graphics2D;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.actor.Player;
import fyp.colorswitch.ui.UIManager;

// Etat
public abstract class State {
	
	public static State currentState = null;
	public static UIManager uiManager = null;

	public static void setState(State state) {
		State.currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public static void setUIManager(UIManager uimanager) {
		State.uiManager = uimanager;
	}
	
	public static UIManager getUIManager() {
		return uiManager;
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
	
	private static Clip clip;

	public static synchronized void playSound(String url) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Player.class.getResource("/sounds/" + url));
			clip = AudioSystem.getClip();

			clip.open(audioIn);
			clip.start();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error : " + e.getMessage());

		}
	}

	public static void getmusic() {
		// play the music
		//playSound("music.wav");
		playSound("mp.wav");
	}

	public void closemusic() {
		clip.close();
	}

}
