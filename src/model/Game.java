package model;

import java.awt.Point;
import java.util.List;

public class Game implements Runnable {
	private static final int	DEFAULT_PACMAN_Y	= 0;
	private static final int	DEFAULT_PACMAN_X	= 0;
	private static final int	DEFAULT_MAP_HEIGHT	= 100;
	private static final int	DEFAULT_MAP_WIDTH	= 100;
	private Map					map;
	private List<Unit>			ghosts;
	private Pacman				pacman;
	public int					MAX_GOLD;

	@Override
	public void run() {

		final Map map = new Map(Game.DEFAULT_MAP_WIDTH, Game.DEFAULT_MAP_HEIGHT);
		pacman = new Pacman(map, new Point(Game.DEFAULT_PACMAN_X, Game.DEFAULT_PACMAN_Y),
				UnitType.PACMAN);

		while (pacman.isLife()) {
			if (pacman.isHungry()) {
				for (Unit ghost : ghosts) {
					ghost.setHungry(false);
				}
			}
			try {
				Thread.sleep(100);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
