package main;

public class GameRoutine {
	enum ROUTINE{
		TITLE {
			@Override
			public void run() {
				System.out.println("タイトルの処理");
				GameRoutineInstance.instance.changeRoutine(IN_GAME);
			}
		},
		IN_GAME {
			@Override
			public void run() {
				System.out.println("インゲームの処理");
				
			}
		},
		GAMEOVER {
			@Override
			public void run() {
				System.out.println("ゲームオーバーの処理");				
			}
		};
		
		abstract public void run();
	}
	
	private ROUTINE now_routine;
	
	private GameRoutine() {
		now_routine = ROUTINE.TITLE;
	}
	
	public void run() {
		now_routine.run();
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
