package model;

public enum CellType {
	WALL(0), APPLE(2), CHERRY(3), FLOOR(1);
	private int	value;

	private CellType(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
