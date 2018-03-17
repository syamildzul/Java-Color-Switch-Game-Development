package fyp.colorswitch.entity.obstacle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import fyp.colorswitch.Handler;

public class obsrectangle extends Obstacle {
	
	private static final int MAX_STATE = 400;
	
	private int strokeval = 20;
	private int xsizeFrame = 500;
	//private int ysizeFrame = 700;
	private int xMidFrame = xsizeFrame/2;
	private float yMidFrame = yPosition;
	
    Line2D linleft = new Line2D.Float(xMidFrame-50-strokeval,yMidFrame-50-handler.getGameCamera().getyOffset(),xMidFrame-50-strokeval,yMidFrame+50-handler.getGameCamera().getyOffset()); 
    Line2D lintop = new Line2D.Float(xMidFrame-50,yMidFrame-50-strokeval-handler.getGameCamera().getyOffset(),xMidFrame+50,yMidFrame-50-strokeval-handler.getGameCamera().getyOffset());
    Line2D linright = new Line2D.Float(xMidFrame+50+strokeval,yMidFrame-50-handler.getGameCamera().getyOffset(),xMidFrame+50+strokeval,yMidFrame+50-handler.getGameCamera().getyOffset());
    Line2D linbot = new Line2D.Float(xMidFrame-50,yMidFrame+50+strokeval-handler.getGameCamera().getyOffset(),xMidFrame+50,yMidFrame+50+strokeval-handler.getGameCamera().getyOffset());
    
	
	public static final Color colors[] = {new Color(50, 226, 241),
	        new Color(244, 222, 14), new Color(140, 18, 251), new Color(255, 0, 128)};

	private int state; //for rotation
	private int rangestate; //for collision
	
	public obsrectangle(Handler handler, float yPosition) {
		super(handler, yPosition,0);
		yPosition = yPosition - handler.getGameCamera().getyOffset();
		// TODO Auto-generated constructor stub
		

	}
	
	//+15 angle rotation
	AffineTransform at15 = AffineTransform.getRotateInstance(Math.toRadians(15),xMidFrame,yPosition);
	AffineTransform at30 = AffineTransform.getRotateInstance(Math.toRadians(30),xMidFrame,yPosition);
	AffineTransform at60 = AffineTransform.getRotateInstance(Math.toRadians(60),xMidFrame,yPosition);
	AffineTransform at75 = AffineTransform.getRotateInstance(Math.toRadians(75),xMidFrame,yPosition);
	AffineTransform at105 = AffineTransform.getRotateInstance(Math.toRadians(105),xMidFrame,yPosition);
	AffineTransform at120 = AffineTransform.getRotateInstance(Math.toRadians(120),xMidFrame,yPosition);
	AffineTransform at150 = AffineTransform.getRotateInstance(Math.toRadians(150),xMidFrame,yPosition);
	AffineTransform at165 = AffineTransform.getRotateInstance(Math.toRadians(165),xMidFrame,yPosition);
	AffineTransform at195 = AffineTransform.getRotateInstance(Math.toRadians(195),xMidFrame,yPosition);
	AffineTransform at210 = AffineTransform.getRotateInstance(Math.toRadians(210),xMidFrame,yPosition);
	AffineTransform at240 = AffineTransform.getRotateInstance(Math.toRadians(240),xMidFrame,yPosition);
	AffineTransform at255 = AffineTransform.getRotateInstance(Math.toRadians(255),xMidFrame,yPosition);
	AffineTransform at285 = AffineTransform.getRotateInstance(Math.toRadians(285),xMidFrame,yPosition);
	AffineTransform at300 = AffineTransform.getRotateInstance(Math.toRadians(300),xMidFrame,yPosition);
	AffineTransform at330 = AffineTransform.getRotateInstance(Math.toRadians(330),xMidFrame,yPosition);
	AffineTransform at345 = AffineTransform.getRotateInstance(Math.toRadians(345),xMidFrame,yPosition);
	
	//+45 angle rotation
	AffineTransform at45 = AffineTransform.getRotateInstance(Math.toRadians(45),xMidFrame,yPosition);
	AffineTransform at90 = AffineTransform.getRotateInstance(Math.toRadians(90),xMidFrame,yPosition);
	AffineTransform at135 = AffineTransform.getRotateInstance(Math.toRadians(135),xMidFrame,yPosition);
	AffineTransform at180 = AffineTransform.getRotateInstance(Math.toRadians(180),xMidFrame,yPosition);
	AffineTransform at225 = AffineTransform.getRotateInstance(Math.toRadians(225),xMidFrame,yPosition);
	AffineTransform at270 = AffineTransform.getRotateInstance(Math.toRadians(270),xMidFrame,yPosition);
	AffineTransform at315 = AffineTransform.getRotateInstance(Math.toRadians(315),xMidFrame,yPosition);
	
	
	@Override
	public void tick() {	
		state++;
		if (state == MAX_STATE) {
				state = 0;
			}
	}

	@Override
	public void render(Graphics2D g) {
		rotaterectangle(g);
	}
	
	public void rotaterectangle(Graphics2D g) {
	Graphics2D g2 = g;
    g2.setStroke(new BasicStroke(strokeval));
            
    
    linleft.setLine(xMidFrame-50-strokeval,yMidFrame-50-handler.getGameCamera().getyOffset(),xMidFrame-50-strokeval,yMidFrame+50-handler.getGameCamera().getyOffset()); 
    lintop.setLine(xMidFrame-50,yMidFrame-50-strokeval-handler.getGameCamera().getyOffset(),xMidFrame+50,yMidFrame-50-strokeval-handler.getGameCamera().getyOffset());
    linright.setLine(xMidFrame+50+strokeval,yMidFrame-50-handler.getGameCamera().getyOffset(),xMidFrame+50+strokeval,yMidFrame+50-handler.getGameCamera().getyOffset());
    linbot.setLine(xMidFrame-50,yMidFrame+50+strokeval-handler.getGameCamera().getyOffset(),xMidFrame+50,yMidFrame+50+strokeval-handler.getGameCamera().getyOffset());
    
    
	if (state < 100) {
	g2.setColor(colors[0]);
    g2.draw(linleft);
    
    g2.setColor(colors[1]);
    g2.draw(lintop);
    
    g2.setColor(colors[2]);
    g2.draw(linright);
    
    g2.setColor(colors[3]);
    g2.draw(linbot);
    
    rangestate = 0;
    
	}else if(state >= 100 && state <200) {
	g2.setColor(colors[3]);
    g2.draw(linleft);
    
    g2.setColor(colors[0]);
    g2.draw(lintop);
    
    g2.setColor(colors[1]);
    g2.draw(linright);
    
    g2.setColor(colors[2]);
    g2.draw(linbot);
    
    rangestate = 1;
    
	}else if(state >= 200 && state <300) {
	g2.setColor(colors[2]);
    g2.draw(linleft);
    
    g2.setColor(colors[3]);
    g2.draw(lintop);
    
    g2.setColor(colors[0]);
    g2.draw(linright);
    
    g2.setColor(colors[1]);
    g2.draw(linbot);
    
    rangestate = 2;
    
	}else if (state >= 300 && state <400) {
	g2.setColor(colors[1]);
    g2.draw(linleft);
    
    g2.setColor(colors[2]);
    g2.draw(lintop);
    
    g2.setColor(colors[3]);
    g2.draw(linright);
    
    g2.setColor(colors[0]);
    g2.draw(linbot);
    
    rangestate = 3;
	}
			
	}

	@Override
	public boolean collidesWith(Double body, int bodycolor) {
		// TODO Auto-generated method stub
		
		boolean collision = false;
		//bot collision
		if((yMidFrame+50+strokeval-handler.getGameCamera().getyOffset()+strokeval>=body.getCenterY()) &&  (yMidFrame+50+strokeval-handler.getGameCamera().getyOffset()<=body.getCenterY())){
			if((rangestate==0) && (bodycolor!=3)) {
				collision = true;
			}else if ((rangestate==1) && (bodycolor!=2)) {
				collision = true;
			}else if ((rangestate==2) && (bodycolor!=1)) {
				collision = true;
			}else if ((rangestate==3) && (bodycolor!=0)) {
				collision = true;
			}else collision = false;
		//top collision
		}else if((yMidFrame-50-strokeval-handler.getGameCamera().getyOffset()+strokeval>=body.getMinY()) && (yMidFrame-50-strokeval-handler.getGameCamera().getyOffset()<=body.getMinY())) {
			if((rangestate==0) && (bodycolor!=1)){
				collision = true;
			}else if((rangestate==1) && (bodycolor!=0)) {
				collision = true;
			}else if((rangestate==2) && (bodycolor!=3)) {
				collision = true;
			}else if((rangestate==3) && (bodycolor!=2)) {
				collision = true;
			}else if((rangestate==0) && (bodycolor!=1)) {
				collision = true;
			}else collision = false;
			
		}else collision = false;
		
		return collision;
	}

}
