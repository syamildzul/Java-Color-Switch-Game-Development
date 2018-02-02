package fyp.colorswitch.state;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.ui.ClickListener;
import fyp.colorswitch.ui.UIImageButton;
import fyp.colorswitch.ui.UIManager;
import fyp.colorswitch.ui.UITitle;

public class MenuState extends State {

	private EntityManager entities;
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		entities = new EntityManager(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		// add entities
		entities.addEntity(new Circle(handler, midHeight - 100, 200, 3));
		entities.addEntity(new Circle(handler, midHeight - 75, 150, 1));
		entities.addEntity(new Circle(handler, midHeight - 50, 100, 2));
		
		uiManager.addObject(new UITitle(handler, 70, 300, 150, Assets.title));
		
		uiManager.addObject(new UIImageButton(handler, midHeight - 35, 70, 70, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
			
		}));
	}

	@Override
	public void tick() {
		entities.tick();
		uiManager.tick();
	}

	@Override
	public void render(Graphics2D g) {
		entities.render(g);
		g.setStroke(new BasicStroke(20));
		g.setColor(Color.white);
		g.draw(new Ellipse2D.Double(100, 100, 300, 300));
		Graphics gd = (Graphics) g;
		uiManager.render(gd);
	}
	
}
