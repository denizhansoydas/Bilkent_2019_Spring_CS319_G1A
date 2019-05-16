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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


class AboutPanel extends JPanel {

	private static final long serialVersionUID = 5026218410295269812L;
	private JPanel mainPanel;
	public static final String NAME = "About Us";
	private JButton returnButton = new JButton("Return");
	private Icon buttonIcon;
	private JTextPane aboutPane = new JTextPane();
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;

	public AboutPanel(JPanel panel) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonIcon = new ImageIcon(image);
		mainPanel = panel;
		add(returnButton);
		add(aboutPane);

		Font f = (MainPanel.getF()).deriveFont(13f);
		
		aboutPane.setVisible(true);
		aboutPane.setBounds(200, 300, 1000, 280);
		aboutPane.setText("\n"
				+ "	Selim Can Gülsever 21601033\n"
				+ "	Cavid Gayibli 21500636\n"
				+ "	Denizhan Soydas 21502231\n"
				+ "	Deniz Ufuk Düzgün 21402164\n"
				+ "	Kaan Atakan Öztürk 21302164\n"
				+ "	Serkan Delil 21501289");
		aboutPane.setVisible(true);
		aboutPane.setBounds(300, 300, 1200, 280);
		aboutPane.setFont(new Font("Calibri", Font.BOLD, 25));
		aboutPane.setBackground(Color.BLACK);
		aboutPane.setForeground(Color.ORANGE);
		aboutPane.setEditable(false);
		aboutPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		StyledDocument doc = aboutPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		
		returnButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 180, 200, 50);
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