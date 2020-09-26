package auxiliar;

/**
 * Clase BoundaryViolationException
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class BoundaryViolationException extends Exception {
	
		/**
 		 *     Se crea una excepcion BoundaryViolationException para lanzar cuando: LA posición pasada 
		 * por parámetro es invalida.	
		 * @param msg El mensaje que dispara la excepcion BoundaryViolationException
		 */
	   public BoundaryViolationException (String msg) {super(msg);}
	   
}