package fyp.colorswitch.world;

import java.awt.Graphics2D;
import java.util.Random;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.actor.Player;
import fyp.colorswitch.entity.actor.Score;
import fyp.colorswitch.entity.actor.ScoreStar;
import fyp.colorswitch.entity.actor.Switcher;
import fyp.colorswitch.entity.obstacle.Bar;
import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.entity.obstacle.Cross;
import fyp.colorswitch.entity.obstacle.Rectangle;
import fyp.colorswitch.state.State;
import fyp.colorswitch.utils.Util;

public class World {
	
	private Handler handler;
	private EntityManager em;
	
	private Player player;
	private Switcher switcher;
	private ScoreStar scoreStar;
	
	private Score score;
	private int playerscore;
	
	private float midHeight, midWidth;
	private float deadlinePosition = 0;
	
	public World(Handler handler) {
		this.handler = handler;
		this.midWidth = handler.getWidth() / 2;
		this.midHeight = handler.getHeight() / 2;
		this.deadlinePosition = handler.getHeight();
		this.playerscore = 0;
		score = new Score(handler, 50);
		
		em = new EntityManager(handler);
		
		// add entities
		em.addEntity(new Circle(handler, midHeight, 200, 3));
		em.addEntity(new Rectangle(handler, 300));
		//em.addEntity(new Cross(handler, 350));
		//em.addEntity(new Bar(handler, 300));
		scoreStar = new ScoreStar(handler, midHeight - 200, 10, 20);
		em.addEntity(scoreStar);
		
		switcher = new Switcher(handler, 400);
		em.addEntity(switcher);
		
		// add player last to render it in front of other entities
		player = new Player(handler, handler.getHeight() - 100, 0);
		em.addEntity(player);
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public void tick() {
		int timer = 0;
		em.tick();	
		if(isGameOver()) {
			//State.setState(handler.getGame().menuState);
		}	
		if(checkCollisions())
			System.out.println("there's a collision"); // to see if the collision detection works 
		
		//randomSpawn(); 
		//System.out.println(player.getyPosition());
	}
	
	public void render(Graphics2D g) {
		em.render(g);
		score.render(g);
		//g.drawString(Integer.toString(playerscore), 300, 100);
	}
	
	public boolean isGameOver() {
		
		if(player.getyPosition() >= deadlinePosition || checkCollisions())
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
				if(currentEntity == switcher) {
					player.setColor(handler.getGame().randomInt(4));
					switcher.setyPosition(switcher.getyPosition() - 300);					
				}
				
				// case scorestar
				if(currentEntity == scoreStar) {
					scoreStar.setyPosition(scoreStar.getyPosition() - 300);
					playerscore++;
					score.setPlayerScore(playerscore);
				}
				
				return true;
			}	
			else
				continue;
		}
		
		return false;
	}
		
	public void randomSpawn() {
		int size = em.getLength() - 4; // - 4 because ( n:player, n-1:switcher, n-2:scoreStar)
		int distanceBetweenObstacle = 0;
		int x = 0;
		x = handler.getGame().randomInt(2); // for now only 2 obstacles are finished
		// 0 : circle : default diameter is 200
		// 1 : bar : default height is ?
		int spawnHeight = (int) (distanceBetweenObstacle - em.getEntities().get(size).getyPosition() + 100);
		
		System.out.println(spawnHeight);
		
		float maxymove = 0;
		maxymove += player.getyMove();
		System.out.println(maxymove);
		if(player.getyPosition() < spawnHeight && player.getyMove() != 0) {
			switch(x) {
				case 0 : em.addEntity(new Circle(handler, spawnHeight, 200, 3));
				case 1 : em.addEntity(new Bar(handler, spawnHeight));
			}
		} 
		
	}
	
	public boolean canAddEntity() {
		boolean thereIsAnObstacle = false;
		//if(player.getyPosition() + 200 )
		return thereIsAnObstacle;
	}
	
	public void updateDeadline() {
		//this.deadlinePosition;
	}
	
}
