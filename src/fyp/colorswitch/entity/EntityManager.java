package fyp.colorswitch.entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
import fyp.colorswitch.Handler;

// Cette classe est pour bien gérer tous les entités 

public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler) {
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick() {
		// update tous les entities
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics2D g) {
		// afficher tous les entities
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		// ajout d'entity dans l'arraylist entities
		entities.add(e);
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
	
	public float getyPosition(Entity e) {
		return e.getyPosition();
	}
	
	public int getLength() {
		return entities.size();
		
	}

}
