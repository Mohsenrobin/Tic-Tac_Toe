import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

//This is the main class which extends a JFrame library to create a window.
public class Window extends JFrame {

	// The only instance of the window
	private static Window window;
	// The main Panel
	private Greeting greetingPanel;

	// Create window
	public void createWindow() {
		window.setPreferredSize(new Dimension(1000, 700));
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setLocation(100, 100);
		window.setVisible(true);
		window.greetingPanel = new Greeting();
		window.add(greetingPanel);
		window.pack();

	}

	// The main method of the project where everything starts
	public static void main(String[] args) {
		window = new Window();
		window.createWindow();
	}

	// GETTERS AND SETTERS

	public static Window getWindow() {
		return window;
	}

	public Greeting getGreetingPanel() {
		return greetingPanel;
	}

}
