package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.MainWindow;

public class ScreenShotEvent implements ActionListener {
	private MainWindow window;
	
	public ScreenShotEvent(MainWindow window) {
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String fileExt = "png";
		String fileName = "screenshot";
		try {
			ImageIO.write(this.window.getMap().getMap(), fileExt, new File(fileName + "." + fileExt));
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Ошибка ввода-вывода");
		}		
	}

}
