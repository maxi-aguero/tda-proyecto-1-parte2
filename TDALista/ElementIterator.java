package TDALista;
import auxiliar.*;
import java.lang.*; 
import java.util.*; 

/**
 * Clase ElementIterator
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class  ElementIterator<E> implements Iterator <E> {
	protected PositionList<E> list;  // Lista a iterar 
	protected Position<E> cursor;  // Posición del elemento corriente 
	
	/**
	  * Se crear una ED lineal auxiliar que aloja todos los elementos de la colección.
	  * @param l Una lista a itererar
      */
	public ElementIterator (PositionList <E> l ){  
		       list = l;    
		       if (list.isEmpty()) cursor = null;			   
		       else {
				    try {
					      cursor = list.first();
				         } 
				    catch (EmptyListException e) {e.printStackTrace();} 
			      }
     }
	  
	/**
	  *Testea si quedan elementos por visitar en la secuencia. 
	  * @return Verdadero si quedan elementos por visitar, falso en caso contrario
      */	
	public boolean hasNext()  { return cursor != null; }
	
	/**
	  * Devuelve el próximo elemento a visitar en la secuencia. 
	  * @return El próximo elemento 
	  */
	public E next () throws NoSuchElementException{ 
		   if ( cursor == null )   
			   throw new NoSuchElementException ("no tiene siguiente");  
		  
		   E toReturn = cursor.element(); 
		   try {
			   		cursor = (cursor == list.last()) ? null : list.next(cursor);
		        } 
		   catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {e.printStackTrace();}      
		   
		   return toReturn; 
	 } 
	
    /**
	  * Remueve un elementos en la secuencia.
	  * Obs: no se implemeto porque en el proyecto no utilizamos este método.
	  * Solo se definio. 
      */	
	public void remove() {}	
}
