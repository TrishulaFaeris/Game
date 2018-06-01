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
	
	
	
	//player related stuff;
	private BufferedImage[] orientations;
	private int currentOrientation;
	
	public Player(int x, int y, int width, int height) {
		super(x,y,width,height);
		
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
		bullets = new Bullet[5];
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
					currentOrientation = 0;
					setVx(0);
					setVy(-speed);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			    	currentOrientation = 1;
			    	setVy(0);
			    	setVx(speed);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					currentOrientation = 2;
					setVx(0);
					setVy(speed);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			    	currentOrientation = 3;
			    	setVx(-speed);
					setVy(0);
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
		//NEW DISCOVERY! THE GETX() AND GETY() GETS THE MIDDLE COORDINATE OF THE COMPONENT, NOT THE TOP RIGHT CORNER. THIS CHANGES SO MUCH!
		int getBx = -100;
		int getBy = -100;
    	if(currentOrientation == 0) {
    		getBx = getX() +  getWidth()/2 ;
    		getBy = getY() - getHeight()/2;
    		bullets[clipIndex].setX(getBx);
        	bullets[clipIndex].setY(getBy);
	    	Utility.moveThen(bullets[clipIndex], getBx, getBy-bulletDistance, 500, new Action() {
				
	    		
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
    		bullets[clipIndex].setX(getBx);
        	bullets[clipIndex].setY(getBy);
    		Utility.moveThen(bullets[clipIndex], getBx + bulletDistance, getBy, 500, new Action() {
				
	    		
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
    		bullets[clipIndex].setX(getBx);
        	bullets[clipIndex].setY(getBy);
    		Utility.moveThen(bullets[clipIndex], getBx, getBy + bulletDistance, 500, new Action() {
				
	    		
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
    		bullets[clipIndex].setX(getBx);
    		bullets[clipIndex].setY(getBy);
   	
	    	Utility.moveThen(bullets[clipIndex], getBx - bulletDistance, getBy, 500, new Action() {
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
			setVy(0);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	setVx(0);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	setVy(0);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	setVx(0);
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
		if(getX() > 920) {
			setX(919);
			setVx(0);
		}
	}


	
}