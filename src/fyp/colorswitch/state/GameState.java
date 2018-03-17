package fyp.colorswitch.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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
import fyp.colorswitch.world.World;

public class GameState extends State {
	
//	private float midPos = handler.getWidth() / 2;
//	private float obsXspawn = midPos - midPos/2,
//			obsYspawn = midPos;
	
	private Handler handler;
	private EntityManager em;
	
	private Player player;
	private Switcher switcher;
	private ScoreStar scoreStar;
	private Score score;
	
	private int playerscore;
	
	private float midHeight, midWidth;
	private float deadlinePosition = 0;
	
	private Rectangle2D bounds;
	
	//private World world;
	
	public GameState(Handler handler) {
		super(handler);
		this.handler = handler;
		//world = new World(handler);
		this.midWidth = handler.getWidth() / 2;
		this.midHeight = handler.getHeight() / 2;
		this.deadlinePosition = handler.getHeight();
		this.playerscore = 0;
		
		bounds = new Rectangle2D.Double(midWidth, (handler.getHeight()-100), 20, 20);
		score = new Score(handler, 50);
		
		em = new EntityManager(handler);
		// add entities
		//em.addEntity(new Circle(handler, 400, 200, 2));
		//em.addEntity(new Rectangle(handler, 0, 170));
		//em.addEntity(new RectangleLine(handler, 200, 170));
		//em.addEntity(new Cross(handler, 200, 100, 1));
		//em.addEntity(new Bar(handler, 300));
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
		//world.tick();	
		
		em.tick();	
		if(isGameOver()) {
			handler.getGame().getMouseManager().setUIManager(null);
			//State.getState().setUIManager(uimanager);
			State.setState(handler.getGame().gameOverState);
		}	
		if(checkCollisions())
			System.out.println("there's a collision"); // to see if the collision detection works 
		
		if(player.isMoving())
			totalymove += player.getyMove() / 2;
		//System.out.println(totalymove);
		if(player.getyPosition() < em.getEntities().get(em.getEntities().size()-1).getyPosition()+200) 
			randomSpawn();
	}

	@Override
	public void render(Graphics2D g) {
		
		em.render(g);
		score.render(g);
		//g.drawString(Integer.toString(playerscore), 300, 100);
		//g.drawImage(Assets.firefist[0], (handler.getWidth()/2)-50, (int) (handler.getHeight()-100 + totalymove), 100, 100, null);
		g.setColor(Color.white);
		//g.fill3DRect((int) (bounds.getX() - bounds.getWidth() / 2), (int) (handler.getHeight()-90 + totalymove), (int) bounds.getWidth(), (int) bounds.getHeight(), false);

		
		//world.render(g);
	}

	public boolean isGameOver() {
		//player.getP().intersects(firefist);
		if(player.isGameOver() || checkCollisions())
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
		
	public void randomSpawn() {
		
		int distanceBetweenObstacle = 300;
		int x = 0;
		x = handler.getGame().randomInt(2);
		int spawnHeight = (int) (em.getEntities().get(em.getEntities().size()-1).getyPosition() - distanceBetweenObstacle);
		
		switch(x) {
			case 0 : em.addEntity(new Circle(handler, spawnHeight, 200, 3)); break;
			case 1 : em.addEntity(new Bar(handler, spawnHeight)); break;
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
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
}
