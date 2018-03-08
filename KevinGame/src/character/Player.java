package character;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.AnimatedComponent;
import gui.components.ImageTextButton;
import gui.interfaces.KeyedComponent;

public class Player extends ImageButton implements KeyedComponent{

	public int movement;
	public Player(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
		movement = 10;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.move(getX(), getY()-movement, 15);
			System.out.println("North");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.move(getX()+movement, getY(), 30);
			System.out.println("E");
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.move(getX(), getY()+movement, 30);
			System.out.println("S");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.move(getX()-movement, getY(), 30);
			System.out.println("W");
	    }
		
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

	
}