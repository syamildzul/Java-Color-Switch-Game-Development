package fyp.colorswitch.entity.actor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class Player extends Actor {
	
	private static final int DEFAULT_WIDTH = 20, DEFAULT_HEIGHT = 20;
	private static final int DEFAULT_DIAMETER = 20;
	
	private boolean start = false, isMoving = false, isGameOver = false;
	private int i = 0, color, distance = 0;
	private int midLine, lowerLine;
	
	private Ellipse2D.Double p; // La balle est de type Ellipse2D
	
	public Player(Handler handler, float yPosition, int color) {
		super(handler, yPosition);
		this.color = color;
		midLine = handler.getHeight() / 2;
		lowerLine = handler.getHeight();
		
		// initialisation de la balle
		p = new Ellipse2D.Double(x - DEFAULT_DIAMETER / 2, yPosition , DEFAULT_DIAMETER, DEFAULT_DIAMETER);
	}
	
	@Override
	public void tick() {
		getInput(); // appel tout input de l'utilisateur
		move();
		fall();
		
		updateLines();
		
		// update le caméra
		handler.getGameCamera().updatePlayerView(this);
	}
	
	@Override
	public void render(Graphics2D g) { 
		
		int xPos = (int) (x - DEFAULT_DIAMETER / 2);
		int yPos = (int) (yPosition - handler.getGameCamera().getyOffset());
		
		g.setColor(Entity.colors[color]);
		
		// réinitialiser le positionnement de la balle
		p.setFrame(xPos, yPos, DEFAULT_DIAMETER, DEFAULT_DIAMETER);
		g.fill(p);
	
		// instruction pour commencer 
		if(!start) {
			Font newFont = new Font("Arial", Font.BOLD, 20);
			g.setColor(Color.WHITE);
			g.setFont(newFont);
			g.drawString("Click to start", handler.getWidth() / 2 - 50, handler.getHeight() - 50);
		}
		
		distance = yPos;
	}
	
	private int pp = 13;
	
	public void getInput() {
		xMove = 0;
		yMove = 0;
		/*
		if(handler.getKeyManager().jump)
			yMove = -speed; */
		if(handler.getMouseManager().leftPressed) {
			yMove = -speed;
			if (pp == 13) {
				playSound("jump1.wav");
				pp -= 13;
			}
			pp++;
		}
			
		
		if(yMove != 0)
			isMoving = true;
	}
	
	@Override
	public void fall() { // la balle va commencer à décendre après avoir commencé le jeu
		if(yPosition <= 680) {
			if(handler.getMouseManager().leftPressed) {
				start = true;
				i++;
			}
			if(i>1)
				if((start) && (yMove == 0) && !handler.getMouseManager().leftPressed) {
					yPosition += speed * 0.15f;
					isMoving = false;
				}	
		}
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
	public void updateLines() {
		if(p.getY() <= midLine) {
			lowerLine += yMove;
			midLine += yMove;
		}		
	}
	
	public boolean isStarted() {
		return start;
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double entity, int colors) { // la collision détection de la balle mais
																	   // mais on en a pas vraiment besoin
		Area playerArea = new Area(p);
		Area bodyArea = new Area(entity);
		playerArea.intersect(bodyArea);
		if(bodyArea.isEmpty() && color==colors)
			return true;
		else
			return false;
	}
	
	public static synchronized void playSound(String url) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Player.class.getResource("/sounds/" + url));
			Clip clip = AudioSystem.getClip();
			// JOptionPane.showMessageDialog(null,
			// "ssssssssssssmmmmmmmmmmmmmmmmmmmmm");
			clip.open(audioIn);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error : " + e.getMessage());
			// JOptionPane.showMessageDialog(null, "ssssssssssssssss");
		}
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public int getColorType() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Ellipse2D.Double getP() {
		return p;
	}

	public void setP(Ellipse2D.Double p) {
		this.p = p;
	}

}
