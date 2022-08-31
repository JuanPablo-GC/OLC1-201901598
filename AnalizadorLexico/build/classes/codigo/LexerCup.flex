package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%column


L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

if |
else |
while {return new Symbol(sym.Reservadas, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}

"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"mod" {return new Symbol(sym.Módulo, yychar, yyline, yytext());}
"potencia" {return new Symbol(sym.Potencia, yychar, yyline, yytext());}


/* variable */
_[a-zA-Z0-9]+_ {return new Symbol(sym.Variable, yychar, yyline, yytext());}
[0-9]+(\.[0-9][0-9]?)? {return new Symbol(sym.Numero, yychar, yyline, yytext());}
\"(.+)*\" {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

"Verdadero" {return new Symbol(sym.Booleano, yychar, yyline, yytext());}
"Falso" {return new Symbol(sym.Booleano, yychar, yyline, yytext());}
'{1}[a-zA-Z]{1}'{1} {return new Symbol(sym.Caracter, yychar, yyline, yytext());}

"inicio" {return new Symbol(sym.Global, yychar, yyline, yytext());}
"fin" {return new Symbol(sym.Global, yychar, yyline, yytext());}


\/\/.+ {return new Symbol(sym.Comentario, yychar, yyline, yytext());}
\/{1}\*{1}(.+(\n|.)+)*\*{1}\/{1} {return new Symbol(sym.ComentarioMultilinea, yychar, yyline, yytext());}

"ingresar" {return new Symbol(sym.Ingresar, yychar, yyline, yytext());}
"como" {return new Symbol(sym.Como, yychar, yyline, yytext());}
"con_valor" {return new Symbol(sym.ConValor, yychar, yyline, yytext());}


"->" {return new Symbol(sym.Asignacion, yychar, yyline, yytext());}
";" {return new Symbol(sym.PuntoComa, yychar, yyline, yytext());}
"," {return new Symbol(sym.Coma, yychar, yyline, yytext());}

"si" {return new Symbol(sym.Si, yychar, yyline, yytext());}
"entonces" {return new Symbol(sym.Entonces, yychar, yyline, yytext());}
"fin_si" {return new Symbol(sym.FinSi, yychar, yyline, yytext());}
"de_lo_contrario" {return new Symbol(sym.DeloContrario, yychar, yyline, yytext());}
o_si {return new Symbol(sym.OSi, yychar, yyline, yytext());}

"segun" {return new Symbol(sym.Segun, yychar, yyline, yytext());}
"hacer" {return new Symbol(sym.Hacer, yychar, yyline, yytext());}
"fin_segun" {return new Symbol(sym.FinSegun, yychar, yyline, yytext());}

/* ciclo for */
"para" {return new Symbol(sym.Para, yychar, yyline, yytext());}
"hasta" {return new Symbol(sym.Hasta, yychar, yyline, yytext());}
"fin_para" {return new Symbol(sym.FinPara, yychar, yyline, yytext());}
"con incremental" {return new Symbol(sym.Incremental, yychar, yyline, yytext());}

/* ciclo mientras*/
"mientras" {return new Symbol(sym.Mientras, yychar, yyline, yytext());}
"fin_mientras" {return new Symbol(sym.FinMientras, yychar, yyline, yytext());}


"repetir" {return new Symbol(sym.Repetir, yychar, yyline, yytext());}
"hasta_que" {return new Symbol(sym.HastaQue, yychar, yyline, yytext());}


/* retornar*/
"retornar" {return new Symbol(sym.Retornar, yychar, yyline, yytext());}


"metodo" {return new Symbol(sym.Metodo, yychar, yyline, yytext());}
"fin_metodo" {return new Symbol(sym.FinMetodo, yychar, yyline, yytext());}
"con_parametros" {return new Symbol(sym.Parametros, yychar, yyline, yytext());}

[a-zA-Z0-9]+\( {return new Symbol(sym.Nombre, yychar, yyline, yytext());}
"funcion" {return new Symbol(sym.Funcion, yychar, yyline, yytext());}
"fin_funcion" {return new Symbol(sym.FinFuncion, yychar, yyline, yytext());}

"ejecutar" {return new Symbol(sym.Ejecutar, yychar, yyline, yytext());}
[a-zA-Z0-9]+\(\) {return new Symbol(sym.LLamada, yychar, yyline, yytext());}

"imprimir" {return new Symbol(sym.Imprimir, yychar, yyline, yytext());}
"imprimir_nl" {return new Symbol(sym.ImprimirSalto, yychar, yyline, yytext());}

[a-zA-Z]{1} {return new Symbol(sym.Letra, yychar, yyline, yytext());}


/* tipo de dato*/
( byte | int | char | long | float | double | string ) {return new Symbol(sym.TipoDato, yychar, yyline, yytext());}

/* Operadores logicos */
( and | or | not) {return new Symbol(sym.OperadorLogico, yychar, yyline, yytext());}


/*Operadores Relacionales */
( "mayor" | "menor" | "mayor_o_igual" | "menor_o_igual" | "es_igual" | "es_diferente" ) {return new Symbol(sym.OperadorRelacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {return new Symbol(sym.OperadorAtribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.OperadorIncremento, yychar, yyline, yytext());}

/* Parentesis etc  */
"(" {return new Symbol(sym.ParentesisA, yychar, yyline, yytext());}
")" {return new Symbol(sym.ParentesisC, yychar, yyline, yytext());}
"{" {return new Symbol(sym.LLaveA, yychar, yyline, yytext());}
"}" {return new Symbol(sym.LLaveC, yychar, yyline, yytext());}


 .| [a-zA-Z0-9]+ {return new Symbol(sym.ERROR, yychar, yyline, yytext());}