/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author 50242
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta="D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/Lexer.flex";
        String ruta2="D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/Sintax.cup" };
        generar(ruta, ruta2, rutaS);
    }
    public static void generar(String ruta, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo= new File(ruta);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/sym.java");
        if (Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        
        Files.move(
                Paths.get("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/sym.java"), 
                Paths.get("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/sym.java")
        );
        
        
        Path rutaSin = Paths.get("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/Sintax.java"), 
                Paths.get("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/src/codigo/Sintax.java")
        );
    }
}
