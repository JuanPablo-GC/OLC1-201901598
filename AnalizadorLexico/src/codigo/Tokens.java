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
public enum Tokens {
    Reservadas,
    Espacio, 
    
    Igual,
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Módulo,
    Potencia,
    
    Variable,
    Numero,
    Cadena,
    Booleano,
    Caracter,
    
    Global,
    Comentario,
    ComentarioMultilinea,
    Ingresar,
    Como,
    ConValor,

    
    Asignacion,
    PuntoComa,
    Coma,
    
    Si,
    Entonces,
    FinSi,
    DeloContrario,
    OSi,
    
    Segun,
    Hacer,
    FinSegun,
    
    Para,
    Hasta,
    FinPara,
    Incremental,
    
    Mientras,
    FinMientras,
    
    Repetir,
    HastaQue,
    
    Retornar,
    
    Metodo,
    FinMetodo,
    Parametros,

    
    Funcion,
    FinFuncion,
    
    Ejecutar,
    LLamada,
    
    Imprimir,
    ImprimirSalto,
    
    Letra,
    TipoDato,
    
    OperadorLogico,
    OperadorRelacional,
    OperadorAtribucion,
    OperadorIncremento,
    
    
    ParentesisA,
    ParentesisC,
    LLaveA,
    LLaveC,
    CorcheteA,
    CorcheteC,
    
    ERROR
    
}
