package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;

public class StartEvent implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: create game, create map, create controller, setController to map and mapModel, start game
		Game game = new Game();
	}

}
