import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

	public static final String titre = "Ice Runner";
	public static final int codeMenuPrincipal = 0;
	public static final int codeJeu = 1;
	
	public static AppGameContainer agc;
	
	private MenuPrincipal menuPrincipal = new MenuPrincipal(codeMenuPrincipal,this);
	private Jeu jeu = new Jeu(codeJeu);
	
	public Main(String titre) {
		super(titre);
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(menuPrincipal);
		this.addState(jeu);
		this.enterState(codeMenuPrincipal);
		this.getState(codeMenuPrincipal).init(gc, this);
		this.getState(codeJeu).init(gc, this);
	}
	
	public MenuPrincipal menuPrincipal() {
		return this.menuPrincipal;
	}
	
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new Main(titre), Jeu.largeur, Jeu.hauteur, false).start();
	}
	
}
