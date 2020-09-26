package auxiliar;

/**
 * Clase EmptyListException
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class EmptyListException extends Exception {

	 	/**
 		 * Se crea una excepcion EmptyListException para lanzar cuando una Lista este vacia. 
		* @param msg El mensaje que dispara la excepcion EmptyListException
	 	 */
	   public EmptyListException (String msg) {super(msg);}
	   
}