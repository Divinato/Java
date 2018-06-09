
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class WindowGame extends BasicGame {
	
    private GameContainer container;
	private Carte carte;
	private Personnage perso;
	private Chrono chrono;
	
	private Image boutonBois;
	
	public static int width = 672+256;
	public static int height = 672;

	public WindowGame() throws SlickException {
        super("IceRunner : Le fun est présent");
        this.chrono = new Chrono();
        this.carte = new Carte(); 
        this.perso = new Personnage(this.carte);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
    	
    	// Initialisation de la fenêtre
    	this.container = container;
    	this.container.setShowFPS(false); 
    	
    	// Initialisation de la carte
        this.carte.init();
        
        // Initialisation du personnage
        this.perso.init();
        
        // Initialisation HUD
        this.boutonBois = new Image("src/ressources/map/hud/button_wood.png");
        
        // Initialisation du chronomètre
        Thread t = new Thread(chrono);
        t.start();
        
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	// Affichage de la carte
    	this.carte.render();
    	// Affichage du chronomètre
    	this.boutonBois.draw(725, 20);
    	g.setColor(Color.black);
    	g.drawString(chrono.toString(),760, 25);
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


    @Override
    public void update(GameContainer container, int delta) throws SlickException {
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
    public void keyReleased(int key, char c) {
    	// Fermeture de la fenêtre
        if (Input.KEY_ESCAPE == key) {
            this.container.exit();
        }
    }
    
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), WindowGame.width, WindowGame.height, false).start();
    }
    
}