import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Objects;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Labels extends JLabel {

	// The field that store the value of the label
	private String value;

	// Create Label using parameters
	public void createLabel(JPanel myPanel, String value, int x, int y,
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

		new JLabel();
	}

	// Method to create the label of the winner
	public void getWinnerLabel() {
		setForeground(Color.red);
		if (Objects.equals(GameLogic.getGameLogic().getWinner(), "X"))
			setText(Window.getWindow().getGreetingPanel().getPlayer1()
					+ " is the Winner         ");
		else
			setText(Window.getWindow().getGreetingPanel().getPlayer2()
					+ " is the Winner         ");

		setFont(new Font("Verdana", Font.BOLD, 35));
		setVisible(true);
	}

	// Getter
	public String getValue() {
		return value;
	}

}
