package console;

class ConsoleOutput {
	public void DispMineSweeperField(game_logic.MineSweeperGrid[][] grids) {
		for(game_logic.MineSweeperGrid[] cols: grids) {
			for(game_logic.MineSweeperGrid grid : cols) {
				System.out.print(grid.getString());
			}
			System.out.println();
		}
	}
}
