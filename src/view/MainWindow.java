package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import control.Controller;

<<<<<<< HEAD
import model.Cell;
import model.MenuModel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 3172688540921699213L;
	private static final String build = "alpha 0.0000001 :)"; 
	
	private Controller controller;
	private JMenuBar northMenuBar;
	private ScoreBar southScoreBar;
	private Map map;

	public MainWindow() {
		initDefaultSettings();
		initMenuBar();
		initMap();
		showGameBars(true);
	}

	private void initMap() {
		map = new Map();
		add(map, BorderLayout.CENTER);
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
		
		southScoreBar = new ScoreBar();
		add(southScoreBar, BorderLayout.SOUTH);
	}

	public void showGameBars(Boolean showGameBars) {
		this.northMenuBar.setVisible(showGameBars);
		this.southScoreBar.setVisible(showGameBars);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return this.controller;
	}
	
	public void paintMap(Cell[][] map, int width, int height) {
		this.map.paintMap(map, width, height);
=======
import model.MenuModel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 3172688540921699213L;
	private static final String build = "alpha 0.0000001 :)"; 
	
	private Controller controller;
	private JMenuBar northMenuBar;
	private ScoreBar southScoreBar;
	private Map map;

	public MainWindow() {
		initDefaultSettings();
		initMenuBar();
		initMap();
		showGameBars(true);
	}

	private void initMap() {
		map = new Map();
		add(map, BorderLayout.CENTER);
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
		
		southScoreBar = new ScoreBar();
		add(southScoreBar, BorderLayout.SOUTH);
	}

	public void showGameBars(Boolean showGameBars) {
		this.northMenuBar.setVisible(showGameBars);
		this.southScoreBar.setVisible(showGameBars);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return this.controller;
	}
	
	public void paintMap(int[][] map) {
		this.map.paintMap(map);
>>>>>>> refs/heads/dev
	}
}
