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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameEndPanel extends JPanel {

	private static final long serialVersionUID = 6742706854461463457L;
	public static final String NAME = "GameEndPanel";
	private JPanel mainPanel;
	private JButton returnButton, againButton;
	private Icon buttonIcon;
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private int currentLevel;
	private String currentDifficulty;
	private boolean rogueGame;
	
	GameEndPanel(JPanel panel) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/end_button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;
		returnButton = new JButton("Return");
		againButton = new JButton("Try Again");

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
		returnButton.setBounds(WIDTH / 2 - 250, HEIGHT / 2, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f.deriveFont(14f));
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(32,32,32) , new Color(32,32,32)));
		
		add(againButton);
		againButton.setBounds(WIDTH / 2 + 50, HEIGHT / 2, 200, 50);
		againButton.setIcon(buttonIcon);
		againButton.setFont(f.deriveFont(14f));
		againButton.setVerticalTextPosition(SwingConstants.CENTER);
		againButton.setHorizontalTextPosition(SwingConstants.CENTER);
		againButton.addActionListener(new AgainButtonListener());
		againButton.setBorder(BorderFactory.createBevelBorder(1, new Color(32,32,32) , new Color(32,32,32)));
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

	class AgainButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			((MainPanel) mainPanel).switchGameScreen(currentLevel, currentDifficulty, rogueGame);
		}
	}

	public void setGameStatus(boolean rogueGame2) {
		rogueGame = rogueGame2;
	}
}
