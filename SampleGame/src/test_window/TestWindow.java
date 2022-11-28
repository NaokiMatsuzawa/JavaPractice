package test_window;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game_logic.MineSweeperGrid.GridType;

class TestButton extends JButton implements MouseListener{
	private final TestWindow window;
	private final int x;
	private final int y;
	private final Map<GridType, String> map = new HashMap<GridType,String>();
	
	public TestButton(TestWindow testWindow, final int x, final int y) {
		super();
		assert(testWindow != null);
		this.window = testWindow;
		this.x = x;
		this.y = y;
		addMouseListener(this);
		setPreferredSize(new Dimension(32, 32));
		setSize(32, 32);
		setText("");
		setVisible(true);
		
		map.put(GridType.ZERO, "0");
		map.put(GridType.ONE, "1");
		map.put(GridType.TWO, "2");
		map.put(GridType.THREE, "3");
		map.put(GridType.FOUR, "4");
		map.put(GridType.FIVE, "5");
		map.put(GridType.SIX, "6");
		map.put(GridType.SEVEN, "7");
		map.put(GridType.EIGHT, "8");
		map.put(GridType.BOMB, "B");
		map.put(GridType.UNOPEN, "");
		map.put(GridType.FLAGED, "F");
	}
	
	void buttonAutoOpen(GridType type) {
		if(type == GridType.UNOPEN || type == GridType.FLAGED) {
			setEnabled(true);
			return;
		}
		if(!isEnabled()) return;		
		setEnabled(false);
	}

	void updateText() {
		setText(map.get(window.getGridType(x, y)));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			window.buttonClicked(x, y);
		}
		else {
			window.buttonFlagClicked(x, y);
		}
		window.refresh();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}

class TestWindow{
	private TestWindowGame game;
	JFrame window;
	JPanel panel;
	TestButton buttons[][];
	
	public TestWindow(TestWindowGame game) {
		assert(game != null);
		this.game = game;
		window = new JFrame("title");
		window.setVisible(true);
		window.setSize(500,500);
		
		final game_logic.MineSweeperField field = game.refGame();
		
		buttons = new TestButton[field.getHeight()][field.getWidth()];
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(field.getWidth(), field.getHeight()));
		
		for(int y = 0; y < field.getHeight(); ++y) {
			for(int x= 0; x < field.getWidth(); ++x) {
				buttons[y][x] = new TestButton(this, x, y);
				panel.add(buttons[y][x]);
			}
		}
		window.add(panel);
	}
	
	void refresh() {
		for(TestButton[] col : buttons) {
			for(TestButton button : col) {
				button.updateText();
			}
		}
	}

	void buttonClicked(final int x, final int y) {
		game.buttonClicked(x, y);
	}
	
	void buttonFlagClicked(final int x, final int y) {
		game.flagClicked(x, y);
	}
	
	void buttonAutoOpen(final int x, final int y, GridType type) {
		assert(type != null);
		buttons[y][x].buttonAutoOpen(type);
	}
	
	GridType getGridType(final int x, final int y) {
		return game.getGridType(x, y);
	}
}
