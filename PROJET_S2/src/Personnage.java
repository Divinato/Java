
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Personnage {

	private float x = 48f, y = 55f;
	private int direction = 2;
	private boolean enMouvement = false;
	private Animation[] animations = new Animation[8];
	
	private Carte map;
	
	public Personnage(Carte map) {
	    this.map = map;
	}

	public void init() throws SlickException {
		SpriteSheet spriteSheet = new SpriteSheet("src/ressources/map/sprites/character.png", 64, 64);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
	}

	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		Animation animation = new Animation();
		for (int x = startX; x < endX; x++) {
			animation.addFrame(spriteSheet.getSprite(x, y), 100);
		}
		return animation;
	}

	public void render(Graphics g) throws SlickException {
		g.drawAnimation(animations[direction + (enMouvement ? 4 : 0)], x-32, y-60);
	}

	public void update(int delta) {
		if (this.enMouvement) {
			float futurX = getFuturX(delta);
			float futurY = getFuturY(delta);
			boolean collision = this.map.isCollision(futurX, futurY,this.direction);
			if (collision) {
				this.enMouvement = false;
			} else {
				this.x = futurX;
				this.y = futurY;
			}
		}
	}
	
	public boolean getMouvement() {
		return this.enMouvement;
	}
	
	public void setMouvement(boolean enMouvement) {
		this.enMouvement = enMouvement;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}

	private float getFuturX(int delta) {
		float futurX = this.x;
		switch (this.direction) {
		case 1: futurX = this.x - .20f * delta; break;
		case 3: futurX = this.x + .20f * delta; break;
		}
		return futurX;
	}

	private float getFuturY(int delta) {
		float futurY = this.y;
		switch (this.direction) {
		case 0: futurY = this.y - .20f * delta; break;
		case 2: futurY = this.y + .20f * delta; break;
		}
		return futurY;
	}

}