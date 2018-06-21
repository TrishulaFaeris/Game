package mainGame;

import java.awt.Color;
import java.util.List;

import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.interfaces.Visible;
import gui.userInterfaces.FullFunctionScreen;
import mainGame.GameGui;
import mainGame.EndScreen;
public class StartScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 1L;
	private Graphic background;
	private Button start;

	public StartScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Start screen.png");
		start = new Button(400,400,80,40, "Start", Color.RED, new Action() {
			
			@Override
			public void act() {
				GameGui.t.setScreen(GameGui.t.screen);
				
			}
		});
		viewObjects.add(background);
		viewObjects.add(start);
		
	}

}
