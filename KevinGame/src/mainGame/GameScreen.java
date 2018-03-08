package mainGame;

import java.util.List;

import character.Player;
import gui.interfaces.Visible;
import gui.userInterfaces.FullFunctionScreen;

public class GameScreen extends FullFunctionScreen {
	/**
	 * 
	 */
	public Player p;
	private static final long serialVersionUID = -8743834112365285160L;
	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		p = new Player(300, 300, 100, 100);
		p.addSequence("resources/", time, x, y, w, h, n);
		
	}

}
