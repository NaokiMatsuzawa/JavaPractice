package console;

public class ConsoleMineSweeper {
	private game_logic.MineSweeperField game_field;
	private ConsoleInput console_input;
	private ConsoleOutput console_output;
	
	public ConsoleMineSweeper() {
		game_field = new game_logic.MineSweeperField();
		console_input = new ConsoleInput();
		console_output = new ConsoleOutput();
		disp();
	}
	
	public void run() {
		input();
		disp();
	}
	
	public boolean isGameOver() {
		return game_field.isGameover();
	}
	
	private void disp() {
		console_output.DispMineSweeperField(game_field.getField());
	}
	
	private void input() {
		final int x = console_input.getInputInt();
		final int y = console_input.getInputInt();
		game_field.open(x, y);
	}
}
