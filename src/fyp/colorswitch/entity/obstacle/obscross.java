package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.geom.Line2D;

import fyp.colorswitch.Handler;

public class obscross extends Obstacle {

//	private float strokeval,xsizeFrame,ysizeFrame,xMidFrame,yMidFrame;

	private static final int MAX_STATE = 359;
	
	private int strokeval = 20;
	private int xsizeFrame = 500;
	//private int ysizeFrame = 700;
	private int xMidFrame = xsizeFrame/2;
	private float yMidFrame = yPosition;
	
	
	public static final Color colors[] = {new Color(50, 226, 241),
	        new Color(244, 222, 14), new Color(140, 18, 251), new Color(255, 0, 128)};
	
	private int state; //for rotation
	private int rangestate; //for collision
	
	private ArrayList<Line2D> lesCross;

	public obscross(Handler handler, float yPosition) {
		super(handler, yPosition);
		// TODO Auto-generated constructor stub
		yPosition = yPosition - handler.getGameCamera().getyOffset();
		
		Line2D lintop = new Line2D.Float(xMidFrame,yMidFrame-strokeval-100-handler.getGameCamera().getyOffset(),xMidFrame,yMidFrame-strokeval-handler.getGameCamera().getyOffset());
		Line2D linright = new Line2D.Float(xMidFrame+strokeval,yMidFrame-handler.getGameCamera().getyOffset(),xMidFrame+100+strokeval,yMidFrame-handler.getGameCamera().getyOffset());
		Line2D linbot = new Line2D.Float(xMidFrame,yMidFrame+strokeval-handler.getGameCamera().getyOffset(),xMidFrame,yMidFrame+strokeval+100-handler.getGameCamera().getyOffset());
		Line2D linleft = new Line2D.Float(xMidFrame-strokeval-100,yMidFrame-handler.getGameCamera().getyOffset(),xMidFrame-strokeval,yMidFrame-handler.getGameCamera().getyOffset());
		
		lesCross = new ArrayList<Line2D>();
		
		lesCross.add(lintop);
		lesCross.add(linright);
		lesCross.add(linbot);
		lesCross.add(linleft);
		
	}



	@Override
	public void tick() {
		state++;
		if (state == MAX_STATE) {
			state = 0;
		}
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = g;
		g2.setStroke(new BasicStroke(strokeval));
		
		
		Line2D lintop = new Line2D.Float(xMidFrame,yMidFrame-strokeval-100-handler.getGameCamera().getyOffset(),xMidFrame,yMidFrame-strokeval-handler.getGameCamera().getyOffset());
		Line2D linright = new Line2D.Float(xMidFrame+strokeval,yMidFrame-handler.getGameCamera().getyOffset(),xMidFrame+100+strokeval,yMidFrame-handler.getGameCamera().getyOffset());
		Line2D linbot = new Line2D.Float(xMidFrame,yMidFrame+strokeval-handler.getGameCamera().getyOffset(),xMidFrame,yMidFrame+strokeval+100-handler.getGameCamera().getyOffset());
		Line2D linleft = new Line2D.Float(xMidFrame-strokeval-100,yMidFrame-handler.getGameCamera().getyOffset(),xMidFrame-strokeval,yMidFrame-handler.getGameCamera().getyOffset());
		
	
		AffineTransform at15 = AffineTransform.getRotateInstance(Math.toRadians(15),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at30 = AffineTransform.getRotateInstance(Math.toRadians(30),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at60 = AffineTransform.getRotateInstance(Math.toRadians(60),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at75 = AffineTransform.getRotateInstance(Math.toRadians(75),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at105 = AffineTransform.getRotateInstance(Math.toRadians(105),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at120 = AffineTransform.getRotateInstance(Math.toRadians(120),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at150 = AffineTransform.getRotateInstance(Math.toRadians(150),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at165 = AffineTransform.getRotateInstance(Math.toRadians(165),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at195 = AffineTransform.getRotateInstance(Math.toRadians(195),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at210 = AffineTransform.getRotateInstance(Math.toRadians(210),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at240 = AffineTransform.getRotateInstance(Math.toRadians(240),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at255 = AffineTransform.getRotateInstance(Math.toRadians(255),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at285 = AffineTransform.getRotateInstance(Math.toRadians(285),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at300 = AffineTransform.getRotateInstance(Math.toRadians(300),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at330 = AffineTransform.getRotateInstance(Math.toRadians(330),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at345 = AffineTransform.getRotateInstance(Math.toRadians(345),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		
		AffineTransform at45 = AffineTransform.getRotateInstance(Math.toRadians(45),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at90 = AffineTransform.getRotateInstance(Math.toRadians(90),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at135 = AffineTransform.getRotateInstance(Math.toRadians(135),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at180 = AffineTransform.getRotateInstance(Math.toRadians(180),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at225 = AffineTransform.getRotateInstance(Math.toRadians(225),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at270 = AffineTransform.getRotateInstance(Math.toRadians(270),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());
		AffineTransform at315 = AffineTransform.getRotateInstance(Math.toRadians(315),xMidFrame,yMidFrame-handler.getGameCamera().getyOffset());

		if (state>=0 && state<15) {
			
	        g2.setColor(colors[0]);
			g2.draw(lintop);
			
			g2.setColor(colors[1]);
			g2.draw(linright);
			
			g2.setColor(colors[2]);
			g2.draw(linbot);
			
			g2.setColor(colors[3]);
			g2.draw(linleft);
			
			
		}else if(state >= 15 && state<30) {
	        g2.setColor(colors[0]);
			g2.draw(at15.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at15.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at15.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at15.createTransformedShape(linleft));
			
			
		}else if(state >= 30 && state<45) {
	        g2.setColor(colors[0]);
			g2.draw(at30.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at30.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at30.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at30.createTransformedShape(linleft));
			
			
		}else if(state >= 45 && state<60) {
	        g2.setColor(colors[0]);
			g2.draw(at45.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at45.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at45.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at45.createTransformedShape(linleft));
			
			
		}else if(state >= 60 && state<75) {
	        g2.setColor(colors[0]);
			g2.draw(at60.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at60.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at60.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at60.createTransformedShape(linleft));
			
			
		}else if(state >= 75 && state<90) {
	        g2.setColor(colors[0]);
			g2.draw(at75.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at75.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at75.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at75.createTransformedShape(linleft));
			
			
		}else if(state >= 90 && state<105) {
	        g2.setColor(colors[0]);
			g2.draw(at90.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at90.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at90.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at90.createTransformedShape(linleft));
			
			
		}else if(state >= 105 && state<120) {
	        g2.setColor(colors[0]);
			g2.draw(at105.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at105.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at105.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at105.createTransformedShape(linleft));
			
			
		}else if(state >= 120 && state<135) {
	        g2.setColor(colors[0]);
			g2.draw(at120.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at120.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at120.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at120.createTransformedShape(linleft));
			
			
		}else if(state >= 135 && state<150) {
	        g2.setColor(colors[0]);
			g2.draw(at135.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at135.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at135.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at135.createTransformedShape(linleft));
			
			
		}else if(state >= 150 && state<165) {
	        g2.setColor(colors[0]);
			g2.draw(at150.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at150.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at150.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at150.createTransformedShape(linleft));
			
			
		}else if(state >= 165 && state<180) {
	        g2.setColor(colors[0]);
			g2.draw(at165.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at165.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at165.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at165.createTransformedShape(linleft));
			
			
		}else if(state >= 180 && state<195) {
	        g2.setColor(colors[0]);
			g2.draw(at180.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at180.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at180.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at180.createTransformedShape(linleft));
			
			
		}else if(state >= 195 && state<210) {
	        g2.setColor(colors[0]);
			g2.draw(at195.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at195.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at195.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at195.createTransformedShape(linleft));
			
			
		}else if(state >= 210 && state<225) {
	        g2.setColor(colors[0]);
			g2.draw(at210.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at210.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at210.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at210.createTransformedShape(linleft));
			
			
		}else if(state >= 225 && state<240) {
	        g2.setColor(colors[0]);
			g2.draw(at225.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at225.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at225.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at225.createTransformedShape(linleft));
			
			
		}else if(state >= 240 && state<255) {
	        g2.setColor(colors[0]);
			g2.draw(at240.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at240.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at240.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at240.createTransformedShape(linleft));
			
			
		}else if(state >= 255 && state<270) {
	        g2.setColor(colors[0]);
			g2.draw(at255.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at255.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at255.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at255.createTransformedShape(linleft));
			
			
		}else if(state >= 270 && state<285) {
	        g2.setColor(colors[0]);
			g2.draw(at270.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at270.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at270.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at270.createTransformedShape(linleft));
			
			
		}else if(state >= 285 && state<300) {
	        g2.setColor(colors[0]);
			g2.draw(at285.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at285.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at285.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at285.createTransformedShape(linleft));
			
			
		}else if(state >= 300 && state<315) {
	        g2.setColor(colors[0]);
			g2.draw(at300.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at300.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at300.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at300.createTransformedShape(linleft));
			
			
		}else if(state >= 315 && state<330) {
	        g2.setColor(colors[0]);
			g2.draw(at315.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at315.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at315.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at315.createTransformedShape(linleft));
			
			
		}else if(state >= 330 && state<345) {
	        g2.setColor(colors[0]);
			g2.draw(at330.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at330.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at330.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at330.createTransformedShape(linleft));
			
			
		}else if(state >= 345 && state<360) {
	        g2.setColor(colors[0]);
			g2.draw(at345.createTransformedShape(lintop));
			
			g2.setColor(colors[1]);
			g2.draw(at345.createTransformedShape(linright));
			
			g2.setColor(colors[2]);
			g2.draw(at345.createTransformedShape(linbot));
			
			g2.setColor(colors[3]);
			g2.draw(at345.createTransformedShape(linleft));
			
			
		}
	}



	@Override
	public boolean collidesWith(Ellipse2D.Double body, int bodycolor) {
		boolean collision = false;
		
		//bot line collision
		if((yMidFrame+strokeval-handler.getGameCamera().getyOffset()<=body.getCenterY()) && (yMidFrame+strokeval+100-handler.getGameCamera().getyOffset()>=body.getCenterX())) {
			if(rangestate==23 || rangestate == 0 || rangestate == 1) {
				if(bodycolor!=2) {collision = true;} else collision = false;
			}else if(rangestate==6) {
				if(bodycolor!=1) {collision = true;} else collision = false;
			}else if(rangestate==12) {
				if(bodycolor!=0) {collision = true;} else collision = false;
			}else if(rangestate==18) {
				if(bodycolor!=3) {collision = true;} else collision = false;
			}else collision = false;
				
		//top line collision
		}else if((yMidFrame-strokeval-100-handler.getGameCamera().getyOffset()<=body.getCenterY()) && (yMidFrame-strokeval-handler.getGameCamera().getyOffset()>=body.getCenterY()))
			if(rangestate==23 || rangestate == 0 || rangestate == 1) {
				if(bodycolor!=0) {collision = true;} else collision = false;
			}else if(rangestate==5 || rangestate == 6 || rangestate == 7) {
				if(bodycolor!=3) {collision = true;} else collision = false;
			}else if(rangestate==11 || rangestate == 12 || rangestate == 13) {
				if(bodycolor!=2) {collision = true;} else collision = false;
			}else if(rangestate==17 || rangestate == 18 || rangestate == 19) {
				if(bodycolor!=1) {collision = true;} else collision = false;
			}else collision = false;
		
		return collision;
	}
}
