package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AboutEvent implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Это программа пишется пакменом");
	}

}
