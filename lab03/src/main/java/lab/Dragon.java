package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Dragon {
	
	private Point2D speed;
	private Point2D position;
	private int widthOfWorld;
	private int hightOfWorld;
	private World world;
	
	public Dragon(Point2D speed, Point2D position, int widthOfWorld, int hightOfWorld, World world) {
	
		this.speed = speed;
		this.position = position;
		this.widthOfWorld = widthOfWorld;
		this.hightOfWorld = hightOfWorld;
		this.world = world;
	}
	
	public void draw(GraphicsContext gc) {
		Point2D canvasPosition = world.getCanvasPoint(position);
		gc.drawImage(Constants.DRAGON_IMAGE, canvasPosition.getX(), canvasPosition.getY(), 60, 60);
	}
	
	
	public void simulation(double deltaT) {
		position = new Point2D(position.getX() + speed.getX()*deltaT /400., position.getY() + speed.getY()*deltaT/400.); 
		position = new Point2D((position.getX() + widthOfWorld)%widthOfWorld, (position.getY() + widthOfWorld)%widthOfWorld);
		
	}
	
	public void hit () {
		speed = new Point2D( -speed.getX(), speed.getY());
	}
	
	public Rectangle2D getBoundingBox() {
		return new Rectangle2D(position.getX(), position.getY(), 40, 40);
	}
}
