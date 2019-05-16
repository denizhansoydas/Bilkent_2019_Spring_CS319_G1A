package gui;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameVictoryPanel extends JPanel {


	private static final long serialVersionUID = 3388624532422831108L;
	public static final String NAME = "GameVictoryPanel";
	private JPanel mainPanel;
	//private JLabel stars;
	private JButton returnButton, nextButton;
	private Icon buttonIcon;
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private int currentLevel;
	private String currentDifficulty;
	private boolean rogueGame;
	private JLabel starLabel, timeLabel, rogueLabel;

	GameVictoryPanel (JPanel panel) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/victory_button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;
		returnButton = new JButton("Return");
		nextButton = new JButton("Next Level");

		
		Font f = null;
		InputStream is = getClass().getResourceAsStream("res/goodtimes.ttf");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			f = Font.createFont(Font.TRUETYPE_FONT, is);
			ge.registerFont(f);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		add(returnButton);
		returnButton.setBounds(WIDTH / 2 - 250, HEIGHT / 2 + 200, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f.deriveFont(14f));
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black));
		
		add(nextButton);
		nextButton.setBounds(WIDTH / 2 + 50, HEIGHT / 2 + 200, 200, 50);
		nextButton.setIcon(buttonIcon);
		nextButton.setFont(f.deriveFont(14f));
		nextButton.setVerticalTextPosition(SwingConstants.CENTER);
		nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
		nextButton.addActionListener(new NextButtonListener());
		nextButton.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black));
		
		BufferedImage imageLevel = null;

		try {
			imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_5_of_5.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		starLabel = new JLabel();
		ImageIcon iconLevel = new ImageIcon(imageLevel);
		starLabel.setIcon(iconLevel);
		starLabel.setBounds(WIDTH / 2 - 200, HEIGHT - 220 , 400, 100);
		starLabel.setVisible(true);
		add(starLabel);
		
		timeLabel = new JLabel();
		timeLabel.setBounds(WIDTH / 2 - 250, HEIGHT - 100 , 500, 50);
		timeLabel.setVisible(true);
		add(timeLabel);
		
		BufferedImage rogueLevel = null;
		
		try {
			rogueLevel = ImageIO.read(getClass().getResourceAsStream("res/rogue_victory.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rogueLabel = new JLabel();
		ImageIcon rogueIcon = new ImageIcon(rogueLevel);
		rogueLabel.setIcon(rogueIcon);
		rogueLabel.setBounds(WIDTH / 2 - 540, HEIGHT / 2 - 375, 1076, 548);
		rogueLabel.setVisible(false);
		add(rogueLabel);
		
		
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getCurrentDifficulty() {
		return currentDifficulty;
	}

	public void setCurrentDifficulty(String currentDifficulty) {
		this.currentDifficulty = currentDifficulty;
	}

	class ReturnButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			rogueLabel.setVisible(false);
			if(!rogueGame) {
				((MainPanel) mainPanel).changeMusic(false);
				CardLayout cLayout = (CardLayout) mainPanel.getLayout();
				cLayout.show(mainPanel, OptionsPanel.NAME);
			}
			else {
				CardLayout cLayout = (CardLayout) mainPanel.getLayout();
				cLayout.show(mainPanel, RoguePanel.NAME);
				removeAll();
			}
		}
	}

	class NextButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			rogueLabel.setVisible(false);
			((MainPanel) mainPanel).switchGameScreen(currentLevel, currentDifficulty, rogueGame);
		}
	}

	public void setFinishedTime(int timeCounter, int gotHint) {

		BufferedImage imageLevel = null;
		
		int timeAddition = 0;
		if(currentDifficulty == "Easy")  {
			timeAddition = 15 - gotHint * 20;
		}
		else if(currentDifficulty == "Normal")  {
			timeAddition = 25 - gotHint * 15;
		}
		else if(currentDifficulty == "Hard")  {
			timeAddition = 35 - gotHint * 20;
		}
		else if(currentDifficulty == "Expert")  {
			timeAddition = 30 - gotHint * 20;
		}

		if(timeCounter < 15 + (currentLevel * timeAddition)) {
			try {
				imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_5_of_5.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(timeCounter < 25 + (currentLevel * timeAddition)) {
			try {
				imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_4_of_5.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(timeCounter < 35 + (currentLevel * timeAddition)) {
			try {
				imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_3_of_5.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(timeCounter < 45 + (currentLevel * timeAddition)) {
			try {
				imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_2_of_5.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(timeCounter < 55 + (currentLevel * timeAddition)) {
			try {
				imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_1_of_5.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				imageLevel = ImageIO.read(getClass().getResourceAsStream("res/Star_rating_0_of_5.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(rogueGame) {
			rogueLabel.setVisible(true);
		}
		
		timeLabel.setText(" Finished Time : " + timeCounter);
		timeLabel.setForeground(new Color(0, 0, 0));
		timeLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setVerticalTextPosition(JLabel.CENTER);
		timeLabel.setHorizontalTextPosition(JLabel.CENTER);
		//label1.setText("Current Score = 5446");
		timeLabel.setVisible(true);
		
		ImageIcon iconLevel = new ImageIcon(imageLevel);
		starLabel.setIcon(iconLevel);
		repaint();
		revalidate();
		
	}

	public void setGameStatus(boolean rogueGame) {
		this.rogueGame = rogueGame;
	}
}
