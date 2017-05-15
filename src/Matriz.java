import java.util.Vector;
/**
 * Henry Gomez, Carnet No.15703
 */

public class Matriz<T,R> implements InterfazGrafo {
	private Vector vertices = new Vector();
    private int[][] arcos= new int [25][25];
    
    public void MatrizGrafo()
    {
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }
    public void add(Object label) 
    {
        if(!vertices.contains(label))
        {
            vertices.add(label);
        }
            
    }

    public void addEdge(Object vtx1, Object vtx2, Object label)
    {
        int i = vertices.indexOf(vtx1);
        int j = vertices.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        arcos[i][j]=peso;   
       
    }

    public String show() 
    {
        String stringMatriz="";
         for(int i=0;i<vertices.size();i++){
            for(int j=0;j<vertices.size();j++)
            {
                stringMatriz+=""+arcos[i][j]+" \t";
            }
            stringMatriz+="\n";
        }   
        return stringMatriz;
    }

    public Object get(int label) {
       
        return (T)vertices.get(label);
        
    }

    public int getEdge(Object label1, Object label2)
    {
        return arcos[vertices.indexOf(label1)][vertices.indexOf(label2)];
        
    }

    
    public boolean contains(Object label) 
    {
        return vertices.contains(label);
        
    }

   
    public int size()
    {
         return vertices.size();
    }
	

        
}
