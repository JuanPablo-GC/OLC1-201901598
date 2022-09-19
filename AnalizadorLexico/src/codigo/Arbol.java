/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author 50242
 */
import java.io.File;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arbol {
    public Nodo raiz;
    
    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }
    
     public void GraficarSintactico(){
        String grafica = "digraph Arbol_Sintactico{\n\n" + GraficaNodos(this.raiz, "0") + "\n\n}";        
        GenerarDot(grafica);

    }
    
    private String GraficaNodos(Nodo nodo, String i){
        int k=0; 
        String r = "";
        String nodoTerm = nodo.token;
        nodoTerm = nodoTerm.replace("\"", "");
        r= "node" + i + "[label = \"" + nodoTerm + "\"];\n";
        
        for(int j =0 ; j<=nodo.hijos.size()-1; j++){
            r = r + "node" + i + " -> node" + i + k + "\n";
            r= r + GraficaNodos(nodo.hijos.get(j), ""+i+k);
            k++;
        }
        
        if( !(nodo.lexema.equals("")) ){
            String nodoToken = nodo.lexema;
            nodoToken = nodoToken.replace("\"", "");
            r += "node" + i + "c[label = \"" + nodoToken + "\"];\n";
            r += "node" + i + " -> node" + i + "c\n";
        }
        
        return r;
    }
    
    private void GenerarDot(String cadena){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try{
            fichero = new FileWriter("Sintactico.dot");
            escritor = new PrintWriter(fichero);
            escritor.println(cadena);
            escritor.close();
            fichero.close();
            //System.out.println(" .dot Generado ");

              
             // La imagen y el .dot se guardan dentro de la carpeta del proyecto
           
            
            //GenerarJpg();
            reportar();
            
        } catch (Exception e) {
            System.out.println("error al generar dot");
            e.printStackTrace();
        }
    }
    
    public void GenerarJpg(){
        GenerarBat();
        Runtime aplicacion = Runtime.getRuntime(); 
        try{
            Thread.sleep(2000);
            aplicacion.exec("Sintactico.bat");
            System.out.println("Ejecuto bat");
            try{ 
                try {
                    Desktop.getDesktop().open(new File("Sintactico.jpg"));
                    //System.out.println("Genero jpg");
                } catch (IOException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
        public void GenerarBat(){
        String fic = "Sintactico.bat";
        String dotPath  = "D:\\Programas\\Graphviz\\bin\\dot.exe";
        String fileInputPath = "Sintactico.dot";
        String fileOutputPath = "Sintactico.jpg";
        String tParam = "-Tjpg";
        String tOParam = "-o";
        
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try{
            fichero = new FileWriter(fic);
            escritor = new PrintWriter(fichero);
            escritor.println("@echo off");
            escritor.println(dotPath + " " + tParam + " " + fileInputPath + " " + tOParam + " " + fileOutputPath);
            escritor.println("exit");
            escritor.close();
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void reportar() throws IOException {
        
        String file_input_path = "Sintactico.dot";
        String do_path = "D:\\Programas\\Graphviz\\bin\\dot.exe";
        
        
        String file_get_path =  "Sintactico.jpg" ;
        try {
            ProcessBuilder pBuilder;
            pBuilder = new ProcessBuilder(do_path, "-Tjpg", "-o", file_get_path, file_input_path);
            pBuilder.redirectErrorStream(true);
            pBuilder.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
     
       Desktop.getDesktop().open(new File(file_get_path));
    }
}
