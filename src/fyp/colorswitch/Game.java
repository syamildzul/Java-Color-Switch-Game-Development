package fyp.colorswitch;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import fyp.colorswitch.display.Display;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.gfx.GameCamera;
import fyp.colorswitch.input.KeyManager;
import fyp.colorswitch.input.MouseManager;
import fyp.colorswitch.state.GameOverState;
import fyp.colorswitch.state.GameState;
import fyp.colorswitch.state.MenuState;
import fyp.colorswitch.state.State;

public class Game implements Runnable{
	
	private Display display;
	private Thread thread;
	public String title;
	protected int width, height;
	public boolean running = false;
	
	private BufferStrategy bs;
	private Graphics2D g;
	
	// Handler
	private Handler handler;
	
	// State
	public State menuState;
	public State gameState;
	
	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	// Camera 
	private GameCamera gameCamera;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();		
	}
	
	public void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init(); // for images
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0); // Camera not funtional yet
		
		menuState = new MenuState(handler);
		gameState = new GameState(handler);
		State.setState(menuState);
	}
	
	public void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		
		// set panel background to black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		// render all here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		// end drawing
		// display the image
		bs.show();
		g.dispose();
	}
	
		
	
	
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int randomInt(int range) {
		Random ran = new Random();
		int x = ran.nextInt(range);
		return x;
	}
	
}
