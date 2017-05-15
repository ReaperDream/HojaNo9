/**
 * Henry Gomez, Carnet No.15703
 * Interfaz de grafo Libro Java Structures
*/
public interface InterfazGrafo<T,R> {
	public void add(T label);
   
    public void addEdge(T vtx1, T vtx2, R label);
    
    public String show();

    public T get(int label);
   
    public int getEdge(T label1, T label2);
    
    public boolean contains(T label);
    
    public int size();
    
}
