import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Jeu extends BasicGameState {
	
    private GameContainer conteneur;
	private Carte carte;
	private Personnage perso;
	private Chrono chrono;
	private Thread t;
	
	private Image panneau;
	
	private SortHUD sortHUD;
	
	public static int menuLargeur = 256;
	public static int largeur = 672+menuLargeur;
	public static int hauteur = 672;
	
	public Jeu(int ID) {
		this.chrono = new Chrono();
        this.carte = new Carte(); 
        this.perso = new Personnage(this.carte);
        this.sortHUD = new SortHUD(this.perso);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	  	// Initialisation de la fenêtre
    	this.conteneur = gc;
    	this.conteneur.setShowFPS(false); 
    	
    	// Initialisation de la carte
        this.carte.init();
        
        // Initialisation du personnage
        this.perso.init();
        
        // Initialisation HUD
        this.panneau = new Image("src/ressources/map/hud/button_wood.png");
        this.sortHUD.init(gc);
        
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Affichage de la carte
    	this.carte.render();
    	// Affichage du chronomètre
    	this.panneau.draw(725, 20);
    	g.setColor(Color.black);
    	g.drawString(chrono.toString(),760, 25);
    	// Affichage des boutons des sorts
    	this.sortHUD.render(gc, g);
    	// Affichage du personnage
        this.perso.render(g);    
        //quadrillage(g);
        //coordonne(g);
	}
	
	public void quadrillage(Graphics g) {
    	for(int x = 0; x < 672; x+=32) {
    		for(int y = 0; y < 672; y+=32) {
        		g.draw(new Rectangle(x, y, 32, 32));
        	}
    	}  	
    }
    
    public void coordonne(Graphics g) {
    	g.setColor(Color.pink);
    	g.drawString("X : "+this.perso.getX()+", Y : "+this.perso.getY(),680, 75);
    }
    
    public void restart() throws SlickException {
    	this.carte.changeMap("src/ressources/map/test.tmx");
    	start();
    }

    public void start() {
    	// Initialisation du chronomètre
        t = new Thread(chrono);
        t.start();
    }

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		this.perso.update(delta);
	}
	
	@Override
    public void keyPressed(int key, char c) {
    	// Déplacement du personnage
    	if(!this.perso.getMouvement())
        switch (key) {
            case Input.KEY_UP:    this.perso.setDirection(0); this.perso.setMouvement(true); break;
            case Input.KEY_LEFT:  this.perso.setDirection(1); this.perso.setMouvement(true); break;
            case Input.KEY_DOWN:  this.perso.setDirection(2); this.perso.setMouvement(true); break;
            case Input.KEY_RIGHT: this.perso.setDirection(3); this.perso.setMouvement(true); break;
        }
    } 
    
    @Override
    public void mousePressed(int button, int x, int y) {
    	if(this.perso.getSort() == 1 && !this.perso.getMouvement()) {
    		this.carte.setRock(x/32, y/32);
    	}
    	this.perso.setSort(0);
    }

    @Override
    public void keyReleased(int key, char c) {
    	// Fermeture de la fenêtre
        if (Input.KEY_ESCAPE == key) {
            this.conteneur.exit();
        }
    }

	@Override
	public int getID() {
		return 1;
	}
	
}
