import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends JButton {

	// The field that store the button's number
	private int number;

	// The Function that takes details as parameter then create a button
	public void createButtons(JPanel myPanel, String name, int x, int y,
							  GridBagConstraints c, int number, Labels label) {
		this.setText(name);
		this.setNumber(number);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(100, 100));
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);

		// This method will run every time that any of players push a button
		this.addActionListener(e -> GameLogic.getGameLogic().play(number, label, Buttons.this));
		myPanel.add(this, c);
	}

	// Getter
	public int getNumber() {
		return number;
	}

	// Setter
	public void setNumber(int number) {
		this.number = number;
	}
}
