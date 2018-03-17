package fyp.colorswitch.entity.obstacle;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import fyp.colorswitch.Handler;

public class DoubleBar extends Obstacle {
	// declaration of the two bars
	private BarMovingLeftToRight barLtoR;
	private BarMovingRightToLeft barRtoL;

	public DoubleBar(Handler handler, float yPosition) {
		super(handler, yPosition, 0);
		barLtoR = new BarMovingLeftToRight(handler, yPosition + 200);// 100
																		// space
																		// between
																		// the
																		// two
																		// bars
		barRtoL = new BarMovingRightToLeft(handler, yPosition);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {
		barLtoR.render(g);
		barRtoL.render(g);
	}

	@Override
	public boolean collidesWith(Ellipse2D.Double body, int color) {
		if (barLtoR.collidesWith(body, color)) {
			return true;
		} else {
			if (barRtoL.collidesWith(body, color)) {
				return true;
			} else
				return false;
		}

	}

}
