package engine;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Thief extends Entity {

	public Thief() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/thief.jpg"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}

	public Thief(boolean rogueGame) {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/rogue.jpg"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}
}
