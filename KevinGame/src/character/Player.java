package character;

import java.awt.Image;
import java.awt.event.KeyEvent;

import gui.components.Action;
import gui.components.ImageTextButton;
import gui.interfaces.KeyedComponent;

public class Player extends ImageTextButton implements KeyedComponent{

	public Player(String text, Image icon, int x, int y, int width, int height, Action action) {
		super(text, icon, x, y, width, height, action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}
	

}
