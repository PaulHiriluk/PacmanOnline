package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Cell {
	private final int	x;
	private final int	y;
	private boolean		crossroad;
	private List<Cell>	exits;
	private CellType	type;

	public Cell(final int x, final int y, final int type) {
		this.x = x;
		this.y = y;
		init(type);
	}

	public Cell(final Point coordinates, final int type) {
		x = coordinates.x;
		y = coordinates.y;
		init(type);
	}

	public void addExit(final Cell exit) {
		exits.add(exit);
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

	public CellType getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return (Integer.toString(x) + Integer.toString(y)).hashCode();
	}

	private void init(final int type) {
		switch (type) {
			case 0:
				this.type = CellType.WALL;
			break;
			case 1:
				this.type = CellType.FLOOR;
			break;
			case 2:
				this.type = CellType.APPLE;
			break;
			case 3:
				this.type = CellType.CHERRY;
		}
		exits = new ArrayList<Cell>();
	}

	public boolean isCrossroad() {
		return exits.size() > 2;
	}

	public void setType(final CellType type) {
		this.type = type;
	}

}
