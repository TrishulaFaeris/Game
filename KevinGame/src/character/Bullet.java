package character;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import gui.components.Action;
import gui.components.Button;
import gui.components.Component;
import gui.components.CustomImageButton;
import gui.interfaces.DrawInstructions;
import gui.interfaces.KeyedComponent;

public class Bullet extends Component{

	public static int standardWidth = 10;
	public static int standardHeight = 10;
	public static CustomImageButton standardBullet = new CustomImageButton(0, 0, standardWidth, standardHeight, new DrawInstructions() {
		
		@Override
		public void draw(Graphics2D g, boolean highlight) {

				g.setColor(Color.yellow);
				g.setStroke(new BasicStroke(2));
				g.fillRoundRect(0, 0, standardWidth, standardHeight, 8, 8);
			
		}
	}, null);

	public Bullet(int x, int y) {
		super(x, y, standardWidth, standardHeight, standardBullet.getImage());

		// TODO Auto-generated constructor stub
	}
	public void drawButton(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.YELLOW);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
