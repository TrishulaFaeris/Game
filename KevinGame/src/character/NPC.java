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
	private int currentOrientation;
	private BufferedImage[] orientations;
	
	public NPC(int x, int y, int w, int h) {
		super(x, y, w, h);
		orientations = new BufferedImage[4];
		orientations[0] = new Graphic(0, 0, "resources/ZFront.png").getImage();
		orientations[1] = new Graphic(0, 0, "resources/ZRight.png").getImage();
		orientations[2] = new Graphic(0, 0, "resources/ZBack.png").getImage();
		orientations[3] = new Graphic(0, 0, "resources/ZLeft.png").getImage();

		movement = 10;
	}
	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	public BufferedImage getImage(){
		return orientations[currentOrientation];
	}
	public void facePlayer(int xpos, int ypos) {
		/* npc location - player location
		* if negative, that means the npc is right(xpos)/top(yps) in relative to the player location
		* if positive, that means the npc is left(xpos)/bottom(ypos) in relative to the player location
		* just to make sure, print out the int
		*/
	}
}


