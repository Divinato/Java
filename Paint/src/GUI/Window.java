package GUI;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private int width = 500;
	private int height = 500;
	private String title = "Paint";
	
	private MenuBar menu;
	private Pannel pannel;
	
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
		
		this.menu = new MenuBar();	
		this.setJMenuBar(this.menu);
		
		this.pannel = new Pannel();
		this.add(this.pannel);
		
	}
		
	public static void main(String[] args) {
		Window window = new Window();
	}

}
