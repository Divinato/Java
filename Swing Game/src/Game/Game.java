package Game;

import Enity.Player;
import Exception.CellBusyException;
import GUI.Panel;

public class Game {
	
	public static Player player;
	public static int currentLevel = 0;

	private static Level[] levels = new Level[] {
		new Level(
				"Zone de test",
				new Map(
						new Cell[][] {
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS),new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.NULL), new Cell(CellType.NULL), new Cell(CellType.NULL),new Cell(CellType.GRASS), new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.NULL),new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.NULL),new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.GRASS), new Cell(CellType.NULL), new Cell(CellType.NULL),new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS),new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS), new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS) }
						}
				)
		),
		new Level(
				"LOL",
				new Map(
						new Cell[][] {
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
							{ new Cell(CellType.GRASS), new Cell(CellType.GRASS),  new Cell(CellType.GRASS) },
						}
				)
		)
	};
	
	public static void setGame() {
		try {
			player = new Player(levels[currentLevel].getMap().getCells()[5][0]);
		} catch (CellBusyException e) {
			e.printStackTrace();
		}
	}
		
	public static Level getLevel(int index) {
		return levels[index];
	}

	public static void move(Direction direction) {
		
		Cell destination = null;
		int x = 0, y = 0;
		
		for(int i = 0; i < levels[currentLevel].getMap().getCells().length; i++) {		
			for(int j = 0; j < levels[currentLevel].getMap().getCells()[i].length; j++) {	
				if(levels[currentLevel].getMap().getCells()[i][j] == player.getCell()) {
					x = i;
					y = j;
				}
			}
		}
		boolean movePossible = false;
		switch(direction) {
			case NORTH:
				if(y >= 1 && !levels[currentLevel].getMap().getCells()[x][y-1].containsEntity() && levels[currentLevel].getMap().getCells()[x][y-1].getCellType().isWalkable()) {
					destination = levels[currentLevel].getMap().getCells()[x][y-1];
					movePossible = true;
					player.setImage("src/Image/cowboy3.png");
				}
				break;			
			case EAST:
				try {
					if(!levels[currentLevel].getMap().getCells()[x-1][y].containsEntity() && levels[currentLevel].getMap().getCells()[x-1][y].getCellType().isWalkable()) {
						destination = levels[currentLevel].getMap().getCells()[x-1][y];
						movePossible = true;
						player.setImage("src/Image/cowboy2.png");
					}
				} catch(ArrayIndexOutOfBoundsException e) {}
				break;
			case SOUTH:
				if(y < levels[currentLevel].getMap().getCells()[x].length - 1 && !levels[currentLevel].getMap().getCells()[x][y+1].containsEntity() && levels[currentLevel].getMap().getCells()[x][y+1].getCellType().isWalkable()) {
					destination = levels[currentLevel].getMap().getCells()[x][y+1];
					movePossible = true;
					player.setImage("src/Image/cowboy.png");
				}
				break;
			case WEST:
				try {
					if(!levels[currentLevel].getMap().getCells()[x+1][y].containsEntity() && levels[currentLevel].getMap().getCells()[x+1][y].getCellType().isWalkable()) {
						destination = levels[currentLevel].getMap().getCells()[x+1][y];
						movePossible = true;
						player.setImage("src/Image/cowboy4.png");
					}
				} catch(ArrayIndexOutOfBoundsException e) {}
				break;
		}
		
		if(movePossible) {
			player.move(player.getCell(), destination);
			Panel.MainPanel.repaint();
		}
		
	}
	
}
