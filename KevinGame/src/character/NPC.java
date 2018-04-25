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
		/*the pic should look like this
		 * from the edge of the body to the edge of the gun is 3pixel
			___
		   |   |
		_3_|   |____
	   |*/
		

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
		/* player location - npc location
		*top is 0, right is 1, bot is 2, left is 3;
		*/
		if(xpos - getX() > 0 && ypos - getY() < 0) {
			currentOrientation = (int) (Math.random() * 2);
		}else if(xpos - getX() > 0 && ypos - getY() > 0) {
			currentOrientation = (int) (Math.random() * 2) + 1;
		}else if(xpos - getX() < 0 && ypos - getY() > 0) {
			currentOrientation = (int) (Math.random() * 2) + 2;
		}else{
			if(Math.random() < 0.49) {
				currentOrientation = 0;
				
			}else {
				currentOrientation = 3;
			}
		}
	}
}


