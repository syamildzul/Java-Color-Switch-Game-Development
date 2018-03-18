package fyp.colorswitch.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	// un sprite est un ensemble de graphiques dans une seule feuille
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	// méthode pour rogner un image du spritesheet
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
