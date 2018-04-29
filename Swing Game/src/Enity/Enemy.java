package Enity;

import Exception.CellBusyException;
import Game.Cell;

public class Enemy extends Entity {

	public Enemy(Cell cell) throws CellBusyException {
		super("Enemy", "src/Image/enemy.png", cell);
	}
	
}
