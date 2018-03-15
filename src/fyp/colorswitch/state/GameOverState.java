package fyp.colorswitch.state;

import java.awt.Graphics;
import java.awt.Graphics2D;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.ui.ClickListener;
import fyp.colorswitch.ui.UIImageButton;
import fyp.colorswitch.ui.UIManager;

public class GameOverState extends State {

	private EntityManager e;
	private UIManager ui;
	
	public GameOverState(Handler handler) {
		super(handler);
		e = new EntityManager(handler);
		ui = new UIManager(handler);
		//if(handler.getMouseManager() == null)
			//handler.getMouseManager().setUIManager(ui);
		
		ui.addObject(new UIImageButton(handler, midHeight - 35, 70, 70, Assets.replay, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
			
		}));
		
	}

	@Override
	public void tick() {
		ui.tick();
	}

	@Override
	public void render(Graphics2D g) {
		Graphics gd = (Graphics) g;
		ui.render(gd);
	}

}
