package engine;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Tunnel extends Entity {
	public Tunnel() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/tunnel.jpg"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}
}
