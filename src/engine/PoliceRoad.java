package engine;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PoliceRoad extends Police {
	
	public PoliceRoad() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/policeRoad.jpg"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		// TODO Auto-generated constructor stub
	}

	public PoliceRoad(boolean rogue) {
		super();
		if(rogue) {
			URL url = this.getClass().getResource("res/fbiRoad.jpg");
			entityImage = new ImageIcon(url).getImage();
		}
		else {
			URL url = this.getClass().getResource("res/policeRoad.jpg");
			entityImage = new ImageIcon(url).getImage();
		}
	}
}
