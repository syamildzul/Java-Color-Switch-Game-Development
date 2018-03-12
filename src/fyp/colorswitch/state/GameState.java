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
import fyp.colorswitch.world.World;

public class GameState extends State {
	
	private int playerScore;
	
	private float midPos = handler.getWidth() / 2;
	private float obsXspawn = midPos - midPos/2,
			obsYspawn = midPos;
	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler);
	}
	
	@Override
	public void tick() {
		world.tick();			
	}

	@Override
	public void render(Graphics2D g) {
		
		//if(player.getY() >= handler.getGame().getHeight())
		//	System.out.println("i'm in the upper section");
		
		world.render(g);
	}

}
