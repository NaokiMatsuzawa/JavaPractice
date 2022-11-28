package game_logic;

import java.util.Random;

public class MineSweeperField {
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	private final int BOMB_NUM = 10;
	private MineSweeperGridBase grids[][] = new MineSweeperGridBase[HEIGHT][WIDTH];
	
	public MineSweeperField() {
		assert(WIDTH * HEIGHT > BOMB_NUM);
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
	
	public int getWidth() { return WIDTH;}
	public int getHeight() {return HEIGHT;}
	
	public final MineSweeperGrid.GridType getGridType(final int x, final int y){
		return grids[y][x].getGridType();
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
	
	public boolean isClear() {
		for(var row : grids) {
			for(var grid : row) {
				if(grid.hasBomb()) {
					continue;
				}
				if(!grid.isOpen()) {
					return false;
				}
			}
		}
		return true;
	}

	public void open(final int x, final int y) {
		if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT){
			return;
		}
		assert(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT);
		if(grids[y][x].isOpen()) return;
		grids[y][x].open_request();
		if(!grids[y][x].isOpen()) return;
		if(!grids[y][x].isZeroArround()) return;
		
		open(x-1,y-1);
		open(x-1,y);
		open(x-1,y+1);
		open(x, y-1);
		open(x, y+1);
		open(x+1,y-1);
		open(x+1,y);
		open(x+1,y+1);
	}

	public void flag_request(int x, int y) {
		grids[y][x].flag_request();
	}
}
