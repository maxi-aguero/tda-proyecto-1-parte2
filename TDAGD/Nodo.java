package TDAGD;
import auxiliar.*;
/**
 * Clase Nodo
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */

public class Nodo<V> implements Vertex<V> {
		private V rotulo; 
		private Position<Nodo<V>>pos; 	
	
		public V element() { return rotulo; }
	
		public Nodo( V rotulo ) {this.rotulo = rotulo;}
	
		public V getRotulo() {return rotulo; }

		public void setRotulo(V nuevoRotulo) {rotulo=nuevoRotulo; }
		
		public void	setPosicionVertice(Position<Nodo<V>> p ) { pos=p; }

		
		public Position<Nodo<V>> getPosicionVertice(){ return pos; }
}

