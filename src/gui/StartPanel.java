package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class StartPanel extends JPanel {

	private static final long serialVersionUID = 7680968290302459363L;
	public static final String NAME = "Start";
	private JPanel mainPanel;
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private JButton rogueButton = null;
	
	public StartPanel(JPanel panel) {

		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedImage imageRogue = null;
		try {
			imageRogue = ImageIO.read(getClass().getResourceAsStream("res/rogueButton.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Icon rogueIcon = new ImageIcon(imageRogue);
		Icon buttonIcon = new ImageIcon(image);
		
		JButton returnButton = new JButton("Return");
		JButton easyButton = new JButton("Easy Difficulty");
		JButton normalButton = new JButton("Medium Difficulty");
		JButton hardButton = new JButton("Hard Difficulty");
		JButton expertButton = new JButton("Expert Difficulty");
		rogueButton = new JButton("Rogue Mode");

		Font f = (MainPanel.getF()).deriveFont(15f);

		mainPanel = panel;
		add(returnButton);
		add(easyButton);
		add(normalButton);
		add(hardButton);
		add(expertButton);
		add(rogueButton);

		easyButton.setBounds(WIDTH / 2 - 150, HEIGHT / 2 - 60, 300, 50);
		easyButton.setFont(f);
		easyButton.setIcon(buttonIcon);
		easyButton.setVerticalTextPosition(SwingConstants.CENTER);
		easyButton.setHorizontalTextPosition(SwingConstants.CENTER);
		easyButton.addActionListener(new EasyButtonListener());
		easyButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		normalButton.setBounds(WIDTH / 2 - 150, HEIGHT / 2, 300, 50);
		normalButton.setIcon(buttonIcon);
		normalButton.setFont(f);
		normalButton.setVerticalTextPosition(SwingConstants.CENTER);
		normalButton.setHorizontalTextPosition(SwingConstants.CENTER);
		normalButton.addActionListener(new NormalButtonListener());
		normalButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));

		hardButton.setBounds(WIDTH / 2 - 150, HEIGHT / 2 + 60, 300, 50);
		hardButton.setIcon(buttonIcon);
		hardButton.setFont(f);
		hardButton.setVerticalTextPosition(SwingConstants.CENTER);
		hardButton.setHorizontalTextPosition(SwingConstants.CENTER);
		hardButton.addActionListener(new HardButtonListener());
		hardButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));

		expertButton.setBounds(WIDTH / 2 - 150, HEIGHT / 2 + 120, 300, 50);
		expertButton.setIcon(buttonIcon);
		expertButton.setFont(f);
		expertButton.setVerticalTextPosition(SwingConstants.CENTER);
		expertButton.setHorizontalTextPosition(SwingConstants.CENTER);
		expertButton.addActionListener(new ExpertButtonListener());
		expertButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));

		rogueButton.setVisible(false);
		rogueButton.setBounds(WIDTH / 2 - 150, HEIGHT / 2 - 200, 300, 50);
		rogueButton.setIcon(rogueIcon);
		rogueButton.setForeground(Color.WHITE);
		rogueButton.setFont(f);
		rogueButton.setVerticalTextPosition(SwingConstants.CENTER);
		rogueButton.setHorizontalTextPosition(SwingConstants.CENTER);
		rogueButton.addActionListener(new RogueButtonListener());
		rogueButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));


		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved (MouseEvent me) {
				if (rogueButton.getBounds().contains(me.getPoint())) {
					rogueButton.setVisible(true);  
					return; 
				}
				rogueButton.setVisible(false);
			}
		});

		returnButton.setBounds(WIDTH / 2 - 150, HEIGHT / 2 + 180, 300, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f);
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
	}

	class RogueButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			rogueButton.setVisible(false);
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			((MainPanel) mainPanel).changeMusic(true);
			cLayout.show(mainPanel, RoguePanel.NAME);
		}
	}

	class ExpertButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, ExpertPanel.NAME);
		}
	}

	class ReturnButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, OptionsPanel.NAME);
		}
	}

	class EasyButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, EasyPanel.NAME);
		}
	}
	class NormalButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, NormalPanel.NAME);
		}
	}
	
	class HardButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cLayout = (CardLayout) mainPanel.getLayout();
			cLayout.show(mainPanel, HardPanel.NAME);
		}
	}
}