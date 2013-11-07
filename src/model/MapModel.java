package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapModel {
	private int width;
	private int height;
	private Cell[][] map;

	public MapModel() {
		int[][] temp_map = readMap();
		if (temp_map != null) {
			parseMap(temp_map);
		}
	}

	private int[][] readMap() {
		int temp_map[][] = null;
		File file = new File("map" + File.separator + "level_one.map");
		if (file.exists()) {
			try {

				BufferedReader reader = new BufferedReader(new FileReader(file));
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(":*(");
		}
		return temp_map;
	}

	private void parseMap(int[][] input_map) {
		map = new Cell[height][width];
		Cell currentCell;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				currentCell = new Cell(y, x, input_map[y][x]);
				map[y][x] = currentCell;
				if (input_map[y][x] == CellType.WALL.getValue())
					continue;
				if (y > 0) {
					findExitsFromCell(currentCell, y - 1, x);
				}
				if (x > 0) {
					findExitsFromCell(currentCell, y, x - 1);
				}
			}
		}
	}

	private void findExitsFromCell(Cell currentCell, int i, int j) {
		if (!isWall(j, i)) {
			Cell cell = getCell(j, i);
			cell.addExit(currentCell);
			currentCell.addExit(cell);
		}
	}

	public Cell getCell(Point coordinates) {
		return map[coordinates.y][coordinates.x];
	}

	public Cell getCell(int x, int y) {
		return map[y][x];
	}

	private void clearCurrentCell(final Point aimCoordinates) {
		map[aimCoordinates.y][aimCoordinates.x].setType(CellType.FLOOR);
	}

	private boolean isAppleCell(Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.APPLE;
	}

	private boolean isCherryCell(Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.CHERRY;
	}

	private boolean isEmptyCell(Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.FLOOR;
	}

	private boolean isWall(Point aimCoordinates) {

		return map[aimCoordinates.y][aimCoordinates.x].getType() == CellType.WALL;
	}

	private boolean isWall(int x, int y) {

		return map[y][x].getType() == CellType.WALL;
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
			if (cell.getX() == arg_cell.getX()
					&& cell.getY() == arg_cell.getY()) {
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

	public Cell[][] getMap() {
		return map;
	}
}
