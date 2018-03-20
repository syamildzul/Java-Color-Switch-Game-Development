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
	// vitesse du mouvement de la bar
	private final int speed;

	// premiere bar // coordonées debut et fin de chaque ligne
	private int xsline, xsline2, xsline3, xsline4;
	private int xeline, xeline2, xeline3, xeline4;
	// deuxieme bar
	private int Sxsline, Sxsline2, Sxsline3, Sxsline4;
	private int Sxeline, Sxeline2, Sxeline3, Sxeline4;

	private float y;// position de la bar selon y
	private static int width = 500;// largeur de game state
	private Line2D line, line2, line3, line4, Sline, Sline2, Sline3, Sline4;
	private ArrayList<Line2D> lines = new ArrayList<Line2D>();// liste qui contiendera l ensemble des lignes

	public BarMovingRightToLeft(Handler handler, float yPosition, int speed) {
		super(handler, yPosition);
		this.speed = speed;
		y = yPosition
				- handler.getGameCamera().getyOffset();/*
														 * pour que y aura tjr la meme position y=yposition defini
														 * initialement - yoffset la hauteur deja parcouru par camera
														 */
		initialisation();

		// l ordre est important pour reconaitre la couleur
		lines.add(line = new Line2D.Double());// instancier chaque line et l'ajouter dans la liste
		lines.add(line2 = new Line2D.Double());
		lines.add(line3 = new Line2D.Double());
		lines.add(line4 = new Line2D.Double());
		// les 4 lignes de la 2eme bar
		lines.add(Sline = new Line2D.Double());
		lines.add(Sline2 = new Line2D.Double());
		lines.add(Sline3 = new Line2D.Double());
		lines.add(Sline4 = new Line2D.Double());

	}

	private void initialisation() {// affecter les valeur des coordonnées aux lignes dans gamestate
		// 1er bar
		xsline = 10; // 20 px laisser entre chaque ligne // 105 defini comme longueur de chaque ligne
		xeline = 115;

		xsline2 = 135;
		xeline2 = 240;

		xsline3 = 260;
		xeline3 = 365;

		xsline4 = 385;
		xeline4 = 490;
		/*
		 * initialisation 2eme bar chaque line aura la position ds le sens negatif pour
		 * avoir la bar qui apparait directement des qun pixel de la premiere bar
		 * disparait
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

		// le sens est right to left
		xsline -= speed;// la vitesse c le speed passé en parametre au constructeur
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

		if (Sxeline4 == 500) {// premiere bar est passé reinitialisation des deux bars
			initialisation();
		}
	}

	@Override
	public void render(Graphics2D g) {// g objet quis ns permet d afficher (dessiner) nos lines

		g.setStroke(new BasicStroke(20));// l'epaisseur de la bar
		TranslateBar(g);

	}

	public void TranslateBar(Graphics2D g) {
		y = yPosition- handler.getGameCamera().getyOffset(); /*
														 * pour que y aura tjr la meme position y=yposition defini
														 * initialement - yoffset la hauteur deja parcouru par camera
														 */

		lines.get(0).setLine(xsline, y, xeline, y);// recuperer chaque ligne de la liste et lui affecter ces coordonnées
		lines.get(1).setLine(xsline2, y, xeline2, y);
		lines.get(2).setLine(xsline3, y, xeline3, y);
		lines.get(3).setLine(xsline4, y, xeline4, y);

		lines.get(4).setLine(Sxsline, y, Sxeline, y);
		lines.get(5).setLine(Sxsline2, y, Sxeline2, y);
		lines.get(6).setLine(Sxsline3, y, Sxeline3, y);
		lines.get(7).setLine(Sxsline4, y, Sxeline4, y);

		// 1er bar
		g.setColor(Entity.colors[0]);// affecter une couleur au graphique
		g.draw(lines.get(0));// dessiner la line a l aide du graphique
		g.setColor(Entity.colors[1]);
		g.draw(lines.get(1));
		g.setColor(Entity.colors[2]);
		g.draw(lines.get(2));
		g.setColor(Entity.colors[3]);
		g.draw(lines.get(3));

		// 2eme bar
		g.setColor(Entity.colors[0]);
		g.draw(lines.get(4));
		g.setColor(Entity.colors[1]);
		g.draw(lines.get(5));
		g.setColor(Entity.colors[2]);
		g.draw(lines.get(6));
		g.setColor(Entity.colors[3]);
		g.draw(lines.get(7));

		tick(); // pour bouger la ligne creer

	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {// balle et sa couleur

		for (int i = 0; i < lines.size(); i++) {
			Area playerArea = new Area(body);// recuperer l area de la balle avc ces coordonnées
			Area lineArea = new Area(lines.get(i).getBounds());// recuperer l area des ligne avec leur limite
																// (getbounds)

			playerArea.intersect(lineArea);// playerarea recoit l intersection entre lui meme et l linearea
											// si y a pas d intersection entre les 2 , playerarea recoit null cad empty

			if (!playerArea.isEmpty()) {
				// cad il existe une intersection (collision)

				if (color != getcolor(i))// si couleur balle diff couleur ligne
					return true; // il existe collisions quitter la methode
			} else
				continue;// il existe pas d intersection
		}
		return false; // pas de collision line et balle sont disjoint
	}

	public int getcolor(int i) { 

		switch (i) {// retourner la couleur qui correspond a chaque ligne
		case 4:
			return 0;
		case 5:
			return 1;
		case 6:
			return 2;
		case 7:
			return 3;
		default:
			return i; // pr les ligne 0,1,2,3 retourner la mm valeur
		}

	}

}



