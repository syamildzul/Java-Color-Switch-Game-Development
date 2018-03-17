package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;
import java.util.ArrayList;

public class BarMovingRightToLeft extends Obstacle {
	// The speed movement of the bar
	private static final int speed = 1;
	// First bar
	private int xsline, xsline2, xsline3, xsline4; // xstart of each line
	private int xeline, xeline2, xeline3, xeline4;// xend of each line
	// second bar
	private int Sxsline, Sxsline2, Sxsline3, Sxsline4;// xstart of each line
	private int Sxeline, Sxeline2, Sxeline3, Sxeline4;// xend of each line
	private float y;
	// the width of the screen
	private int width = 500;

	private Line2D line, line2, line3, line4, Sline, Sline2, Sline3, Sline4;
	private ArrayList<Line2D> lines;

	public BarMovingRightToLeft(Handler handler, float yPosition) {
		super(handler, yPosition,0);
		y = yPosition - handler.getGameCamera().getyOffset();// widthposition of
																// the bar on
																// the screen
		
		initialisation();

		lines = new ArrayList<Line2D>();

		lines.add(line = new Line2D.Double(xsline, y, xeline, y));// l ordre est important pour savoir la couleur de
																	// chak ligne qu on pointe
		lines.add(line2 = new Line2D.Double(xsline2, y, xeline2, y));
		lines.add(line3 = new Line2D.Double(xsline3, y, xeline3, y));
		lines.add(line4 = new Line2D.Double(xsline4, y, xeline4, y));

		lines.add(Sline = new Line2D.Double(Sxsline, y, Sxeline, y));
		lines.add(Sline2 = new Line2D.Double(Sxsline2, y, Sxeline2, y));
		lines.add(Sline3 = new Line2D.Double(Sxsline3, y, Sxeline3, y));
		lines.add(Sline4 = new Line2D.Double(Sxsline4, y, Sxeline4, y));
	}
	
	private void initialisation() {
		// initialisation of the first bar
		xsline = 10;
		xeline = 115; // on laisse 1 px entre chaque lines pour ne pas avoir le
						// pixel de la premiere ligne en dessous dela deuxieme
						// ligne
		xsline2 = 135;
		xeline2 = 240;
		
		xsline3 = 260;
		xeline3 = 365;
		
		xsline4 = 385;
		xeline4 = 490;
		/*
		 * initialisation of the second bar each line takes minus line of the first bar
		 * to have the second bar that appears directly after the disappears of each
		 * pixel of the first bar
		 */
		Sxsline = xsline + width;
		Sxeline = xeline + width;
		Sxsline2 = xsline2 + width;
		Sxeline2 = xeline2 + width;
		Sxsline3 = xsline3 + width;
		Sxeline3 = xeline3 + width;
		Sxsline4 = xsline4 + width;
		Sxeline4 = xeline4 + width;

	}


	@Override
	public void tick() {

		// the sens is left to right
		xsline -= speed;// vitesse du mouvement de 2
		xeline -= speed;
		xsline2 -= speed;
		xeline2 -= speed;
		xsline3 -= speed;
		xeline3 -= speed;
		xsline4 -= speed;
		xeline4 -= speed;

		Sxsline -= speed;
		Sxeline -= speed;
		Sxsline2 -= speed;
		Sxeline2 -= speed;
		Sxsline3 -= speed;
		Sxeline3 -= speed;
		Sxsline4 -= speed;
		Sxeline4 -= speed;

		if (Sxeline4 == 490) {
			initialisation();
		}
	}

	@Override
	public void render(Graphics2D g) {

		g.setStroke(new BasicStroke(20));// l'epaisseur de la bar
		TranslateBar(g);

	}

	public void TranslateBar(Graphics2D g) {
		y = yPosition - handler.getGameCamera().getyOffset();

		lines.get(0).setLine(new Line2D.Double(xsline, y, xeline, y));
		lines.get(1).setLine(new Line2D.Double(xsline2, y, xeline2, y));
		lines.get(2).setLine(new Line2D.Double(xsline3, y, xeline3, y));
		lines.get(3).setLine(new Line2D.Double(xsline4, y, xeline4, y));

		lines.get(4).setLine(new Line2D.Double(Sxsline, y, Sxeline, y));
		lines.get(5).setLine(new Line2D.Double(Sxsline2, y, Sxeline2, y));
		lines.get(6).setLine(new Line2D.Double(Sxsline3, y, Sxeline3, y));
		lines.get(7).setLine(new Line2D.Double(Sxsline4, y, Sxeline4, y));

		// its for drawing the first bar that appears directly on the main
		// screen
		g.setColor(Entity.colors[0]);
		g.draw(line);
		g.setColor(Entity.colors[1]);
		g.draw(line2);
		g.setColor(Entity.colors[2]);
		g.draw(line3);
		g.setColor(Entity.colors[3]);
		g.draw(line4);

		// its for drawing the second bar
		g.setColor(Entity.colors[0]);
		g.draw(Sline);
		g.setColor(Entity.colors[1]);
		g.draw(Sline2);
		g.setColor(Entity.colors[2]);
		g.draw(Sline3);
		g.setColor(Entity.colors[3]);
		g.draw(Sline4);
		
		
		tick();

	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {

		for (int i = 0; i < lines.size(); i++) {
			Area playerArea = new Area(body);
			Area lineArea = new Area(lines.get(i).getBounds());
			// System.out.println(leslines.get(i).getBounds());
			playerArea.intersect(lineArea);// playerarea recoit l intersection
											// entre lui mm et l arcarea

			if (!playerArea.isEmpty()) { // si y a pas d intersection entre les
											// 2 playerarea recoit null cad
											// empty

				if (color != getcolor(i))// si couleur balle diff couleur
					// arc
					return true; // il existe collisions quitter la methode
			} else
				continue;
		}
		return false;
	}

	public int getcolor(int i) {
		switch (i) {
		case 4:
			return 0;
		case 5:
			return 1;
		case 6:
			return 2;
		case 7:
			return 3;
		default:
			return i;
		}
	}

}
