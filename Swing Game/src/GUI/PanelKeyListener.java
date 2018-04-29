package GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Game.Direction;
import Game.Game;

public class PanelKeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int k = e.getKeyCode();
		
		if(k == KeyEvent.VK_UP) {
			Game.move(Direction.NORTH);
		} else if(k == KeyEvent.VK_RIGHT) {
			Game.move(Direction.EAST);
		} else if(k == KeyEvent.VK_DOWN) {
			Game.move(Direction.SOUTH);
		} else if(k == KeyEvent.VK_LEFT) {
			Game.move(Direction.WEST);
		}
		
		if(k == KeyEvent.VK_SPACE) {
			Game.currentLevel=1;
		}
			
	}
	
	

}
