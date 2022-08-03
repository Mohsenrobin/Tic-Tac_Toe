import javax.swing.*;
import java.awt.*;

public class Greeting extends JPanel {

	private String player1;
	private String player2;
	private JTextField text1;
	private JTextField text2;

	public Panels getPanel() {
		return panel;
	}

	private Panels panel;

	/**
	 * This method create a button and also store the value of tex1 and text2 inside
	 * player 1 and player 2
	 */
	public JButton getGreetingButton(int x, int y, GridBagConstraints c) {
		JButton button = new JButton("Start");
		button.setVisible(true);
		button.setPreferredSize(new Dimension(220, 50));
		button.setFont(new Font("Verdana", Font.BOLD, 20));
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		button.addActionListener(e -> {
			Greeting.this.setVisible(false);
			player2 = text2.getText();
			player1 = text1.getText();
			panel = new Panels();
			Window.getWindow().add(panel);
		});
		return button;
	}

	// create text1
	public JTextField getText1(int x, int y, GridBagConstraints c) {
		text1 = new JTextField();
		text1.setPreferredSize(new Dimension(200, 50));
		text1.setVisible(true);
		text1.setFont(new Font("Verdana", Font.BOLD, 30));
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		return text1;
	}

	// create text2
	public JTextField getText2(int x, int y, GridBagConstraints c) {
		text2 = new JTextField();
		text2.setPreferredSize(new Dimension(200, 50));
		text2.setVisible(true);
		text2.setFont(new Font("Verdana", Font.BOLD, 30));
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		return text2;
	}

	// Create a welcome label
	public JLabel getGreetingLabels(String name, int x, int y, GridBagConstraints c,
			int width, int height, int fontsizze, Color color) {
		JLabel label = new JLabel(name);
		label.setBackground(Color.black);
		label.setPreferredSize(new Dimension(width, height));
		label.setFont(new Font("Verdana", Font.BOLD, fontsizze));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(color);
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		return label;
	}

	// Greeting panel which take player names
	public Greeting() {
		setPreferredSize(new Dimension(1000, 700));
		setLayout(new GridBagLayout());
		setBackground(Color.CYAN);
		GridBagConstraints c = new GridBagConstraints();
		add(getGreetingLabels("Welcome to the ( X O ) Game", 0, 0, c, 900, 50, 50,
				Color.yellow), c);
		add(getGreetingLabels("", 0, 1, c, 100, 20, 30, Color.yellow), c);
		add(getGreetingLabels("Player 1 :", 0, 2, c, 300, 50, 30, Color.blue), c);
		add(getGreetingLabels("Player 2 :", 0, 4, c, 300, 50, 30, Color.blue), c);
		add(getText1(0, 3, c), c);
		add(getText2(0, 5, c), c);
		add(getGreetingLabels("", 0, 6, c, 100, 20, 30, Color.blue), c);
		add(getGreetingButton(0, 7, c), c);

	}

	// GETTERS AND SETTERS

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}

}