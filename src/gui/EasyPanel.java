package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


class EasyPanel extends JPanel {

	private static final long serialVersionUID = -989246297598611302L;
	public static final String NAME = "Easy";
	private JPanel mainPanel;
	private JButton level1Button = new JButton("Level 1");
	private JButton level2Button = new JButton("Level 2");
	private JButton level3Button = new JButton("Level 3");
	private JButton returnButton = new JButton("Return");
	private Icon buttonIcon;
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private static final String difficulty = "Easy";

	public EasyPanel(JPanel panel) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;
		
		Font f = (MainPanel.getF()).deriveFont(13f);
		
		add(returnButton);
		returnButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 120, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f);
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));

		add(level1Button);
		level1Button.setBounds(WIDTH / 2 - 100, HEIGHT / 2 - 60, 200, 50);
		level1Button.setIcon(buttonIcon);
		level1Button.setFont(f);
		level1Button.setVerticalTextPosition(SwingConstants.CENTER);
		level1Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level1Button.addActionListener(new Level1ButtonListener());
		level1Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level2Button);
		level2Button.setBounds(WIDTH / 2 - 100, HEIGHT / 2, 200, 50);
		level2Button.setIcon(buttonIcon);
		level2Button.setFont(f);
		level2Button.setVerticalTextPosition(SwingConstants.CENTER);
		level2Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level2Button.addActionListener(new  Level2ButtonListener());
		level2Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(level3Button);
		level3Button.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 60, 200, 50);
		level3Button.setIcon(buttonIcon);
		level3Button.setFont(f);
		level3Button.setVerticalTextPosition(SwingConstants.CENTER);
		level3Button.setHorizontalTextPosition(SwingConstants.CENTER);
		level3Button.addActionListener(new Level3ButtonListener());
		level3Button.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
	}

	class ReturnButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, StartPanel.NAME);
		}
	}

	class Level1ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			((MainPanel) mainPanel).switchGameScreen(1, difficulty, false);
		}
	}

	class Level2ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			((MainPanel) mainPanel).switchGameScreen(2, difficulty, false);
		}
	}

	class Level3ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			((MainPanel) mainPanel).switchGameScreen(3, difficulty, false);
		}
	}
}