package model;

import java.awt.Point;

public class Pacman extends Unit{
	public Pacman(Point coordinates, UnitType type) {

		super(coordinates, type);
	}

	private int gold_count;
	
	public int getGold() {
		return gold_count;
	}
	
	protected void move(){
		
	}
}
