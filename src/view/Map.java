package view;

import java.awt.Color;

import javax.swing.JPanel;

<<<<<<< HEAD
import model.Cell;
import model.CellType;

public class Map extends JPanel{
	private static final long serialVersionUID = 3885570269374432604L;
	private boolean isGreen;

	public Map() {
		setBackground(Color.BLACK);
	}

	public void paintMap(Cell[][] map, int width, int height) {
		if (!isGreen) {
			setBackground(Color.GREEN);
			isGreen = true;
		}
		else {
			setBackground(Color.RED);
			isGreen = false;
		}
		CellType type;
		for(int cellHInd = 0; cellHInd < height; cellHInd++) {
			for(int cellWInd = 0; cellWInd < height; cellWInd++) {
				type = map[height][width].getType();
			}
		}
		
=======
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
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map.length; y++){
				
			}
		}
>>>>>>> refs/heads/dev
	}
}
