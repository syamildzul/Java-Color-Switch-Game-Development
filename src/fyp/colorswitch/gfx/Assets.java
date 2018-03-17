package fyp.colorswitch.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int widthBtn = 64, heightBtn = 64;

	public static BufferedImage[] btn_start, replay;
	public static BufferedImage title, firefist, gameover, highscore;
	
	public static void init() {
 
		SpriteSheet uiSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/ui.png"));
				
		btn_start = new BufferedImage[2];
		replay = new BufferedImage[2];
		
		firefist = ImageLoader.LoadImage("/textures/firefist.png");
		title = ImageLoader.LoadImage("/textures/title.png");
		gameover = ImageLoader.LoadImage("/textures/gameover.png");
		highscore = ImageLoader.LoadImage("/textures/highscore.png");
		
		btn_start[0] = uiSheet.crop(0, 0, widthBtn, heightBtn);
		btn_start[1] = uiSheet.crop(widthBtn, 0, widthBtn, heightBtn);
		replay[0] = uiSheet.crop(widthBtn * 2, 0, widthBtn, heightBtn);
		replay[1] = uiSheet.crop(widthBtn * 3, 0, widthBtn, heightBtn);
		
	}
}
