package game_logic;

public interface MineSweeperGrid {
	void open();
	String getString();
}

abstract class MineSweeperGridBase implements MineSweeperGrid{
	enum GridState{
		UNOPEN,
		OPENED,
	}
	protected GridState grid_state = GridState.UNOPEN;
	
	@Override
	public String getString() {
		switch(grid_state) {
		case UNOPEN:
			return "_";
		case OPENED:
			return getGridString();
		default:
			assert(false);
		}
		return " ";
	}
	
	boolean isOpen() {
		return grid_state == GridState.OPENED;
	}
	
	abstract boolean isZeroArround();
	
	abstract String getGridString();
	abstract public boolean hasBomb();
}

class MineSweeperBombGrid extends MineSweeperGridBase{

	@Override
	public void open() {
		// TODO ゲームオーバー処理に入る？
		grid_state = GridState.OPENED;
		assert(false);
	}



	@Override
	public boolean hasBomb() {
		return true;
	}



	@Override
	String getGridString() {
		return "B";
	}



	@Override
	boolean isZeroArround() {
		return false;
	}	
}

class MineSweeperNormalGrid extends MineSweeperGridBase{
	private final int number_of_mines_arround;
	
	public MineSweeperNormalGrid(int number_of_mines_arround) {
		this.number_of_mines_arround = number_of_mines_arround;
	}
	
	@Override
	public void open() {
		grid_state = GridState.OPENED;
	}

	@Override
	public boolean hasBomb() {
		return false;
	}

	@Override
	String getGridString() {
		return String.valueOf(number_of_mines_arround);
	}

	@Override
	boolean isZeroArround() {
		return number_of_mines_arround == 0;
	}
	
}

