package fyp.colorswitch;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import fyp.colorswitch.display.Display;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.gfx.GameCamera;
import fyp.colorswitch.input.MouseManager;
import fyp.colorswitch.state.MenuState;
import fyp.colorswitch.state.State;

public class Game implements Runnable{
	
	private Thread thread;
	public String title;
	protected int width, height;
	public boolean running = false;
	
	// Required for display
	private Display display;
	private BufferStrategy bs; // Buffer est comme l'écran caché dans le pc
							   // On a besoin de buffer pour éviter des lags d'affichage
							   // Tous les affichages seront dessinés dans le buffer 
							   // avant de les afficher à l'écran 
	private Graphics2D g;
	
	// Handler
	private Handler handler;
	
	// State
	public State menuState; 
//	public State gameState;
//	public State gameOverState;
	
	// Input
	// private KeyManager keyManager; // il servira s'il y a besoin de clavier
	private MouseManager mouseManager;
	
	// Camera 
	private GameCamera gameCamera;
	
	// Highest score of the game
	private int highScore;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		//keyManager = new KeyManager();
		mouseManager = new MouseManager();		
	}
	
	public void init() {
		// initialisation de display avec le titre, le longueur et la hauteur de frame
		display = new Display(title, width, height);
		//display.getFrame().addKeyListener(keyManager);
		// ajouts le mouselistener et mousemotionlistener pour les deux (canvas et frame) 
		// car sinon, il y aura des bugs où le souris n'est pas détecté 
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init(); // initialisation des images dans Assets
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0); 
		
		menuState = new MenuState(handler);
//		gameState = new GameState(handler);
//		gameOverState = new GameOverState(handler);
		State.setState(menuState);
		
	}
	
	// j'appelle le méthode update, tick car c'est plus utilisé dans le développement 
	// de jeu
	public void tick() {
		//keyManager.tick();
		
		// s'assurer qu'on a un état courant 
		if(State.getState() != null) {
			State.getState().tick();
		} else {
			State.setState(menuState);
			State.getState().tick();;
		}
		
	}
	
	public void render() {
		// initialisation de buffer strategy au buffer strategy courant du display
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			// créer un triple-buffering strategy
			display.getCanvas().createBufferStrategy(3); // 3 c'est le maximum BS 
														 // qu'on peut ajouter
			return;
		}
		
		// graphics2D g nous permet de dessiner quelque chôse dans le canvas
		g = (Graphics2D) bs.getDrawGraphics();
		
		// set background panel to black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		// render all here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		// end drawing
		// afficher le buffer à l'écran
		bs.show();
		g.dispose(); // jeter les dessins courant pour pouvoir dessiner à nouveau
					 // la prochaine vue
	}
	
	@Override
	public void run() {
		// initialiser le controlleur et l'affichage du jeu
		init();
		
		
		int fps = 60; // frame per second = 60, on va appeler tick() et render() 
				      // 60 fois par seconde
		double timePerTick = 1000000000 / fps; // y a milliard nano seconde dans une seconde
											   // c'est le temps de chaque tick & render en nano seconde
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0; 
		
		while(running) {
			now = System.nanoTime(); // le temps courant en nano seconde
			delta += (now - lastTime) / timePerTick; // combien de temps on a jusqu'à prochain appel de tick & render
			timer += now - lastTime; // le temps depuis le dernière mis à jour de delta 
			lastTime = now; // après le mise à jour de delta et timer est fini en haut, 
							// lastTime est maintenant le temps avant le màj
			
			if(delta >= 1) { // si vraie, on peut appeler la fonction tick & render 
				tick();
				render();
				ticks++;
				delta--; // on a appelé nos méthodes, donc delta est décrémenté
			}
			
			if(timer >= 1000000000) { // si une seconde est passé, remettre ticks et timer à 0
				ticks = 0;
				timer = 0;
			}
			
			// ticks sert pour voir est-ce qu'on a bien notre FPS 
			// System.out.println("ticks & frames per second : " + ticks);
			
		}
		
		stop();
	}
	
	public synchronized void start() {
		// si le jeu est en train de circuler, retour toute suite 
		if(running)
			return;
		
		// sinon, set running à vrai et initialiser le thread et le lancer
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		// si le jeu est déjà arrêté, retour toute suite 
		if(!running)
			return;
		
		// sinon set running à false
		running = false;
		try {
			thread.join(); // attendre la fin du thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// méthode random pour pouvoir random un integer selon un rang donné
	// par exemple 4 pour random une des quatre couleurs.
	public int randomInt(int range) {
		Random ran = new Random();
		int x = ran.nextInt(range);
		return x;
	}
	
	// servira à afficher le high score et le set
	
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	// les autres getters & setters
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	/*
	public KeyManager getKeyManager() {
		return keyManager;
	}
	*/
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	
	
}
