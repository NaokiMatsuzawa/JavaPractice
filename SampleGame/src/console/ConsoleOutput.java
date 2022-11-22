package console;

import java.util.HashMap;
import java.util.Map;

import game_logic.MineSweeperGrid.GridType;;

class ConsoleOutput {
	private final Map<GridType, String> map = new HashMap<GridType,String>();

	public ConsoleOutput() {
		map.put(GridType.ZERO, "0");
		map.put(GridType.ONE, "1");
		map.put(GridType.TWO, "2");
		map.put(GridType.THREE, "3");
		map.put(GridType.FOUR, "4");
		map.put(GridType.FIVE, "5");
		map.put(GridType.SIX, "6");
		map.put(GridType.SEVEN, "7");
		map.put(GridType.EIGHT, "8");
		map.put(GridType.BOMB, "B");
		map.put(GridType.UNOPEN, "*");
	}
	
	public void DispMineSweeperField(game_logic.MineSweeperGrid[][] grids) {		
		for(game_logic.MineSweeperGrid[] cols: grids) {
			for(game_logic.MineSweeperGrid grid : cols) {
				System.out.print(map.get(grid.getGridType()));
			}
			System.out.println();
		}
	}
}
