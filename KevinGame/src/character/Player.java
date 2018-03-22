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

import gui.components.Action;
import gui.components.AnimatedComponent;
import gui.components.Button;
import gui.components.Component;
import gui.components.Graphic;
import gui.components.ImageButton;
import gui.components.ImageTextButton;
import gui.interfaces.KeyedComponent;

public class Player extends Component implements KeyedComponent{

	//how fast you move
	private int movement;
	
	//bullets related stuff
	private Bullet[] bullets;
	private int clipIndex;
	
	//player related stuff;
	private BufferedImage[] orientations;
	private int currentOrientation;
	
	public Player(int x, int y, int width, int height) {
		super(x,y,width,height);
		
		bullets = new Bullet[1];
		for(int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet(-50, -50);
		}
		clipIndex = 0;
		
		orientations = new BufferedImage[4];
		orientations[0] = new Graphic(0, 0, "resources/PPNorth.png").getImage();
		orientations[1] = new Graphic(0, 0, "resources/PPEast.png").getImage();
		orientations[2] = new Graphic(0, 0, "resources/PPSouth.png").getImage();
		orientations[3] = new Graphic(0, 0, "resources/PPWest.png").getImage();
		movement = 10;
	}

	@Override
	public void keyPressed(KeyEvent e) { 
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			currentOrientation = 0;
			this.move(getX(), getY()-movement, 15);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			currentOrientation = 1;
			this.move(getX()+movement, getY(), 30);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentOrientation = 2;
			this.move(getX(), getY()+movement, 30);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			currentOrientation = 3;
			this.move(getX()-movement, getY(), 30);
	    }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	clipIndex = clipIndex % bullets.length;
	    	bullets[clipIndex].setX(getX());
	    	bullets[clipIndex].setY(getY());    
	    	new Thread() {
		    	public void run() {
		    		bullets[clipIndex].move(50, 50, 1000);
		    		try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		;
		    	}
	    	}.start();	

	    	//make a new thread
	    	clipIndex++;

	    	
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
	public void update(Graphics2D g) {

	}


	
}