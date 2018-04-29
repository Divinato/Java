package Game;

import Enity.Entity; 

public class Cell {

	private Entity entity;
	private CellType cellType;

	public Cell(CellType cellType) {
		this.cellType = cellType;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity() {
		return this.entity;
	}
	
	public boolean containsEntity() {
		return this.entity != null;
	}
	
	public CellType getCellType() {
		return this.cellType;
	}
	
}
