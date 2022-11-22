package game_logic;

import java.util.HashMap;
import java.util.Map;

public interface MineSweeperGrid {
	enum GridType{
		ZERO,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		BOMB,
		UNOPEN,
	}
	
	void open();
	GridType getGridType();
}

abstract class MineSweeperGridBase implements MineSweeperGrid{
	enum GridState{
		UNOPEN,
		OPENED,
	}
	protected GridState grid_state = GridState.UNOPEN;
	
	@Override
	public void open() {
		grid_state = GridState.OPENED;
	}
	@Override
	public GridType getGridType() {
		if(isOpen()) return getGridTypeSub();
		return GridType.UNOPEN;
	}	


	protected abstract GridType getGridTypeSub();
	
	boolean isOpen() {
		return grid_state == GridState.OPENED;
	}
	
	abstract boolean isZeroArround();
	abstract public boolean hasBomb();
}

class MineSweeperBombGrid extends MineSweeperGridBase{

	@Override
	protected GridType getGridTypeSub() {
		return GridType.BOMB;
	}
	
	@Override
	public boolean hasBomb() {
		return true;
	}

	@Override
	boolean isZeroArround() {
		return false;
	}



}

class MineSweeperNormalGrid extends MineSweeperGridBase{
	private final int number_of_mines_around;
	private static final Map<Integer, GridType> map = new HashMap<Integer, GridType>();
	
	public MineSweeperNormalGrid(int number_of_mines_around) {
		assert(number_of_mines_around >= 0 && number_of_mines_around <= 8);
		this.number_of_mines_around = number_of_mines_around;
		map.put(0, GridType.ZERO);
		map.put(1, GridType.ONE);
		map.put(2, GridType.TWO);
		map.put(3, GridType.THREE);
		map.put(4, GridType.FOUR);
		map.put(5, GridType.FIVE);
		map.put(6, GridType.SIX);
		map.put(7, GridType.SEVEN);
		map.put(8, GridType.EIGHT);
	}
	
	@Override
	protected GridType getGridTypeSub() {
		return map.get(number_of_mines_around);
	}

	
	@Override
	public boolean hasBomb() {
		return false;
	}

	@Override
	boolean isZeroArround() {
		return number_of_mines_around == 0;
	}


}

