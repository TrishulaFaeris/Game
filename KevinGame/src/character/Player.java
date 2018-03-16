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


	private int movement;
	private int xPos;
	private int yPos;
	private ArrayList<Ammo> ammo;
	
	private BufferedImage[] orientations;
	private int currentOrientation;
	
	public Player(int x, int y, int width, int height) {
		super(x,y,width,height);
		movement = 10;
		orientations = new BufferedImage[4];
		orientations[0] = new Graphic(0, 0, "resources/PPNorth.png").getImage();
		orientations[1] = new Graphic(0, 0, "resources/PPEast.png").getImage();
		orientations[2] = new Graphic(0, 0, "resources/PPSouth.png").getImage();
		orientations[3] = new Graphic(0, 0, "resources/PPWest.png").getImage();
		xPos = this.getX();
		yPos = this.getY();
		ammo = new ArrayList<Ammo>();
	}

	@Override
	public void keyPressed(KeyEvent e) { 
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			currentOrientation = 0;
			this.move(getX(), getY()-movement, 15);
			System.out.println("North");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			currentOrientation = 1;
			this.move(getX()+movement, getY(), 30);
			System.out.println("E");
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentOrientation = 2;
			this.move(getX(), getY()+movement, 30);
	    	System.out.println("S");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			currentOrientation = 3;
			this.move(getX()-movement, getY(), 30);
	    	System.out.println("W");
	    }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	Ammo bullet = new Ammo(100, 100, 50, 50, "", Color.YELLOW, null);
	    	ammo.
	    }
		
	}
	
	public 
	
	public BufferedImage getImage(){
		return orientations[currentOrientation];
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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