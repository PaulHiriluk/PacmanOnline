package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
	
	private void clearCurrentCell(final Point aimCoordinates) {
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
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	private Cell isInList(final List<Cell> list_of_cells, final Point arg_cell) {
		for (final Cell cell : list_of_cells) {
			if (cell.getX() == arg_cell.getX() && cell.getY() == arg_cell.getY()) {
				return cell;
			}
		}
		return null;
	}

	public void move(final Pacman pacman, final Direction direction) {
		final Point pacmanCoordinates = pacman.getCoordinate();
		final Point aimCoordinates = pacmanCoordinates;
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

	public void move(final Unit unit, final Pacman enemy) {

	}

	public int[][] getMap() {
		return this.map;
	}
}
