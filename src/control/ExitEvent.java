package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitEvent implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		System.exit(0);
	}

}
