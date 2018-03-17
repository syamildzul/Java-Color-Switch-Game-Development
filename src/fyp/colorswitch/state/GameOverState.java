package fyp.colorswitch.state;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.ui.ClickListener;
import fyp.colorswitch.ui.UIImageButton;
import fyp.colorswitch.ui.UIManager;

public class GameOverState extends State {

	private EntityManager e;
	private UIManager ui;
	
	private JButton replay;
	
	public GameOverState(Handler handler) {
		super(handler);
		e = new EntityManager(handler);
		ui = new UIManager(handler);
		handler.getMouseManager().setUIManager(ui);
		
		ui.addObject(new UIImageButton(handler, midHeight - 35, 70, 70, Assets.replay, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State gameState = new GameState(handler);
				State.setState(gameState);
			}
			
		}));
		
		
		Icon replayIdle = new ImageIcon(getClass().getResource("/textures/replay1.png"));
		Icon replayHovered = new ImageIcon(getClass().getResource("/textures/replay2.png"));
		
		replay = new JButton("Replay", replayIdle);
		replay.setRolloverIcon(replayHovered);
		
		handler.getGame().getDisplay().getFrame().add(replay);
		replay.addActionListener(handler);
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
