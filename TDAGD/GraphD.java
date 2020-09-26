package TDAGD;
/**
 * Interface GraphD para grafos dirigidos no pesado.
 * @author Aguero, Maximiliano C�tedra de Tecnologia de programaci�n, Departamento de Cs. e Ing. de la Computaci�n, UNS.
 */
public interface GraphD<V,E> {
	
	
	/**
	 * Agrega el nodo "node" al grafo, si a�n no pertenec�a a la estructura.
	 * @param node valor entero del nodo.
	 */
	public void addNode(int node);	
	
	/**
	 *Agrega un arco entre el nodo "node1" y el nodo "node2", si a�n no exist�a el arco y ambos par�metros son nodos pertenecientes a la
estructura.
	 * @param node1 valor entero de un nodo.
	 * @param node2 valor entero de un nodo.
	 */
	public void addEdge(int node1, int node2);
	
	public void removeNode(int node);
	
	public void removeEdge(int node1, int node2);

	
	
}