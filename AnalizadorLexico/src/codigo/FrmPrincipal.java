/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;

/**
 *
 * @author 50242
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void analizarLexico(){
        
        
        
        try {
            String expr= (String) txtAnalizar.getText();

            Lexer lexer = new Lexer(new StringReader(expr));
            String resultado="";
            while(true){
                Tokens tokens = lexer.yylex();
                if(tokens == null ){
                    resultado+= "FIN";
                    txtResultado.setText(resultado);
                    return; 
                }
                switch (tokens){
                    case ERROR:
                        resultado+= lexer.lexeme +" : ***** Simbolo no definido *****\n";
                        break;
                        
                    case Variable: case Numero: case Reservadas:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    case Cadena:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    case Booleano: case Caracter:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    case Global:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    case Igual: case Suma: case Resta: case Multiplicacion: case Division: case Módulo: case Potencia:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break; 
                    
                    //comentarios 
                    case Comentario: case ComentarioMultilinea:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break; 
                    case Ingresar: case Como: case ConValor:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break; 
                    case Asignacion: case PuntoComa: case Coma:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break; 
                        
                    //condicional si    
                    case Si: case Entonces: case FinSi: case DeloContrario: case OSi:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break; 
                        
                    //selecciones Multiples 
                    case Segun: case Hacer: case FinSegun:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    //para ciclo for
                    case Para: case Hasta: case FinPara: case Incremental:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    
                     //para ciclo mientras
                    case Mientras: case FinMientras:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    //para ciclo repetir hasta
                    case Repetir: case HastaQue:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    //para retornar
                    case Retornar: 
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    
                     //para metodos
                    case Metodo: case FinMetodo: case Parametros:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                            
                        
                    //para funciones 
                    case Funcion: case FinFuncion: case Nombre:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    //para ejecutar funciones
                    case Ejecutar: case LLamada:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;  
                        
                    //para imprimir
                    case Imprimir: case ImprimirSalto:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    //para condicionales i>23 ETC
                    case Letra: case TipoDato: case OperadorLogico: case OperadorRelacional: case OperadorAtribucion: case OperadorIncremento:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    //para () {}
                    case ParentesisA: case ParentesisC: case LLaveA: case LLaveC:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                    default:
                        resultado += "TOKEN: "+ tokens + "*****\n";
                        
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnAbrir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizar = new javax.swing.JTextArea();
        btnSintactico = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSintactico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        btnAbrir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAbrir.setText("Abrir Archivo");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        txtAnalizar.setColumns(20);
        txtAnalizar.setRows(5);
        jScrollPane2.setViewportView(txtAnalizar);

        btnSintactico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSintactico.setText("Sintactico ");
        btnSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSintacticoActionPerformed(evt);
            }
        });

        txtSintactico.setColumns(20);
        txtSintactico.setRows(5);
        jScrollPane3.setViewportView(txtSintactico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnSintactico))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalizar))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(btnSintactico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
        analizarLexico();
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo2 = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try{
            String ST= new String(Files.readAllBytes(archivo2.toPath()));
            txtAnalizar.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSintacticoActionPerformed
        // TODO add your handling code here:
        
        String ST= txtAnalizar.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtSintactico.setText("Analisis Sintactico Correcto");
            txtSintactico.setForeground(Color.blue);
        } catch (Exception ex) {
            
            
            
            Symbol sym = s.getS();
            txtSintactico.setText("Error de Sintaxis    Linea :"+(sym.right+1)+" Columna: "+(sym.left+1)+" Texto: "+ sym.value);
            txtSintactico.setForeground(Color.red);
            
        }
        
    }//GEN-LAST:event_btnSintacticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnSintactico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizar;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextArea txtSintactico;
    // End of variables declaration//GEN-END:variables
}
