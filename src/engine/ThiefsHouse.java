package engine;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ThiefsHouse extends Entity{
	
	public ThiefsHouse() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/thiefsHouse.jpg"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}
}
