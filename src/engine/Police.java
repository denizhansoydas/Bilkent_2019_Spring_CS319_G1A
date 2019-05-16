package engine;

public class Police extends Entity {

	private Police [][] policePieces;
	private int width = 0;
	private int length = 0;
	private boolean isPlaced;
	int rotateNum;

	public Police(int width, int length, String shape) {
		super();
		rotateNum = 0;
		isPlaced = false;
		this.setWidth(width);
		this.setLength(length);
		policePieces = new Police[width][length];
		createPolicePieces(shape, false);
		// TODO Auto-generated constructor stub
	}

	public Police() {
		super();
	}

	public Police(int width, int length, String shape, boolean rogueGame) {
		super();
		rotateNum = 0;
		isPlaced = false;
		this.setWidth(width);
		this.setLength(length);
		policePieces = new Police[width][length];
		createPolicePieces(shape, rogueGame);
		// TODO Auto-generated constructor stub
	}

	public void createPolicePieces(String shape, boolean rogue) {
		if(shape == "L1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "L2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "L3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "L4") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
		else if(shape == "L6") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "L5") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
		}
		else if(shape == "L7") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
		}
		else if(shape == "L8") {
            policePieces[0][0] = new PoliceRoad(rogue);
            policePieces[1][0] = new PoliceCar(rogue);
            policePieces[2][0] = new PoliceRoad(rogue);
            policePieces[0][1] = new PoliceCar(rogue);
        }
		else if(shape == "T1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "T2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "T3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "T4") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceCar(rogue);
		}
		else if(shape == "I1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "I2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "I3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
		}
		else if(shape == "I4") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "jrL1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "jrL2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "jrL3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceCar(rogue);
		}
		else if(shape == "C1") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "C2") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "C3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "C4") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "C5") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
		else if(shape == "C6") {
            policePieces[0][0] = new PoliceCar(rogue);
            policePieces[0][1] = new PoliceCar(rogue);
            policePieces[1][0] = new PoliceRoad(rogue);
            policePieces[2][0] = new PoliceRoad(rogue);
            policePieces[2][1] = new PoliceRoad(rogue);
        }
		else if(shape == "P1") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "P2") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "P3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "P4") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "P5") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
		}
		else if(shape == "S1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "S2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "S3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
		else if(shape == "S4") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceCar(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Lwith4") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
		}
		else if(shape == "jrLwith3") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
		}
		else if(shape == "Iwith3") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
		}
		else if(shape == "Lwith2_1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
		}
		else if(shape == "Iwith2_1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "Twith2_1") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Lwith2_3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
		else if(shape == "Lwith2_1") {
            policePieces[0][0] = new PoliceCar(rogue);
            policePieces[1][0] = new PoliceRoad(rogue);
            policePieces[2][0] = new PoliceRoad(rogue);
            policePieces[0][1] = new PoliceCar(rogue);
        }
		else if(shape == "Lwith2_2") {
            policePieces[0][0] = new PoliceRoad(rogue);
            policePieces[1][0] = new PoliceCar(rogue);
            policePieces[2][0] = new PoliceCar(rogue);
            policePieces[0][1] = new PoliceRoad(rogue);
        }
		else if(shape == "Twith3_1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Twith2_1") {
            policePieces[0][0] = new PoliceRoad(rogue);
            policePieces[1][0] = new PoliceCar(rogue);
            policePieces[2][0] = new PoliceCar(rogue);
            policePieces[1][1] = new PoliceRoad(rogue);
        }
		else if(shape == "Twith2_3") {
            policePieces[0][0] = new PoliceCar(rogue);
            policePieces[1][0] = new PoliceCar(rogue);
            policePieces[2][0] = new PoliceRoad(rogue);
            policePieces[1][1] = new PoliceRoad(rogue);
        }
		else if(shape == "Twith2_1_2") {
            policePieces[0][0] = new PoliceRoad(rogue);
            policePieces[1][0] = new PoliceRoad(rogue);
            policePieces[2][0] = new PoliceCar(rogue);
            policePieces[1][1] = new PoliceRoad(rogue);
        }
		else if(shape == "Lwith4_2") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
		else if(shape == "Lwith3_2") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
		else if(shape == "Lwith3_3") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[0][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Iwith2_1") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
		}
		else if(shape == "Twith2_2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Twith2_3") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceCar(rogue);
		}
		else if(shape == "Twith2_4") {
			policePieces[0][0] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[1][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Twith2_5") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[1][0] = new PoliceCar(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[1][1] = new PoliceCar(rogue);
		}
		else if(shape == "Cwith2_1") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceCar(rogue);
			policePieces[2][1] = new PoliceRoad(rogue);
		}
		else if(shape == "Cwith2_2") {
			policePieces[0][0] = new PoliceRoad(rogue);
			policePieces[0][1] = new PoliceCar(rogue);
			policePieces[1][0] = new PoliceRoad(rogue);
			policePieces[2][0] = new PoliceRoad(rogue);
			policePieces[2][1] = new PoliceCar(rogue);
		}
	}

	public Police[][] getPolicePieces() {
		return policePieces;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Police getObject(int i, int j) {
		return policePieces[i][j];
	}


	public void rotateArray() {
		if(!isPlaced) {
			Police[][] ret = new Police[length][width];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < width; j++) {
					ret[i][j] = policePieces[j][length - i - 1];
				}
			}
			int temp = width;
			width = length;
			length = temp;
			policePieces = ret;
			increaseRotateNum();
		}
	}

	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(boolean isPlaced) {
		this.isPlaced = isPlaced;
	}

	public void setRotateNum(int rotateNum) {
		this.rotateNum = rotateNum;
	}

	public void increaseRotateNum() {
		this.rotateNum = rotateNum + 1;
		if(rotateNum == 4)
			rotateNum = 0;
	}

	public int getRotateNum() {
		return rotateNum;
	}
}
