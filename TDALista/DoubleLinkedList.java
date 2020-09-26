package TDALista;
import auxiliar.*;
import java.util.Iterator;

/**
 * Clase DoubleLinkedList
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class DoubleLinkedList <E> implements PositionList <E>
{
  private Dnode<E> header;
  private Dnode<E> trailer;
  private int size;
  
  /**
    *Se crea una lista doblemente enlazada con nodos centinelas
    */
  public DoubleLinkedList()
  {
    this.header = new Dnode();
    this.trailer = new Dnode(null, this.header, null);
    this.header.setSiguiente(this.trailer);
  }

  /**
	 * Consulta la cantidad de elementos de la lista.
	 * @return Cantidad de elementos de la lista.
	 */
  public int size(){ return this.size;}

 /**
	 * Consulta si la lista está vacía.
	 * @return Verdadero si la lista está vacía, falso en caso contrario.
	 */
  public boolean isEmpty(){ return this.size == 0;}

  /**
	 * Devuelve la posición del primer elemento de la lista. 
	 * @return Posición del primer elemento de la lista.
	 * @throws EmptyListException si la lista está vacía.
	 */
  public Position<E> first()
    throws EmptyListException
  {
    if (this.size == 0) {
      throw new EmptyListException("lista vacia en metodo first");
    }
    return this.header.getSiguiente();
  }

  /**
	 * Devuelve la posición del último elemento de la lista. 
	 * @return Posición del último elemento de la lista.
	 * @throws EmptyListException si la lista está vacía.
	 */  
  public Position<E> last()
    throws EmptyListException
  {
    if (this.size == 0) {
      throw new EmptyListException("lista vacia en metodo last");
    }
    return this.trailer.getAnterior();
  }
  
 /**
	 * Devuelve la posición del elemento siguiente a la posición pasada por parámetro.
	 * @param p Posición a obtener su elemento siguiente.
	 * @return Posición del elemento siguiente a la posición pasada por parámetro.
	 * @throws InvalidPositionException si el posición pasada por parámetro es inválida o la lista está vacía.
	 * @throws BoundaryViolationException si la posición pasada por parámetro corresponde al último elemento de la lista.
	 */
  public Position<E> next(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException
  {
    Dnode<E> aux = checkposition(p);
    aux = aux.getSiguiente();
    if (aux == this.trailer) {
      throw new BoundaryViolationException("no tiene siguiente en next");
    }
    return aux;
  }

  /**
	  * Devuelve la posición del elemento anterior a la posición pasada por parámetro.
	  * @param p Posición a obtener su elemento anterior.
	  * @return Posición del elemento anterior a la posición pasada por parámetro.
	  * @throws InvalidPositionException si la posición pasada por parámetro es inválida o la lista está vacía.
	  * @throws BoundaryViolationException si la posición pasada por parámetro corresponde al primer elemento de la lista.
	  */
  public Position<E> prev(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException
  {
    Dnode<E> aux = checkposition(p);
    aux = aux.getAnterior();
    if (aux == this.header) {
      throw new BoundaryViolationException("no tiene anterior en prev");
    }
    return aux;
  }
  
  /**
	  * Inserta un elemento al principio de la lista.
	  * @param element Elemento a insertar al principio de la lista.
	  */
  public void addFirst(E element)
  {
    Dnode<E> aux = new Dnode(element, this.header, this.header.getSiguiente());
    this.header.getSiguiente().setAnterior(aux);
    this.header.setSiguiente(aux);
    this.size += 1;
  }
  
  /**
	  * Inserta un elemento al final de la lista.
	  * @param element Elemento a insertar al final de la lista.
	  */
  public void addLast(E element)
  {
    Dnode<E> aux = new Dnode(element, this.trailer.getAnterior(), this.trailer);
    this.trailer.getAnterior().setSiguiente(aux);
    this.trailer.setAnterior(aux);
    this.size += 1;
  }

  /**
	  * Inserta un elemento luego de la posición pasada por parámatro.
	  * @param p Posición en cuya posición siguiente se insertará el elemento pasado por parámetro.
	  * @param element Elemento a insertar luego de la posición pasada como parámetro.
	  * @throws InvalidPositionException si la posición es inválida o la lista está vacía.
	  */  
  public void addAfter(Position<E> p, E element)
    throws InvalidPositionException
  {
    Dnode<E> aux = checkposition(p);
    Dnode<E> nuevo = new Dnode(element, aux, aux.getSiguiente());
    aux.getSiguiente().setAnterior(nuevo);
    aux.setSiguiente(nuevo);
    this.size += 1;
  }

  /**
	  * Inserta un elemento antes de la posición pasada como parámetro.
	  * @param p Posición en cuya posición anterior se insertará el elemento pasado por parámetro. 
	  * @param element Elemento a insertar antes de la posición pasada como parámetro.
	  * @throws InvalidPositionException si la posición es inválida o la lista está vacía.
	  */
  public void addBefore(Position<E> p, E element)
    throws InvalidPositionException
  {
    Dnode<E> aux = checkposition(p);
    Dnode<E> nuevo = new Dnode(element, aux.getAnterior(), aux);
    aux.getAnterior().setSiguiente(nuevo);
    aux.setAnterior(nuevo);
    this.size += 1;
  }
  

  /**
	  * Remueve el elemento que se encuentra en la posición pasada por parámetro.
	  * @param p Posición del elemento a eliminar.
	  * @return element Elemento removido.
	  * @throws InvalidPositionException si la posición es inválida o la lista está vacía.
	  */	
  public E remove(Position<E> p)
    throws InvalidPositionException
  {
    Dnode<E> aeliminar = checkposition(p);
    aeliminar.getSiguiente().setAnterior(aeliminar.getAnterior());
    aeliminar.getAnterior().setSiguiente(aeliminar.getSiguiente());
    this.size -= 1;
    return (E)aeliminar.element();
  }
  
  /**	
	 * Establece el elemento en la posición pasados por parámetro. Reemplaza el elemento que se encontraba anteriormente en esa posición y devuelve el elemento anterior.
	 * @param p Posición a establecer el elemento pasado por parámetro.
	 * @param element Elemento a establecer en la posición pasada por parámetro.
	 * @return Elemento anterior.
	 * @throws InvalidPositionException si la posición es inválida o la lista está vacía.	 
	 */
  public E set(Position<E> p, E element)
    throws InvalidPositionException
  {
    Dnode<E> tochange = checkposition(p);
    E aux = tochange.element();
    tochange.setElemento(element);
    return aux;
  }

  /**
	  * Devuelve un un iterador de todos los elementos de la lista.
	  * @return Un iterador de todos los elementos de la lista.
	  */
  public Iterator<E> iterator() { return new ElementIterator(this); }
  
  /**
	  * Devuelve una colección iterable de posiciones.
	  * @return Una colección iterable de posiciones.
	  */
  public Iterable<Position<E>> positions()
  {
    PositionList<Position<E>> toret = new DoubleLinkedList();
    if (!isEmpty()) {
      try
      {
        Position<E> recorro = first();
        while (recorro != last())
        {
          toret.addLast(recorro);
          recorro = next(recorro);
        }
        toret.addLast(recorro);
      }
      catch (InvalidPositionException|BoundaryViolationException|EmptyListException e)
      {
        e.printStackTrace();
      }
    }
    return toret;
  }
  
  /**
    * Controla que la posición pasada por parámetro sea valida
    */

  private Dnode<E> checkposition(Position<E> p)
    throws InvalidPositionException
  {
    if (p == null) {
      throw new InvalidPositionException("La pocisión es nula");
    }
    if (p == this.header) {
      throw new InvalidPositionException("no se puede eliminar el nodo centinela");
    }
    if (p == this.trailer) {
      throw new InvalidPositionException("no se puede eliminar el nodo centinela");
    }
    if (isEmpty()) {
      throw new InvalidPositionException("La lista esta vacia");
    }
    try
    {
      Dnode<E> temp = (Dnode)p;
      if ((temp.getAnterior() == null) || (temp.getSiguiente() == null)) {
        throw new InvalidPositionException("posicion invalida"); //ver: se cae de la lista
      }
      return temp;
    }
    catch (ClassCastException e)
    {
      throw new InvalidPositionException("La posición es de otro tipo de estructura");
    }
  }
}
