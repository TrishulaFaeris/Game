package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Button;
import gui.components.Component;
import gui.components.Graphic;
import gui.components.ImageTextButton;

public class NPC extends Component{
	
	private int movement;
	private BufferedImage[] orientations;
	
	public NPC(int x, int y, int w, int h) {
		super(x, y, w, h);
		orientations = new BufferedImage[4];
		orientations[0] = new Graphic(0, 0, "resources/ZFront.png").getImage();

		movement = 10;
	}
	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	public BufferedImage getImage(){
		return orientations[0];
	}
}


