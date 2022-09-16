/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author 50242
 */
public class ObjetoError{
    public String tipo;
    public String lexema;
    public String descripcion;
    

    
    public ObjetoError(String tipo, String lexema, String descripcion){
       this.tipo = tipo;
       this.lexema = lexema;
       this.descripcion = descripcion;

    }
}
