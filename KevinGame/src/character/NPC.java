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
import gui.components.MovingComponent;
import mainGame.GameScreen;

public class NPC extends MovingComponent{
	
	private int movement;
	private int currentOrientation;
	private BufferedImage[] orientations;
	private int playerX;
	private int playerY;
	public NPC(int x, int y, int w, int h) {
		super(x, y, w, h);
		//make the images transparent
		orientations = new BufferedImage[4];
		orientations[0] = new Graphic(0, 0, "resources/ZNorth.png").getImage();
		orientations[1] = new Graphic(0, 0, "resources/ZEast.png").getImage();
		orientations[2] = new Graphic(0, 0, "resources/ZSouth.png").getImage();
		orientations[3] = new Graphic(0, 0, "resources/ZWest.png").getImage();
		/*the pic should look like this
		 * from the edge of the body to the arm is 3 pixels
		 * the width of gun is 7
		 * and the height is 13
		 * body is 25 by 25
		 * overall image is 25 width by 38 height
			___
		   |   |
		_3_|   |____
	   |*/
		

		movement = 10;
	}

	public BufferedImage getImage(){
		return orientations[currentOrientation];
	}
	public void facePlayer(int xpos, int ypos) {
		/* player location - npc location
		*top is 0, right is 1, bot is 2, left is 3;
		*change, remove the randomless, if the distance to the sides is greater top and bottom, face right, etc, calculate at home
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
	@Override
	public void drawImage(Graphics2D g) {
		// TODO Auto-generated method stub
		//method doesnt do anything since getImage is overrided
		//to add *animations* delete the getImage and update this instead and use this
		
	}
	@Override
	public void checkBehaviors() {
		playerX = GameScreen.p.getX();
		playerY = GameScreen.p.getY();
		facePlayer(playerX, playerY);
		setVx((playerX - getX())/10);
		setVy((playerY - getY())/10);
		//setVx(1);
		//setVy(1);

		
	}
}


