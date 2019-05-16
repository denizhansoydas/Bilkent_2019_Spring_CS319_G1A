package engine;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Buildings extends Entity{

	public Buildings() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/Buildings.jpg"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}
}
