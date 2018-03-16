package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import gui.components.Action;
import gui.components.Button;
import gui.components.Component;
import gui.interfaces.KeyedComponent;

public class Ammo extends Button{

	private int x;
	private int y;
	public Ammo(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		this.x=x;
		this.y=y;
		// TODO Auto-generated constructor stub
	}
	public void drawButton(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.YELLOW);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
