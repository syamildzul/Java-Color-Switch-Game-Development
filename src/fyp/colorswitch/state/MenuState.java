package fyp.colorswitch.state;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.obstacle.Circle;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.ui.ClickListener;
import fyp.colorswitch.ui.UIImageButton;
import fyp.colorswitch.ui.UIManager;
import fyp.colorswitch.ui.UIImage;

public class MenuState extends State {

	private EntityManager e;
	private UIManager ui;
	
	public MenuState(Handler handler) {
		super(handler);
		e = new EntityManager(handler);
		ui = new UIManager(handler);
		handler.getMouseManager().setUIManager(ui);
		
		// add entities to show at the menu interface
		e.addEntity(new Circle(handler, midHeight, 200, 3));
		e.addEntity(new Circle(handler, midHeight, 150, 1));
		e.addEntity(new Circle(handler, midHeight, 100, 2));
		
		ui.addObject(new UIImage(handler, 70, 300, 150, Assets.title));
		
		ui.addObject(new UIImageButton(handler, midHeight - 35, 70, 70, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State gameState = new GameState(handler);
				State.setState(gameState);
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
		
		Graphics gd = g;
		ui.render(gd);
		
	}
	
}
