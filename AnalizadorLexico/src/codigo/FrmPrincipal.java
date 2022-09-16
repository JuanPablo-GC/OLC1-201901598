/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    public ArrayList<String> errores = new ArrayList<String>();
    private void analizarLexico(){
        
        
        //.toLowerCase()
        try {
            String expr= (String) txtAnalizar.getText();
            System.out.println(expr);
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
                        errores.add(lexer.lexeme);
                        break;
                        
                    case Variable: case Numero: case Reservadas:
                        resultado+=lexer.lexeme + ": Es un "+ tokens +"\n";
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
                    case Funcion: case FinFuncion:
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
                    case TipoDato: case OperadorLogico: case OperadorRelacional: case OperadorAtribucion: case OperadorIncremento:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    //para () {}
                    case ParentesisA: case ParentesisC: case LLaveA: case LLaveC: case CorcheteA: case CorcheteC:
                        resultado+= lexer.lexeme + ": Es un "+ tokens +"\n";
                        break;
                        
                    //para espacio, tabulaciones etc 
                    case Linea:
                        resultado+= "*****SALTO DE LINEA*****";
                    //    break;
                    
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnAbrir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizar = new javax.swing.JTextArea();
        btnSintactico = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSintactico = new javax.swing.JTextArea();
        btnGraficar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtErrores = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        btnAbrirArchivo = new javax.swing.JMenuItem();
        btnGuardarContenido = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnErrores = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

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

        btnGraficar.setText("AST");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        jLabel1.setText("ERRORES");

        txtErrores.setEditable(false);
        txtErrores.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );

        jMenu3.setText("ARCHIVO");

        btnAbrirArchivo.setText("ABRIR");
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });
        jMenu3.add(btnAbrirArchivo);

        btnGuardarContenido.setText("GUARDAR COMO");
        btnGuardarContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContenidoActionPerformed(evt);
            }
        });
        jMenu3.add(btnGuardarContenido);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("REPORTES");

        jMenuItem2.setText("DIAGRAMA");
        jMenu4.add(jMenuItem2);

        btnErrores.setText("ERRORES");
        btnErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErroresActionPerformed(evt);
            }
        });
        jMenu4.add(btnErrores);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGraficar)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSintactico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGraficar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
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
            String ST= new String(Files.readAllBytes(archivo2.toPath())).toLowerCase();
            txtAnalizar.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnAbrirActionPerformed
    Sintax s;
    private void btnSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSintacticoActionPerformed
        // TODO add your handling code here:
        
        String ST= txtAnalizar.getText();
        s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        
        s.estado=1;
        try {
            s.parse();
            
            txtSintactico.setText("Analisis Sintactico Correcto");
            txtSintactico.setForeground(Color.blue);
            
            
            
        } catch (Exception ex) {
            
            
            
            Symbol sym = s.getS();
            txtSintactico.setText("Error de Sintaxis    Linea: "+(sym.right+1)+" Columna: "+(sym.left+1)+" Texto: "+ sym.value );
            txtSintactico.setForeground(Color.red);
            
        }
        
        
    }//GEN-LAST:event_btnSintacticoActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        // TODO add your handling code here:
        Nodo raiz = null;
        raiz = s.getRaiz();
        if(raiz != null){
           
            Arbol arbol = new Arbol(raiz);
            arbol.GraficarSintactico();
        }
       
        JOptionPane.showMessageDialog(null, "Arbol Graficado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGraficarActionPerformed

        //boton del panel para abrir el archivo
    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo2 = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try{
            String ST= new String(Files.readAllBytes(archivo2.toPath())).toLowerCase();
            txtAnalizar.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed
    //guarda el contenido del txt en un archivo .olv
    private void btnGuardarContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContenidoActionPerformed
        // TODO add your handling code here:
        guardarContenido();
    }//GEN-LAST:event_btnGuardarContenidoActionPerformed

    private void btnErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErroresActionPerformed
        // TODO add your handling code here:
        VerErrores();
        abrirReporteErrores();
    }//GEN-LAST:event_btnErroresActionPerformed

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
    
    
    
    public void guardarContenido(){
        String contenido= (String) txtAnalizar.getText().toLowerCase();
        JFileChooser fc = new JFileChooser(); 
        int seleccion = fc.showOpenDialog(this);
        if (seleccion ==JFileChooser.APPROVE_OPTION){
            
        }
        
        try {
            //String ruta = "D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/Contenido.txt";

            File file = fc.getSelectedFile();
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            //JOptionPane.showMessageDialog(null, "Archivo guardado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    public void VerErrores(){
        String codigoHTML= "<!DOCTYPE html> \n"
+"<html>\n"
+"<style>\n"
+"table, th, td {\n"
+"  border:1px solid black;\n"
+"}\n"
+"</style>\n"
+"<body>\n"
+"<div style=\"text-align: center;\"> <img src=\"http://www.ingenieria.cunoc.usac.edu.gt/portal/images/logo-usac%20(copia).png\" > \n"
+"</div> \n"
+"<div style=\"text-align: center;\">\n"
+"<h2>Juan Pablo Garcia ceballos</h2>\n"
+"<h2>Carne: 201901598</h2>\n"
+"<h2>Organización de Lenguajes y Compiladores 1</h2>\n"
+"<h2>Proyecto 1</h2>\n"
+"</div>\n"
+"<p style=\"text-align: center;\"><strong> <br /></strong></p>\n"
+"<p style=\"text-align: center;\"><strong> <br /></strong></p>\n"
+"<p style=\"text-align: center;\"><strong> <br /></strong></p>\n"
+"<h1>TABLA DE ERRORES</h1>\n"
+"<table style=\"width:100%\">\n"
+"  <tr>\n"
+"    <th>TIPO DE ERROR</th>\n"
+"    <th>LEXEMA</th>\n"
+"    <th>DESCRIPCION</th>\n"
+"  </tr>\n";
        for (Object lexicos : errores) {
        codigoHTML+=("<tr><td>Lexico</td><td>"+ lexicos+"</td><td>Lexema no definido</td></tr> \n");
        
                
        }
        ArrayList a = s.getErrores();
        for (Object sintacticos : a) {
        codigoHTML+=("<tr><td>Sintactico</td><td>"+ sintacticos+"</td><td>simbolo no esperado</td></tr> \n ");
        }
codigoHTML+= "</table> \n"
+"<p style=\"text-align: center;\"><strong> <br /></strong></p>\n"
+"<p style=\"text-align: center;\"><strong> <br /></strong></p>\n"
+"<p style=\"text-align: center;\"><strong> <br /></strong></p>\n"
+"</body>"
+"</html>";
        int tamañoErrores=errores.size()+ a.size();
        txtErrores.setText(String.valueOf(tamañoErrores));
        errores.clear();
        //System.out.println(codigoHTML);
        
        
        try {
            //String ruta = "D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/Contenido.txt";

            File file = new File("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/errores.html");
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(codigoHTML);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void abrirReporteErrores(){
        try
        {
            File file = new File("D:/Descargas/SEMESTRE 2022/COMPILADORES 1/LAB/AnalizadorLexico/errores.html");
            if(!Desktop.isDesktopSupported())
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists())
                desktop.open(file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JMenuItem btnAbrirArchivo;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JMenuItem btnErrores;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JMenuItem btnGuardarContenido;
    private javax.swing.JButton btnSintactico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizar;
    private javax.swing.JTextField txtErrores;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextArea txtSintactico;
    // End of variables declaration//GEN-END:variables
}
