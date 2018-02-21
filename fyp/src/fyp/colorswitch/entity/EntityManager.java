package fyp.colorswitch.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.actor.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	/*
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity e1, Entity e2) { /*
			if(e1.getY() + e1.getHeight() < e2.getY() + e2.getHeight())
				return -1; 
			return 1;
		}
		
	};
	*/
	
	public EntityManager(Handler handler) {
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick() {
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics2D g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void updateyPosition() {
		for(int i = 0; i < entities.size(); i++) {
			
				continue;
			//e.setyPosition(e.getyPosition() + handler.getGameCamera().getyOffset());
		}
			
	}

	// Getters & Setters
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public float getyPosition(Entity e) {
		return e.getyPosition();
	}
	
	public int getLength() {
		return entities.size();
		
	}

}
