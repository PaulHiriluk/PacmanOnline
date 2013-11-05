package model;

import java.awt.Point;

public class Pacman extends Unit {
	private final MapModel	map;
	private Direction	direction;
	private int			apple_count;

	public Pacman(final MapModel map, final Point coordinates, final UnitType type) {

		super(map, coordinates, type);
		this.map = map;
		setHungry(false);
	}

	public int getApple() {

		return apple_count;
	}
	
	public void eatApple() {
		
		apple_count++;
	}

	protected void move(final Direction direction) {

		this.direction = direction;
		map.move(this, direction);
	}
}
