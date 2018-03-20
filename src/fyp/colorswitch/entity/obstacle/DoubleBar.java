package fyp.colorswitch.entity.obstacle;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import fyp.colorswitch.Handler;

public class DoubleBar extends Obstacle {
	// declaration des 3 bars
	private BarWave barstare;
	private BarMovingRightToLeft barRtoL;
	private BarMovingLeftToRight barLtoR;
	private final int cas; //existe 3 cas de composition de deux bars

	public DoubleBar(Handler handler, float yPosition, int speed, int cas) {
		super(handler, yPosition);
		this.cas = cas;
		
		if (this.cas == 0) {
			
			barRtoL = new BarMovingRightToLeft(handler, yPosition, speed);
			barstare = new BarWave(handler, yPosition + 120, speed);// 150 espace entre les bars
			
			
		} else {
			if (this.cas == 1) {
				barRtoL = new BarMovingRightToLeft(handler, yPosition, speed);
				barLtoR = new BarMovingLeftToRight(handler, yPosition + 120, speed);
			} else {// cas 2
				
				barLtoR = new BarMovingLeftToRight(handler, yPosition, speed);
				barstare = new BarWave(handler, yPosition + 120, speed);
			}
		}

	}

	@Override
	public void tick() {// chaque bar fait ca mise a jour dans sa propore classe

	}

	@Override
	public void render(Graphics2D g) {
		if (cas == 0) {
			barstare.render(g);// afficher les bars
			barRtoL.render(g);
		} else {
			if (cas == 1) {
				barLtoR.render(g);
				barRtoL.render(g);
			} else {
				barstare.render(g);
				barLtoR.render(g);
			}
		}

	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {
		if (cas == 0) {
			
			if (barstare.collidesWith(body, color) ) {/* sil trouve une collision avec la premiere bar il retourn true et quitte ma methode
														sinon il passe a l autre bar */
				return true;
			} else {
				if (barRtoL.collidesWith(body, color)) {
					return true;
				} else
					return false;
			}
		} else {
			if (cas == 1) {
				
				if (barLtoR.collidesWith(body, color)) {
					return true;
				} else {
					if (barRtoL.collidesWith(body, color)) {
						return true;
					} else
						return false;
				}
			} else {
				
				if (barLtoR.collidesWith(body, color)) {
					return true;
				} else {
					if (barstare.collidesWith(body, color)) {
						return true;
					} else
						return false;
				}
			}
		}

	}

}