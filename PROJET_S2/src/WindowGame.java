
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class WindowGame extends BasicGame {
	
    private GameContainer container;
	private TiledMap map;
	private Chrono chrono;
	
	private String temps;
	private Image boutonBois;
	
	public static int width = 672+256;
	public static int height = 672;

	public WindowGame() throws SlickException {
        super("IceRunner : Le fun est présent");
        this.chrono = new Chrono();
    }

    @Override
    public void init(GameContainer container) throws SlickException {
    	this.container = container;
    	this.container.setShowFPS(false); 
        this.map = new TiledMap("src/ressources/map/test.tmx"); 
        this.boutonBois = new Image("src/ressources/map/hud/button_wood.png");
        Thread t = new Thread(chrono);
        t.start();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	this.map.render(0, 0);
    	this.boutonBois.draw(725, 20);
    	g.setColor(Color.black);
    	g.drawString(chrono.toString(),760, 25);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }
    
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), WindowGame.width, WindowGame.height, false).start();
    }
    
}