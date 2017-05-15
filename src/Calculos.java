/**
 * Henry Gomez, Carnet No.15703
 */
import java.io.IOException;

public class Calculos {
	 public Archivo archivo= new Archivo();
	    public InterfazGrafo grafo;
	    public int[][] matriz;
	    public int[] vector;
	    public int centroGrafo;
	    public int minimo=10000;
	    
	    public Calculos(){
	        
	        try {
	            String dir = System.getProperty("user.dir");
	            archivo.obtenerArchivo(dir+"\\cuidades.txt");
	            
	            archivo.arregloNombres();
	            grafo = archivo.matrizCostos();
	            matriz = new int[25][25];
	            vector = new int[25];
	        } 
	        catch (IOException ex) 
	        {
	            ex.printStackTrace();
	        }
	        for(int i=0;i<archivo.grafo.size();i++)
	        {
	            for(int j=0;j<archivo.grafo.size();j++)
	            {
	                matriz[i][j]=0;
	            }
	        }
	    }
	    
	    public String caminoCorto(){
	        String resultado="";
	        for(int k=0;k<archivo.grafo.size();k++){
	            for(int i=0;i<archivo.grafo.size();i++){
	                for(int j=0;j<archivo.grafo.size();j++){
	                    if(grafo.getEdge(archivo.grafo.get(i),archivo.grafo.get(j))>(grafo.getEdge(archivo.grafo.get(i), archivo.grafo.get(k))+grafo.getEdge(archivo.grafo.get(k), archivo.grafo.get(j)))){
	                        grafo.addEdge(archivo.grafo.get(i), archivo.grafo.get(j), (grafo.getEdge(archivo.grafo.get(i), archivo.grafo.get(k))+grafo.getEdge(archivo.grafo.get(k), archivo.grafo.get(j))));
	                        matriz[i][j]=k;
	                    }
	                }
	            }
	        }
	        return resultado=grafo.show();
	    }
	    
	    public String centroGrafo(){
	        String centrografo=null;
	        caminoCorto();
	        int n=0;       
	        for(int i=0;i<grafo.size();i++){
	            for(int j=0;j<grafo.size()-1;j++){
	                int num1=grafo.getEdge(grafo.get(j), grafo.get(i));
	                n=j;
	                n++;
	                int num2=grafo.getEdge(grafo.get(n), grafo.get(i));
	                if(num1>num2){
	                    vector[i]=num1;
	                }
	                else{
	                    vector[i]=num2;
	                }
	            }
	            n++;
	        }
	        
	        
	        for(int i=0;i<grafo.size();i++){
	            int num1=vector[i];
	            if(num1<minimo){
	                centroGrafo=i;
	                minimo=num1;
	            }
	        }
	        return centrografo="\nEl centro del grafo es: "+grafo.get(centroGrafo)+"\n";
	        
	    }
}
