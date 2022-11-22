package main;

import javax.swing.JFrame;

import in_game.TestMinsweeper;

public class GameRoutine {
	enum ROUTINE{
		TITLE {
			@Override
			public void run() {
				System.out.println("タイトルの処理");
				GameRoutineInstance.instance.changeRoutine(IN_GAME);
			}

			@Override
			public void initialize() {
				// TODO 自動生成されたメソッド・スタブ
				
			}
		},
		IN_GAME {
			in_game.TestMinsweeper game;
			@Override
			public void run() {
				assert(game != null);
				game.run();
				if(game.isGameover()) {
					GameRoutineInstance.instance.changeRoutine(GAMEOVER);
				}
			}
			@Override
			public void initialize() {
				// TODO 自動生成されたメソッド・スタブ
				game = new TestMinsweeper();
			}
		},
		GAMEOVER {
			@Override
			public void run() {
				//System.out.println("ゲームオーバーの処理");				
			}

			@Override
			public void initialize() {
				// TODO 自動生成されたメソッド・スタブ
				
			}
		};
		
		abstract public void initialize();
		abstract public void run();
	}
	
	private ROUTINE now_routine;
	private JFrame window;
	
	private GameRoutine() {
		now_routine = ROUTINE.IN_GAME;
		now_routine.initialize();
		window = new JFrame();
		window.setVisible(true);
	}
	
	public void run() {
		now_routine.run();
	}
	
	public boolean isClosed() {
		return !window.isVisible();
	}
	
	private void changeRoutine(ROUTINE next_routine) {
		now_routine = next_routine;
	}

	private static class GameRoutineInstance{
		public static GameRoutine instance = new GameRoutine();
	}
	
	public static final GameRoutine getInstance() {
		return GameRoutineInstance.instance;
	}
}
