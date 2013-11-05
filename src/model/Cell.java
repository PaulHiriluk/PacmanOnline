package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Cell {
	private final int x;
	private final int y;
	private boolean crossroad;
	private List<Cell> exits;
	private CellType type;

	public Cell(final int x, final int y, int type) {
		this.x = x;
		this.y = y;
		init(type);
	}

	private void init(int type) {
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

	public Cell(final Point coordinates, int type) {
		x = coordinates.x;
		y = coordinates.y;
		init(type);
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
	
	@Override
	public int hashCode() {
		return (Integer.toString(x)+ Integer.toString(y)).hashCode();
	}

	public CellType getType() {
		return type;
	}

	public void setType(CellType type) {
		this.type = type;
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
