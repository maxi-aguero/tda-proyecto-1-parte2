package TDAGD;
/**
 * Clase claseTesterNode
 * @author AgueroMaximiliano Catedra de Tegnologia de Programacion, UNS.
 */
public class TesterGrafoD {

   public static void main(String[] args) {
		GraphD<Integer,Integer> g1= new GrafoD<Integer,Integer>();

		g1.removeEdge(1, 2);
		
		g1.addEdge(3,9);
		
		g1.addNode(5);
		g1.addNode(6);
		g1.addNode(7);
		g1.addNode(8);
		g1.addNode(5);
		
		g1.addEdge(8,6);
		g1.addEdge(6,5);
		g1.addEdge(5,6);
		g1.addEdge(5,6);
		g1.addEdge(6,15);
		g1.addEdge(7,6);	
				
		g1.removeNode(5);
		g1.removeNode(66);
		
		g1.removeEdge(5,6);
		g1.removeEdge(7,6);	
	}

}
