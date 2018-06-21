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
import mainGame.GameGui;
import mainGame.GameScreen;

public class NPC extends MovingComponent{
	
	private int currentOrientation;
	private BufferedImage[] orientations;
	private int playerX;
	private int playerY;
	private boolean firstCheck;
	private boolean checkIfMove;
	private int playerHitCount;
	private int NPCHitCount;
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
		
		firstCheck = false;
		checkIfMove = false;
		playerX = GameScreen.p.getX();
		playerY = GameScreen.p.getY();
		playerHitCount = 0;
		NPCHitCount = 0;
		
	}

	public BufferedImage getImage(){
		return orientations[currentOrientation];
	}
	public void facePlayer(int xpos, int ypos) {
		/* player location - npc location
		*top is 0, right is 1, bot is 2, left is 3;
		*/
		if(xpos - getX() >= 0 && ypos - getY() <= 0) {
			if(checkGreater(xpos - getX(), ypos - getY())){
				currentOrientation = 1;
			}else {
				currentOrientation = 0;
			}
			
			
		}else if(xpos - getX() >= 0 && ypos - getY() >= 0) {
			if(checkGreater(xpos - getX(), ypos - getY())){
				currentOrientation = 1;
			}else {
				currentOrientation = 2;
			}
		}else if(xpos - getX() <= 0 && ypos - getY() >= 0) {
			if(checkGreater(xpos - getX(), ypos - getY())){
				currentOrientation = 3;
			}else {
				currentOrientation = 2;
			}
		}else if(xpos - getX() <= 0 && ypos - getY() <= 0){
			if(checkGreater(xpos - getX(), ypos - getY())){
				currentOrientation = 3;
			}else {
				currentOrientation = 0;
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
		//need to add object
		//need to add if statements to base on the current player location as well
		playerX = GameScreen.p.getX();
		playerY = GameScreen.p.getY();
		firstTime();
		if(GameScreen.p.isKPressed()) {
			facePlayer(playerX, playerY);
			checkIfMove = false;
		}else {
			checkMoving();
			checkIfMove = true;
			if(Math.abs(playerX - getX()) < 25 || Math.abs(playerY - getY()) < 25) {
				facePlayer(playerX, playerY);
			}
		}
		//use this when perfectly diagonal
//		double dx = playerX - getX();
//		double dy = playerY - getY();
//		double distance = Math.sqrt(Math.pow(dx, 2)+ Math.pow(dy, 2));
//		setVx(dx/distance * 2);
//		setVy(dy/distance * 2);
		if(playerHitCount == 12) {
			GameGui.t.setScreen(GameGui.t.endScreen);
		}
		if(currentOrientation == 0) {
			if(playerX - getX() < getHeight() && Math.abs(playerY - getY()) < getWidth()) {
				if(playerY < 22) {
					GameScreen.p.setVy(-1);				
					setVx(0);
					setVy(0);
				}else {
					setVx(0);
					setVy(0);
					GameScreen.p.move(playerX, playerY - 50, 30);
				}
			}else {
				setVx(0);
				setVy(-2);
			}
		}else if(currentOrientation == 1) {
			if(playerX - getX() < getHeight() && Math.abs(playerY - getY()) < getWidth()) {
				if(playerX > 898) {
					GameScreen.p.setVx(1);				
					setVx(0);
					setVy(0);
				}else {
					setVx(0);
					setVy(0);
					GameScreen.p.move(playerX + 50, playerY, 30);
				}
			}else {
				setVx(2);
				setVy(0);
			}
		}else if(currentOrientation == 2) {
			if(playerX - getX() < getWidth() && Math.abs(playerY - getY()) < getHeight()) {
				if(playerY > 478) {
					GameScreen.p.setVy(1);	
					setVx(0);
					setVy(0);
				}else {
					setVx(0);
					setVy(0);
					GameScreen.p.move(playerX, playerY + 50, 30);
				}
			}else{
				setVy(2);
				setVx(0);	
				
			}
		}else if(currentOrientation == 3) {
			if(Math.abs(playerX - getX()) < getWidth() && Math.abs(playerY - getY()) < getHeight())  {
				if(playerX < 12) {
					GameScreen.p.setVx(-1);			
					setVx(0);
					setVy(0);
				}
				else {
					setVx(0);
					setVy(0);
					GameScreen.p.move(playerX - 50, playerY, 30);
				}
			}else{
				setVx(-2);
				setVy(0);
			}
		}
		
			//setVx(-2);
			//setVy(0);
		//}
		 
	}

	private void firstTime() {
		if(!firstCheck) {
			facePlayer(playerX, playerY);
		}
		firstCheck = true;
	}
	private void checkMoving() {
		if(!checkIfMove) {
			facePlayer(playerX, playerY);
		}
	}

	public boolean checkGreater(int a , int b) {
		if(Math.abs(a) > Math.abs(b))
			return true;
		else 
			return false;
	}
	public boolean checkEqual(int a, int b) {
		if(Math.abs(a) == Math.abs(b))
			return true;
		else 
			return false;
	}
}


