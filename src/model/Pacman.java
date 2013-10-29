package model;

import java.awt.Point;

public class Pacman extends Unit {
	private final Map	map;
	private Direction	direction;
	private int			gold_count;

	public Pacman(final Map map, final Point coordinates, final UnitType type) {

		super(map, coordinates, type);
		this.map = map;
		setHungry(false);
	}

	public int getGold() {

		return gold_count;
	}

	protected void move(final Direction direction) {

		map.move(this, direction);
		this.direction = direction;
	}
}
