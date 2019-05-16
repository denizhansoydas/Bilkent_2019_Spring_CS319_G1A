package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

class HelpPanel extends JPanel {

	private static final long serialVersionUID = 5493219000157109392L;
	public static final String NAME = "Help";
	private JPanel mainPanel;
	private JButton returnButton = new JButton("Return");
	private Icon buttonIcon;
	private JTextPane helpPane = new JTextPane();
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;

	public HelpPanel(JPanel panel) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;

		Image respectImage = null;
		ImageIO.setUseCache(false); // to make it faster to draw small images continuously / using memory instead of disk

		URL url = this.getClass().getResource("res/respect.gif");
		respectImage = new ImageIcon(url).getImage();
		ImageIcon icon = new ImageIcon(respectImage);
		JLabel respectLabel = new JLabel(icon);
		respectLabel.setBounds(WIDTH / 2 + 162, HEIGHT / 2 + 92, 115, 115);
		add(respectLabel);
		
		JLabel infoLabel = null;
		BufferedImage image4 = null;
		try {
			image4 = ImageIO.read(getClass().getResourceAsStream("res/help.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon icon4 = new ImageIcon(image4);
		infoLabel = new JLabel(icon4, JLabel.CENTER);
		infoLabel.setBounds(WIDTH / 2 - 440, HEIGHT / 2 - 230, 880, 460);
		infoLabel.setOpaque(false);
		add(infoLabel);
		
		Font f = (MainPanel.getF()).deriveFont(13f);
		
		add(returnButton);
		add(helpPane);
		returnButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 300, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f);
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());  
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
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
}