package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	private JMenu[] submenu;
	private JMenuItem[][] menuItem;	
	private boolean[][] menuItemSeparator;	
	
	public MenuBar() {
		
		this.submenu = new JMenu[] { 
			new JMenu("Fichier"),
			new JMenu("Edition"),
			new JMenu("Effet"),
			new JMenu("Aide")
		};
		
		this.menuItem = new JMenuItem[][] { 
			{
				
				new JMenuItem("Nouveau"),
				new JMenuItem("Ouvrir"),
				new JMenuItem("Télécharger"),
				new JMenuItem("Enregistrer"),
				new JMenuItem("Enregistrer sous"),
				new JMenuItem("Quitter")
				
			}, {
				
			}, {
				
			}, {
				
				new JMenuItem("Aide"),
				new JMenuItem("A propos")
				
			}
		};
		
		setAction();
		
		this.menuItemSeparator = new boolean[][] { 
			{ false, false, true, false, true, false }, 
			{ }, 
			{ }, 
			{ false, false }
		};
		
		for(int i = 0; i < this.submenu.length; i++) {
			for(int j = 0; j < this.menuItem[i].length; j++) {
				this.submenu[i].add( this.menuItem[i][j] );
				if( this.menuItemSeparator[i][j] ) this.submenu[i].addSeparator();
			}
		}
		
		for(JMenu submenu : this.submenu)
			this.add(submenu);	
		
	}
	
	public void setAction() {
		
		for(int i = 0; i < this.menuItem.length; i++) {
			for(int j = 0; j < this.menuItem[i].length; j++) {
				menuItem[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) { 
						System.out.println(a.getActionCommand());
					}
				});
			}
		}
		
		this.menuItem[0][5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) { 
				System.exit(0); 
			}
		});
		
	}

}
