package Enity;

import Exception.CellBusyException;
import Game.Cell;

public class Player extends Entity {

	public Player(Cell cell) throws CellBusyException {
		super("Player", "src/Image/cowboy.png", cell);
	}

}
