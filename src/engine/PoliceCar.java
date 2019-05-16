package engine;

import java.net.URL;

import javax.swing.ImageIcon;

public class PoliceCar extends Police {
	
	public PoliceCar() {
		super();
		URL url = this.getClass().getResource("res/police.gif");
		entityImage = new ImageIcon(url).getImage();
	}

	public PoliceCar(boolean rogue) {
		super();
		if(rogue) {
			URL url = this.getClass().getResource("res/fbi.jpg");
			entityImage = new ImageIcon(url).getImage();
		}
		else {
			URL url = this.getClass().getResource("res/police.gif");
			entityImage = new ImageIcon(url).getImage();
		}
	}
}
