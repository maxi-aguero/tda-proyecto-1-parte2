package TDAGD;
/**
 * Interface GraphD para grafos dirigidos no pesado.
 * @author Aguero, Maximiliano Cátedra de Tecnologia de programación, Departamento de Cs. e Ing. de la Computación, UNS.
 */
public interface GraphD<V,E> {
	
	
	/**
	 * Agrega el nodo "node" al grafo, si aún no pertenecía a la estructura.
	 * @param node valor entero del nodo.
	 */
	public void addNode(int node);	
	
	/**
	 *Agrega un arco entre el nodo "node1" y el nodo "node2", si aún no existía el arco y ambos parámetros son nodos pertenecientes a la
estructura.
	 * @param node1 valor entero de un nodo.
	 * @param node2 valor entero de un nodo.
	 */
	public void addEdge(int node1, int node2);
	
	public void removeNode(int node);
	
	public void removeEdge(int node1, int node2);

	
	
}