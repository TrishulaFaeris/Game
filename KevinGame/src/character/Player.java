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
	private double speed = 3;
	private int[][] Bxy;
	private boolean isPressed;
	public Thread t;
	
	//player related stuff;
	private BufferedImage[] orientations;
	private int currentOrientation;
	
	public Player(int x, int y, int width, int height) {
		super(x,y,width,height);
		isPressed = false;
		/*the pic should look like this
		 * from the edge of the body to the edge of the gun is 3 pixel
		 * 
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
		
		
		//bullet stuff
		bullets = new Bullet[20];
		for(int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet(-50, -50);
		}
		clipIndex = 0;
		bulletDistance = 300;
		notlocked = true;
		Bxy = new int [bullets.length][2];
		//player stuff
		t = new Thread(this);
		t.start();
		
	}
	//need to add a condition so that the player doesn't move when hit
	@Override
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode() == KeyEvent.VK_W) {
					currentOrientation = 0;
					setVy(-speed);
					setVx(0);
					isPressed = true;
		}
	    else if (e.getKeyCode() == KeyEvent.VK_D) {
			    	currentOrientation = 1;
			    	setVx(speed);
			    	setVy(0);
					isPressed = true;
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_S) {
					currentOrientation = 2;
					setVy(speed);
					setVx(0);
					isPressed = true;
		}
	    else if (e.getKeyCode() == KeyEvent.VK_A) {
			    	currentOrientation = 3;
			    	setVx(-speed);
			    	setVy(0);
					isPressed = true;
	    }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	if(notlocked == true) {
		    	clipIndex = clipIndex % bullets.length;
		    	shootBullet();
		    	clipIndex++;
		    	isPressed = true;
	    	}
	    }
		notlocked = false;  	
	}
	
	
	private void shootBullet() {
		//need to fix, I suggest that pics to be remade, and the bullets to be shotten off the gun,
		//re: needs to be 3pixel off, so need more if else
		//NEW DISCOVERY! THE GETX() AND GETY() GETS THE MIDDLE COORDINATE OF THE COMPONENT, NOT THE TOP RIGHT CORNER. THIS CHANGES SO MUCH!
		int getBx = -100;
		int getBy = -100;
    	if(currentOrientation == 0) {
    		getBx = getX() +  getWidth()/2 ;
    		getBy = getY() - getHeight()/2;
    		Bxy[clipIndex][0] = getBx;
    		Bxy[clipIndex][1] = getBy;
    		bullets[clipIndex].setX(Bxy[clipIndex][0]);
    		bullets[clipIndex].setY(Bxy[clipIndex][1]);
	    	Utility.moveThen(bullets[clipIndex], Bxy[clipIndex][0], Bxy[clipIndex][1]-bulletDistance, 500, new Action() {
				
	    		
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
    		
    		getBx = getX() + getHeight();
    		getBy = getY() + getWidth() - bullets[clipIndex].getWidth();
    		Bxy[clipIndex][0] = getBx;
    		Bxy[clipIndex][1] = getBy;
    		bullets[clipIndex].setX(Bxy[clipIndex][0]);
    		bullets[clipIndex].setY(Bxy[clipIndex][1]);
    		Utility.moveThen(bullets[clipIndex], Bxy[clipIndex][0] + bulletDistance, Bxy[clipIndex][1], 500, new Action() {
				
	    		
	    		int i = clipIndex;
				@Override
				public void act() {
					// TODO Auto-generated method stub
					bullets[i].setX(-100);
					bullets[i].setY(-100);   
					
				}
			});
    	}else if(currentOrientation == 2) {
    		getBx = getX() +  getWidth()/2 - bullets[clipIndex].getHeight();
    		getBy = getY() + getHeight();
    		Bxy[clipIndex][0] = getBx;
    		Bxy[clipIndex][1] = getBy;
    		bullets[clipIndex].setX(Bxy[clipIndex][0]);
    		bullets[clipIndex].setY(Bxy[clipIndex][1]);
    		Utility.moveThen(bullets[clipIndex], Bxy[clipIndex][0], Bxy[clipIndex][1] + bulletDistance, 500, new Action() {
				
	    		
	    		int i = clipIndex;
				@Override
				public void act() {
					// TODO Auto-generated method stub
					bullets[i].setX(-100);
					bullets[i].setY(-100);   
					
				}
			});
    		
    	}else if(currentOrientation == 3) {
    		getBx = getX() - getHeight()/2; 
    		getBy = getY() - getWidth()/2 + bullets[clipIndex].getHeight() + 3;
    		Bxy[clipIndex][0] = getBx;
    		Bxy[clipIndex][1] = getBy;
    		bullets[clipIndex].setX(Bxy[clipIndex][0]);
    		bullets[clipIndex].setY(Bxy[clipIndex][1]);
   	
	    	Utility.moveThen(bullets[clipIndex], Bxy[clipIndex][0] - bulletDistance, Bxy[clipIndex][1], 500, new Action() {
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
		if(e.getKeyCode() == KeyEvent.VK_W) {
			setVy(0);
			isPressed = false;
		}
	    else if (e.getKeyCode() == KeyEvent.VK_D) {
	    	setVx(0);
			isPressed = false;
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_S) {
	    	setVy(0);
			isPressed = false;
		}
	    else if (e.getKeyCode() == KeyEvent.VK_A) {
	    	setVx(0);
			isPressed = false;
	    }
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
		if(getX() > 900) {
			setX(899);
			setVx(0);
		}
		if(getX() < 10) {
			setX(11);
			setVx(0);
		}
		if(getY() < 20) {
			setY(21);
			setVy(0);
		}
		if(getY() > 480) {
			setY(479);
			setVy(0);
		}
	}
	public boolean isKPressed() {
		return isPressed;
	}
	public int[] getBulletLocation(){
		return Bxy[clipIndex];
		
	}



	
}