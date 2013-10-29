package model;

public class Map {
	private final int[][]	map;
	private final int		width;
	private final int		height;

	public Map(final int width, final int height) {

		this.width = width;
		this.height = height;
		map = new int[width][height];
	}

	public void move(final Pacman pacman, final Direction direction) {

	}

	public void move(final Unit unit, final Unit enemy) {

	}
}
