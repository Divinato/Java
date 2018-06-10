import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Carte {
	
	private TiledMap tiledMap;
	
	public void init() throws SlickException {
	    this.tiledMap = new TiledMap("src/ressources/map/test.tmx"); 
	}
	
	public void render() {
		this.tiledMap.render(0, 0);
	}
	
	public void changeMap(String file) throws SlickException {
	    this.tiledMap = new TiledMap(file);
	}	
	
	public boolean isCollision(float x, float y, int direction) {
        int tileW = this.tiledMap.getTileWidth();
        int tileH = this.tiledMap.getTileHeight();
        int logicLayer = this.tiledMap.getLayerIndex("logic");
        int xDecalage = 0;
        int yDecalage = 0;
        switch(direction) {
	        case 1: xDecalage = -18; break;
	        case 3: xDecalage = 18; break;
	        case 0: yDecalage = -25; break;
	        case 2: yDecalage = 5; break;
        }
        Image tile = this.tiledMap.getTileImage((int) (x+xDecalage) / tileW, (int) (y+yDecalage) / tileH, logicLayer);
        boolean collision = tile != null;
        if (collision) {
            Color color = tile.getColor((int) x % tileW, (int) y % tileH);
            collision = color.getAlpha() > 0;
        }
        return collision;
    }
	
	public boolean setRock(int x, int y) {
		boolean isPosed = false;
		if(this.tiledMap.getTileId(x, y, 2) == 0) {
			if(this.tiledMap.getTileId(x, y, 1) == 63) {
				this.tiledMap.setTileId(x, y, 2, 19);
				this.tiledMap.setTileId(x, y, 0, 64);
				isPosed = true;
			}
		}
		return isPosed;
	}
	
	public int getObjectCount() {
		return this.tiledMap.getObjectCount(0);
	}
	public String getObjectType(int objectID) {
		return this.tiledMap.getObjectType(0, objectID);
	}
	public float getObjectX(int objectID) {
		return this.tiledMap.getObjectX(0, objectID);
	}
	public float getObjectY(int objectID) {
		return this.tiledMap.getObjectY(0, objectID);
	}
	public float getObjectWidth(int objectID) {
		return this.tiledMap.getObjectWidth(0, objectID);
	}
	public float getObjectHeight(int objectID) {
		return this.tiledMap.getObjectHeight(0, objectID);
	}
	public String getObjectProperty(int objectID, String propertyName, String def) {
		return this.tiledMap.getObjectProperty(0, objectID, propertyName, def);
	}

}
