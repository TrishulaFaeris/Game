package mainGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import character.Ammo;
import character.Player;
import gui.components.Button;
import gui.interfaces.Visible;
import gui.userInterfaces.FullFunctionScreen;

public class GameScreen extends FullFunctionScreen  {
	/**
	 * 
	 */
	private Player p;
	private static final long serialVersionUID = -8743834112365285160L;
	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		p = new Player(300,300,50,50);
		viewObjects.add(p);
		
		
		
	}



}
