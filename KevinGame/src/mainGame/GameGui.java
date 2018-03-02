package mainGame;

import gui.GUIApplication;

public class GameGui extends GUIApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameScreen screen;
	
	public static void main(String[] args) {
		GameGui s = new GameGui(960,540);
		Thread runner  = new Thread(s);
		runner.start();
	}
	public GameGui(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new GameScreen(getWidth(),getHeight());
		setScreen(screen);
		
	}

}
