package model;

import java.awt.Point;

public class Unit {
<<<<<<< HEAD
	private static final int CELL_SIZE = 16;
	private Point			coordinates;
	private Point			graphicalCoordinates;
	private UnitType		type;
	private boolean			hungry;
	private Direction		direction;
	private final boolean	life;
	private final MapModel		map;
	private Cell prevStep;

	public Unit(final MapModel map, final Point coordinates, final UnitType type) {

		this.coordinates = coordinates;
		this.type = type;
		this.map = map;
		hungry = true;
		direction = Direction.SOUTH;
		life = true;
	}
	
	public Cell getPrevStep() {
		return prevStep;
	}
	

	public Point getCoordinate() {
		return coordinates;
	}
	
	public Point getGraphicalCoordinates() {
		return graphicalCoordinates;
	}
	
	public void setGraphicalCoordinates(Point graphicalCoordinates) {
		this.graphicalCoordinates = graphicalCoordinates;
		coordinates.x = graphicalCoordinates.x / CELL_SIZE;
		coordinates.y = graphicalCoordinates.y / CELL_SIZE;
	}
	
	public int getX() {
		return coordinates.x;
	}
	
	public int getY() {
		return coordinates.y;
	}

	public Direction getDirection() {

		return direction;
	}

	public UnitType getType() {

		return type;
	}

	public boolean isHungry() {

		return hungry;
	}

	public boolean isLife() {

		return life;
	}

	public void move(final Pacman goal) {
		prevStep = map.getCell(coordinates);
=======
	private Point			coordinates;
	private UnitType		type;
	private boolean			hungry;
	private Direction		direction;
	private final boolean	life;
	private final MapModel		map;

	public Unit(final MapModel map, final Point coordinates, final UnitType type) {

		this.coordinates = coordinates;
		this.type = type;
		this.map = map;
		hungry = true;
		direction = Direction.SOUTH;
		life = true;
	}

	public Point getCoordinate() {

		return coordinates;
	}
	
	public int getX() {
		return coordinates.x;
	}
	
	public int getY() {
		return coordinates.y;
	}

	public Direction getDirection() {

		return direction;
	}

	public UnitType getType() {

		return type;
	}

	public boolean isHungry() {

		return hungry;
	}

	public boolean isLife() {

		return life;
	}

	public void move(final Pacman goal) {

>>>>>>> refs/heads/dev
		map.move(this, goal);
	}

	public void setCoordinate(final Point coordinate) {

		coordinates = coordinate;
	}

	public void setDirection(final Direction direction) {

		this.direction = direction;
	}

	public void setHungry(final boolean hungry) {

		this.hungry = hungry;
	}

	public void setType(final UnitType type) {

		this.type = type;
	}

}
