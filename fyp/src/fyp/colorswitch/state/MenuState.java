package fyp.colorswitch.state;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.obstacle.Arc;
import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.ui.ClickListener;
import fyp.colorswitch.ui.UIImageButton;
import fyp.colorswitch.ui.UIManager;
import fyp.colorswitch.ui.UITitle;

public class MenuState extends State {

	private EntityManager e;
	private UIManager ui;
	
	public MenuState(Handler handler) {
		super(handler);
		e = new EntityManager(handler);
		ui = new UIManager(handler);
		//if(handler.getMouseManager() == null)
			handler.getMouseManager().setUIManager(ui);
		// add entities
		e.addEntity(new Circle(handler, midHeight, 200, 3));
		e.addEntity(new Circle(handler, midHeight, 150, 1));
		e.addEntity(new Circle(handler, midHeight, 100, 2));
		e.addEntity(new Arc(handler, midHeight, 200, 0, 1));
		
		ui.addObject(new UITitle(handler, 70, 300, 150, Assets.title));
		
		ui.addObject(new UIImageButton(handler, midHeight - 35, 70, 70, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
			
		}));
	}

	@Override
	public void tick() {
		e.tick();
		ui.tick();
	}

	@Override
	public void render(Graphics2D g) {
		e.render(g);
		g.setStroke(new BasicStroke(20));
		//g.setColor(Color.white);
		//g.draw(new Ellipse2D.Double(100, 100, 300, 300));
		Graphics gd = (Graphics) g;
		ui.render(gd);
	}
	
}
