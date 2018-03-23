package utility;
import gui.components.Action;
import gui.components.AnimatedComponent;
import gui.interfaces.Visible;

public class Utility {
	
	public static void moveThen(Visible v, int newX, int newY, int durationMS, Action action){
		final double frames = durationMS/AnimatedComponent.REFRESH_RATE;
		final double origX = v.getX();
		final double origY = v.getY();
		Thread mover = new Thread(new Runnable() {
			
			@Override
			public void run() {
				double changeX = (newX - v.getX())/frames;
				double changeY= (newY - v.getY())/frames;
				for(int i = 0; i < frames; i++){
					v.setX((int)(origX+i*changeX));
					v.setY((int)(origY+i*changeY));
					try {
						Thread.sleep(AnimatedComponent.REFRESH_RATE);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				v.setX(newX);
				v.setY(newY);
				action.act();
			}
		});
		mover.start();
	}

}
