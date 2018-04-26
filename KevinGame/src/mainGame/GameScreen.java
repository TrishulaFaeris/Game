package mainGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import character.Bullet;
import character.NPC;
import character.Player;
import gui.components.Button;
import gui.interfaces.Visible;
import gui.userInterfaces.FullFunctionScreen;

public class GameScreen extends FullFunctionScreen  {
	/**
	 * 
	 */
	public static Player p;
	private NPC c;
	private static final long serialVersionUID = -8743834112365285160L;
	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		p = new Player(300,300,25,25);
		c = new NPC(200, 300, 25, 25);
		//add multiple threads
		Thread firstPhase = new Thread(c);
		firstPhase.start();
		for(Bullet b : p.getBullet()) {
			viewObjects.add(b);
		}
		viewObjects.add(c);
		viewObjects.add(p);
	}



}
