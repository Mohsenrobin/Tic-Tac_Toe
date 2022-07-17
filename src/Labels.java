import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Labels extends JLabel {

	// The field that store the value of the label
	private String value;

	// Create Label using parameters
	public JLabel createLabel(JPanel myPanel, String value, int x, int y,
			GridBagConstraints c, int fontSize) {
		this.value = value;
		this.setText(getValue());
		this.setVisible(false);
		this.setFont(new Font("Verdana", Font.BOLD, fontSize));
		this.setPreferredSize(new Dimension(100, 100));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.magenta);

		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		myPanel.add(this, c);

		return new JLabel();
	}

	// Method to create the label of the winner
	public JLabel getWinnerLabel() {
		setForeground(Color.red);
		if (GameLogic.getGameLogic().getWinner() == "X")
			setText(Window.getWindow().getGreetingPanel().getPlayer1()
					+ " is the Winner         ");
		else
			setText(Window.getWindow().getGreetingPanel().getPlayer2()
					+ " is the Winner         ");

		setFont(new Font("Verdana", Font.BOLD, 35));
		setVisible(true);
		return this;
	}

	// Getter
	public String getValue() {
		return value;
	}

	// Setter
	public void setValue(String value) {
		this.value = value;
	}
}
