package engine;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Park extends Entity {

	public Park() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/park.PNG"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}
}
