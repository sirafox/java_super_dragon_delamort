package lab;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawingThread extends AnimationTimer {

	private final Canvas canvas;
	
	private final GraphicsContext gc;

	private final World world;
	
	private long lasttime = -1;

	public DrawingThread(Canvas canvas) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.world = new World(canvas);
	}

	/**
	  * Draws objects into the canvas. Put you code here. 
	 */
	@Override
	public void handle(long now) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		world.draw();
		if (lasttime > 0) {
			//time are in nanoseconds and method simulate expects miliseconds
			world.simulate((now - lasttime) / 1e6);
		}
		lasttime = now;
	}

}
