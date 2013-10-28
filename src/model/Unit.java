package model;

import java.awt.Point;

public class Unit {
	private Point coordinates;
	private UnitType type;
	private Boolean isHungry;
	private Direction direction;
	private boolean life;
	
	
	
	public Unit(Point coordinates, UnitType type) {

		this.coordinates = coordinates;
		this.type = type;
		isHungry = true;
		direction = Direction.SOUTH;
		life = true;
	}
	
	public boolean isLife() {
		return life;
	}
	
	public Point getCoordinate() {
	
		return coordinates;
	}
	public UnitType getType() {
	
		return type;
	}
	public Boolean getIsHungry() {
	
		return isHungry;
	}
	public Direction getDirection() {
	
		return direction;
	}
	public void setCoordinate(Point coordinate) {
	
		this.coordinates = coordinate;
	}
	public void setType(UnitType type) {
	
		this.type = type;
	}
	public void setIsHungry(Boolean isHungry) {
	
		this.isHungry = isHungry;
	}
	public void setDirection(Direction direction) {
	
		this.direction = direction;
	}
	
	
}
