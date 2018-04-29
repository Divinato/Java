package GUI;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private int width = 1600;
	private int height = 800;
	private String title = "Jeu2D";
	
	private Panel panel;
	
	public Window() {		
		buildComponent();
		createFrame();		
	}
	
	private void createFrame() {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void buildComponent() {		
		this.panel = new Panel();
		this.add(this.panel);	
	}
		
	public static void main(String[] args) {
		Window window = new Window();
	}

}
		
