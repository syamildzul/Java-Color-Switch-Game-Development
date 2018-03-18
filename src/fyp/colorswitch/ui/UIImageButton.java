package fyp.colorswitch.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fyp.colorswitch.Handler;

public class UIImageButton extends UIObject {
	
	private BufferedImage[] images; // tableau d'images pour avoir 
	private ClickListener clicker;
	
	public UIImageButton(Handler handler, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(handler, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
