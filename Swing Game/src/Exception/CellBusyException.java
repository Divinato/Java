package Exception;

public class CellBusyException extends Exception {
	public CellBusyException(){
	    System.out.println("Vous essayez d'instancier une entit�e sur une cellule d�j� occup�e !");
	  }  
}
