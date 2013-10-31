package model;

import java.awt.Point;

public class MapModel {
	private static final int CELL_WALL = 0;
	private final int[][] map;
	private final int width;
	private final int height;

	public MapModel(final int width, final int height) {

		this.width = width;
		this.height = height;
		map = new int[width][height];
	}

	public void move(final Pacman pacman, final Direction direction) {

		Point pacmanCoordinates = pacman.getCoordinate();
		Point aimCoordinates = pacmanCoordinates;
		getAimCoordinates(direction, aimCoordinates);
		if (!isWall(aimCoordinates)) {
			pacman.setCoordinate(aimCoordinates);
			if (isAppleCell(aimCoordinates)) {
				pacman.eatApple();
			} else if (isCherryCell(aimCoordinates)) {
				pacman.setHungry(true);
			}
			clearCurrentCell(aimCoordinates);
		}
	}

	private void clearCurrentCell(Point aimCoordinates) {

		map[aimCoordinates.x][aimCoordinates.y] = 1;
	}

	private boolean isAppleCell(Point aimCoordinates) {

		return map[aimCoordinates.x][aimCoordinates.y] == 1;
	}

	private boolean isCherryCell(Point aimCoordinates) {

		return map[aimCoordinates.x][aimCoordinates.y] == 1;
	}

	private boolean isEmptyCell(Point aimCoordinates) {

		return map[aimCoordinates.x][aimCoordinates.y] == 1;
	}

	private boolean isWall(Point aimCoordinates) {

		return map[aimCoordinates.x][aimCoordinates.y] == CELL_WALL;
	}

	private void getAimCoordinates(final Direction direction,
			Point aimCoordinates) {

		switch (direction) {
		case EAST:
			aimCoordinates.x++;
			break;
		case NORTH:
			aimCoordinates.y++;
			break;
		case SOUTH:
			aimCoordinates.y--;
			break;
		case WEST:
			aimCoordinates.x--;
			break;
		}
	}

	public void move(final Unit unit, final Unit enemy) {

	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int[][] getMap() {
		return map;
	}
}
