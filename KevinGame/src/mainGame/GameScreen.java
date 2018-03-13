package mainGame;

import java.util.List;

import character.Player;
import gui.interfaces.KeyedComponent;
import gui.interfaces.Visible;
import gui.userInterfaces.FullFunctionScreen;

public class GameScreen extends FullFunctionScreen {
	/**
	 * 
	 */
	public Player p;
	public String s;
	private static final long serialVersionUID = -8743834112365285160L;
	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		s = p.returnLocation();
		System.out.println(s);
		//p = new Player(300,300,50,50, s);
		//viewObjects.add(p);
		
		
	}



}
