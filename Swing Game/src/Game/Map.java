package Game;

public class Map {
	
	private Cell[][] cells;

	public Map(Cell[][] cells) {
		this.cells = cells;
	}
	
	public Cell[][] getCells() {
		return this.cells;
	}
	
}
