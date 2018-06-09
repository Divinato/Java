
public class Chrono implements Runnable {

    private long duree;
    private boolean start;
    
    public Chrono() {
    	this.duree=0;
    	this.start = false;
    }
        
    public void stop() {
    	this.start = false;
    }
    
    public long getDuree() {
    	return this.duree;
    }

    
    public String toString() {
    	String h = getHeure() < 10 ? "0" + String.valueOf( getHeure() ) : String.valueOf( getHeure() );
    	String m = getMinute() < 10 ? "0" + String.valueOf( getMinute() ) : String.valueOf( getMinute() );
    	String s = getSeconde() < 10 ? "0" + String.valueOf( getSeconde() ) : String.valueOf( getSeconde() );
    	return h+":"+m+":"+s;
    }
    
    public int getHeure() {
    	return (int) (this.duree / 3600);
    }
    
    public int getMinute() {
    	return (int) ( (this.duree % 3600) / 60 );
    }
    
    public int getSeconde() {
    	return (int) (this.duree % 60);
    }

	@Override
	public void run() {
		this.start = true;
		while(this.start) {			
			if(getHeure() < 99 ) this.duree += 1;
			else this.duree = 0;			
			try {Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
		
}        