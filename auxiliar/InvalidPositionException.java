package auxiliar;

/**
 * Clase InvalidPositionException
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class InvalidPositionException extends Exception {    
	
		/**
 		 *     Se crea una excepcion InvalidPositionException para lanzar cuando: LA posición pasada por parámetro es invalida.	
		* @param msg El mensaje que dispara la excepcion InvalidPositionException
		 */		 
	   public InvalidPositionException (String msg) {super(msg);}
	   
}