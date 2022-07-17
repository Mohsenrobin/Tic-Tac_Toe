import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panels extends JPanel implements KeyListener {

	// Buttons and Labels
	private Buttons[] buttons;
	private Labels[] labels;
	GridBagConstraints c = new GridBagConstraints();

	// Initial Buttons and Labels before creating the instance
	{


	}

	// Constructor, where we initial keyboard functions
	public Panels() {
		addKeyListener(this);
		setFocusable(true);
		setVisible(true);
		setFocusTraversalKeysEnabled(false);
		buttons = new Buttons[10];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Buttons();
		}
		labels = new Labels[14];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Labels();
		}
		setPreferredSize(new Dimension(1000, 700));
		setLayout(new GridBagLayout());
		setBackground(Color.orange);
		setSize(800, 600);
		add(getPanel1(1, 1), c);
		add(getPanel2(1, 0), c);
	}

	// Main Panel which contains panel 1 and panel 2
	public Panels createPanel() {

		setPreferredSize(new Dimension(1000, 700));
		setLayout(new GridBagLayout());
		setBackground(Color.orange);
		setSize(800, 600);
		add(getPanel1(1, 1), c);
		add(getPanel2(1, 0), c);
		return this;

	}

	// First panel which holds the player names
	public JPanel getPanel1(int x, int y) {
		JPanel panelTemp = new JPanel();
		panelTemp.setLayout(new GridBagLayout());
		panelTemp.setBackground(Color.orange);
		labelPanel1(panelTemp);
		c.fill = GridBagConstraints.CENTER;
		c.gridx = x;
		c.gridy = y;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(3, 3, 3, 3);
		return panelTemp;
	}

	// Second panel
	// This panels adds two panels(Labels and Buttons) to the same display area, But
	// labels are invisible by default.
	// After a player push a button, the button will be invisible and the label
	// become visible to show the value to
	// the player
	public JPanel getPanel2(int x, int y) {
		JPanel panelTemp = new JPanel();
		panelTemp.setLayout(new GridBagLayout());
		panelTemp.setBackground(Color.orange);
		labelPanel2(panelTemp);
		buttonPanel(panelTemp);
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		return panelTemp;

	}

	// The Panel that shows the winner
	public JPanel panelWinner(int x, int y) {
		JPanel panelTemp = new JPanel();
		panelTemp.setBackground(Color.orange);
		labels[11].getWinnerLabel();
		panelTemp.add(labels[11]);
		panelTemp.setVisible(true);
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = x;
		c.gridy = y;
		c.insets = new Insets(3, 3, 3, 3);
		return panelTemp;
	}

	// Inner layer of panel 2
	public void buttonPanel(JPanel panel11) {
		buttons[0].createButtons(panel11, "One", 0, 0, c, 1, labels[0]);
		buttons[1].createButtons(panel11, "Two", 1, 0, c, 2, labels[1]);
		buttons[2].createButtons(panel11, "Three", 2, 0, c, 3, labels[2]);
		buttons[3].createButtons(panel11, "Four", 0, 1, c, 4, labels[3]);
		buttons[4].createButtons(panel11, "Five", 1, 1, c, 5, labels[4]);
		buttons[5].createButtons(panel11, "Six", 2, 1, c, 6, labels[5]);
		buttons[6].createButtons(panel11, "Seven", 0, 2, c, 7, labels[6]);
		buttons[7].createButtons(panel11, "Eight", 1, 2, c, 8, labels[7]);
		buttons[8].createButtons(panel11, "Nine", 2, 2, c, 9, labels[8]);
	}

	// Inner layer of panel 1
	public void labelPanel1(JPanel panel) {
		labels[9].createLabel(panel, Window.getWindow().getGreetingPanel().getPlayer1() + " is Player X ", 0,
				0, c, 30);
		labels[9].setPreferredSize(new Dimension(400, 40));
		labels[9].setVisible(true);
		labels[10].createLabel(panel, Window.getWindow().getGreetingPanel().getPlayer2() + " is Player O ",
				0, 1, c, 30);
		labels[10].setPreferredSize(new Dimension(400, 40));

		labels[10].setVisible(true);

	}

	// Inner layer of panel 2
	public void labelPanel2(JPanel panel) {
		labels[0].createLabel(panel, "", 0, 0, c, 95);
		labels[1].createLabel(panel, "", 1, 0, c, 95);
		labels[2].createLabel(panel, "", 2, 0, c, 95);
		labels[3].createLabel(panel, "", 0, 1, c, 95);
		labels[4].createLabel(panel, "", 1, 1, c, 95);
		labels[5].createLabel(panel, "", 2, 1, c, 95);
		labels[6].createLabel(panel, "", 0, 2, c, 95);
		labels[7].createLabel(panel, "", 1, 2, c, 95);
		labels[8].createLabel(panel, "", 2, 2, c, 95);
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_NUMPAD1:
			GameLogic.getGameLogic().play(1, labels[0], buttons[0]);
			break;
		case KeyEvent.VK_NUMPAD2:
			GameLogic.getGameLogic().play(2, labels[1], buttons[1]);
			break;
		case KeyEvent.VK_NUMPAD3:
			GameLogic.getGameLogic().play(3, labels[2], buttons[2]);
			break;
		case KeyEvent.VK_NUMPAD4:
			GameLogic.getGameLogic().play(4, labels[3], buttons[3]);
			break;
		case KeyEvent.VK_NUMPAD5:
			GameLogic.getGameLogic().play(5, labels[4], buttons[4]);
			break;
		case KeyEvent.VK_NUMPAD6:
			GameLogic.getGameLogic().play(6, labels[5], buttons[5]);
			break;
		case KeyEvent.VK_NUMPAD7:
			GameLogic.getGameLogic().play(7, labels[6], buttons[6]);
			break;
		case KeyEvent.VK_NUMPAD8:
			GameLogic.getGameLogic().play(8, labels[7], buttons[7]);
			break;
		case KeyEvent.VK_NUMPAD9:
			GameLogic.getGameLogic().play(9, labels[8], buttons[8]);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}
