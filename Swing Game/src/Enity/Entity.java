package Enity;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Exception.CellBusyException;
import Game.Cell;

public abstract class Entity {
	
	protected String name;
	protected BufferedImage image;
	protected Cell cell;
	
	public Entity(String name, String fileName, Cell cell) throws CellBusyException {
		if(cell.containsEntity()) throw new CellBusyException();
		this.name = name;
		setImage(fileName);
		this.cell = cell;
		this.cell.setEntity(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public void setImage(String fileName) {
		BufferedImage tempImage = null;
		try {
			tempImage = ImageIO.read(new File(fileName));
		} catch (Exception e) {
			tempImage = null;
		}
		this.image = tempImage;
	}
	
	public Cell getCell() {
		return this.cell;
	}
	
	public void move(Cell arrival, Cell destination) {
		arrival.setEntity(null);
		destination.setEntity(this);
		this.cell = destination;
	}
	
}
