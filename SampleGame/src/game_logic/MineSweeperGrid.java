package game_logic;

import java.util.HashMap;
import java.util.Map;

public interface MineSweeperGrid {
	public enum GridType{
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
	
	public void open_request();
	public void flag_request();
}

abstract class MineSweeperGridBase implements MineSweeperGrid{
	enum GridState{
		UNOPEN,
		OPENED,
		FLAGED,
	}
	protected GridState grid_state = GridState.UNOPEN;
	
	private static final  Map<GridState, GridState> next_state_by_open_request = new HashMap<GridState, GridState>();
	private static final Map<GridState, GridState> next_state_by_flag_request= new HashMap<GridState, GridState>();
	
	public MineSweeperGridBase() {
		next_state_by_open_request.put(GridState.UNOPEN, GridState.OPENED);
		next_state_by_open_request.put(GridState.UNOPEN, GridState.OPENED);
		next_state_by_open_request.put(GridState.FLAGED, GridState.FLAGED);
		
		next_state_by_flag_request.put(GridState.UNOPEN,  GridState.FLAGED);
		next_state_by_flag_request.put(GridState.FLAGED,  GridState.UNOPEN);
		next_state_by_flag_request.put(GridState.OPENED,  GridState.OPENED);
		
	}
	
	@Override
	public void open_request() {
		grid_state = next_state_by_open_request.get(grid_state);
	}
	
	@Override
	public void flag_request() {
		grid_state = next_state_by_flag_request.get(grid_state);
	}
	
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
		super();
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

