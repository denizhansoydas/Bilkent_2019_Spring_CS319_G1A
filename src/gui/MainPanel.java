package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainPanel extends JPanel {

	private static final long serialVersionUID = 2178032482860006284L;
	private GamePanel gamePanel;
	private GameEndPanel gameEndPanel = new GameEndPanel(this);
	private GameVictoryPanel gameVictoryPanel = new GameVictoryPanel(this);
	private static final int WIDTH = 1800;
	private static final int HEIGHT = 1000;
	private static JFrame frame;
	private static Font f;
	private SettingsPanel settingsPanel = null;
	public JFrame getFrame() {
		return frame;
	}

	public MainPanel() {

		InputStream is = getClass().getResourceAsStream("res/goodtimes.ttf");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			setF(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(18f));
			ge.registerFont(f);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		OptionsPanel optionsPanel = new OptionsPanel(this);
		AboutPanel aboutPanel = new AboutPanel(this);
		HelpPanel helpPanel = new HelpPanel(this);
		StartPanel startPanel = new StartPanel(this);
		EasyPanel easyPanel = new EasyPanel(this);
		NormalPanel normalPanel = new NormalPanel(this);
		HardPanel hardPanel = new HardPanel(this);
		settingsPanel = new SettingsPanel(this);
		ExpertPanel expertPanel = new ExpertPanel(this);
		RoguePanel roguePanel = new RoguePanel(this);
		
		JLabel label1 = new JLabel(),
				label2 = new JLabel(),
				label3 = new JLabel(),
				label4 = new JLabel(),
				label5 = new JLabel(),
				label6 = new JLabel(),
				label7 = new JLabel(),
				label8 = new JLabel(),
				label9 = new JLabel(),
				label10 = new JLabel(),
				label11 = new JLabel(),
				label12 = new JLabel();
		
		setLayout(new CardLayout());
		
		BufferedImage image = null, image2 = null, image3 = null, secretImage = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));

		try {
			image2 = ImageIO.read(getClass().getResourceAsStream("res/game_over.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon imageIconEnd = new ImageIcon(new ImageIcon(image2).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));

		try {
			image3 = ImageIO.read(getClass().getResourceAsStream("res/game_victory.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon imageIconVictory = new ImageIcon(new ImageIcon(image3).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));

		try {
			secretImage = ImageIO.read(getClass().getResourceAsStream("res/secret.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon imageIconRogue = new ImageIcon(new ImageIcon(secretImage).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));
		
		label1.setIcon(imageIcon);
		label2.setIcon(imageIcon);
		label3.setIcon(imageIcon);
		label4.setIcon(imageIcon);
		label5.setIcon(imageIcon);
		label6.setIcon(imageIcon);
		label7.setIcon(imageIcon);
		label8.setIcon(imageIcon);
		label9.setIcon(imageIconEnd);
		label10.setIcon(imageIconVictory);
		label11.setIcon(imageIcon);
		label12.setIcon(imageIconRogue);
		
		//optionsPanel = new OptionsPanel(this);
		optionsPanel.setBackground(Color.black);
		optionsPanel.setLayout(new BorderLayout(0, 0));
		this.add(optionsPanel, OptionsPanel.NAME);
		optionsPanel.add(label1);

		//aboutPanel = new AboutPanel(this);
		aboutPanel.setBackground(Color.black);
		aboutPanel.setLayout(new BorderLayout(0, 0));
		this.add(aboutPanel, AboutPanel.NAME);
		aboutPanel.add(label2);

		//helpPanel = new HelpPanel(this);
		helpPanel.setBackground(Color.black);
		helpPanel.setLayout(new BorderLayout(0, 0));
		this.add(helpPanel, HelpPanel.NAME);
		helpPanel.add(label3);

		//startPanel = new StartPanel(this);
		startPanel.setBackground(Color.black);
		startPanel.setLayout(new BorderLayout(0, 0));
		this.add(startPanel, StartPanel.NAME);
		startPanel.add(label4);

		//easyPanel = new EasyPanel(this);
		easyPanel.setBackground(Color.black);
		easyPanel.setLayout(new BorderLayout(0, 0));
		this.add(easyPanel, EasyPanel.NAME);
		easyPanel.add(label5);

		//normalPanel = new NormalPanel(this);
		normalPanel.setBackground(Color.black);
		normalPanel.setLayout(new BorderLayout(0, 0));
		this.add(normalPanel, NormalPanel.NAME);
		normalPanel.add(label6);

		//hardPanel = new HardPanel(this);
		hardPanel.setBackground(Color.black);
		hardPanel.setLayout(new BorderLayout(0, 0));
		this.add(hardPanel, HardPanel.NAME);
		hardPanel.add(label7);

		//settingsPanel = new SettingsPanel(this);
		settingsPanel.setBackground(Color.black);
		settingsPanel.setLayout(new BorderLayout(0, 0));
		this.add(settingsPanel, SettingsPanel.NAME);
		settingsPanel.add(label8);

		//gameEndPanel = new GameEndPanel(this);
		gameEndPanel.setBackground(Color.black);
		gameEndPanel.setLayout(new BorderLayout(0, 0));
		this.add(gameEndPanel, GameEndPanel.NAME);
		gameEndPanel.add(label9);

		//gameVictoryPanel = new GameVictoryPanel(this);
		gameVictoryPanel.setBackground(Color.black);
		gameVictoryPanel.setLayout(new BorderLayout(0, 0));
		this.add(gameVictoryPanel, GameVictoryPanel.NAME);
		gameVictoryPanel.add(label10);
		

		expertPanel.setBackground(Color.black);
		expertPanel.setLayout(new BorderLayout(0, 0));
		this.add(expertPanel, ExpertPanel.NAME);
		expertPanel.add(label11);
		
		roguePanel.setBackground(Color.black);
		roguePanel.setLayout(new BorderLayout(0, 0));
		this.add(roguePanel, RoguePanel.NAME);
		roguePanel.add(label12);
	}

	public static void createTitleScreen() {
		
		MainPanel mainPanel = new MainPanel();

		frame = new JFrame("Roadblock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.black);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}

	public void switchGameScreen(int level, String difficulty, boolean rogueGame) {
		CardLayout cLayout = (CardLayout) this.getLayout();
		gamePanel = new GamePanel(this, level, difficulty, rogueGame);
		gamePanel.setLayout(new BorderLayout(0, 0));
		gamePanel.setLevel(level, difficulty, rogueGame);
		this.add(gamePanel, GamePanel.NAME);
		cLayout.show(this, GamePanel.NAME);
	}

	public void setCurrentMap(int currentLevel, String currentDifficulty, boolean rogueGame) {
		gameEndPanel.setGameStatus(rogueGame);
		gameEndPanel.setCurrentDifficulty(currentDifficulty);
		gameEndPanel.setCurrentLevel(currentLevel);
	}

	public void setNextMap(int currentLevel, String currentDifficulty, int timeCounter, boolean rogueGame, int gotHint) {
		if(currentLevel == 3) {
			if(currentDifficulty == "Easy") {
				currentDifficulty = "Normal";
				currentLevel = 1;
			}
			else if(currentDifficulty == "Normal") {
				currentDifficulty = "Hard";
				currentLevel = 1;
			}
			else if(currentDifficulty == "Hard") {
				currentDifficulty = "Expert";
				currentLevel = 1;
			}
			else if(currentDifficulty == "Expert") {
				currentLevel = 3;
			}
		}
		else {
			currentLevel++;
		}
		gameVictoryPanel.setGameStatus(rogueGame);
		gameVictoryPanel.setCurrentDifficulty(currentDifficulty);
		gameVictoryPanel.setCurrentLevel(currentLevel);
		gameVictoryPanel.setFinishedTime(timeCounter, gotHint);
	}

	public static Font getF() {
		return f;
	}

	public static void setF(Font f) {
		MainPanel.f = f;
	}

	public void changeMusic(boolean rogueMusic) {
		((SettingsPanel) settingsPanel).changeMusic(rogueMusic);
	}
}
