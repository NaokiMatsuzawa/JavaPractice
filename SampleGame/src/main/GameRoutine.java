package main;


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
			console.ConsoleMineSweeper game;
			@Override
			public void run() {
				assert(game != null);
				if(!game.isGameOver()) {
					game.run();
				}
				else {
					GameRoutineInstance.instance.changeRoutine(GAMEOVER);
				}
			}
			@Override
			public void initialize() {
				game = new console.ConsoleMineSweeper();
			}
		},
		GAMEOVER {
			@Override
			public void run() {
				//System.out.println("ゲームオーバーの処理");				
			}

			@Override
			public void initialize() {
				System.out.println("GAME OVER");
			}
		};
		
		abstract public void initialize();
		abstract public void run();
	}
	
	private ROUTINE now_routine;
	
	private GameRoutine() {
		now_routine = ROUTINE.IN_GAME;
		now_routine.initialize();
	}
	
	public void run() {
		now_routine.run();
	}
	
	public boolean isClosed() {
		return now_routine == ROUTINE.GAMEOVER;
	}
	
	private void changeRoutine(ROUTINE next_routine) {
		now_routine = next_routine;
		now_routine.initialize();
	}

	private static class GameRoutineInstance{
		public static GameRoutine instance = new GameRoutine();
	}
	
	public static final GameRoutine getInstance() {
		return GameRoutineInstance.instance;
	}
}
