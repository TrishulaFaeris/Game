package character;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.AnimatedComponent;
import gui.components.ImageTextButton;
import gui.interfaces.KeyedComponent;

public class Player extends AnimatedComponent implements KeyedComponent{

	public Player(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setVx(-3);
//			setX(getX() - 10);
//			System.out.println("asdfasd");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	setVx(3);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	setVy(-3);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	setVy(3);
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
