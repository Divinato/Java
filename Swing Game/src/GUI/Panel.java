package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Enity.Entity;
import Game.Game;
import Game.Map;

public class Panel extends JPanel {
	
	public static Panel MainPanel;
	
	public Panel() {
		MainPanel = this;
		addKeyListener(new PanelKeyListener());
		setFocusable(true);
		Game.setGame();
	}
	
	public void paintComponent(Graphics g){	
		drawMap(g, Game.getLevel(Game.currentLevel).getMap());
	}	
	
	public void drawMap(Graphics g, Map map) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		
        int originX = 600, originY = 300;
               
		for(int i = 0; i < map.getCells().length; i++) {			
			int x = originX-(32*i), y = originY+(i*16);			
			for(int j = 0; j < map.getCells()[i].length; j++) {		
				if(map.getCells()[i][j] != null) {
					g.drawImage(map.getCells()[i][j].getCellType().getImage(), x, y, this);				
					if(map.getCells()[i][j].containsEntity()) {
						drawEntity(g,map.getCells()[i][j].getEntity(),x,y,0,-30,64,80);
					}			
				}
				x += 32;
	            y += 16; 	            
			}		
		}
		
	}
	
	public void drawEntity(Graphics g, Entity e, int x, int y, int offsetX, int offsetY, int w, int h) {		
		g.drawImage(e.getImage(), x+offsetX, y+offsetY, w, h, this);
	}
	
}
