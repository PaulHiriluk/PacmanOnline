package model;

import java.awt.Point;
import java.util.List;

public class Game implements Runnable{
	private Map map;
	private List<Unit> ghosts;
	private Pacman pacman;
	public int MAX_GOLD;
	
	@Override
	public void run() {
		pacman = new Pacman(new Point(0, 0), UnitType.PACMAN);
		while(pacman.isLife()){
			
		}
	}
	
	
}
