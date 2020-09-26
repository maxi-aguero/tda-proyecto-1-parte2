package TDAGD;
import auxiliar.*;
/**
 * Clase Arco
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class Arco <V,E> implements Edge<E> {
	private Nodo<V>predecesor, sucesor; 
	private Position<Arco<V,E>> pos;// posicionEnListaArco:	
			
	public Arco( Nodo<V> sucesor,Nodo<V> predecesor){ 
	  this.sucesor=sucesor;this.predecesor=predecesor;
	}
	
	public E element() { return (E) (predecesor.element()+","+sucesor.element()); }
	
	public Nodo<V> getPredecesor() {return predecesor;}
	public Nodo<V> getSucesor() { return sucesor; }	
	
	public Position<Arco<V,E>>	getPosicionArco() { return pos; }	
	
	public void setPosicionArco(Position<Arco<V,E>> p) { pos=p;}
}
	
	