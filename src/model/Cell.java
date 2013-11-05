package model;

import java.awt.Point;
import java.util.List;

public class Cell {
	private final int	x;
	private final int	y;
	private boolean crossroad;
	private List<Cell> exits;

	public Cell(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public Cell(final Point coordinates) {
		x = coordinates.x;
		y = coordinates.y;
	}
	
	public void addExit(Cell exit) {
		exits.add(exit);
	}

	public boolean isCrossroad() {
		return exits.size() > 2;
	}
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Cell) {
			final Cell tmp_cell = (Cell) obj;
			if (tmp_cell.getX() == x && tmp_cell.getY() == y) {
				return true;
			}
		} else if (obj instanceof Point) {
			final Point tmp_point = (Point) obj;
			if (tmp_point.x == x && tmp_point.y == y) {
				return true;
			}
		}
		return false;
	}

	public Point getCoordinates() {
		return new Point(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
