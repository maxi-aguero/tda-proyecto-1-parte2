package TDAGD;
import TDALista.*;
import static org.junit.Assert.assertTrue;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import auxiliar.*;
/**
 * Clase GrafoD, Grafos implementados con listas de arcos.
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */
public class GrafoD <V,E> implements GraphD<V,E> {

	private PositionList<Nodo<V>> nodos; // vertices
	
	private PositionList<Arco<V,E>> arcos; //arcos
	
	private static Logger logger;
	
	public GrafoD() {
		nodos=new DoubleLinkedList<Nodo<V>>();
		arcos=new DoubleLinkedList<Arco<V,E>>();
		if (logger == null){
			
			logger = Logger.getLogger(GrafoD.class.getName());
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
				
			logger.setLevel(Level.WARNING); //logger.setLevel(Level.INFO);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		
		}
	}	
	
	public void addNode(int node) {
		Nodo<V> nodo_nuevo = new Nodo(node);
	  try {
		if (nodos.isEmpty()) {   			
            nodos.addLast((Nodo<V>)nodo_nuevo);            
			Position<Nodo<V>> posLast = nodos.last();
			logger.info("Se agrego el nodo "+node+" con exito.");
		}
		else {	
			
			boolean esta=false;
			Position<Nodo<V>> pos;			
			pos = nodos.first();
			while(pos!=nodos.last()&&!esta) {
				if (pos.element().getRotulo().equals(node)) {					
					esta=true;
				}
				pos=nodos.next(pos);
			}			
			
			if(!esta&&pos==nodos.last()) {
		    	if (pos.element().getRotulo().equals(node)) {
					esta=true;
				}
		    }			
			
			if (!esta) {
				nodos.addLast(nodo_nuevo);
				logger.info("Se agrego el nodo "+node+" con exito.");
		     }
			else {
				logger.warning("Error: el nodo "+node+" ya estaba en la estructura.");
			}
			
		 }
	  } catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}
	}	
	
	
	public void addEdge(int node1, int node2) {	
	try {	
		if (nodos.isEmpty() )
		    logger.warning("Error: la lista de vertices esta vacia en la estructura.");
		else{
		boolean esta=false;
		Position<Nodo<V>> pos;	
		Position<Nodo<V>> pos_pri;
		pos_pri=nodos.first();
		pos = nodos.first();		
		while(pos!=nodos.last()&&!esta) {
			if (pos.element().getRotulo().equals(node1)) { 				
				esta=true;
				pos_pri=pos;	
			}
			pos=nodos.next(pos);
		}
		
		if(!esta&&pos==nodos.last()) {
	    	if (pos.element().getRotulo().equals(node1)) {
				esta=true;
				pos_pri=pos;
			}
	    }		
		
		if (!esta){				
		    logger.warning("Error: no esta el arco ("+node1+","+node2+") en la estructura.");	
	      }		
		
		boolean esta_segundo=false;		
		Position<Nodo<V>> posseg;
		Position<Nodo<V>> pos_seg;
		pos_seg=nodos.first();
		posseg = nodos.first();		
		while(posseg!=nodos.last()&&!esta_segundo) {
			if (posseg.element().getRotulo().equals(node2)) { 
				esta_segundo=true;
				pos_seg=posseg;				
			}
			posseg=nodos.next(posseg);
		}
		
		if(!esta_segundo&&posseg==nodos.last()) {
	    	if (posseg.element().getRotulo().equals(node2)) {
	    		esta_segundo=true;
				pos_seg=posseg;
			}
	    }		
		
		if (!esta_segundo){
	       	        logger.warning("Error: no esta el arco ("+node1+","+node2+") en la estructura.");

	       }	
		
		if (esta&&esta_segundo)
			{	Position<Arco<V,E>> posarco;
				Nodo<V> pre =  pos_pri.element();
				Nodo<V> succ = pos_seg.element();
				
				if(arcos.isEmpty()){
					Arco<V,E>nuevoarco=new Arco(succ,pre);
					arcos.addLast(nuevoarco);
	       	        logger.info("Se agego con exito el arco ("+node1+","+node2+") en la estructura.");

				}
				else{										
					posarco=arcos.first();
					boolean esta_arco=false;
					while(posarco!=arcos.last()&&!esta_arco) {
						if (posarco.element().getPredecesor().element().equals(pre.element())) { 
							if (posarco.element().getSucesor().element().equals(succ.element())) 
								{esta_arco=true;}
						}
							
						posarco=arcos.next(posarco);
					}
					
					if(!esta_arco&&posarco==arcos.last()) {
						if (posarco.element().getPredecesor().element().equals(pre.element())) { 
							if (posarco.element().getSucesor().element().equals(succ.element()))
								{esta_arco=true;}							
						}
					

					if (esta_arco){ 						
		       	            logger.warning("Error: no se pudo agregar el arco ("+node1+","+node2+") por que ya estaba en la estructura.");
						}
					else {
					    Arco<V,E>nuevoarco=new Arco(succ,pre);
						arcos.addLast(nuevoarco);
		       	        logger.info("Se agego con exito el arco ("+node1+","+node2+") en la estructura.");

					 }

				    }					
					
				}
							
				
				
			}
		
		}

		
	 } catch (EmptyListException | InvalidPositionException | BoundaryViolationException  e) {
			e.printStackTrace();
		}
		
					
	}

	public void removeNode(int node) {		
		if (nodos.isEmpty() )
	        	logger.warning("Error: la lista de vertices esta vacia en la estructura.");
		else
		{
		  try {
			boolean esta=false;		
			Position<Nodo<V>> pos_ennodo;
			Position<Nodo<V>> posicion_aeliminar;		
			pos_ennodo=nodos.first();			
			posicion_aeliminar = nodos.first();	
			while(pos_ennodo!=nodos.last()&&!esta) {
				if (pos_ennodo.element().getRotulo().equals(node)) { 
					esta=true;
					posicion_aeliminar=pos_ennodo;				
				}			
				pos_ennodo=nodos.next(pos_ennodo);
					
			}
			
			if(!esta&&pos_ennodo==nodos.last()) {
		    	if (pos_ennodo.element().getRotulo().equals(node)) {
		    		esta=true;
		    		posicion_aeliminar=pos_ennodo;
				}
		    }
			
			if (!esta)
		       {	 
		        	logger.warning("Error: no esta el vertice "+node+" en la estructura.");
		       }
			else{
				
			 if (arcos.isEmpty()){
		        	logger.warning("Error: lista de arco esta vacia en la estructura.");
			   }
			 
			 else {
				Position<Arco<V, E>> pos = arcos.first();
				boolean marca=false;
				while(pos!=arcos.last()) {
				 	if(pos.element().getSucesor().element().equals(node))
				 	{
				 		arcos.remove(pos);
				 		marca=true;
				 	}
				 	
				 	if (marca==false){
					 	if(pos.element().getPredecesor().element().equals(node))
					 	{
					 		arcos.remove(pos);
					 		marca=true;
					 	}
				 		
				 	}
				 	marca=false;
				 	
				 	pos=arcos.next(pos);
				}
				if (pos==arcos.last())
					{
						if(pos.element().getSucesor().element().equals(node))
					 	{
					 		arcos.remove(pos);
					 		marca=true;
					 	}
						
					 	if (marca==false){
						 	if(pos.element().getPredecesor().element().equals(node))
						 	{
						 		arcos.remove(pos);
						 		marca=true;
						 	}
					 		
					 	}
					 	marca=false;
					}
			 				
				nodos.remove(posicion_aeliminar);
	        	logger.info("Se elimino con exito el vertice "+node+" en la estructura.");

			 	}
			}
			
		  } catch (EmptyListException|InvalidPositionException | BoundaryViolationException e) {	e.printStackTrace();}

		}	
		
		
	}

	
	public void removeEdge(int node1, int node2) {	
		if (arcos.isEmpty())
			{
			logger.warning("Error: no hay arcos para eliminar en la estructura.");
			}
		else {
			try {
				Position<Arco<V, E>> pos = arcos.first();
				Position<Arco<V, E>> pos_aeliminar= arcos.first();
				boolean enc=false;
				while(pos!=arcos.last()&&!enc) {
					    if (pos.element().getPredecesor().element().equals(node1)) {
						 	if(pos.element().getSucesor().element().equals(node2))
						 		{
						 			enc=true;
						 			pos_aeliminar = pos;
						 		}
					    }
						pos=arcos.next(pos);
				}
				if(!enc&&pos==arcos.last()) {
					  if (pos.element().getPredecesor().element().equals(node1)) {
						 	if(pos.element().getSucesor().element().equals(node2))
						 		{
						 			enc=true;
						 			pos_aeliminar = pos;
						 		}
					  }
				} 
				
				
				if (!enc){
					logger.warning("Error: no se ecuentra el arco: ("+node1+","+node2+") en la estructura.");
				}
				else{
						arcos.remove(pos_aeliminar);
						logger.info("Se elimino con exito el arco ("+node1+","+node2+")");	
					}
				
			} catch (InvalidPositionException | BoundaryViolationException|EmptyListException e) {
				e.printStackTrace();
			}
		}
	}
	
		
}	