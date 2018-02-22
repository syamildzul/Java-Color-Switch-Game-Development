package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.Rectangle;
import java.awt.Shape;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import fyp.colorswitch.entity.obstacle.frames.Line;
import fyp.colorswitch.entity.obstacle.frames.*;
import java.awt.geom.Ellipse2D.Double;

public class Bar extends Obstacle {
	// First bar
	private int xsline, xsline2, xsline3, xsline4; // xstart of each line
	private int xeline, xeline2, xeline3, xeline4;// xend of each line
	// second bar
	private int Sxsline, Sxsline2, Sxsline3, Sxsline4;// xstart of each line
	private int Sxeline, Sxeline2, Sxeline3, Sxeline4;// xend of each line
	private float y;

	public Bar(Handler handler, float yPosition) {
		super(handler, yPosition);
		// initialisation of the first bar
		xsline = 1;
		xeline = 125;
		xsline2 = 125;
		xeline2 = 250;
		xsline3 = 250;
		xeline3 = 375;
		xsline4 = 375;
		xeline4 = 500;
		/*
		 * initialisation of the second bar each line takes minus line of the first bar
		 * to have the second bar that appears directly after the disappears of each
		 * pixel of the first bar
		 */
		Sxsline = -xsline;
		Sxeline = -xeline;
		Sxsline2 = -xsline2;
		Sxeline2 = -xeline2;
		Sxsline3 = -xsline3;
		Sxeline3 = -xeline3;
		Sxsline4 = -xsline4;
		Sxeline4 = -xeline4;

		y = yPosition - handler.getGameCamera().getyOffset();// widthposition of the bar on the screen
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {

		g.setStroke(new BasicStroke((float) 20));// l'epaisseur de la bar
		TranslateLine(g);

	}

	public void TranslateLine(Graphics2D g) {
		y = yPosition - handler.getGameCamera().getyOffset();

		Line2D line = new Line2D.Double(xsline, y, xeline, y);
		Line2D line2 = new Line2D.Double(xsline2, y, xeline2, y);
		Line2D line3 = new Line2D.Double(xsline3, y, xeline3, y);
		Line2D line4 = new Line2D.Double(xsline4, y, xeline4, y);

		Line2D Sline4 = new Line2D.Double(Sxeline, y, Sxsline, y);
		Line2D Sline3 = new Line2D.Double(Sxeline2, y, Sxsline2, y);
		Line2D Sline2 = new Line2D.Double(Sxeline3, y, Sxsline3, y);
		Line2D Sline = new Line2D.Double(Sxeline4, y, Sxsline4, y);

		xsline += 2;// vitesse du mouvement de 2
		xeline += 2;
		xsline2 += 2;
		xeline2 += 2;
		xsline3 += 2;
		xeline3 += 2;
		xsline4 += 2;
		xeline4 += 2;

		g.setColor(Entity.colors[0]);
		g.draw(line);
		g.setColor(Entity.colors[1]);
		g.draw(line2);
		g.setColor(Entity.colors[2]);
		g.draw(line3);
		g.setColor(Entity.colors[3]);
		g.draw(line4);

		Sxsline += 2;
		Sxeline += 2;
		Sxsline2 += 2;
		Sxeline2 += 2;
		Sxsline3 += 2;
		Sxeline3 += 2;
		Sxsline4 += 2;
		Sxeline4 += 2;		

		g.setColor(Entity.colors[0]);
		g.draw(Sline);
		g.setColor(Entity.colors[1]);
		g.draw(Sline2);
		g.setColor(Entity.colors[2]);
		g.draw(Sline3);
		g.setColor(Entity.colors[3]);
		g.draw(Sline4);

		if (Sxeline4 == 0) {
			xsline = 1;
			xeline = 125;
			xsline2 = 125;
			xeline2 = 250;
			xsline3 = 250;
			xeline3 = 375;
			xsline4 = 375;
			xeline4 = 500;

			Sxsline = -xsline;
			Sxeline = -xeline;
			Sxsline2 = -xsline2;
			Sxeline2 = -xeline2;
			Sxsline3 = -xsline3;
			Sxeline3 = -xeline3;
			Sxsline4 = -xsline4;
			Sxeline4 = -xeline4;
		}

	}

	@Override
	public boolean collidesWith(Shape body, int bodycolor) {
		// TODO Auto-generated method stub
		return false;
	}

}
