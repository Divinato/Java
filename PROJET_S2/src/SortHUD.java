import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class SortHUD implements ComponentListener {

	private static final int SPACE = 5;
	private static final int Y_PADDING = 16; 
	private static final int X_PADDING = 23;

	private MouseOverArea sortTerre;
	private MouseOverArea sortFeu;
	private MouseOverArea sortVent;
	private MouseOverArea sortEau;

	private Personnage perso;

	public SortHUD(Personnage perso) {
		this.perso = perso;
	}

	public void init(GameContainer container) throws SlickException {
		Image buttonImage = new Image("src/ressources/map/hud/button_wood2.png");
		sortTerre = new MouseOverArea(container, buttonImage, 700, container.getHeight() - 400, this);
		sortFeu = new MouseOverArea(container, buttonImage, 700, container.getHeight() - 320, this);
		sortVent = new MouseOverArea(container, buttonImage, 820, container.getHeight() - 400, this);
		sortEau = new MouseOverArea(container, buttonImage, 820, container.getHeight() - 320, this);
	}

	public void render(GameContainer container, Graphics g) {
		
		// Sort terre
		g.setColor(Color.black);		
		if(this.perso.getSort() == 1) g.setColor(new Color(124,82,13));
		
		sortTerre.render(container, g);
		g.drawString("Terre", sortTerre.getX() + X_PADDING, sortTerre.getY() + Y_PADDING);
		
		// Sort feu
		g.setColor(Color.black);
		if(this.perso.getSort() == 2) g.setColor(new Color(217,0,0));
		
		sortFeu.render(container, g);
		g.drawString("Feu", sortFeu.getX() + X_PADDING, sortFeu.getY() + Y_PADDING);
		
		// Sort vent
		g.setColor(Color.black);
		if(this.perso.getSort() == 3) g.setColor(new Color(229,255,219));
		
		sortVent.render(container, g);
		g.drawString("Vent", sortVent.getX() + X_PADDING, sortVent.getY() + Y_PADDING);
		
		// Sort eau
		g.setColor(Color.black);
		if(this.perso.getSort() == 4) g.setColor(new Color(11,132,225));
		
		sortEau.render(container, g);
		g.drawString("Eau", sortEau.getX() + X_PADDING, sortEau.getY() + Y_PADDING);
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == sortTerre) {
			System.out.println("Terre");
			this.perso.setSort(1);
		} else if (source == sortFeu) {
			System.out.println("Feu");
			this.perso.setSort(2);
		} else if (source == sortVent) {
			System.out.println("Vent");
			this.perso.setSort(3);
		} else if (source == sortEau) {
			System.out.println("Eau");
			this.perso.setSort(4);
		}
	}

}
