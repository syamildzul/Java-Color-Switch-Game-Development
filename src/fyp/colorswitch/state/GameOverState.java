package fyp.colorswitch.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import fyp.colorswitch.Handler;
import fyp.colorswitch.entity.EntityManager;
import fyp.colorswitch.entity.obstacle.Bar;
import fyp.colorswitch.gfx.Assets;
import fyp.colorswitch.ui.ClickListener;
import fyp.colorswitch.ui.UIImage;
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
		
		e.addEntity(new Bar(handler, midHeight - 50));
		e.addEntity(new Bar(handler, midHeight + 90));
		
		ui.addObject(new UIImageButton(handler, midHeight - 35, 70, 70, Assets.replay, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State gameState = new GameState(handler);
				State.setState(gameState);
			}
			
		}));
		
		
//		Icon replayIdle = new ImageIcon(getClass().getResource("/textures/replay1.png"));
//		Icon replayHovered = new ImageIcon(getClass().getResource("/textures/replay2.png"));
//		
//		replay = new JButton("Replay", replayIdle);
//		replay.setRolloverIcon(replayHovered);
//		
//		handler.getGame().getDisplay().getFrame().add(replay);
//		replay.addActionListener(handler);
	}

	@Override
	public void tick() {
		e.tick();
		ui.tick();
	}

	@Override
	public void render(Graphics2D g) {
		
		//e.getEntities().get(0).set
		
		e.render(g);
		Graphics gd = (Graphics) g;
		ui.render(gd);
		g.drawImage(Assets.gameover, (int) (midWidth - 150), 80, 300, 150, null);
		g.drawImage(Assets.highscore, 100, 500, 300, 80, null);

		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
		g.drawString(String.valueOf(handler.getGame().getHighScore()), 250, 620);
	}

}
