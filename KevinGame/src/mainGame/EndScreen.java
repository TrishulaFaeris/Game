package mainGame;

import java.awt.Color;
import java.util.List;

import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.interfaces.Visible;
import gui.userInterfaces.FullFunctionScreen;

public class EndScreen extends FullFunctionScreen{
	/**
	 * 
	 */
	private static final long serialVersionUID = -445338051120205379L;
	private Graphic background;
	private Button end;
	public EndScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		background = new Graphic(0, 0, getWidth(), getHeight(),  "resources/End Screen.png");
		end = new Button(400,400,80,40, "Ok", Color.RED, new Action() {
			
			@Override
			public void act() {
				GameGui.t.setScreen(GameGui.t.startScreen);
				
			}
		});
		viewObjects.add(background);
		viewObjects.add(end);
	}

}
