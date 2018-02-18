package GUI;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() {
		this.setTitle("Paint");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Window window = new Window();
	}

}
