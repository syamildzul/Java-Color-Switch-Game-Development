package fyp.colorswitch.entity.obstacle;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.obstacle.frames.Arc;

public class Circle extends Obstacle {

	private static final int DEFAULT_CIRCLE_DIAMETER = 200;
	private static final int DEFAULT_CIRCLE_THICKNESS = 15;
	private static final int DEFAULT_CIRCLE_ANGULARSPEED = 1;
	
	private int diameter = DEFAULT_CIRCLE_DIAMETER;
	private int angularSpeed = DEFAULT_CIRCLE_ANGULARSPEED; // le nombre à ajouter à l'angle courant de chaque tick
	private int thickness;
	private double currentAngle;
	
	private ArrayList<Arc> lesArc;
	
	public Circle(Handler handler, float y, int diameter, int angularSpeed) {
		super(handler, y - diameter / 2);
		x = midPos - diameter / 2;
		this.diameter = diameter;
		this.thickness = DEFAULT_CIRCLE_THICKNESS;
		this.currentAngle = 0;
		this.angularSpeed = angularSpeed;
		
		// initialisation de tableau d'arcs
		lesArc = new ArrayList<Arc>();
		
		// ajouts des arcs dans le tableau d'arcs
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle, 0));
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle + 90, 1));
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle + 180, 2));
		lesArc.add(new Arc(handler, yPosition, diameter, currentAngle + 270, 3));
		
	}

	public void updateAngle() {
		currentAngle = (currentAngle + angularSpeed) % 360;
	}	

	@Override
	public void tick() {
		updateAngle(); // màj de l'angle courant
	}
	
	@Override
	public void render(Graphics2D g) {
		
		lesArc.get(0).setAngleStart(currentAngle);
		lesArc.get(1).setAngleStart(currentAngle + 90);
		lesArc.get(2).setAngleStart(currentAngle + 180);
		lesArc.get(3).setAngleStart(currentAngle + 270);
		
		for (int i = 0; i < lesArc.size(); i++) {
			lesArc.get(i).render(g); // affichage de tous les arcs
		}

	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {
		
		for (int i = 0; i < lesArc.size(); i++) { // on va parcourir tous les arcs
			Area playerArea = new Area(body);
	        Area arcArea = new Area(lesArc.get(i).getArc());
	        
	        playerArea.intersect(arcArea); // ceci donne l'aire de l'intersection 
	        							   //des deux aires
	        
	        if (!playerArea.isEmpty()) { // si l'aire n'est pas vide alors, il y a collision 
	        	
	        	if(color != lesArc.get(i).getColorType()) // check la couleur
	        		return true;
	        }
	        else 
	        	continue;
		}
		
		return false;
	}	
	
	
	// Getters and Setters
	
	public int getAngularSpeed() {
		return angularSpeed;
	}

	public void setAngularSpeed(int angularSpeed) {
		this.angularSpeed = angularSpeed;
	}

	public double getCurrentAngle() {
		return currentAngle;
	}

	public void setCurrentAngle(double currentAngle) {
		this.currentAngle = currentAngle;
	}
	 
}
