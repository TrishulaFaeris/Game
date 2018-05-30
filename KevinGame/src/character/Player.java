package character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.Utilities;
import gui.components.Action;
import gui.components.AnimatedComponent;
import gui.components.Button;
import gui.components.Component;
import gui.components.Graphic;
import gui.components.ImageButton;
import gui.components.ImageTextButton;
import gui.components.MovingComponent;
import gui.interfaces.KeyedComponent;
import utility.Utility;
import mainGame.GameGui;

public class Player extends MovingComponent implements KeyedComponent{

	//how fast you move
	private int movement;
	
	//bullets related stuff
	private Bullet[] bullets;
	private int clipIndex;
	private boolean notlocked;
	private int bulletDistance;
	private int width;
	private int height;
	private double speed = 3;
	
	
	
	//player related stuff;
	private BufferedImage[] orientations;
	private int currentOrientation;
	
	public Player(int x, int y, int width, int height) {
		super(x,y,width,height);
		
		/*the pic should look like this
		 * from the edge of the body to the edge of the gun is 3 pixel
		 * the width of gun is 7
		 * and the height is 13
		 * body is 25 by 25
		 * so the is 25 (width) by 38(height)
			___
		   |   |
		_3_|   |____
	   |*/
		
		//player direction
		orientations = new BufferedImage[4];
		orientations[0] = new Graphic(0, 0, "resources/PNorth.png").getImage();
		orientations[1] = new Graphic(0, 0, "resources/PEast.png").getImage();
		orientations[2] = new Graphic(0, 0, "resources/PSouth.png").getImage();
		orientations[3] = new Graphic(0, 0, "resources/PWest.png").getImage();
		movement = 10;
		
		//player stuff
		this.width = width;
		this.height = height;
		
		//bullet stuff
		bullets = new Bullet[50];
		for(int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet(-50, -50);
		}
		clipIndex = 0;
		bulletDistance = 300;
		notlocked = true;
		Thread t = new Thread(this);
		t.start();
	}
	//need to add a condition so that the player doesn't move when hit
	@Override
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode() == KeyEvent.VK_UP) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundY(getY() - getHeight())) {
//					currentOrientation = 0;
//					this.move(getX(), getY()-movement, 40);
//				}
//			}else {
//				if(checkBoundY(getY() - getWidth())) {
					currentOrientation = 0;
//					this.move(getX(), getY()-movement, 40);
//				}
//			}
			setVy(-speed);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundX(getX() + getWidth())) {
			    	currentOrientation = 1;
//					this.move(getX()+movement, getY(), 40);
//				}
//			}else {
//				if(checkBoundX(getX() + getHeight())) {
//			    	currentOrientation = 1;
//					this.move(getX()+movement, getY(), 40);
//				}
//			}
	    	setVx(speed);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundY(getY() + getHeight())) {					
//					currentOrientation = 2;
//					this.move(getX(), getY()+movement, 40);
//				}
//			}else {
//				if(checkBoundY(getY() + getWidth())) {
					currentOrientation = 2;
//					this.move(getX(), getY()+movement, 40);
//				}
//			}
	    	setVy(speed);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundX(getX() - getWidth())) {
//			    	currentOrientation = 3;
//					this.move(getX()-movement, getY(), 40);
//				}
//			}else {
//				if(checkBoundX(getX() - getHeight())) {
			    	currentOrientation = 3;
//					this.move(getX()-movement, getY(), 40);
//				}
//			}
	    	setVx(-speed);
	    }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	if(notlocked == true) {
		    	clipIndex = clipIndex % bullets.length;
		    	shootBullet();
		    	clipIndex++;
	    	}
	    }
		notlocked = false;  	
	}
	
	
	private void shootBullet() {
		//need to fix, I suggest that pics to be remade, and the bullets to be shotten off the gun,
		//re: needs to be 3pixel off, so need more if else
    	if(currentOrientation == 0) {
    		bullets[clipIndex].setX((getX() + width - bullets[clipIndex].getWidth() - 1));
        	bullets[clipIndex].setY(getY());
	    	Utility.moveThen(bullets[clipIndex], (getX() + width - bullets[clipIndex].getWidth() - 1), getY()-bulletDistance, 500, new Action() {
				
	    		
	    		int i = clipIndex;
				@Override
				public void act() {
					// TODO Auto-generated method stub
					bullets[i].setX(-100);
					bullets[i].setY(-100);   
					
				}
			});
    	}
    	else if(currentOrientation  == 1) {
    		bullets[clipIndex].setX(getX() + width - bullets[clipIndex].getWidth());
        	bullets[clipIndex].setY(getY() + height - bullets[clipIndex].getHeight() - 1);
    		Utility.moveThen(bullets[clipIndex], getX() + bulletDistance, getY() + height - bullets[clipIndex].getHeight() - 1, 500, new Action() {
				
	    		
	    		int i = clipIndex;
				@Override
				public void act() {
					// TODO Auto-generated method stub
					bullets[i].setX(-100);
					bullets[i].setY(-100);   
					
				}
			});
    	}else if(currentOrientation == 2) {
    		bullets[clipIndex].setX(getX() + 1);
        	bullets[clipIndex].setY(getY() + height + bullets[clipIndex].getHeight());
    		Utility.moveThen(bullets[clipIndex], getX(), getY() + height + bullets[clipIndex].getHeight()+ bulletDistance, 500, new Action() {
				
	    		
	    		int i = clipIndex;
				@Override
				public void act() {
					// TODO Auto-generated method stub
					bullets[i].setX(-100);
					bullets[i].setY(-100);   
					
				}
			});
    		
    	}else if(currentOrientation == 3) {
    		bullets[clipIndex].setX(getX() + 1 + bullets[clipIndex].getWidth());
    		bullets[clipIndex].setY(getY() + bullets[clipIndex].getWidth());
   	
	    	Utility.moveThen(bullets[clipIndex], getX() - bulletDistance, getY(), 500, new Action() {
	    		int i = clipIndex;
				@Override
				public void act() {
					// TODO Auto-generated method stub
					bullets[i].setX(-100);
					bullets[i].setY(-100);   
					
				}
			});
    	}
		
	}

	public BufferedImage getImage(){
		return orientations[currentOrientation];
	}
	
	public Bullet[] getBullet() {
		return bullets;
	}
	@Override
	public void keyReleased(KeyEvent e) {    
    	notlocked = true;
		if(e.getKeyCode() == KeyEvent.VK_UP) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundY(getY() - getHeight())) {
//					currentOrientation = 0;
//					this.move(getX(), getY()-movement, 40);
//				}
//			}else {
//				if(checkBoundY(getY() - getWidth())) {
//					currentOrientation = 0;
//					this.move(getX(), getY()-movement, 40);
//				}
//			}
			setVy(0);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundX(getX() + getWidth())) {
//			    	currentOrientation = 1;
//					this.move(getX()+movement, getY(), 40);
//				}
//			}else {
//				if(checkBoundX(getX() + getHeight())) {
//			    	currentOrientation = 1;
//					this.move(getX()+movement, getY(), 40);
//				}
//			}
	    	setVx(0);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundY(getY() + getHeight())) {					
//					currentOrientation = 2;
//					this.move(getX(), getY()+movement, 40);
//				}
//			}else {
//				if(checkBoundY(getY() + getWidth())) {
//					currentOrientation = 2;
//					this.move(getX(), getY()+movement, 40);
//				}
//			}
	    	setVy(0);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			if(currentOrientation % 2 == 0){
//				if(checkBoundX(getX() - getWidth())) {
//			    	currentOrientation = 3;
//					this.move(getX()-movement, getY(), 40);
//				}
//			}else {
//				if(checkBoundX(getX() - getHeight())) {
//			    	currentOrientation = 3;
//					this.move(getX()-movement, getY(), 40);
//				}
//			}
	    	setVx(0);
	    }
	}
	//the check bound method checks if it in bounds, if it is false, it is not in bound, move it the bounded region in this case is 960
	public boolean checkBoundX(int x) {
		if(x > 920 || x < 0) 
			return false;
		return true;
	}
	//same as the top but 560 is the bounded region
	public boolean checkBoundY(int y) {
		if(y > 500 || y < 0)
			return false;
		return true;
	}
	//this will always move in relationship to 50pix/30miliseconds
	//useful when getting hit and is close to the edge of the screen
	public int calculationTimeToMove(int x) {
		return ((30*x)/50);
	}
	public boolean checkHit() {
		return true;
	}
	
	public int getCurrentOrientation() {
		return currentOrientation;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawImage(Graphics2D g) {
//		g.drawImage( orientations[currentOrientation], 0, 0, null);
	}
	@Override
	public void checkBehaviors() {
		// TODO Auto-generated method stub
		if(getX() > 920) {
			setX(919);
			setVx(0);
		}
	}


	
}