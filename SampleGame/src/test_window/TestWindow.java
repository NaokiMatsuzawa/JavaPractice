package test_window;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class TestButton extends JButton implements ActionListener{
	public TestButton() {
		super();
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);
	}
	
}

public class TestWindow{
	//private game_logic.MineSweeperField game;
	JFrame window;
	JPanel panel;
	TestButton buttons[] = new TestButton[100];
	
	public TestWindow() {
		//game = new game_logic.MineSweeperField();
		window = new JFrame("title");
		window.setVisible(true);
		window.setSize(500,500);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10));
		
		for(var button : buttons) {
			button = new TestButton();
			button.setPreferredSize(new Dimension(32, 32));
			button.setText("0");
			button.setVisible(true);
			//button.setEnabled(false);
			//button.setActionCommand("test");
			panel.add(button);
		}
		//button.set
		
		//setOpaque(true);
		
		window.add(panel);
	}
}
