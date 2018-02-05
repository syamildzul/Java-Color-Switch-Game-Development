package fyp.colorswitch.state;

import java.awt.Graphics;
import java.awt.Graphics2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.actor.Player;
import fyp.colorswitch.entity.actor.Score;
import fyp.colorswitch.entity.actor.ScoreStar;
import fyp.colorswitch.entity.actor.Switcher;
import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.entity.obstacle.Cross;
import fyp.colorswitch.entity.obstacle.Rectangle;

public class GameState extends State {
	
	private static final float BIG_CIRCLE_DIAMETER = 200;
	private static final float SMALL_CIRCLE_DIAMETER = 100;
	
	private EntityManager e;
	private Score score;
	private int playerScore;
	
	private float midPos = handler.getWidth() / 2;
	private float obsXspawn = midPos - midPos/2,
			obsYspawn = midPos;
	
	private Player player;
	
	public GameState(Handler handler) {
		super(handler);
		score = new Score(handler, 50);
		e = new EntityManager(handler);
		// add entities
		e.addEntity(new Circle(handler, midHeight, 200, 3));
		//e.addEntity(new Circle(handler, midHeight, 100, 2));
		//e.addEntity(new Rectangle(handler, 300));
		//e.addEntity(new Cross(handler, 350));
		// test 
		e.addEntity(new ScoreStar(handler, midHeight, 10, 20));
		e.addEntity(new Switcher(handler, midPos));
		
		// add player last to render it in front of other entities
		player = new Player(handler, handler.getHeight() - 100);
		e.addEntity(player);
	}
	
	@Override
	public void tick() {
		e.tick();
		if(isGameOver())
			State.setState(handler.getGame().menuState);
			
	}

	@Override
	public void render(Graphics2D g) {
		/*
		int bottom = (int) ( Math.min(0, handler.getGameCamera().getyOffset()) ); 		
		int top = (int) ( Math.max(handler.getHeight(), handler.getGameCamera().getyOffset()) );
		/*
		for(int y = yStart; y < yEnd; y++) { 
			y = y + 5;
			//entityManager.render(g);
		}
		*/
		// float yOff = - e.getPlayer().getY() / 2; //handler.getGame().getHeight();
		
		
		//if(player.getY() >= handler.getGame().getHeight())
		//	System.out.println("i'm in the upper section");
		
		e.render(g);
		score.render(g);
	}
	
	public EntityManager getEntityManager() {
		return e;
	}
	
	public boolean isGameOver() {
		// to add : bodycollisions with colors
		if(player.getY() >= 680)
			return true;
		else 
			return false;
	}

}
