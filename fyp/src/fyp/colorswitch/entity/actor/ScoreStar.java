package fyp.colorswitch.entity.actor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D.Double;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class ScoreStar extends Actor {
	
	private Polygon star;
	private int[] xList, yList;
	private double size, maxSize, minSize;
	private double angularSpeed;
    private boolean increasing = false;
    private int edges;
    int temp = 270;
	
	public ScoreStar(Handler handler, float yPosition, int edges, double size) {
		super(handler, yPosition);
		this.edges = edges;
		xList = new int[edges];
	    yList = new int[edges];
	    this.size = size;
	    maxSize = 1.2 * size;
	    minSize = 0.8 * size;
	    for (int i = 0; i < edges; i++) {
	    	double angle = 90 + 360.0 / edges * i; //starts vertical, shifts 36 everytime
	        if (i % 2 == 0) {
	        	xList[i] = (int) (yPosition + size * Math.cos(Math.toRadians(angle)));
	            yList[i] = (int) (yPosition + size * Math.sin(Math.toRadians(angle)));
	        } else {
	       	 	xList[i] = (int) (yPosition + 0.5 * size * Math.cos(Math.toRadians(angle)));
	            yList[i] = (int) (yPosition + 0.5 * size * Math.sin(Math.toRadians(angle)));
	        }
	    }
	    star = new Polygon(xList, yList, edges);
	}

	@Override
	public void tick() {
		//updateyPosition();
	}

	@Override
	public void render(Graphics2D g) {
		temp += angularSpeed;
        temp %= 360;
        g.setColor(Color.white);

        //code to change star size pulsation
        if (size > maxSize) {
            increasing = false;
        }
        if (size < minSize) {
            increasing = true;
        }
        if (increasing) {
            size *= 1.005;
        } else {
            size *= 0.995;
        }

        for (int i = 0; i < edges; i++) {
            double angle = temp + 360.0 / edges * i; //starts vertical, shifts 36 everytime
            //code to define vertices of star
            if (i % 2 == 0) {
                xList[i] = (int) (yPosition + size * Math.cos(Math.toRadians(angle)));
                yList[i] = (int) (yPosition - handler.getGameCamera().getyOffset() + size * Math.sin(Math.toRadians(angle)));
            } else {
                xList[i] = (int) (yPosition + 0.5 * size * Math.cos(Math.toRadians(angle)));
                yList[i] = (int) (yPosition - handler.getGameCamera().getyOffset() + 0.5 * size * Math.sin(Math.toRadians(angle)));
            }
        }
        star = new Polygon(xList, yList, edges);
		/*
		int xPoints[] = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
		int yPoints[] = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};
		*/
		g.setColor(Color.WHITE);
		g.fill(star);
		//g.fillPolygon(xList, yList, edges);
		
	}

	@Override
	public boolean collidesWith(Double body, int color) {
		// TODO Auto-generated method stub
		return false;
	}

}
