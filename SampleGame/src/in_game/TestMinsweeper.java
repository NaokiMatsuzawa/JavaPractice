package in_game;

import java.util.Random;
import java.util.Scanner;

public class TestMinsweeper {
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	private final int BOMB_NUM = 10;
	private int field[][] = new int[HEIGHT][WIDTH];
	private boolean is_open[][] = new boolean[HEIGHT][WIDTH];
	private int last_value = -1;
	boolean is_gameover = false;
	
	Scanner scn;
	
	public TestMinsweeper() {
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
					field[y][x] = 9;
					continue;
				}
				int count = 0;
				final int vector[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
				for(int i = 0; i < vector.length; ++i) {
					if(initialize_field[Y + vector[i][0]][X + vector[i][1]] == 9) {
						++count;
					}
				}
				field[y][x] = count;
			}
		}
		
		for(boolean[] row : is_open) {
			for(boolean b : row) {
				b = false;
			}
		}
		
		scn = new Scanner(System.in);
	}

	public void run() {
		for(int y = 0; y < HEIGHT; ++y) {
			for(int x = 0; x < WIDTH; ++x) {
				if(is_open[y][x] == true) {
					System.out.print(field[y][x]);
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		
		if(last_value == 9) {
			System.out.println("BOMB");
			System.out.println("GAME OVER");
			is_gameover= true;
			return;
		}
		
		int input = scn.nextInt();
		assert(input >= 0 && input < WIDTH * HEIGHT);
		int y = input / HEIGHT;
		int x = input % HEIGHT;
		if(is_open[y][x]) return;
		last_value = field[y][x];
		is_open[y][x] = true;
	}
	
	public boolean isGameover() {return is_gameover;}
}
