package Exception;

public class CellBusyException extends Exception {
	public CellBusyException(){
	    System.out.println("Vous essayez d'instancier une entitée sur une cellule déjà occupée !");
	  }  
}
