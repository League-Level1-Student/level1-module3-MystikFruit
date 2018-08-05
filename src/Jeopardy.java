import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;

/* This recipe is to be used with the Jeopardy Handout: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	private JPanel header;
	private JPanel quizPanel;
	int score = 0;
	JLabel scoreBox = new JLabel("0");
	int buttonCount = 0;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	private void start() {
		JFrame frame = new JFrame();

		quizPanel = new JPanel();

		frame.setLayout(new BorderLayout());

		frame.setVisible(true);

		frame.setTitle("Howard");

		header = createHeader("Animals");

		quizPanel.add(header);

		frame.add(quizPanel);

		firstButton = createButton("$100");

		quizPanel.add(firstButton);

		secondButton = createButton("$1,000,000");

		quizPanel.add(secondButton);

		firstButton.addActionListener(this);

		secondButton.addActionListener(this);

		frame.pack();

		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));

		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JButton createButton(String dollarAmount) {
		JButton button = new JButton();
		button.setText(dollarAmount);
		buttonCount += 1;
		return button;
	}

	public void actionPerformed(ActionEvent arg0) {
		playJeopardyTheme();
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed.equals(firstButton)) {
			askQuestion("What is the fastest sea creature, in the world?", "sailfish", 100);
		}
		if (buttonPressed.equals(secondButton)) {
			askQuestion1("What is the fastest land animal, for it's size?", "paratarsotomus macropalpis", 1000000);
		}
	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		String sea = JOptionPane.showInputDialog("What is the fastest sea species, in the world?");
		if (sea.equalsIgnoreCase("sailfish")) {
			score = +prizeMoney;
			updateScore();
			JOptionPane.showMessageDialog(null, "You are correct!");
		} else {
			JOptionPane.showMessageDialog(null, "You are wrong! The correct answer was sailfish.");
			score = -prizeMoney;
			updateScore();
		}
	}

	private void askQuestion1(String question1, String correctAnswer1, int prizeMoney1) {
		String land = JOptionPane.showInputDialog("What is the fastest land animal, for it's size?");
		if (land.equalsIgnoreCase("paratarsotomus macropalpis")) {
			score = +prizeMoney1;
			updateScore();
			JOptionPane.showMessageDialog(null, "You are correct!");
		} else {
			JOptionPane.showMessageDialog(null,
					"I knew you'd get that wrong. The correct answer was paratarsotomus macropalpis.");
			score = -prizeMoney1;
			updateScore();
		}
	}

	public void playJeopardyTheme() {
		try {
			AudioClip sound = JApplet.newAudioClip(getClass().getResource("jeopardy.wav"));
			sound.play();
			Thread.sleep(3400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip scream = JApplet.newAudioClip(getClass().getResource(fileName));
		scream.play();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
