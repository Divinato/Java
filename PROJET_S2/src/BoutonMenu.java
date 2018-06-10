import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class BoutonMenu implements ComponentListener {
	
	private MenuPrincipal menu;

	private static final int SPACE = 5;
	private static final int Y_PADDING = 5; 
	private static final int X_PADDING = 42;

	private MouseOverArea nouveau;
	private MouseOverArea continuer;
	private MouseOverArea aPropos;
	private MouseOverArea quitter;
	
	public BoutonMenu(MenuPrincipal menu) {
		this.menu = menu;
	}

	public void init(GameContainer container) throws SlickException {
		Image buttonImage = new Image("src/ressources/map/hud/button_wood.png");
		int x = (container.getWidth()/2)-(buttonImage.getWidth()/2);
		nouveau = new MouseOverArea(container, buttonImage, x, container.getHeight() - 360, this);
		continuer = new MouseOverArea(container, buttonImage, x, container.getHeight() - 320, this);
		aPropos = new MouseOverArea(container, buttonImage, x, container.getHeight() - 280, this);
		quitter	= new MouseOverArea(container, buttonImage, x, container.getHeight() - 240, this);	
	}

	public void render(GameContainer container, Graphics g) {

		g.setColor(Color.black);		

		// Nouvelle partie
		nouveau.render(container, g);
		g.drawString("Nouveau", nouveau.getX() + X_PADDING, nouveau.getY() + Y_PADDING);

		// Continuer	
		continuer.render(container, g);
		g.drawString("Continuer", continuer.getX() + X_PADDING, continuer.getY() + Y_PADDING);

		// A propos
		aPropos.render(container, g);
		g.drawString("A propos", aPropos.getX() + X_PADDING, aPropos.getY() + Y_PADDING);

		// Quitter
		quitter.render(container, g);
		g.drawString("Quitter", quitter.getX() + X_PADDING, quitter.getY() + Y_PADDING);
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == nouveau) {
			System.out.println("Nouvelle partie");
			this.menu.startGame();
		} else if (source == continuer) {
			System.out.println("Continuer");
		} else if (source == aPropos) {
			System.out.println("A propos");
		} else if (source == quitter) {
			System.out.println("Quitter");
		}
	}

}
