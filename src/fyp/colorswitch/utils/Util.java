package fyp.colorswitch.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import fyp.colorswitch.entity.Entity;

public class Util {
	
	private int color = 0;
	
	protected Color getColor() {
        switch (color) {
            case 1:
                return Entity.colors[0];
            case 2:
                return Entity.colors[1];
            case 3:
                return Entity.colors[2];
            case 4:
                return Entity.colors[3];
            default:
                return Color.WHITE;
        }
    }
	
	public void switchColor(Graphics2D g) {
		int x = randomInt();
		setColor(g, x);
	}
	
	public void setColor(Graphics2D g, int c) {
		switch(c) {
			case 1 : g.setColor(Entity.colors[0]); break;
			case 2 : g.setColor(Entity.colors[1]); break;
			case 3 : g.setColor(Entity.colors[2]); break;
			case 4 : g.setColor(Entity.colors[3]); break;
		}
	}
	
	public int randomInt() {
		Random ran = new Random();
		int x = ran.nextInt(4);
		return x;
	}
	
}
