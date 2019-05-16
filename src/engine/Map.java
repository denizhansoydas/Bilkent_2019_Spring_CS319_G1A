package engine;

import javax.swing.JPanel;

public class Map extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4321402704370786401L;
	//properties
	private int x;
	private int y;
	private int policeNum;
	private int policeIndex;
	int [][] solArray;
	Entity [][] entities;
	Entity [] policeArray;

	public Map(int x, int y, int policeNum){
		this.x = x;
		this.y = y;
		solArray = new int [6][6];
		entities = new Entity[x][y];
		policeArray = new Police[policeNum];
		setPoliceNum(policeNum);
		policeIndex = 0;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Entity[][] getEntities() {
		return entities;
	}
	public void setEntities(Entity[][] entities) {
		this.entities = entities;
	}

	public Entity retrieveAt(int x, int y) {
		return entities[x][y];
	}

	public void setEntityAt(int x, int y, Entity last) {
		entities[x][y] = last;
	}

	public boolean addPolice(Entity last) {
		if(policeIndex < policeNum ) {
			policeArray[policeIndex] = last;
			policeIndex++;
			return true;
		}
		else
			return false;
	}

	public String toString() {
		String temp = "";
		for(int i = 0; i <= x-1; i++) {
			for (int j = 0; j <= y-1; j++) {
				temp = temp + "\t" + entities[i][j];
			}
			temp = temp + "\n";
		}
		return temp;
	}

	public Entity[] getPoliceArray() {
		return policeArray;
	}

	public int getPoliceIndex() {
		return policeIndex;
	}

	public int getPoliceNum() {
		return policeNum;
	}

	public void setPoliceNum(int policeNum) {
		this.policeNum = policeNum;
	}

	public int [][] returnSolution() {
		return solArray;
	}

	private void addSolution(int[][] solutionArray) {
		solArray = solutionArray;
	}

	public void createMapEasy(int level, boolean rogueGame) {
		if(!rogueGame) {
			if(level == 1) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Buildings());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Thief());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Buildings());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Buildings());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Buildings());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Buildings());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Buildings());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,1,"I1"));
				addPolice(new Police(3,2,"C1"));
				addPolice(new Police(3,1,"I1"));
				addPolice(new Police(3,1,"I3"));
				addPolice(new Police(2,2,"jrL1"));
				addPolice(new Police(2,2,"jrL2"));
				int[][] solutionArray = {
						{0,1,1,1,0,0},
						{0,5,5,4,6,0},
						{0,5,0,4,6,6},
						{0,3,0,4,0,0},
						{0,3,0,2,0,2},
						{0,3,0,2,2,2}};
				addSolution(solutionArray);
			}
			if(level == 2) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Thief());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new ThiefsHouse());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Buildings());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,2, "S2"));
				addPolice(new Police(3,2, "C4"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(2,2, "jrL1"));
				addPolice(new Police(3,2, "L4"));
				addPolice(new Police(3,2, "T4"));
				int[][] solutionArray = {
						{0,2,2,3,0,0},
						{0,2,3,3,0,0},
						{5,2,2,0,1,1},
						{5,4,4,1,1,0},
						{5,5,4,6,0,0},
						{0,0,6,6,6,0}};
				addSolution(solutionArray);

			}
			if(level == 3) {
				setEntityAt(1, 1, new Road());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new Buildings());
				setEntityAt(2, 3, new Tunnel());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Buildings());
				setEntityAt(3, 3, new Buildings());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Buildings());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Thief());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Buildings());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Buildings());
				setEntityAt(5, 5, new Tunnel());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new ThiefsHouse());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1, "I3"));
				addPolice(new Police(3,1, "I1"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(3,2, "L3"));
				addPolice(new Police(2,2, "jrL2"));
				int[][] solutionArray = {
						{1,1,1,2,2,2},
						{0,0,0,3,3,0},
						{4,0,0,3,0,5},
						{4,4,0,5,5,5},
						{0,0,6,0,0,0},
						{0,6,6,0,0,0}};
				addSolution(solutionArray);
			}
		} 
		else {
			if(level == 1) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Tunnel());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Buildings());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Thief(rogueGame));
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Buildings());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Buildings());
				setEntityAt(4, 6, new Park());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Buildings());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Tunnel());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,2,"Lwith4",rogueGame));
				addPolice(new Police(3,1,"Iwith3",rogueGame));
				addPolice(new Police(2,2,"jrLwith3",rogueGame));
				addPolice(new Police(2,2,"jrL2",rogueGame));
				addPolice(new Police(2,2,"jrL1",rogueGame));
				addPolice(new Police(3,2,"C1",rogueGame));
				int[][] solutionArray = {
						{0,1,1,2,0,0},
						{0,1,2,2,3,0},
						{0,1,0,4,3,3},
						{0,5,4,4,0,0},
						{0,5,0,6,0,6},
						{0,5,0,6,6,6}};
				addSolution(solutionArray);
			}
			else if(level == 2) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Thief(rogueGame));
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Buildings());
				setEntityAt(3, 3, new Buildings());
				setEntityAt(3, 4, new Buildings());
				setEntityAt(3, 5, new Buildings());
				setEntityAt(3, 6, new ThiefsHouse());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Buildings());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Buildings());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Buildings());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Park());
				setEntityAt(5, 5, new Buildings());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Park());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,2,"Lwith2_1",rogueGame));
				addPolice(new Police(2,2,"jrLwith3",rogueGame));
				addPolice(new Police(3,2,"Lwith2_1",rogueGame));
				addPolice(new Police(2,2,"jrL1",rogueGame));
				addPolice(new Police(2,2,"jrLwith3",rogueGame));
				addPolice(new Police(3,1,"Iwith3",rogueGame));
				int[][] solutionArray = {
						{0,0,0,4,4,5},
						{1,1,0,4,5,5},
						{1,0,0,0,0,0},
						{1,0,3,3,0,6},
						{2,0,3,0,0,6},
						{2,2,3,0,0,6}};
				addSolution(solutionArray);
			} 
			else if(level == 3) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Park());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new ThiefsHouse());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Buildings());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Buildings());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Buildings());
				setEntityAt(5, 4, new Thief(rogueGame));
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1,"Iwith2_1",rogueGame));
				addPolice(new Police(3,1,"Iwith2_1",rogueGame));
				addPolice(new Police(3,2,"C1",rogueGame));
				addPolice(new Police(2,2,"jrLwith3",rogueGame));
				addPolice(new Police(3,2,"Lwith4",rogueGame));
				addPolice(new Police(2,2,"jrLwith3",rogueGame));
				int[][] solutionArray = {
						{0,0,0,0,0,6},
						{0,2,0,2,0,6},
						{1,2,2,2,6,6},
						{1,3,3,3,5,5},
						{1,4,0,0,5,0},
						{0,4,4,0,0,0}};
				addSolution(solutionArray);
			}
		}
	}

	public void createMapNormal(int level, boolean rogueGame) {
		if(!rogueGame) {
			if(level == 1) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Park());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Buildings());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Tunnel());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Buildings());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Tunnel());
				setEntityAt(4, 4, new Buildings());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Thief());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new ThiefsHouse());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,2, "T4"));
				addPolice(new Police(3,1, "I3"));
				addPolice(new Police(2,2, "jrL1"));
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(3,2, "T2"));
				addPolice(new Police(2,2, "jrL3"));
				int[][] solutionArray = {
						{0,0,5,0,0,0},
						{1,0,5,5,6,0},
						{1,1,5,0,2,0},
						{1,4,0,0,2,0},
						{6,4,4,0,2,3},
						{6,6,0,0,3,3}};
				addSolution(solutionArray);
			}
			else if(level == 2) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new ThiefsHouse());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Tunnel());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Buildings());
				setEntityAt(3, 5, new Buildings());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Tunnel());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Park());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Thief());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1, "I1"));
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(3,2, "T4"));
				addPolice(new Police(3,2, "L1"));
				addPolice(new Police(3,2, "T2"));
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(2,2, "jrL3"));

				int[][] solutionArray = {
						{0,0,0,1,1,1},
						{2,0,3,0,4,4},
						{2,2,3,0,0,4},
						{2,0,3,3,0,0},
						{0,6,0,5,5,5},
						{6,6,0,0,5,0}};
				addSolution(solutionArray);

			}
			else if(level == 3) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Tunnel());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Buildings());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Thief());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Buildings());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Buildings());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Park());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Buildings());
				setEntityAt(5, 5, new Tunnel());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(3,1, "I3"));
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(3,2, "T2"));
				addPolice(new Police(3,1, "I2"));
				int[][] solutionArray = {
						{0,0,2,0,3,0},
						{1,0,2,2,3,0},
						{1,1,0,4,3,0},
						{0,5,0,4,4,6},
						{0,5,5,0,0,6},
						{0,5,0,0,0,6}};
				addSolution(solutionArray);
			}
		}
		else {
			if(level == 1) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Buildings());
				setEntityAt(2, 4, new Buildings());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Buildings());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Buildings());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Buildings());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Thief(rogueGame));
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,1,"I1", rogueGame));
				addPolice(new Police(3,1,"Iwith2_1", rogueGame));
				addPolice(new Police(3,2,"Cwith2_2", rogueGame));
				addPolice(new Police(3,2,"C3", rogueGame));
				addPolice(new Police(2,2,"jrL2", rogueGame));
				addPolice(new Police(3,2,"Twith2_1", rogueGame));
				int[][] solutionArray = {
						{0,0,0,1,1,1},
						{2,2,0,0,3,0},
						{2,0,4,0,3,0},
						{2,2,4,4,3,0},
						{6,0,6,0,5,0},
						{6,6,6,5,5,5}};
				addSolution(solutionArray);
			}
			else if(level == 2) {
				setEntityAt(1, 1, new Tunnel());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new Buildings());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Tunnel());
				setEntityAt(2, 5, new Buildings());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Buildings());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Buildings());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Thief(rogueGame));
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Buildings());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,1, "I2", rogueGame));
				addPolice(new Police(2,2, "jrL1", rogueGame));
				addPolice(new Police(3,2, "T4", rogueGame));
				addPolice(new Police(3,2, "T4", rogueGame));
				addPolice(new Police(3,2, "C3", rogueGame));
				addPolice(new Police(2,2, "jrL2", rogueGame));
				int[][] solutionArray = {
						{0,0,1,1,1,0},
						{0,0,2,0,0,0},
						{3,0,2,2,0,0},
						{3,3,0,4,4,4},
						{3,0,6,4,5,4},
						{0,6,6,6,5,5}};
				addSolution(solutionArray);
			}
			else if(level == 3) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Buildings());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Buildings());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Buildings());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Thief(rogueGame));
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Buildings());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Buildings());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(2,2, "jrL2", rogueGame));
				addPolice(new Police(3,2, "I2", rogueGame));
				addPolice(new Police(3,2, "Twith2_3", rogueGame));
				addPolice(new Police(3,2, "Twith2_4", rogueGame));
				addPolice(new Police(3,2, "Cwith2_1", rogueGame));
				addPolice(new Police(3,2, "Cwith2_2", rogueGame));
				int[][] solutionArray = {
						{0,0,1,2,2,2},
						{0,1,1,1,2,0},
						{0,3,3,3,0,4},
						{0,3,0,3,0,4},
						{0,5,0,5,6,4},
						{0,5,5,5,6,6}};
				addSolution(solutionArray);
			}
		}
	}

	public void createMapHard(int level, boolean rogueGame) {
		if(!rogueGame) {
			if(level == 1) {
				setEntityAt(1, 1, new Road());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Thief());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new ThiefsHouse());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Park());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1, "I2"));
				addPolice(new Police(3,2, "P3"));
				addPolice(new Police(3,2, "C4"));
				addPolice(new Police(3,2, "S1"));
				addPolice(new Police(2,2, "jrL1"));
				addPolice(new Police(3,2, "T2"));
				int[][] solutionArray = {
						{2,2,3,0,3,0},
						{2,2,3,3,3,0},
						{2,4,4,0,5,0},
						{4,4,0,5,5,0},
						{0,0,6,1,1,1},
						{0,6,6,6,0,0}};
				addSolution(solutionArray);
			}
			else if(level == 2) {
				setEntityAt(1, 1, new Road());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Park());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Buildings());
				setEntityAt(2, 4, new Buildings());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new ThiefsHouse());
				setEntityAt(3, 3, new Buildings());
				setEntityAt(3, 4, new Tunnel());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Thief());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Tunnel());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,2, "P2"));
				addPolice(new Police(3,2, "L1"));
				addPolice(new Police(3,1, "I1"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(3,1, "I2"));
				int[][] solutionArray = {
						{1,1,0,2,2,3},
						{1,1,0,0,2,3},
						{1,0,0,0,2,3},
						{6,6,6,4,0,0},
						{0,0,5,4,4,0},
						{0,0,5,5,0,0}};
				addSolution(solutionArray);
			}
			else if(level == 3) {
				setEntityAt(1, 1, new Road());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Tunnel());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Park());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Thief());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new ThiefsHouse());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Park());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Tunnel());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,2, "L4"));
				addPolice(new Police(2,2, "jrL1"));
				addPolice(new Police(3,2, "T4"));
				addPolice(new Police(3,2, "C4"));
				addPolice(new Police(3,2, "S2"));
				addPolice(new Police(3,1, "I2"));
				int[][] solutionArray = {
						{1,3,3,3,0,0},
						{1,0,3,5,0,0},
						{1,1,0,5,5,6},
						{4,4,2,0,5,6},
						{4,0,2,2,0,6},
						{4,4,0,0,0,0}};
				addSolution(solutionArray);
			}
		}
		else {
			if(level == 1) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Tunnel());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Tunnel());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Thief(rogueGame));
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Buildings());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Park());
				setEntityAt(5, 3, new Buildings());
				setEntityAt(5, 4, new ThiefsHouse());
				setEntityAt(5, 5, new Park());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,2,"C4", rogueGame));
				addPolice(new Police(3,2,"Lwith4_2", rogueGame));
				addPolice(new Police(2,2,"jrLwith3", rogueGame));
				addPolice(new Police(3,1,"Iwith2_1", rogueGame));
				addPolice(new Police(3,1,"I1", rogueGame));
				addPolice(new Police(3,2, "Twith3_1", rogueGame));
				int[][] solutionArray = {
						{0,0,6,6,6,5},
						{1,1,4,6,0,5},
						{1,0,4,0,3,5},
						{1,1,4,3,3,0},
						{0,0,0,0,0,2},
						{0,0,0,2,2,2}};
				addSolution(solutionArray);
			}
			else if(level == 2) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new Buildings());
				setEntityAt(2, 3, new Tunnel());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Buildings());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Thief(rogueGame));
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Tunnel());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,2,"Lwith2_3", rogueGame));
				addPolice(new Police(2,2,"jrL1", rogueGame));
				addPolice(new Police(3,1,"Iwith2_1", rogueGame));
				addPolice(new Police(3,1,"Iwith2_1", rogueGame));
				addPolice(new Police(3,2,"C4", rogueGame));
				addPolice(new Police(3,2, "S1", rogueGame));
				int[][] solutionArray = {
						{0,0,0,0,0,3},
						{0,0,0,2,2,3},
						{0,6,6,2,0,3},
						{6,6,1,4,4,4},
						{1,1,1,5,0,5},
						{0,0,0,5,5,5}};
				addSolution(solutionArray);
			} 
			else if(level == 3) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Thief(rogueGame));
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Tunnel());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Tunnel());
				setEntityAt(4, 3, new Road());
				setEntityAt(4, 4, new Park());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1,"Iwith2_1", rogueGame));
				addPolice(new Police(3,1,"Iwith2_1", rogueGame));
				addPolice(new Police(3,2,"C4", rogueGame));
				addPolice(new Police(2,2,"jrLwith3", rogueGame));
				addPolice(new Police(3,2, "Twith2_1", rogueGame));
				addPolice(new Police(3,2, "Twith2_1", rogueGame));
				int[][] solutionArray = {
						{0,0,0,0,0,5},
						{2,3,0,3,5,5},
						{2,3,3,3,0,5},
						{2,0,6,0,4,4},
						{0,6,6,6,4,0},
						{0,1,1,1,0,0}};
				addSolution(solutionArray);
			}
		}
	}
	public void createMapExpert(int level, boolean rogueGame) {
		if(!rogueGame) {
			if(level == 1) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Park());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Buildings());
				setEntityAt(2, 2, new ThiefsHouse());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Tunnel());
				setEntityAt(2, 5, new ThiefsHouse());
				setEntityAt(2, 6, new Park());
				setEntityAt(3, 1, new Tunnel());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Thief());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1, "I2"));
				addPolice(new Police(3,1, "I2"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(3,2, "C4"));
				addPolice(new Police(3,2, "L4"));
				addPolice(new Police(3,2, "T1"));
				int[][] solutionArray = {
						{0,0,1,1,1,0},
						{0,0,3,0,0,0},
						{0,2,3,3,6,0},
						{5,2,0,6,6,6},
						{5,2,4,4,4,0},
						{5,5,4,0,4,0}};
				addSolution(solutionArray);
			}
			else if(level == 2) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Thief());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new ThiefsHouse());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Tunnel());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Park());
				setEntityAt(4, 3, new ThiefsHouse());
				setEntityAt(4, 4, new Park());
				setEntityAt(4, 5, new ThiefsHouse());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Tunnel());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(3,2, "S4"));
				addPolice(new Police(2,2, "jrL1"));
				addPolice(new Police(3,1, "I2"));
				addPolice(new Police(3,1, "I2"));
				addPolice(new Police(3,2, "T1"));
				int[][] solutionArray = {
						{0,0,0,0,0,0},
						{0,0,0,0,0,0},
						{0,0,0,0,0,0},
						{0,0,0,0,0,0},
						{0,0,0,0,0,0},
						{0,0,0,0,0,0}};
				addSolution(solutionArray);
			}
			else if(level == 3) {
				setEntityAt(1, 1, new Road());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new ThiefsHouse());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Thief());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Park());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Buildings());
				setEntityAt(4, 2, new ThiefsHouse());
				setEntityAt(4, 3, new Tunnel());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Tunnel());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Buildings());
				setEntityAt(5, 2, new Park());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new ThiefsHouse());
				setEntityAt(6, 3, new Park());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Road());
				addPolice(new Police(3,2, "L4"));
				addPolice(new Police(2,2, "jrL2"));
				addPolice(new Police(3,2, "T4"));
				addPolice(new Police(2,2, "jrL3"));
				addPolice(new Police(3,1, "I2"));
				addPolice(new Police(3,1, "I1"));
				int[][] solutionArray = {
						{2,2,0,0,4,4},
						{2,0,1,0,4,0},
						{1,1,1,6,6,6},
						{0,0,0,3,0,5},
						{0,0,3,3,3,5},
						{0,0,0,0,0,5}};
				addSolution(solutionArray);

			}
		}
		else {
			if(level == 1) {
				setEntityAt(1, 1, new Road());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Road());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Buildings());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Buildings());
				setEntityAt(2, 5, new Buildings());
				setEntityAt(2, 6, new Buildings());
				setEntityAt(3, 1, new Buildings());
				setEntityAt(3, 2, new Buildings());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Road());
				setEntityAt(3, 5, new ThiefsHouse());
				setEntityAt(3, 6, new Road());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new Thief(rogueGame));
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Tunnel());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Tunnel());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Buildings());
				setEntityAt(6, 6, new Buildings());
				addPolice(new Police(3,1, "I4", rogueGame));
				addPolice(new Police(3,2, "L5", rogueGame));
				addPolice(new Police(2,2, "jrL1", rogueGame));
				addPolice(new Police(2,2, "jrL2", rogueGame));
				addPolice(new Police(3,2, "C4", rogueGame));
				addPolice(new Police(2,2, "jrL2", rogueGame));
				int[][] solutionArray = {
						{1,1,1,2,2,2},
						{1,0,3,0,0,0},
						{0,0,3,3,0,4},
						{5,5,0,4,4,4},
						{5,0,6,6,0,0},
						{5,0,6,0,0,0}};
				addSolution(solutionArray);
			}
			if(level==2) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Buildings());
				setEntityAt(1, 3, new Buildings());
				setEntityAt(1, 4, new Road());
				setEntityAt(1, 5, new Buildings());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Tunnel());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Road());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Road());
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Tunnel());
				setEntityAt(3, 5, new  Buildings());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Thief(rogueGame));
				setEntityAt(4, 3, new  Buildings());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Road());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Road());
				setEntityAt(6, 1, new Road());
				setEntityAt(6, 2, new Road());
				setEntityAt(6, 3, new Road());
				setEntityAt(6, 4, new Buildings());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new  Buildings());
				addPolice(new Police(2,2, "jrL3", rogueGame));
				addPolice(new Police(3,1, "I3", rogueGame));
				addPolice(new Police(3,2, "L8", rogueGame));
				addPolice(new Police(3,2, "C6", rogueGame));
				addPolice(new Police(3,2, "Twith2_1_2", rogueGame));
				addPolice(new Police(3,2, "L6", rogueGame));
				
				int[][] solutionArray = {
						{0,0,0,1,0,0},
						{2,0,2,1,1,1},
						{2,2,2,0,0,0},
						{3,0,0,4,4,4},
						{3,3,3,5,5,5},
						{6,6,6,0,5,0}};
				addSolution(solutionArray);
			}
			if(level==3) {
				setEntityAt(1, 1, new Buildings());
				setEntityAt(1, 2, new Road());
				setEntityAt(1, 3, new Road());
				setEntityAt(1, 4, new Buildings());
				setEntityAt(1, 5, new Road());
				setEntityAt(1, 6, new Buildings());
				setEntityAt(2, 1, new Road());
				setEntityAt(2, 2, new Road());
				setEntityAt(2, 3, new Road());
				setEntityAt(2, 4, new Tunnel());
				setEntityAt(2, 5, new Road());
				setEntityAt(2, 6, new Road());
				setEntityAt(3, 1, new Road());
				setEntityAt(3, 2, new Thief(rogueGame));
				setEntityAt(3, 3, new Road());
				setEntityAt(3, 4, new Buildings());
				setEntityAt(3, 5, new Road());
				setEntityAt(3, 6, new Buildings());
				setEntityAt(4, 1, new Road());
				setEntityAt(4, 2, new Road());
				setEntityAt(4, 3, new  Buildings());
				setEntityAt(4, 4, new Road());
				setEntityAt(4, 5, new Road());
				setEntityAt(4, 6, new Road());
				setEntityAt(5, 1, new Road());
				setEntityAt(5, 2, new Road());
				setEntityAt(5, 3, new Tunnel());
				setEntityAt(5, 4, new Road());
				setEntityAt(5, 5, new Road());
				setEntityAt(5, 6, new Buildings());
				setEntityAt(6, 1, new Buildings());
				setEntityAt(6, 2, new Buildings());
				setEntityAt(6, 3, new Buildings());
				setEntityAt(6, 4, new Road());
				setEntityAt(6, 5, new Road());
				setEntityAt(6, 6, new  Buildings());
				addPolice(new Police(3,1, "I1", rogueGame));
				addPolice(new Police(3,2, "Lwith3_2", rogueGame));
				addPolice(new Police(2,2, "jrL3", rogueGame));
				addPolice(new Police(3,2, "T2", rogueGame));
				addPolice(new Police(3,2, "Lwith3_3", rogueGame));
				addPolice(new Police(3,2, "Lwith3_3", rogueGame));
				
				int[][] solutionArray = {
						{0,1,1,0,3,0},
						{2,2,1,0,3,3},
						{2,0,1,0,3,0},
						{2,4,0,5,6,6},
						{4,4,0,5,6,0},
						{0,0,0,5,6,0}};
				addSolution(solutionArray);
			}
		}
	}
}