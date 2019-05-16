package gui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import engine.*;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

class GamePanel extends JPanel
{

	private static final long serialVersionUID = 7946072068569233114L;
	public static final String NAME = "Game Panel";
	public static final int WIDTH  = 1800;
	public static final int HEIGHT = 1000;
	public static final int X_ORIGIN = 20; // X coordinate of the top left
	public static final int Y_ORIGIN = 5; // Y coordinate of the top left
	public static final int TILE_SIZE = 115; // Size of the tile spaces
	public static final int BORDER_SIZE = 5; // size of the border between spaces

	private static int [][] gridArray;
	private static int [][] solArray;
	private static Entity [][] entities;
	private static Entity [] policeArray;
	private static JPanel[] panelArray;
	private static JPanel mainPanel;
	private static Clip clip = null;

	private JLabel infoLabel = new JLabel();
	private BufferedImage gridImage;
	private static int currentLevel, hintNumber, hintCount, hintRemained, gotHint;
	private static int [] hintArray;
	private static String currentDifficulty;
	private static boolean isVictory, isFinished, shownHint, shownTip, rogueGame;
	private Map map;

	int timeCounter = 0;

	public GamePanel(JPanel panel, int curLevel, String curDifficulty, boolean isRogueGame) {
		isVictory = false;
		isFinished = false;
		setGotHint(0);
		rogueGame = isRogueGame;
		mainPanel = panel;
		setBackground(Color.LIGHT_GRAY);
		setLocation(0,0);
		hintNumber = 0;
		panelArray = new JPanel[8];
		gridArray = new int[8][8];

		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[i].length; j++) {
				gridArray[i][j] = 1;
			}
		}

		Font f = (MainPanel.getF()).deriveFont(16f);

		JLabel label1 = new JLabel(),
				label2 = new JLabel(),
				labelLevel = new JLabel(),
				label3 = new JLabel();

		JButton returnButton = new JButton("Return");
		JButton hintButton = new JButton("Hint");
		JButton tipButton = new JButton("Tips");

		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Icon buttonIcon = new ImageIcon(image);

		shownTip = false;

		returnButton.setBounds(WIDTH - 250, HEIGHT - 100, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f);
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		add(returnButton, BorderLayout.SOUTH);

		hintButton.setBounds(WIDTH - 750, HEIGHT - 100, 200, 50);
		hintButton.setIcon(buttonIcon);
		hintButton.setFont(f);
		hintButton.setVerticalTextPosition(SwingConstants.CENTER);
		hintButton.setHorizontalTextPosition(SwingConstants.CENTER);
		hintButton.addActionListener(new HintButtonListener());
		hintButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		add(hintButton, BorderLayout.SOUTH);

		tipButton.setBounds(WIDTH - 450, HEIGHT - 100, 100, 50);
		tipButton.setIcon(buttonIcon);
		tipButton.setFont(f);
		tipButton.setVerticalTextPosition(SwingConstants.CENTER);
		tipButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tipButton.addActionListener(new TipButtonListener());
		tipButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		add(tipButton, BorderLayout.SOUTH);

		// Label 1

		label1.setBounds(1000, 25, 800, 50);
		BufferedImage image1 = null;
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("res/timer.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Font timeFont = null;
		InputStream is = getClass().getResourceAsStream("res/digital.ttf");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			timeFont = Font.createFont(Font.TRUETYPE_FONT, is);
			ge.registerFont(f);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ImageIcon icon1 = new ImageIcon(image1);
		label1.setIcon(icon1);
		label1.setBounds(1000, 0, 800, 100);
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(timeFont.deriveFont(21f));
		label1.setVerticalTextPosition(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		//label1.setText("Current Score = 5446");
		label1.setVisible(true);
		Timer myTimer = new Timer();

		TimerTask myTask = new TimerTask() {
			public void run() {
				timeCounter++;
				label1.setText("Time : " + timeCounter);
			}
		};
		myTimer.schedule(myTask, 0, 1000);
		add(label1);

		// Label Level

		BufferedImage imageLevel = null;
		try {
			imageLevel = ImageIO.read(getClass().getResourceAsStream("res/level.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon iconLevel = new ImageIcon(imageLevel);
		labelLevel.setIcon(iconLevel);
		labelLevel.setBounds(1300, 0, 500, 100);
		labelLevel.setForeground(new Color(255, 255, 255));
		labelLevel.setFont(timeFont.deriveFont(21f));
		labelLevel.setVerticalTextPosition(JLabel.CENTER);
		labelLevel.setHorizontalTextPosition(JLabel.CENTER);
		labelLevel.setText("Current Difficulty : " + curDifficulty + " | Current Level : " + curLevel);
		labelLevel.setVisible(true);
		add(labelLevel);

		// Label 2

		BufferedImage image2 = null;
		try {
			if(!isRogueGame)
				image2 = ImageIO.read(getClass().getResourceAsStream("res/upperground.PNG"));
			else {
				image2 = ImageIO.read(getClass().getResourceAsStream("res/upperrogue.PNG"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label2.setBounds(1000, 0, 800, 100);;
		ImageIcon icon2 = new ImageIcon(image2);
		label2.setIcon(icon2);
		add(label2);

		label3.setBounds(1000, 100, 800, 900);
		label3.setOpaque(true);
		add(label3);

		// Label 3

		BufferedImage image3 = null;
		try {
			if(!isRogueGame)
				image3 = ImageIO.read(getClass().getResourceAsStream("res/beachground.PNG"));
			else {
				image3 = ImageIO.read(getClass().getResourceAsStream("res/rogueground.jpg"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon icon3 = new ImageIcon(image3);
		label3.setIcon(icon3);
		add(label3);

		try {
			gridImage = ImageIO.read(getClass().getResourceAsStream("res/blackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedImage image4 = null;
		try {
			if(!isRogueGame)
				image4 = ImageIO.read(getClass().getResourceAsStream("res/info.jpg"));
			else
				image4 = ImageIO.read(getClass().getResourceAsStream("res/infoRogue.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon icon4 = new ImageIcon(image4);
		infoLabel = new JLabel(icon4, JLabel.CENTER);
		infoLabel.setOpaque(false);

	}

	public void setLevel(int level, String difficulty, boolean rogueGame) {
		currentLevel = level;
		currentDifficulty = difficulty;
		if(currentDifficulty == "Expert") {
			createLevelExpert();
			hintRemained = 0;
		}
		else if(currentDifficulty == "Hard") {
			createLevelHard();
			hintRemained = 1;
		}
		else if (currentDifficulty == "Normal") {
			createLevelNormal();
			hintRemained = 2;
		}
		else if (currentDifficulty == "Easy") {
			createLevelEasy();
			hintRemained = 3;
		}
		else if(currentDifficulty == "Expert" && rogueGame) {
			createLevelExpert();
			hintRemained = 0;
		}
		else if(currentDifficulty == "Hard" && rogueGame) {
			createLevelHard();
			hintRemained = 1;
		}
		else if (currentDifficulty == "Normal" && rogueGame) {
			createLevelNormal();
			hintRemained = 2;
		}
		else if (currentDifficulty == "Easy" && rogueGame) {
			createLevelEasy();
			hintRemained = 3;
		}
		solArray = map.returnSolution();
		hintCount = map.getPoliceNum();
		hintArray = new int [hintCount];
		for(int i = 0; i < hintCount; i++) {
			hintArray[i] = 0;
		}
	}

	class ReturnButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(!rogueGame) {
				CardLayout cLayout = (CardLayout) mainPanel.getLayout();
				((MainPanel) mainPanel).changeMusic(false);
				cLayout.show(mainPanel, OptionsPanel.NAME);
				removeAll();
			}
			else {
				CardLayout cLayout = (CardLayout) mainPanel.getLayout();
				cLayout.show(mainPanel, RoguePanel.NAME);
				removeAll();
			}
		}
	}

	class HintButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			showHint();
		}
	}

	class TipButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{

			if(!shownTip) {
				shownTip = true;
				infoLabel.setVisible(true);
				add(infoLabel);
				setComponentZOrder(infoLabel, 0);
				revalidate();
				repaint();
			}
			else {
				shownTip = false;
				infoLabel.setVisible(false);
				remove(infoLabel);
				revalidate();
				repaint();
			}
		}
	}

	/*private void showSolution() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(solArray[i][j] + ", ");
			}
			System.out.println();
		}
	}*/

	public void callSound(boolean placed) {
		if(placed) {
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("res/placeBlock.wav"));
			} catch (UnsupportedAudioFileException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clip.start();
		}
		else {
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("res/removeBlock.wav"));
			} catch (UnsupportedAudioFileException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clip.start();
		}
	}

	private void showHint() {
		//showSolution();
		shownHint = false;
		hintNumber = 1;

		while(hintArray[hintNumber - 1] != 0 && hintNumber != hintCount) {
			hintNumber++;
		}
		hintArray[hintNumber - 1] = 1;

		for(int i = 1; i < 7; i++) {
			for(int j = 1; j < 7; j++) {
				if(gridArray[i][j] != 0 && solArray[i - 1][j - 1] == hintNumber) {
					showHint();
					return;
				}
			}
		}

		for(int i = 1; i < 7 && hintRemained > 0; i++) {
			for(int j = 1; j < 7; j++) {
				if(solArray[i - 1][j - 1] == hintNumber) {
					if(hintRemained == 3)
						((Road) entities[i][j]).setHintRoadGreen();
					else if (hintRemained == 2)
						((Road) entities[i][j]).setHintRoadYellow();
					else
						((Road) entities[i][j]).setHintRoadBlue();
					shownHint = true;
				}
			}
		}
		if(shownHint) {
			hintRemained--;
			setGotHint(getGotHint() + 1);
		}
		revalidate();
		repaint();

		if(hintNumber == hintCount) {
			for(int i = 0; i < hintCount; i++) {
				hintArray[i] = 0;
			}
		}
	}

	private void createLevelEasy() {
		map = new Map(8,8,6);
		map.createMapEasy(currentLevel, rogueGame);
		updateGrid();
		setup();
	}

	private void createLevelNormal() {
		map = new Map(8,8,6);
		map.createMapNormal(currentLevel, rogueGame);
		updateGrid();
		setup();
	}

	private void createLevelHard() {
		map = new Map(8,8,6);
		map.createMapHard(currentLevel, rogueGame);
		updateGrid();
		setup();
	}

	private void createLevelExpert() {
		map = new Map(8,8,6);
		map.createMapExpert(currentLevel, rogueGame);
		updateGrid();
		setup();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(gridImage, 0, 0, this);
		for (int i = 0; i < map.getX(); i++) {
			for (int j = 0; j < map.getY(); j++) {
				if (map.getEntities()[i][j] instanceof Thief || map.getEntities()[i][j] instanceof Buildings || map.getEntities()[i][j] instanceof Tunnel 
						|| map.getEntities()[i][j] instanceof ThiefsHouse || map.getEntities()[i][j] instanceof Road || map.getEntities()[i][j] instanceof Park) {
					g2.drawImage(((Entity) entities[i][j]).getImage(), X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * j) + BORDER_SIZE/2, Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * i) + BORDER_SIZE/2, this);
				}
				else if (map.getEntities()[i][j] == null) {
					g2.drawImage(setOutside(i,j),
							X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * i) + BORDER_SIZE/2,
							Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * j) + BORDER_SIZE/2, this);
				}
			}
		}
	}

	/*private void checkAround(int i, int j) {
		int rightX = 0, upY = 0, downY = 0, leftX = 0;
		if(map.getEntities()[i + 1][j] instanceof Road || map.getEntities()[i + 1][j] == null)
			downY = 1;
		if(map.getEntities()[i - 1][j] instanceof Road || map.getEntities()[i - 1][j] == null)
			upY = 1;
		if(map.getEntities()[i][j + 1] instanceof Road || map.getEntities()[i][j + 1] == null)
			rightX = 1;
		if(map.getEntities()[i][j - 1] instanceof Road || map.getEntities()[i][j - 1] == null)
			leftX = 1;
		System.out.println(rightX + " " + leftX + " " + upY + " " + downY);
		((Road) map.getEntities()[i][j]).setRoad(rightX, leftX, upY, downY);
	}*/

	public Image setOutside(int i, int j) {
		Image entityImage = null;
		ImageIO.setUseCache(false); // to make it faster to draw small images continuously / using memory instead of disk

		if(j == 0 && i == 0) {
			URL url = this.getClass().getResource("res/outside6.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if((j > 0 && j < 7) && i == 0) {
			URL url = this.getClass().getResource("res/outside4.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if(j == 7 && i == 0) {
			URL url = this.getClass().getResource("res/outside7.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if(j == 7 && (i > 0 && i < 7)) {
			URL url = this.getClass().getResource("res/outside3.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if(j == 7 && i == 7) {
			URL url = this.getClass().getResource("res/outside8.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if((j > 0 && j < 7) && i == 7) {
			URL url = this.getClass().getResource("res/outside2.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if(j == 0 && i == 7) {
			URL url = this.getClass().getResource("res/outside1.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		else if(j == 0 && (i > 0 && i < 7)) {
			URL url = this.getClass().getResource("res/outside5.gif");
			entityImage = new ImageIcon(url).getImage();
		}
		return entityImage;
	}

	private void setup() {

		setEntities(map.getEntities());
		policeArray = map.getPoliceArray();

		final int policeIndex = map.getPoliceIndex();

		for (int j = 0; j < policeIndex; j++) {

			final int policeID = j;

			int width = ((Police) policeArray[j]).getWidth();
			int length = ((Police) policeArray[j]).getLength();

			// creates a panel with an X Axis box layout for the ship
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;

			for (int i = 0; i < width; i++) {
				c.gridy = i;
				for (int k = 0; k < length; k++) {
					c.gridx =  k;
					c.insets = new Insets(0,0,5,5);  //top padding
					if(((Police)policeArray[j]).getPolicePieces()[i][k] != null) {
						ImageIcon icon = new ImageIcon(((Police)policeArray[j]).getPolicePieces()[i][k].getImage());
						JLabel label = new JLabel(icon);
						panel.add(label, c);
					}
				}
			}
			panel.setLocation(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE)+2*(j%3)* (TILE_SIZE + BORDER_SIZE + 2) + 50, (3*(j%2))* (TILE_SIZE + BORDER_SIZE + 2)+100);
			panel.setSize(length * (TILE_SIZE + BORDER_SIZE), width * (TILE_SIZE + BORDER_SIZE) + 5);
			add(panel);
			panelArray[j] = panel;
			setComponentZOrder(panel, 0);

			if(j == policeIndex - 1) {
				JPanel panelLast = new JPanel();
				panelLast.setOpaque(false);
				panelLast.setLayout(new BoxLayout(panelLast, BoxLayout.X_AXIS));
				panelLast.add(Box.createRigidArea(new Dimension(0, 0)));
				add(panelLast);
				panelLast.setVisible(false);
			}

			panel.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// gets the coordinates of the mouse in terms of the window
					JPanel component = (JPanel) e.getComponent().getParent().getParent();
					Point pt = new Point(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), component));
					int counter1 = 0;
					int counter2 = 0;

					// calculates the position in the grid array based on the
					// mouse coordinates
					int value = (int) pt.getX();

					while (X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter1)  + BORDER_SIZE/2 < value) {
						counter1++;
					}
					counter1--;

					int value2 = (int) (pt.getY());
					while (Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter2) < value2) {
						counter2++;
					}
					counter2--;

					if (e.getButton() == MouseEvent.BUTTON1) {

						leftClick(policeID, counter1, counter2, pt);
					}
					else if (e.getButton() == MouseEvent.BUTTON3) {
						if(!((panelArray[policeID].getLocation().getX()==(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE)+2*(policeID%3)*(TILE_SIZE + BORDER_SIZE + 2) + 50)) && 
								(panelArray[policeID].getLocation().getY()== (3*(policeID%2))*(TILE_SIZE + BORDER_SIZE + 2)+100)))
							rightClick(policeID);
					}
					//printGrid();
					checkFinished();
					if(isFinished)
						checkVictory();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					setComponentZOrder(panelArray[policeID], 0);
					if(((Police) policeArray[policeID]).isPlaced()) {
						//System.out.println("Entered");
						((Police) policeArray[policeID]).setPlaced(false);
						removePoliceFromGrid(policeID);

						if(e.getButton() == MouseEvent.BUTTON3) {
							panelArray[policeID].setLocation(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 2 * (policeID % 3) * (TILE_SIZE + BORDER_SIZE + 2) + 50,
									(3 * (policeID % 2)) * (TILE_SIZE + BORDER_SIZE + 2) + 100);

							if((((Police) policeArray[policeID]).getRotateNum() % 4) == 1) {
								rightClick(policeID);
								rightClick(policeID);
								rightClick(policeID);
							}
							else if((((Police) policeArray[policeID]).getRotateNum() % 4) == 2) {
								rightClick(policeID);
								rightClick(policeID);
							}
							else if((((Police) policeArray[policeID]).getRotateNum() % 4) == 3) {
								rightClick(policeID);
							}
						}
					}
				}
			});

			panel.addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {
					// when the left mouse button is down the panel is moved to
					// the mouse location
					if (SwingUtilities.isLeftMouseButton(e)) {
						JPanel component = (JPanel) e.getComponent().getParent().getParent();
						Point pt = new Point(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), component));
						panel.setLocation((int) pt.getX() - (TILE_SIZE / 2), (int) pt.getY() - (TILE_SIZE / 2));
					}
				}
			});
		}
	}

	private void setEntities(Entity[][] entities2) {
		entities = entities2;
	}

	protected void rightClick(int policeIndex) {
		panelArray[policeIndex].removeAll();
		rotatePanel(policeIndex);
		panelArray[policeIndex].revalidate();
		panelArray[policeIndex].repaint();
	}

	private void rotatePanel(int policeIndex) {
		panelArray[policeIndex].setOpaque(false);
		panelArray[policeIndex].setBackground(Color.BLACK);
		panelArray[policeIndex].setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		((Police)policeArray[policeIndex]).rotateArray();

		int width = ((Police) policeArray[policeIndex]).getWidth();
		int length = ((Police) policeArray[policeIndex]).getLength();

		for (int i = 0; i < width; i++) {
			c.gridy = i;
			for (int k = 0; k < length; k++) {
				c.gridx =  k;
				c.insets = new Insets(0,0,5,5);  //top padding
				if(((Police)policeArray[policeIndex]).getPolicePieces()[i][k] != null) {
					ImageIcon icon = new ImageIcon(((Police)policeArray[policeIndex]).getPolicePieces()[i][k].getImage());
					JLabel label = new JLabel(icon);
					panelArray[policeIndex].add(label, c);
				}
			}
		}

		panelArray[policeIndex].setSize(length * (TILE_SIZE + BORDER_SIZE), width * (TILE_SIZE + BORDER_SIZE));
		setComponentZOrder(panelArray[policeIndex], 0);
	}

	protected void leftClick(int policeIndex, int counter1, int counter2, Point pt) {
		int width = ((Police) policeArray[policeIndex]).getWidth();
		int length = ((Police) policeArray[policeIndex]).getLength();

		((Police) policeArray[policeIndex]).setPlaced(false);

		if(counter1 + length > 8 || counter2 + width > 8) {
			panelArray[policeIndex].setLocation(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 2 * (policeIndex % 3) * (TILE_SIZE + BORDER_SIZE + 2) + 50,
					(3 * (policeIndex % 2)) * (TILE_SIZE + BORDER_SIZE + 2) + 100);
			return;
		}
		else {	
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < length; j++) {
					if(((Police) policeArray[policeIndex]).getObject(i,j) != null && !(gridArray[counter2 + i][counter1 + j] == 0)) {
						panelArray[policeIndex].setLocation(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 2 * (policeIndex % 3) * (TILE_SIZE + BORDER_SIZE + 2) + 50,
								(3 * (policeIndex % 2)) * (TILE_SIZE + BORDER_SIZE + 2) + 100);
						panelArray[policeIndex].setSize(length * (TILE_SIZE + BORDER_SIZE), width * (TILE_SIZE + BORDER_SIZE));
						if((((Police) policeArray[policeIndex]).getRotateNum()%4)  == 0) {

						}
						else if((((Police) policeArray[policeIndex]).getRotateNum()%4) == 1) {
							rightClick(policeIndex);
							rightClick(policeIndex);
							rightClick(policeIndex);

						}
						else if((((Police) policeArray[policeIndex]).getRotateNum()%4) == 2) {
							rightClick(policeIndex);
							rightClick(policeIndex);

						}
						else if((((Police) policeArray[policeIndex]).getRotateNum() %4)== 3) {
							rightClick(policeIndex);
						}
						return;
					}

				}
			}
		}
		placePoliceToGrid(policeIndex, counter1, counter2);
	}

	private void removePoliceFromGrid(int policeIndex) {

		int width = ((Police) policeArray[policeIndex]).getWidth();
		int length = ((Police) policeArray[policeIndex]).getLength();

		Point pt = panelArray[policeIndex].getLocation();

		int counter1 = 0;
		int counter2 = 0;

		// calculates the position in the grid array based on the
		// mouse coordinates
		int value = (int) pt.getX();

		while (X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter1) + BORDER_SIZE/2 < value) {
			counter1++;
		}

		int value2 = (int) (pt.getY());
		while (Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter2) < value2) {
			counter2++;
		}

		for(int i = 0; i < width; i++) {
			for(int j = 0; j < length; j++) {
				if(((Police) policeArray[policeIndex]).getObject(i,j) != null) {
					//System.out.println("Removed : " + counter2 + "," + counter1);
					//System.out.println("Removed : " + (counter2 + i) + "," + (counter1 + j));
					gridArray[counter2 + i][counter1 + j] = 0;
				}
			}
		}
		callSound(false);
	}

	private void placePoliceToGrid(int policeIndex, int counter1, int counter2) {

		int width = ((Police) policeArray[policeIndex]).getWidth();
		int length = ((Police) policeArray[policeIndex]).getLength();
		((Police) policeArray[policeIndex]).setPlaced(true);
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < length; j++) {
				if(((Police) policeArray[policeIndex]).getObject(i,j) != null) {
					//System.out.println("Placed : " + (counter2 + i) + "," + (counter1 + j));
					if(((Police) policeArray[policeIndex]).getObject(i,j) instanceof PoliceRoad)
						gridArray[counter2 + i][counter1 + j] = 2;
					else
						gridArray[counter2 + i][counter1 + j] = 1;
				}
			}
			// X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * j) + BORDER_SIZE/2, Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * i) + BORDER_SIZE/2
			panelArray[policeIndex].setLocation(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter1) + BORDER_SIZE/2, Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter2));
		}
		//System.out.println(counter1 + " , " + counter2);
		callSound(true);
	}

	/*private boolean isIntersection(JPanel p) {

		int policeIndex = map.getPoliceIndex();
		System.out.println(policeIndex);
		// loops through the panel array
		for (int i = 0; i < policeIndex; i++) {
			// checks if p intersects with a panel in the array other than
			// itself
			if (p.getBounds().intersects(panelArray[i].getBounds()) && !p.equals(panelArray[i])) {
				return true;
			}
		}
		return false;
	}*/

	public void updateGrid() {
		for (int i = 0; i < map.getX(); i++) {
			for (int j = 0; j < map.getY(); j++) {
				if (map.getEntities()[i][j] instanceof Thief || map.getEntities()[i][j] instanceof Buildings || map.getEntities()[i][j] instanceof Tunnel 
						|| map.getEntities()[i][j] instanceof ThiefsHouse || map.getEntities()[i][j] instanceof Road || map.getEntities()[i][j] instanceof Park) {
					if(map.getEntities()[i][j] instanceof Road)
						gridArray[i][j] = 0;
					else if(map.getEntities()[i][j] instanceof Thief)
						gridArray[i][j] = 5;
					else if(map.getEntities()[i][j] instanceof ThiefsHouse)
						gridArray[i][j] = 6;
					else if(map.getEntities()[i][j] instanceof Park)
						gridArray[i][j] = 3;
					else if(map.getEntities()[i][j] instanceof Tunnel)
						gridArray[i][j] = 4;
					else
						gridArray[i][j] = 1;
				}
				else
					gridArray[i][j] = 2;
			}
		}
	}

	/*
	public void printGrid() {
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				System.out.print(gridArray[m][n] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	 */

	private void checkFinished() {
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				if(gridArray[m][n] == 0)
					return;
			}
		}
		isFinished = true;
	}

	private void checkVictory() {
		int startXThief = 0, startYThief = 0, startXTunnel1 = 0, startXTunnel2 = 0, startYTunnel1 = 0, startYTunnel2 = 0, startXThiefsHouse = 0, startYThiefsHouse = 0;
		int endPointX = 0, endPointY = 0;
		boolean tunnelFound = false;
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				if(gridArray[m][n] == 3) {
					gridArray[m][n] = 2;
				}
				if(gridArray[m][n] == 4) {
					if(!tunnelFound) {
						startXTunnel1 = m;
						startYTunnel1 = n;
						tunnelFound = true;
						gridArray[m][n] = 1;
					}
					else {
						startXTunnel2 = m;
						startYTunnel2 = n;
						gridArray[m][n] = 1;
					}
				}
				if(gridArray[m][n] == 5) {
					startXThief = m;
					startYThief = n;
					gridArray[m][n] = 2;
				}
				if(gridArray[m][n] == 6) {
					startXThiefsHouse = m;
					startYThiefsHouse = n;
					gridArray[m][n] = 1;
				}
			}
		}

		//printGrid();

		boolean[][] wasHere = new boolean[8][8];

		createPathAndTrack(wasHere);
		boolean thiefToEnd = recursiveSolve(gridArray,wasHere,startXThief,startYThief,endPointX,endPointY);
		//System.out.println(startXThief + ", " + startYThief + ", " + endPointX + ", " + endPointY);
		//printCorrectPath(correctPath);

		createPathAndTrack(wasHere);
		boolean thiefToHouse = recursiveSolve(gridArray,wasHere,startXThief,startYThief,startXThiefsHouse,startYThiefsHouse);
		//System.out.println(startXThief + ", " + startYThief + ", " + startXThiefsHouse + ", " + startYThiefsHouse);
		//printCorrectPath(correctPath);

		boolean tunnelExitToEnd = false, tunnelExitToHouse = false, thiefToTunnel = false;

		if((startXTunnel1 != 0 && startYTunnel1 != 0) && (!thiefToHouse && !thiefToEnd)) {

			createPathAndTrack(wasHere);
			thiefToTunnel = recursiveSolve(gridArray,wasHere,startXThief,startYThief,startXTunnel1,startYTunnel1);
			//System.out.println(startXThief + ", " + startYThief + ", " + startXTunnel1 + ", " + startYTunnel1);
			//printCorrectPath(correctPath);

			if(thiefToTunnel) {
				createPathAndTrack(wasHere);
				gridArray[startXTunnel2][startYTunnel2] = 2;
				tunnelExitToEnd = recursiveSolve(gridArray,wasHere,startXTunnel2,startYTunnel2,endPointX,endPointY);
				//System.out.println(startXTunnel2 + ", " + startYTunnel2 + ", " + endPointX + ", " + endPointY);
				//printCorrectPath(correctPath);

				if(startXThiefsHouse != 0 && startYThiefsHouse != 0) {
					createPathAndTrack(wasHere);
					tunnelExitToHouse = recursiveSolve(gridArray,wasHere,startXTunnel2,startYTunnel2,startXThiefsHouse,startYThiefsHouse);
					//System.out.println(startXTunnel2 + ", " + startYTunnel2 + ", " + startXThiefsHouse + ", " + startYThiefsHouse);
					//printCorrectPath(correctPath);
				}
				gridArray[startXTunnel2][startYTunnel2] = 1;

			}
		}
		if((startXTunnel2 != 0 && startYTunnel2 != 0) && (!thiefToHouse && !thiefToEnd && !thiefToTunnel)) {

			createPathAndTrack(wasHere);
			thiefToTunnel = recursiveSolve(gridArray,wasHere,startXThief,startYThief,startXTunnel2,startYTunnel2);
			//System.out.println(startXThief + ", " + startYThief + ", " + startXTunnel2 + ", " + startYTunnel2);
			//printCorrectPath(correctPath);

			if(thiefToTunnel) {
				createPathAndTrack(wasHere);
				gridArray[startXTunnel1][startYTunnel1] = 2;
				tunnelExitToEnd = recursiveSolve(gridArray,wasHere,startXTunnel1,startYTunnel1,endPointX,endPointY);
				//System.out.println(startXTunnel1 + ", " + startYTunnel1 + ", " + endPointX + ", " + endPointY);
				//printCorrectPath(correctPath);

				if(startXThiefsHouse != 0 && startYThiefsHouse != 0) {
					createPathAndTrack(wasHere);
					tunnelExitToHouse = recursiveSolve(gridArray,wasHere,startXTunnel1,startYTunnel1,startXThiefsHouse,startYThiefsHouse);
					//System.out.println(startXTunnel1 + ", " + startYTunnel1 + ", " + startXThiefsHouse + ", " + startYThiefsHouse);
					//printCorrectPath(correctPath);
				}
				gridArray[startXTunnel1][startYTunnel1] = 1;
			}
		}

		//System.out.println("thiefToEnd : " + thiefToEnd);
		//System.out.println("thiefToHouse : " + thiefToHouse);
		//System.out.println("thiefToTunnel : " + thiefToTunnel);
		//System.out.println("tunnelExitToEnd : " + tunnelExitToEnd);
		//System.out.println("tunnelExitToHouse : " + tunnelExitToHouse);

		if(thiefToEnd || thiefToHouse || tunnelExitToEnd || tunnelExitToHouse)
			isVictory = false;
		else
			isVictory = true;

		//System.out.println("Victory : " + isVictory);
		endGame();
	}

	private void createPathAndTrack(boolean[][] wasHere) {
		for (int row = 0; row < gridArray.length; row++)  
			for (int col = 0; col < gridArray[row].length; col++){
				wasHere[row][col] = false;
			}
	}

	/*private void printCorrectPath(boolean [][] correctPath) {
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				if(correctPath[m][n])
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}*/

	private boolean recursiveSolve(int[][] maze, boolean[][] wasHere, int x, int y, int endX,int endY) {

		if (x == endX && y == endY)
			return true;
		if (maze[x][y] == 1 || wasHere[x][y])
			return false;
		// If you are on a wall or already were here
		wasHere[x][y] = true;
		if (x != 0) // Checks if not on left edge
			if (recursiveSolve(maze,wasHere,x-1, y,endX,endY)) { // Recalls method one to the left
				return true;
			}
		if (x != 7) // Checks if not on right edge
			if (recursiveSolve(maze,wasHere,x+1, y,endX,endY)) { // Recalls method one to the right
				return true;
			}
		if (y != 0) // Checks if not on bottom edge
			if (recursiveSolve(maze,wasHere,x, y-1,endX,endY)) { // Recalls method one up
				return true;
			}
		if (y != 7)  // Checks if not on top edge
			if (recursiveSolve(maze,wasHere,x, y+1,endX,endY)) { // Recalls method one down
				return true;
			}	    
		return false;
	}

	private void endGame() {
		if((isVictory && !rogueGame) || (!isVictory && rogueGame)) {

			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("res/success.wav"));
			} catch (UnsupportedAudioFileException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clip.start();

			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			((MainPanel) mainPanel).setNextMap(currentLevel, currentDifficulty, timeCounter, rogueGame, gotHint);
			cLayout.show(mainPanel, GameVictoryPanel.NAME);
			removeAll();

		}
		else {

			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("res/failure.wav"));
			} catch (UnsupportedAudioFileException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clip.start();

			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			((MainPanel) mainPanel).setCurrentMap(currentLevel, currentDifficulty, rogueGame);
			cLayout.show(mainPanel, GameEndPanel.NAME);
			removeAll();
		}
	}

	public Entity [][] getEntities() {
		return entities;
	}

	public static int getGotHint() {
		return gotHint;
	}

	public static void setGotHint(int gotHint) {
		GamePanel.gotHint = gotHint;
	}
}