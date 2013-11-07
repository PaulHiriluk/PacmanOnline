package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import model.Cell;
import model.MenuModel;
import control.Controller;

public class MainWindow extends JFrame {

	private static final long	serialVersionUID	= 3172688540921699213L;
	private static final String	build				= "alpha 0.0000001 :)";

	private Controller			controller;
	private JMenuBar			northMenuBar;
	private ScoreBar			southScoreBar;
	private Map					map;

	public MainWindow() {
		initDefaultSettings();
		initMenuBar();
		initMap();
		showGameBars(true);
	}

	public Controller getController() {
		return controller;
	}

	public Map getMap() {
		return map;
	}

	private void initDefaultSettings() {
		final int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLayout(new BorderLayout());
		setTitle("Pacman - Online " + MainWindow.build);
		setPreferredSize(new Dimension(Map.MAP_PIXEL_WIDTH, Map.MAP_PIXEL_HEIGHT));
		setSize(Map.MAP_PIXEL_WIDTH, Map.MAP_PIXEL_HEIGHT);
		setLocation(width / 3, height / 8);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initMap() {
		map = new Map();
		add(map, BorderLayout.CENTER);
	}

	private void initMenuBar() {
		northMenuBar = new JMenuBar();
		for (final MenuTabItem tabItem : MenuTabItem.values()) {
			northMenuBar.add(MenuModel.createMenu(tabItem, this));
		}
		setJMenuBar(northMenuBar);

		southScoreBar = new ScoreBar();
		add(southScoreBar, BorderLayout.SOUTH);
	}

	public void paintMap(final Cell[][] map, final int width, final int height) {
		this.map.paintMap(map, width, height);
		this.repaint();
	}

	public void setController(final Controller controller) {
		this.controller = controller;
	}

	public void setMap(final Map map) {
		this.map = map;
	}

	public void showGameBars(final Boolean showGameBars) {
		northMenuBar.setVisible(showGameBars);
		southScoreBar.setVisible(showGameBars);
	}
}
