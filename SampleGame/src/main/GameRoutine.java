package main;



import javax.swing.JFrame;

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
			game_logic.MineSweeperField mine_sweeper_field;
			
			console.ConsoleInput console_input;
			console.ConsoleOutput console_output;
			@Override
			public void run() {
				assert(mine_sweeper_field != null);
				console_output.DispMineSweeperField(mine_sweeper_field.getField());
				final int x = console_input.getInputInt();
				final int y = console_input.getInputInt();
				mine_sweeper_field.getField()[y][x].open();
				if(mine_sweeper_field.isGameover()) {
					console_output.DispMineSweeperField(mine_sweeper_field.getField());
					GameRoutineInstance.instance.changeRoutine(GAMEOVER);
				}
			}
			@Override
			public void initialize() {
				mine_sweeper_field = new game_logic.MineSweeperField();
				
				console_input = new console.ConsoleInput();
				console_output = new console.ConsoleOutput();
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
		now_routine.initialize();
	}

	private static class GameRoutineInstance{
		public static GameRoutine instance = new GameRoutine();
	}
	
	public static final GameRoutine getInstance() {
		return GameRoutineInstance.instance;
	}
}
