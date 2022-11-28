package test_window;

public class TestWindowGame {
	private TestWindow window;
	private game_logic.MineSweeperField game;
	public TestWindowGame() {
		game = new game_logic.MineSweeperField();
		window = new TestWindow(this);
	}
	
	final game_logic.MineSweeperField refGame(){ return game;}
	
	public void run() {
		
	}
	
	public boolean isGameOver() {
		return game.isGameover();
	}

	public boolean isGameClear() {
		return game.isClear();
	}
	
	void buttonClicked(final int x, final int y) {
		game.open(x, y);
		for(int y2 = 0; y2 < game.getHeight(); ++y2) {
			for(int x2= 0; x2 < game.getWidth(); ++x2) {
				window.buttonAutoOpen(x2, y2, game.getGridType(x2, y2));
			}
		}
	}

	public void flagClicked(int x, int y) {
		game.flag_request(x, y);
	}
}
