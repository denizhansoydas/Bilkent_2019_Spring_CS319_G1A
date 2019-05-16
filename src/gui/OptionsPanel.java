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


class OptionsPanel extends JPanel
{

	private static final long serialVersionUID = 4124027828217836161L;
	public static final String NAME = "Options Panel";
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private JPanel mainPanel;
	private Icon buttonIcon;

	public OptionsPanel(JPanel panel)
	{
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton aboutButton = new JButton("About Us");
		JButton helpButton = new JButton("Help");
		JButton startButton = new JButton("Play Game");
		JButton exitButton = new JButton("Exit Game");
		JButton settingsButton = new JButton("Settings");
		
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;
		aboutButton.addActionListener(new AboutButtonListener());
		helpButton.addActionListener(new HelpButtonListener());
		startButton.addActionListener(new StartButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		settingsButton.addActionListener(new SettingsButtonListener());

		startButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 - 60, 200, 50);
		helpButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2, 200, 50);
		aboutButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 60, 200, 50);
		exitButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 180, 200, 50);
		settingsButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 120, 200, 50);

		Font f = (MainPanel.getF()).deriveFont(13f);
		
		startButton.setIcon(buttonIcon);
		startButton.setFont(f);
		startButton.setVerticalTextPosition(SwingConstants.CENTER);
		startButton.setHorizontalTextPosition(SwingConstants.CENTER);
		startButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));

		helpButton.setIcon(buttonIcon);
		helpButton.setFont(f);
		helpButton.setVerticalTextPosition(SwingConstants.CENTER);
		helpButton.setHorizontalTextPosition(SwingConstants.CENTER);
		helpButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		aboutButton.setIcon(buttonIcon);
		aboutButton.setFont(f);
		aboutButton.setVerticalTextPosition(SwingConstants.CENTER);
		aboutButton.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		exitButton.setIcon(buttonIcon);
		exitButton.setFont(f);
		exitButton.setVerticalTextPosition(SwingConstants.CENTER);
		exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
		exitButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		settingsButton.setIcon(buttonIcon);
		settingsButton.setFont(f);
		settingsButton.setVerticalTextPosition(SwingConstants.CENTER);
		settingsButton.setHorizontalTextPosition(SwingConstants.CENTER);
		settingsButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		this.add(startButton);
		this.add(aboutButton);
		this.add(helpButton);
		this.add(exitButton);
		this.add(settingsButton);
	}

	class HelpButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, HelpPanel.NAME);
		}
	}

	class ExitButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}

	class StartButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, StartPanel.NAME);
		}
	}

	class AboutButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, AboutPanel.NAME);
		}
	}
	class SettingsButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, SettingsPanel.NAME);
		}
	}

}