package model;

import java.awt.Point;

public class Cell {
	private final int	x;
	private final int	y;
	private int			g;
	private int			h;
	private int			f;
	private Cell		came_from;

	public Cell(final int x, final int y, final int g, final int h, final Cell came_from) {
		this.x = x;
		this.y = y;
		this.g = g;
		this.h = h;
		f = g + h;
		this.came_from = came_from;
	}

	public Cell(final Point coordinates, final int g, final int h, final Cell came_from) {
		x = coordinates.x;
		y = coordinates.y;
		this.g = g;
		this.h = h;
		f = g + h;
		this.came_from = came_from;
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

	public Cell getCame_from() {
		return came_from;
	}

	public Point getCoordinates() {
		return new Point(x, y);
	}

	public int getF() {
		return f;
	}

	public int getG() {
		return g;
	}

	public int getH() {
		return h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setCame_from(final Cell came_from) {
		this.came_from = came_from;
	}

	public void setG(final int g) {
		this.g = g;
		f = g + h;
	}

	public void setGH(final int g, final int h) {
		this.g = g;
		this.h = h;
		f = g + h;
	}

	public void setH(final int h) {
		this.h = h;
		f = g + h;
	}

}
