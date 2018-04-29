package Game;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public enum CellType {
	
	NULL("", false),
	GRASS("src/Image/grass.png", true);

	private final BufferedImage image;
	private boolean walkable;

	private CellType(String fileName, boolean walkable) {
		BufferedImage tempImage = null;
		try {
			tempImage = ImageIO.read(new File(fileName));
		} catch (Exception e) {
			tempImage = null;
		}
		this.image = tempImage;
		this.walkable = walkable;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public boolean isWalkable() {
		return this.walkable;
	}
		
}
