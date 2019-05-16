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


class RoguePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1730663188969518395L;
	public static final String NAME = "Rogue";
	private JPanel mainPanel;
	private Icon buttonIcon;
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private static String difficulty = "Rogue";
	private static Font f;
	
	public RoguePanel (JPanel panel) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/rogueButton.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;
		
		InputStream is = getClass().getResourceAsStream("res/spiderman.TTF");
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
		
		JButton level1Button = new JButton("Rogue 1");
		JButton level2Button = new JButton("Rogue 2");
		JButton level3Button = new JButton("Rogue 3");
		JButton level4Button = new JButton("Rogue 4");
		JButton level5Button = new JButton("Rogue 5");
		JButton level6Button = new JButton("Rogue 6");
		JButton level7Button = new JButton("Rogue 7");
		JButton level8Button = new JButton("Rogue 8");
		JButton level9Button = new JButton("Rogue 9");
		JButton level10Button = new JButton("Rogue 10");
		JButton level11Button = new JButton("Rogue 11");
		JButton level12Button = new JButton("Rogue 12");
		JButton returnButton = new JButton("Return");
		
		add(returnButton);
		returnButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 240, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f.deriveFont(18f));
		returnButton.setForeground(Color.WHITE);
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level1Button);
		level1Button.setBounds(WIDTH / 2 - 700, HEIGHT / 2 - 150, 200, 50);
		level1Button.setIcon(buttonIcon);
		level1Button.setFont(f.deriveFont(18f));
		level1Button.setForeground(Color.WHITE);
		level1Button.setVerticalTextPosition(SwingConstants.CENTER);
		level1Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level1Button.addActionListener(new Level1ButtonListener());
		level1Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level2Button);
		level2Button.setBounds(WIDTH / 2 - 700, HEIGHT / 2 - 50, 200, 50);
		level2Button.setIcon(buttonIcon);
		level2Button.setFont(f.deriveFont(18f));
		level2Button.setForeground(Color.WHITE);
		level2Button.setVerticalTextPosition(SwingConstants.CENTER);
		level2Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level2Button.addActionListener(new  Level2ButtonListener());
		level2Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level3Button);
		level3Button.setBounds(WIDTH / 2 - 700, HEIGHT / 2 + 50, 200, 50);
		level3Button.setIcon(buttonIcon);
		level3Button.setFont(f.deriveFont(18f));
		level3Button.setForeground(Color.WHITE);
		level3Button.setVerticalTextPosition(SwingConstants.CENTER);
		level3Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level3Button.addActionListener(new Level3ButtonListener());
		level3Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level4Button);
		level4Button.setBounds(WIDTH / 2 - 400, HEIGHT / 2 - 150, 200, 50);
		level4Button.setIcon(buttonIcon);
		level4Button.setFont(f.deriveFont(18f));
		level4Button.setForeground(Color.WHITE);
		level4Button.setVerticalTextPosition(SwingConstants.CENTER);
		level4Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level4Button.addActionListener(new Level4ButtonListener());
		level4Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level5Button);
		level5Button.setBounds(WIDTH / 2 - 400, HEIGHT / 2 - 50, 200, 50);
		level5Button.setIcon(buttonIcon);
		level5Button.setFont(f.deriveFont(18f));
		level5Button.setForeground(Color.WHITE);
		level5Button.setVerticalTextPosition(SwingConstants.CENTER);
		level5Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level5Button.addActionListener(new Level5ButtonListener());
		level5Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level6Button);
		level6Button.setBounds(WIDTH / 2 - 400, HEIGHT / 2 + 50, 200, 50);
		level6Button.setIcon(buttonIcon);
		level6Button.setFont(f.deriveFont(18f));
		level6Button.setForeground(Color.WHITE);
		level6Button.setVerticalTextPosition(SwingConstants.CENTER);
		level6Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level6Button.addActionListener(new Level6ButtonListener());
		level6Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level7Button);
		level7Button.setBounds(WIDTH / 2 + 200, HEIGHT / 2 - 150, 200, 50);
		level7Button.setIcon(buttonIcon);
		level7Button.setFont(f.deriveFont(18f));
		level7Button.setForeground(Color.WHITE);
		level7Button.setVerticalTextPosition(SwingConstants.CENTER);
		level7Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level7Button.addActionListener(new Level7ButtonListener());
		level7Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level8Button);
		level8Button.setBounds(WIDTH / 2 + 200, HEIGHT / 2 - 50, 200, 50);
		level8Button.setIcon(buttonIcon);
		level8Button.setFont(f.deriveFont(18f));
		level8Button.setForeground(Color.WHITE);
		level8Button.setVerticalTextPosition(SwingConstants.CENTER);
		level8Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level8Button.addActionListener(new Level8ButtonListener());
		level8Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level9Button);
		level9Button.setBounds(WIDTH / 2 + 200, HEIGHT / 2 + 50, 200, 50);
		level9Button.setIcon(buttonIcon);
		level9Button.setFont(f.deriveFont(18f));
		level9Button.setForeground(Color.WHITE);
		level9Button.setVerticalTextPosition(SwingConstants.CENTER);
		level9Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level9Button.addActionListener(new Level9ButtonListener());
		level9Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level10Button);
		level10Button.setBounds(WIDTH / 2 + 500, HEIGHT / 2 - 150, 200, 50);
		level10Button.setIcon(buttonIcon);
		level10Button.setFont(f.deriveFont(18f));
		level10Button.setForeground(Color.WHITE);
		level10Button.setVerticalTextPosition(SwingConstants.CENTER);
		level10Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level10Button.addActionListener(new Level10ButtonListener());
		level10Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level11Button);
		level11Button.setBounds(WIDTH / 2 + 500, HEIGHT / 2 - 50, 200, 50);
		level11Button.setIcon(buttonIcon);
		level11Button.setFont(f.deriveFont(18f));
		level11Button.setForeground(Color.WHITE);
		level11Button.setVerticalTextPosition(SwingConstants.CENTER);
		level11Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level11Button.addActionListener(new Level11ButtonListener());
		level11Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level12Button);
		level12Button.setBounds(WIDTH / 2 + 500, HEIGHT / 2 + 50, 200, 50);
		level12Button.setIcon(buttonIcon);
		level12Button.setFont(f.deriveFont(18f));
		level12Button.setForeground(Color.WHITE);
		level12Button.setVerticalTextPosition(SwingConstants.CENTER);
		level12Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level12Button.addActionListener(new Level12ButtonListener());
		level12Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		BufferedImage recruit = null;
		try {
			recruit = ImageIO.read(getClass().getResourceAsStream("res/Recruit_difficulty_BO.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel recruitLabel = new JLabel();
		ImageIcon recruitLevel = new ImageIcon(recruit);
		recruitLabel.setIcon(recruitLevel);
		recruitLabel.setBounds(WIDTH / 2 - 650, HEIGHT / 2 - 300 , 100, 120);
		recruitLabel.setVisible(true);
		add(recruitLabel);
		
		BufferedImage regular = null;
		try {
			regular = ImageIO.read(getClass().getResourceAsStream("res/Regular_difficulty_BO.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel regularLabel = new JLabel();
		ImageIcon regularLevel = new ImageIcon(regular);
		regularLabel.setIcon(regularLevel);
		regularLabel.setBounds(WIDTH / 2 - 350, HEIGHT / 2 - 300 , 100, 120);
		regularLabel.setVisible(true);
		add(regularLabel);
		
		BufferedImage hardened = null;
		try {
			hardened = ImageIO.read(getClass().getResourceAsStream("res/Hardened_difficulty_BO.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel hardenedLabel = new JLabel();
		ImageIcon hardenedLevel = new ImageIcon(hardened);
		hardenedLabel.setIcon(hardenedLevel);
		hardenedLabel.setBounds(WIDTH / 2 + 240, HEIGHT / 2 - 300 , 120, 120);
		hardenedLabel.setVisible(true);
		add(hardenedLabel);
		
		BufferedImage veteran = null;
		try {
			veteran = ImageIO.read(getClass().getResourceAsStream("res/Veteran_difficulty_BO.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel veteranLabel = new JLabel();
		ImageIcon veteranLevel = new ImageIcon(veteran);
		veteranLabel.setIcon(veteranLevel);
		veteranLabel.setBounds(WIDTH / 2 + 550, HEIGHT / 2 - 300 , 100, 120);
		veteranLabel.setVisible(true);
		add(veteranLabel);
		
	}

	class ReturnButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			((MainPanel) mainPanel).changeMusic(false);
			cLayout.show(mainPanel, StartPanel.NAME);
		}
	}

	class Level1ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Easy";
			((MainPanel) mainPanel).switchGameScreen(1, difficulty, true);
		}
	}
	
	class Level2ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Easy";
			((MainPanel) mainPanel).switchGameScreen(2, difficulty, true);
		}
	}
	
	class Level3ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Easy";
			((MainPanel) mainPanel).switchGameScreen(3, difficulty, true);
		}
	}
	
	class Level4ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Normal";
			((MainPanel) mainPanel).switchGameScreen(1, difficulty, true);
		}
	}
	
	class Level5ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Normal";
			((MainPanel) mainPanel).switchGameScreen(2, difficulty, true);
		}
	}
	
	class Level6ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Normal";
			((MainPanel) mainPanel).switchGameScreen(3, difficulty, true);
		}
	}
	
	class Level7ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Hard";
			((MainPanel) mainPanel).switchGameScreen(1, difficulty, true);
		}
	}
	
	class Level8ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Hard";
			((MainPanel) mainPanel).switchGameScreen(2, difficulty, true);
		}
	}
	
	class Level9ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Hard";
			((MainPanel) mainPanel).switchGameScreen(3, difficulty, true);
		}
	}
	
	class Level10ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Expert";
			((MainPanel) mainPanel).switchGameScreen(1, difficulty, true);
		}
	}
	
	class Level11ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Expert";
			((MainPanel) mainPanel).switchGameScreen(2, difficulty, true);
		}
	}
	
	class Level12ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			difficulty = "Expert";
			((MainPanel) mainPanel).switchGameScreen(3, difficulty, true);
		}
	}
}
