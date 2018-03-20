package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.Entity;

public class BarWave extends Obstacle {
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

	public BarWave(Handler handler, float yPosition, int speed) {
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

	private void initialisation() {
		// initialisation of the first bar
		xsline = 10; // 18 px entre chaque ligne pour quelle se colle
		xeline = 117;

		xsline2 = 135;
		xeline2 = 242;

		xsline3 = 260;
		xeline3 = 367;

		xsline4 = 385;
		xeline4 = 492;
		/*
		 * initialisation 2eme bar chaque line aura la position ds le sens negatif pour
		 * avoir la bar qui apparait directement des qun pixel de la premiere bar
		 * disparait
		 */
		Sxsline = xsline - width;
		Sxeline = xeline - width;
		Sxsline2 = xsline2 - width;
		Sxeline2 = xeline2 - width;
		Sxsline3 = xsline3 - width;
		Sxeline3 = xeline3 - width;
		Sxsline4 = xsline4 - width;
		Sxeline4 = xeline4 - width;

	}

	@Override
	public void tick() {

		// le sens est left to right

		xsline += speed;// la vitesse c le speed passé en parametre au constructeur
		xeline += speed;
		xsline2 += speed;
		xeline2 += speed;
		xsline3 += speed;
		xeline3 += speed;
		xsline4 += speed;
		xeline4 += speed;
		// seconde bar
		Sxsline += speed;
		Sxeline += speed;
		Sxsline2 += speed;
		Sxeline2 += speed;
		Sxsline3 += speed;
		Sxeline3 += speed;
		Sxsline4 += speed;
		Sxeline4 += speed;

		if (Sxsline == 0) {// premiere bar est passé reinitialisation des deux bars
			initialisation();
		}

	}

	@Override
	public void render(Graphics2D g) {

		g.setStroke(new BasicStroke(20));
		TranslateBar(g);

	}

	int i = 0, j = 0, p = 30, z = 20;

	// variable qui nous permet de simuler le deplacement vertical
	// p la vitesse du changement des variable de simulation(i,j) . z sert a garder
	// l'ancienne valeur de i
	
	private void deplacementV() {
		y = yPosition - handler.getGameCamera().getyOffset();
			// position de y est consideré de position 0 par rapport a i, j
		if (p == 30) { // on appelle la methode deplacementV 30 fois pour pouvoir changer les vars 
			if (i == 0) {// je suis dans la position y , i soit augmente soit diminue pour donner l illusion que la ligne de deplace verticalement

				if (z == 20) {
					i -= 20; // i diminue la ligne se deplace vers le haut
				} else {
					i += 20;// i augmente la lignee se deplace vers le bas
				}
				z = i;// garder la valeur de i pour l utiliser la prochaine fois

			} else {// se bloc remet i a 0
				if (i == 20) {
					i -= 20;
				} else {
					if (i == -20)
						i += 20;
				}
			}

			if (i == 0) {// on adapte la valeur de j selon celle de i
				j = z;// derniere valeur de i
			} else {//si i s est deplacé on remet j a 0
				if (j == 20) {
					j -= 20;
				} else {
					if (j == -20) {
						j += 20;
					}
				}
			}

			p -= 30;
		}

		p++;

	}

	private void TranslateBar(Graphics2D g) {
		deplacementV();
	
	
		lines.get(0).setLine(xsline, y + i, xeline, y + j);

		lines.get(1).setLine(xsline2, y + j, xeline2, y + i);
		lines.get(2).setLine(xsline3, y + i, xeline3, y + j);
		lines.get(3).setLine(xsline4, y + j, xeline4, y + i);

		lines.get(4).setLine(Sxsline, y + i, Sxeline, y + j);
		lines.get(5).setLine(Sxsline2, y + j, Sxeline2, y + i);
		lines.get(6).setLine(Sxsline3, y + i, Sxeline3, y + j);
		lines.get(7).setLine(Sxsline4, y + j, Sxeline4, y + i);

		g.setColor(Entity.colors[0]);
		g.draw(lines.get(4));
		g.setColor(Entity.colors[1]);
		g.draw(lines.get(5));
		g.setColor(Entity.colors[2]);
		g.draw(lines.get(6));
		g.setColor(Entity.colors[3]);
		g.draw(lines.get(7));

		g.setColor(Entity.colors[0]);
		g.draw(lines.get(0));
		g.setColor(Entity.colors[1]);
		g.draw(lines.get(1));
		g.setColor(Entity.colors[2]);
		g.draw(lines.get(2));
		g.setColor(Entity.colors[3]);
		g.draw(lines.get(3));

		tick();

	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {

		for (int i = 0; i < lines.size(); i++) {
			Area playerArea = new Area(body);
			Area lineArea = new Area(lines.get(i).getBounds());
			playerArea.intersect(lineArea);

			if (!playerArea.isEmpty()) {
				if (color != getcolor(i))
					return true;
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
