package engine;


import java.io.IOException;

import javax.imageio.ImageIO;


public class Road extends Entity {

	public Road() {
		super();
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/Crossroad.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setHintRoadGreen() {
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/green_hint.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setHintRoadYellow() {
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/yellow_hint.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setHintRoadBlue() {
		try {
			entityImage = ImageIO.read(getClass().getResourceAsStream("res/blue_hint.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void setRoad(int rightX, int leftX, int upY, int downY) {
		if(rightX == 1 && leftX == 1 && upY == 1 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad1.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 0 && upY == 1 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad2.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 1 && upY == 0 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad3.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 1 && upY == 1 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad4.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 0 && upY == 1 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad5.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 1 && upY == 0 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad6.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 1 && upY == 0 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad7.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 0 && upY == 0 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad8.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 0 && upY == 1 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad9.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 1 && upY == 1 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad10.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 0 && upY == 1 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad11.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 0 && upY == 1 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad12.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 1 && upY == 0 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad13.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 0 && leftX == 0 && upY == 0 && downY == 1) {
			try {
				entityImage = ImageIO.read(new File("Crossroad14.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
		else if(rightX == 1 && leftX == 1 && upY == 1 && downY == 0) {
			try {
				entityImage = ImageIO.read(new File("Crossroad15.jpg"));
			} catch (IOException e) {
				System.out.println("Failed to load image");
			}
		}
	}*/
}
