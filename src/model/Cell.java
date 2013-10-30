package model;

import java.awt.Point;

public class Cell {
	private final Point coordinates;
	private int g;
	private int h;
	private Point came_from;
	
	public Cell(final Point coordinates, int g, int h, final Point came_from) {
		this.coordinates = coordinates;
		this.g = g;
		this.h = h;
		this.came_from = came_from;
	}

	public Point getCoordinates() {
	
		return coordinates;
	}

	public int getG() {
	
		return g;
	}

	public int getH() {
	
		return h;
	}

	public Point getCame_from() {
	
		return came_from;
	}

	public void setG(int g) {
	
		this.g = g;
	}

	public void setH(int h) {
	
		this.h = h;
	}

	public void setCame_from(Point came_from) {
	
		this.came_from = came_from;
	}
	
}
