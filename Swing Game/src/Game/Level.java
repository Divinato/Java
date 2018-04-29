package Game;

public class Level {
	
	private String name;
	private Map map;
	
	public Level(String name, Map map) {
		this.name = name;
		this.map = map;
	}

	public String getName() {
		return this.name;
	}

	public Map getMap() {
		return this.map;
	}
	
}
