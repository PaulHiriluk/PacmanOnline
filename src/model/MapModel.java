package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MapModel {
	private int			width;
	private int			height;
	private Cell[][]	map;

	public MapModel() {
		final int[][] temp_map = readMap();
		if (temp_map != null) {
			parseMap(temp_map);
		}
	}

	private void clearCurrentCell(final Point aimCoordinates) {
		map[aimCoordinates.y][aimCoordinates.x].setType(CellType.FLOOR);
	}

	private void findExitsFromCell(final Cell currentCell, final int i, final int j) {
		if (!isWall(j, i)) {
			final Cell cell = getCell(j, i);
			cell.addExit(currentCell);
			currentCell.addExit(cell);
		}
	}

	private void getAimCoordinates(final Direction direction, final Point aimCoordinates) {

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

	public Cell getCell(final int x, final int y) {
		return map[y][x];
	}

	public Cell getCell(final Point coordinates) {
		return map[coordinates.y][coordinates.x];
	}

	public int getHeight() {
		return height;
	}

	public Cell[][] getMap() {
		return map;
	}

	public int getWidth() {
		return width;
	}

	private boolean isAppleCell(final Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.APPLE;
	}

	private boolean isCherryCell(final Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.CHERRY;
	}

	private boolean isEmptyCell(final Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.FLOOR;
	}

	private Cell isInList(final List<Cell> list_of_cells, final Point arg_cell) {
		for (final Cell cell : list_of_cells) {
			if (cell.getX() == arg_cell.getX() && cell.getY() == arg_cell.getY()) {
				return cell;
			}
		}
		return null;
	}

	private boolean isWall(final int x, final int y) {

		return map[y][x].getType() == CellType.WALL;
	}

	private boolean isWall(final Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.WALL;
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

	private void parseMap(final int[][] input_map) {
		map = new Cell[height][width];
		Cell currentCell;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				currentCell = new Cell(y, x, input_map[y][x]);
				map[y][x] = currentCell;
				if (input_map[y][x] == CellType.WALL.getValue()) {
					continue;
				}
				if (y > 0) {
					findExitsFromCell(currentCell, y - 1, x);
				}
				if (x > 0) {
					findExitsFromCell(currentCell, y, x - 1);
				}
			}
		}
	}

	private int[][] readMap() {
		int temp_map[][] = null;
		final File file = new File("map" + File.separator + "level_one.map");
		if (file.exists()) {
			try {

				final BufferedReader reader = new BufferedReader(new FileReader(file));
				width = Integer.parseInt(reader.readLine());
				height = Integer.parseInt(reader.readLine());
				temp_map = new int[height][width];
				int value;
				int j = 0, i = 0;
				while (reader.ready()) {
					value = reader.read();
					if (value != 13 && value != 10) {
						temp_map[i][j] = value - 48;
						j++;
						if (j == width) {
							j = 0;
							i++;
						}
					}
				}
				reader.close();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(":*(");
		}
		return temp_map;
	}
}
