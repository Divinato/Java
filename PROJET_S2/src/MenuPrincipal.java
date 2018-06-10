import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuPrincipal extends BasicGameState {
	
	private boolean newGame = false;
	private Main main;
	private int ID;
	
	private BoutonMenu boutonMenu;
	private Image logo;
	
	public MenuPrincipal(int ID, Main main) {
		this.ID = ID;
		this.main = main;
		this.boutonMenu = new BoutonMenu(this);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.boutonMenu.init(gc);
		this.logo = new Image("src/ressources/divers/logo.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		this.boutonMenu.render(gc, g);
		g.drawImage(this.logo, 120, 20);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(this.newGame) {
			sbg.enterState(1);
			this.newGame = false;
			this.main.getJeu().start();
		}
	}
	
	public void startGame() {
		newGame = true;
	}

	@Override
	public int getID() {
		return this.ID;
	}

}
