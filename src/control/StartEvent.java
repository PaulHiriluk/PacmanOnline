package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;

import model.Game;

public class StartEvent implements ActionListener {
	private MainWindow window;
	public StartEvent(MainWindow window) {
		this.window = window;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: create game, create map, create controller, setController to map and mapModel, start game
		Game game = new Game();
		Controller controller = new Controller(game, window);
		setController(game, controller);
		Thread thread = new Thread(game);
		thread.start();
	}
	private void setController(Game game, Controller controller) {
		window.setController(controller);
		game.setController(controller);
	}

}
