package fyp.colorswitch.state;

import java.awt.Color;
import java.awt.Graphics2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.actor.Player;
import fyp.colorswitch.entity.actor.Score;
import fyp.colorswitch.entity.actor.ScoreStar;
import fyp.colorswitch.entity.actor.Switcher;
import fyp.colorswitch.entity.obstacle.BarMovingLeftToRight;
import fyp.colorswitch.entity.obstacle.BarMovingRightToLeft;
import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.entity.obstacle.DoubleBar;
import fyp.colorswitch.entity.obstacle.obsrectangle;

public class GameState extends State {
		
	private Handler handler;
	private EntityManager em;
	
	private Player player;
	private Switcher switcher;
	private ScoreStar scoreStar;
	private Score score;
	
	private int playerscore;
	
	private float midHeight, midWidth;
	private float deadlinePosition = 0;
	
	//private World world;
	
	public GameState(Handler handler) {
		super(handler);
		this.handler = handler;
		this.midWidth = handler.getWidth() / 2;
		this.midHeight = handler.getHeight() / 2;
		this.deadlinePosition = handler.getHeight();
		this.playerscore = 0;
		
		score = new Score(handler, 50);
		
		em = new EntityManager(handler);
		
		// add entities 
		// the obstacles will be added randomly later
		scoreStar = new ScoreStar(handler, midHeight - 200, 10, 20);
		em.addEntity(scoreStar);
		
		switcher = new Switcher(handler, 400);
		em.addEntity(switcher);
		
		// add player last to render it in front of other entities
		player = new Player(handler, handler.getHeight() - 20, 0);
		em.addEntity(player);
	}
	
	float totalymove = 0;
	@Override
	public void tick() {	
		
		em.tick();	
		if(isGameOver()) {
			handler.getGame().getMouseManager().setUIManager(null);
			State gameOverState = new GameOverState(handler);
			State.setState(gameOverState);
		}	
		
		if(player.getyPosition() < em.getEntities().get(em.getEntities().size()-1).getyPosition()+200) 
			randomSpawn();
	}

	@Override
	public void render(Graphics2D g) {
		
		em.render(g);
		score.render(g);
		g.setColor(Color.white);
		
	}

	public boolean isGameOver() {
		if(checkCollisions())
			return true;
		else 
			return false;
	}
	
	public boolean checkCollisions() {
		for(int i = 0; i < em.getEntities().size() ; i++) {
			
			Entity currentEntity = em.getEntities().get(i);
			
			if(currentEntity == player)
				continue;
			
			if(currentEntity.collidesWith(player.getP(), player.getColorType())) {
				
				// case switcher
				if(currentEntity.getClass() == switcher.getClass()) {
					em.getEntities().remove(currentEntity); // the switcher will be removed
					player.setColor(handler.getGame().randomInt(4));
					return false;
				}
				
				// case scorestar
				if(currentEntity == scoreStar) {
					scoreStar.setyPosition(scoreStar.getyPosition() - 300);
					playerscore++;
					score.setPlayerScore(playerscore);
					return false;
				}
				
				return true;
			}	
			else
				continue;
		}
		
		return false;
	}
		
	int counter = 0;

	public void randomSpawn() {

		int distanceBetweenObstacle = 400;
		int x = handler.getGame().randomInt(7);
		int y = handler.getGame().randomInt(2)+1;
		int spawnHeight = (int) (em.getEntities().get(em.getEntities().size()-1).getyPosition() - distanceBetweenObstacle);
		switch(x) {
			case 0 : em.addEntity(new Circle(handler, spawnHeight, 200, y)); break;
			case 1 : em.addEntity(new BarMovingLeftToRight(handler, spawnHeight)); break;
			//case 2 : em.addEntity(new obscross(handler, spawnHeight)); break; 
			//GOD MODE
			case 3 : em.addEntity(new obsrectangle(handler,spawnHeight)); break;
			case 4 : em.addEntity(new BarMovingRightToLeft(handler, spawnHeight)); break;
			case 5 : em.addEntity(new DoubleBar(handler, spawnHeight)); break;
			case 6 : em.addEntity(new Switcher(handler,spawnHeight)); break;
		}

	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
}
