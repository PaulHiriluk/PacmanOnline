package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import model.MenuModel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 3172688540921699213L;
	private static final String build = "alpha 0.0000001 :)"; 
	
	private JMenuBar northMenuBar;

	public MainWindow() {
		initDefaultSettings();
		initMenuBar();
		showGameBars(false);
	}

	private void initDefaultSettings() {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//setIconImage(getToolkit().getImage("images/gameIcon.png"));
		setLayout(new BorderLayout());
		setTitle("Pacman - Online " + build);
		setPreferredSize(new Dimension(width / 2, height / 2));
		setSize(width / 2 + 200, height / 2);
		setLocation(width / 2, height / 4);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initMenuBar() {
		northMenuBar = new JMenuBar();
		for(MenuTabItem tabItem: MenuTabItem.values()){
			northMenuBar.add(MenuModel.createMenu(tabItem, this));
		}	
		setJMenuBar(northMenuBar);
	}

	public void showGameBars(Boolean showGameBars) {
		this.northMenuBar.setVisible(showGameBars);
	}
}
