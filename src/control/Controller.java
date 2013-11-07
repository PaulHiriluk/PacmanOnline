package control;

import model.Cell;
import model.Game;
import view.MainWindow;

public class Controller {
	private final Game			game;
	private final MainWindow	window;

	public Controller(final Game game, final MainWindow window) {
		super();
		this.game = game;
		this.window = window;
	}

	public void paintMap(final Cell[][] map, final int width, final int height) {
		window.paintMap(map, width, height);
	}
}
