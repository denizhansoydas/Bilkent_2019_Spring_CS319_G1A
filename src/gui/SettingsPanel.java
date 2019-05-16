package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;


class SettingsPanel extends JPanel {

	private static final long serialVersionUID = 8590452048207954854L;
	public static final String NAME = "Settings";
	private JPanel mainPanel;
	private JButton musicButton = new JButton("Music turn off/on");
	private JButton returnButton = new JButton("Return");
	private Icon buttonIcon;
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 1000;
	private VolumeSlider volumeSlider;
	private JSlider volume = new JSlider();
	private static Clip clip = null;
	private FloatControl gainControl = null;
	
	public SettingsPanel(JPanel panel) {

		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("res/button.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buttonIcon = new ImageIcon(image);

		changeMusic(false);
		
		mainPanel = panel;

		Font f = (MainPanel.getF()).deriveFont(15f);

		add(returnButton);
		returnButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 200, 200, 50);
		returnButton.setIcon(buttonIcon);
		returnButton.setFont(f);
		returnButton.setVerticalTextPosition(SwingConstants.CENTER);
		returnButton.setHorizontalTextPosition(SwingConstants.CENTER);
		returnButton.addActionListener(new ReturnButtonListener());
		returnButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		add(musicButton);
		musicButton.setBounds(WIDTH / 2 - 300, HEIGHT / 2 - 60, 280, 50);
		musicButton.setIcon(buttonIcon);
		musicButton.setFont(f);
		musicButton.setVerticalTextPosition(SwingConstants.CENTER);
		musicButton.setHorizontalTextPosition(SwingConstants.CENTER);
		musicButton.setBorder(BorderFactory.createBevelBorder(1, new Color(86, 74, 0), new Color(214, 163, 0)));
		
		ActionListener loadAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (clip.isRunning()) {
					clip.stop();
				}
				else {
					try {
						clip.open();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					clip.loop(-1);
					clip.start();
				}
			}
		};

		musicButton.addActionListener(loadAction);
		
		volumeSlider = new VolumeSlider(gainControl);
		volume = volumeSlider.getVolume();
		volume.setBackground(new Color(255, 234, 0));
		volume.setMinorTickSpacing(5);
		volume.setMajorTickSpacing(20);
		volume.setBounds(WIDTH / 2 + 20, HEIGHT / 2 - 60, 280, 50);
		add(volume);
	}

	class VolumeSlider {

		JSlider volume;
		
		VolumeSlider(final FloatControl volumeControl) {
			volume = new JSlider(
					(int) volumeControl.getMinimum() * 100,
					(int) volumeControl.getMaximum() * 100,
					(int) volumeControl.getValue() * 100);
			ChangeListener listener = new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					float val = volume.getValue() / 100f;
					volumeControl.setValue(val);
				}
			};
			volume.addChangeListener(listener);
		}

		public JSlider getVolume() {
			return volume;
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

	public void changeMusic(boolean rogueMusic) {
		if(rogueMusic) {

			clip.stop();
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("res/rogue.wav"));
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
			clip.loop(-1);
			clip.start();

			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float) 0.0);
			
		}
		else {
			if(clip != null)
				clip.stop();
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("res/BGMtest.wav"));
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
			clip.loop(-1);
			clip.start();
			
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float) -15.0);
		}
		
		ChangeListener listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				float val = volume.getValue() / 100f;
				gainControl.setValue(val);
			}
		};
		
		volume.addChangeListener(listener);

		//volume.setPaintTicks(true);
		//volume.setPaintLabels(true);
	}
}