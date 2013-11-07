package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import view.MainWindow;

public class StartEvent implements ActionListener {
	private final MainWindow	window;

	public StartEvent(final MainWindow window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO: create game, create map, create controller, setController to
		// map and mapModel, start game
		final Game game = new Game();
		final Controller controller = new Controller(game, window);
		setController(game, controller);
		final Thread thread = new Thread(game);
		thread.start();
	}

	private void setController(final Game game, final Controller controller) {
		window.setController(controller);
		game.setController(controller);
	}

}
