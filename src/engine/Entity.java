package engine;

import java.awt.Image;
import java.awt.Point;


public class Entity{
	
	//properties
	public static final String NAME = "Entity";
	protected Image entityImage;
	protected Point startingPoint;
	
	//constructors
	public Entity() {

		startingPoint = new Point(0,0);
		// will be improved later
			
	}
	
	//methods
	public String getName() {
		return NAME;
	}
	public Image getImage() {
		return entityImage;
	}

	public void setPoint(Point sp){
		startingPoint = sp;
	}
	
	public Point getPoint() {
		return startingPoint;
	}
}
