package view;

import java.awt.Color;

import javax.swing.JPanel;

public class Map extends JPanel{
	private static final long serialVersionUID = 3885570269374432604L;
	private boolean isGreen;

	public Map() {
		setBackground(Color.BLACK);
	}

	public void paintMap(int[][] map) {
		if (!isGreen) {
			setBackground(Color.GREEN);
			isGreen = true;
		}
		else {
			setBackground(Color.RED);
			isGreen = false;
		}
	}
}
