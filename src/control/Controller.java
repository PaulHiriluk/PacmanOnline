package control;

import view.MainWindow;
import model.Game;

public class Controller {
	private Game game;
	private MainWindow window;
	
	public Controller(Game game, MainWindow window) {
		super();
		this.game = game;
		this.window = window;
	}

	public void paintMap(int[][] map){
		this.window.paintMap(map);
	}
}
