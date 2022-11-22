package main;


public class GameRoutine {
	enum ROUTINE{
		TITLE {
			@Override
			public void initialize() {
				// TODO 自動生成されたメソッド・スタブ
				
			}
			@Override
			public void run() {
				System.out.println("タイトルの処理");
				GameRoutineInstance.instance.changeRoutine(IN_GAME);
			}


		},
		IN_GAME {
			console.ConsoleMineSweeper game;
			@Override
			public void initialize() {
				game = new console.ConsoleMineSweeper();
			}
			
			@Override
			public void run() {
				assert(game != null);
				game.run();
				if(game.isGameClear()) {
					GameRoutineInstance.instance.changeRoutine(GAMECLEAR);
				}
				if(game.isGameOver()) {
					GameRoutineInstance.instance.changeRoutine(GAMEOVER);
				}
			}
		},
		GAMEOVER {
			@Override
			public void run() {
			}

			@Override
			public void initialize() {
				System.out.println("GAME OVER");
				System.out.println("リトライ処理とかは未実装です");				

			}
		},
		GAMECLEAR{

			@Override
			public void initialize() {
				System.out.println("GAME CLEAR");				
				System.out.println("リトライ処理とかは未実装です");				

			}

			@Override
			public void run() {

			}
		};
		
		abstract public void initialize();
		abstract public void run();
	}
	
	private ROUTINE now_routine;
	
	private GameRoutine() {
		now_routine = ROUTINE.TITLE;
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
