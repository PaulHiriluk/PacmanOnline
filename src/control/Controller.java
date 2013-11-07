package control;

import view.MainWindow;
import model.Cell;
import model.Game;

public class Controller {
	private Game game;
	private MainWindow window;
	
	public Controller(Game game, MainWindow window) {
		super();
		this.game = game;
		this.window = window;
	}

	public void paintMap(Cell[][] map, int width, int height){
		this.window.paintMap(map, width, height);
	}
}
