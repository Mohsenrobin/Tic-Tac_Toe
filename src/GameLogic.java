import javax.swing.JButton;
import javax.swing.JLabel;

public class GameLogic {

	// Counting the turns
	private int counter;
	// This String array store the value of each button
	private String[] matrix;
	// Store the value of the winner
	private String winner;
	// The only instance of the game logic
	private static GameLogic gameLogic = new GameLogic();

	// Give a default value to Matrix and Counter
	// This block will run before the Constructor
	{
		String[] temp = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		setMatrix(temp);
		setCounter(0);
	}

	// Every time that Players push a button, This method will run to store the
	// value of the button to the matrix
	// and it also check if anyone won the game or not
	// It first check the counter to see if the counter's value is odd or even,
	// If the value is even, the value will of the label be X and if the value is odd, the value will be O
	// Then, It make the button invisible to let the label shows the value of that button.
	public void play(int number, JLabel label, JButton button) {
		if (GameLogic.getGameLogic().getCounter() % 2 == 0)
			label.setText("X");
		else
			label.setText("O");
		button.setVisible(false);
		label.setVisible(true);
		matrix[number - 1] = label.getText();
		setCounter(getCounter() + 1);
		gameLogic(matrix);
		if (getWinner() != null) {
			Window.getWindow().getGreetingPanel().getPanel()
					.remove(Window.getWindow().getGreetingPanel().getPanel().getPanel2(1, 0));
			Window.getWindow().getGreetingPanel().getPanel()
					.remove(Window.getWindow().getGreetingPanel().getPanel().getPanel1(1, 1));
			Window.getWindow().getGreetingPanel().getPanel()
					.add(Window.getWindow().getGreetingPanel().getPanel().panelWinner(0, 0));
			Window.getWindow().getGreetingPanel().getPanel().removeKeyListener(null);
		}
	}

	// This methods set the logic of the game.
	public void gameLogic(String[] matrix) {
		if (matrix[0] == matrix[1] && matrix[1] == matrix[2])
			setWinner(matrix[0]);
		if (matrix[3] == matrix[4] && matrix[4] == matrix[5])
			setWinner(matrix[3]);
		if (matrix[6] == matrix[7] && matrix[7] == matrix[8])
			setWinner(matrix[6]);
		if (matrix[0] == matrix[4] && matrix[4] == matrix[8])
			setWinner(matrix[0]);
		if (matrix[2] == matrix[4] && matrix[4] == matrix[6])
			setWinner(matrix[2]);
		if (matrix[0] == matrix[3] && matrix[3] == matrix[6])
			setWinner(matrix[0]);
		if (matrix[1] == matrix[4] && matrix[4] == matrix[7])
			setWinner(matrix[1]);
		if (matrix[2] == matrix[5] && matrix[5] == matrix[8])
			setWinner(matrix[2]);
	}

	// GETTERS AND SETTERS

	public static GameLogic getGameLogic() {
		return gameLogic;
	}

	public static void setGameLogic(GameLogic gameLogic) {
		GameLogic.gameLogic = gameLogic;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String[] getMatrix() {
		return matrix;
	}

	public void setMatrix(String[] matrix) {
		this.matrix = matrix;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
