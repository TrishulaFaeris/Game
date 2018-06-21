package mainGame;

import gui.GUIApplication;
import mainGame.EndScreen;

public class GameGui extends GUIApplication{
	/**
	 * 
	 */	
	public static GameGui t;
	private static final long serialVersionUID = 1L;
	public  GameScreen screen;
	public  StartScreen startScreen;
	public  EndScreen endScreen;
	
	public static void main(String[] args) {
		t = new GameGui(960,540);
		Thread runner  = new Thread(t);
		runner.start();
	}
	public GameGui(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		startScreen = new StartScreen(getWidth(),getHeight());
		screen = new GameScreen(getWidth(),getHeight());
		endScreen = new EndScreen(getWidth(),getHeight());
		setScreen(startScreen);
	}
}

