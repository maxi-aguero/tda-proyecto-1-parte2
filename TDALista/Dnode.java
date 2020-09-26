package TDALista;
import auxiliar.*;

/**
 * Clase Dnode
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class Dnode<E>implements Position<E>
{
private E elemento;
private Dnode<E> anterior;
private Dnode<E> siguiente;

/** 
	* Crea un nodo con todos sus atributos nulos
 */
public Dnode(){ this(null, null, null);}

/** 
	* Crea un nodo asignandoles un valor a sus atributos 
	* @param elemento El elemento asignado
	* @param anterior El anterior de un Dnode 
	* @param siguiente El siguiente de un Dnode 
	* 
 */
public Dnode(E elemento, Dnode<E> anterior, Dnode<E> siguiente)
{
  this.elemento = elemento;
  this.anterior = anterior;
  this.siguiente = siguiente;
}

/**
	*Devuelve la posicion del nodo anterior
	* @return el Elemento anterior
	*/
public Dnode<E> getAnterior(){ return this.anterior;}

/**
	* Setea un nueva posicion anterior al nodo
	* @param anterior Una nueva posicion anterior 
	*/
public void setAnterior(Dnode<E> anterior){ this.anterior = anterior;}

/**
	*Devuelve la posicion del nodo siguiente
	* @return el Elemento siguiente
	*/
public Dnode<E> getSiguiente(){ return this.siguiente;}

/**
	* Setea un nueva posicion siguiente al nodo
	* @param siguiente Una nueva posicion siguiente 
	*/
public void setSiguiente(Dnode<E> siguiente){ this.siguiente = siguiente;}

/**
	* Setea el elemento del nodo
	* @param elemento El elemento nuevo
	*/
public void setElemento(E elemento){ this.elemento = elemento;}

/**
  * Inspecciona el elemento
  * @return El elemento del nodo
  */
public E element(){ return (E)this.elemento;}

}
