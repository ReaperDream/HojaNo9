import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {

    File archivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
   InterfazGrafo grafo = new Matriz();

    
    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       archivo=new File(direccion); 
    }  
    
    public InterfazGrafo arregloNombres() throws IOException{
    	fileReader = new FileReader (archivo);
    	bufferedReader = new BufferedReader(fileReader);
        String linea;
        while((linea=bufferedReader.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo;
    }
    
    public InterfazGrafo matrizCostos() throws IOException{
    	fileReader = new FileReader (archivo);
    	bufferedReader = new BufferedReader(fileReader);
        String linea;

        while((linea=bufferedReader.readLine())!=null)
        {
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }

}
