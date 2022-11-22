package game_logic;

import java.util.Random;

public class MineSweeperField {
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	private final int BOMB_NUM = 10;
	private MineSweeperGridBase grids[][] = new MineSweeperGridBase[HEIGHT][WIDTH];
	
	public MineSweeperField() {
		int bomb_count = 0;
		Random rand = new Random();
		int initialize_field[][] = new int[HEIGHT + 2][WIDTH + 2];
		while(bomb_count < BOMB_NUM) {
			int tmp = rand.nextInt(WIDTH * HEIGHT);
			int y = tmp / HEIGHT + 1;
			int x = tmp % HEIGHT + 1;
			if(initialize_field[y][x] != 9) {
				initialize_field[y][x] = 9;
				++bomb_count;
			}
		}
		
		for(int y = 0; y < HEIGHT; ++y) {
			for(int x = 0; x < WIDTH; ++x) {
				int Y = y+1;
				int X = x+1;
				if(initialize_field[Y][X] == 9) {
					grids[y][x] = new MineSweeperBombGrid();
					continue;
				}
				int count = 0;
				final int vector[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
				for(int i = 0; i < vector.length; ++i) {
					if(initialize_field[Y + vector[i][0]][X + vector[i][1]] == 9) {
						++count;
					}
				}
				grids[y][x] = new MineSweeperNormalGrid(count);
			}
		}
	}
	
	public MineSweeperGrid[][] getField() {
		return grids;
	}

	public boolean isGameover() {
		for(var row : grids) {
			for(var grid : row) {
				if(grid.hasBomb() && grid.isOpen()) {
					return true;
				}
			}
		}
		return false;
	}
}