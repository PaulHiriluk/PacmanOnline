package model;

import java.awt.Point;
<<<<<<< HEAD
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
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				currentCell = new Cell(j, i, input_map[i][j]);
				map[i][j] = currentCell;
				if (input_map[i][j] == CellType.WALL.getValue())
					continue;
				if (i > 0) {
					findExitsFromCell(currentCell, i - 1, j);
				}
				if (j > 0) {
					findExitsFromCell(currentCell, i, j - 1);
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
=======
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

	public int getHeuristicCostEstimate(final Point start, final Point end) {
		return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
	}

	public Cell getMinFCell(final List<Cell> list) {
		if (list.size() != 0) {
			Cell min = list.get(0);
			for (final Cell cell : list) {
				if (min.getF() > cell.getF()) {
					min = cell;
				}
			}
			return min;
		} else {
			return null;
		}
	}

	private Point getNextStepPoint(final Cell end) {
		Cell cell = end;
		while (cell.getG() != 1 && cell.getCame_from() != null) {
			cell = cell.getCame_from();
		}

		return cell.getCoordinates();
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
		// TODO: if pacman hungry then run
		final Point startCoord = unit.getCoordinate();
		final Point endCoord = enemy.getCoordinate();
		final List<Cell> opened_cells = new ArrayList<Cell>();
		final List<Cell> closed_cells = new ArrayList<Cell>();
		opened_cells.add(new Cell(startCoord, 0, getHeuristicCostEstimate(startCoord,
				endCoord), null));
		while (opened_cells.size() != 0) {
			final Cell currentCell = getMinFCell(opened_cells);
			if (currentCell.equals(endCoord)) {
				final Point stepPoint = getNextStepPoint(currentCell);
				unit.setCoordinate(stepPoint);
				return;
			}
			opened_cells.remove(currentCell);
			closed_cells.add(currentCell);
			final Point northCell = new Point(currentCell.getX(), currentCell.getY() - 1);
			processCell(endCoord, opened_cells, closed_cells, currentCell, northCell);
			final Point southCell = new Point(currentCell.getX(), currentCell.getY() + 1);
			processCell(endCoord, opened_cells, closed_cells, currentCell, southCell);
			final Point eastCell = new Point(currentCell.getX(), currentCell.getY() - 1);
			processCell(endCoord, opened_cells, closed_cells, currentCell, eastCell);
			final Point westCell = new Point(currentCell.getX(), currentCell.getY() + 1);
			processCell(endCoord, opened_cells, closed_cells, currentCell, westCell);
		}
		// TODO: if path not found then random step;
	}

	private void processCell(final Point endCoord, final List<Cell> opened_cells,
			final List<Cell> closed_cells, final Cell currentCell, final Point northCell) {
		Cell tmp_cell;
		if (!isWall(northCell)) {
			if (isInList(closed_cells, northCell) == null) {
				final int g = currentCell.getG() + 1;

				if ((tmp_cell = isInList(opened_cells, northCell)) != null) {
					if (tmp_cell.getG() > g) {
						tmp_cell.setG(g);
						tmp_cell.setCame_from(currentCell);
					}
				} else {
					tmp_cell = new Cell(northCell, g, getHeuristicCostEstimate(northCell,
							endCoord), currentCell);
					opened_cells.add(tmp_cell);
				}
			}
		}
	}

	public int[][] getMap() {
		return this.map;
>>>>>>> refs/heads/dev
	}
}
