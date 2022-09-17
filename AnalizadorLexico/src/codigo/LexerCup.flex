package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%public
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%column
%unicode
%ignorecase 


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

{espacio} {/*Ignore*/}

"=" {return new Symbol(sym.Igual, yycolumn, yyline, yytext());}
"+" {return new Symbol(sym.OperadorAritmetico, yycolumn, yyline, yytext());}
"-" {return new Symbol(sym.OperadorAritmetico, yycolumn, yyline, yytext());}
"*" {return new Symbol(sym.OperadorAritmetico, yycolumn, yyline, yytext());}
"/" {return new Symbol(sym.OperadorAritmetico, yycolumn, yyline, yytext());}
"mod" {return new Symbol(sym.OperadorAritmetico, yycolumn, yyline, yytext());}
"potencia" {return new Symbol(sym.Potencia, yycolumn, yyline, yytext());}


/* variable */
_[a-zA-Z0-9_]+_ {return new Symbol(sym.Variable, yycolumn, yyline, yytext());}
[0-9]+(\.[0-9]+)? {return new Symbol(sym.Numero, yycolumn, yyline, yytext());}
\"[^\"]*\" {return new Symbol(sym.Cadena, yycolumn, yyline, yytext());}

"verdadero" {return new Symbol(sym.Booleano1, yycolumn, yyline, yytext());}
"falso" {return new Symbol(sym.Booleano, yycolumn, yyline, yytext());}
'{1}[a-zA-Z]{1}'{1} {return new Symbol(sym.Caracter, yycolumn, yyline, yytext());}
\‘\$\{[4-9][0-9]\}\’ {return new Symbol(sym.Caracter, yycolumn, yyline, yytext());}

"inicio" {return new Symbol(sym.Global, yycolumn, yyline, yytext());}
"fin" {return new Symbol(sym.Global2, yycolumn, yyline, yytext());}

/*Ignore*/
\/\/[^\n]* {/*Ignore*/}
\/\*[^*\/]*\*\/  {/*Ignore*/}

"ingresar" {return new Symbol(sym.Ingresar, yycolumn, yyline, yytext());}
"como" {return new Symbol(sym.Como, yycolumn, yycolumn, yytext());}
"con_valor" {return new Symbol(sym.ConValor, yycolumn, yyline, yytext());}


"->" {return new Symbol(sym.Asignacion, yycolumn, yyline, yytext());}
";" {return new Symbol(sym.PuntoComa, yycolumn, yyline, yytext());}
"," {return new Symbol(sym.Coma, yycolumn, yyline, yytext());}



"si" {return new Symbol(sym.Si, yycolumn, yyline, yytext());}
"entonces" {return new Symbol(sym.Entonces, yycolumn, yyline, yytext());}
"fin_si" {return new Symbol(sym.FinSi, yycolumn, yyline, yytext());}
"de_lo_contrario" {return new Symbol(sym.DeloContrario, yycolumn, yyline, yytext());}
o_si {return new Symbol(sym.OSi, yycolumn, yyline, yytext());}

"segun" {return new Symbol(sym.Segun, yycolumn, yyline, yytext());}
"hacer" {return new Symbol(sym.Hacer, yycolumn, yyline, yytext());}
"fin_segun" {return new Symbol(sym.FinSegun, yycolumn, yyline, yytext());}

/* ciclo for */
"para" {return new Symbol(sym.Para, yycolumn, yyline, yytext());}
"hasta" {return new Symbol(sym.Hasta, yycolumn, yyline, yytext());}
"fin_para" {return new Symbol(sym.FinPara, yycolumn, yyline, yytext());}
"con incremental" {return new Symbol(sym.Incremental, yycolumn, yyline, yytext());}

/* ciclo mientras*/
"mientras" {return new Symbol(sym.Mientras, yycolumn, yyline, yytext());}
"fin_mientras" {return new Symbol(sym.FinMientras, yycolumn, yyline, yytext());}


"repetir" {return new Symbol(sym.Repetir, yycolumn, yyline, yytext());}
"hasta_que" {return new Symbol(sym.HastaQue, yycolumn, yyline, yytext());}


/* retornar*/
"retornar" {return new Symbol(sym.Retornar, yycolumn, yyline, yytext());}


"metodo" {return new Symbol(sym.Metodo, yycolumn, yyline, yytext());}
"fin_metodo" {return new Symbol(sym.FinMetodo, yycolumn, yyline, yytext());}
"con_parametros" {return new Symbol(sym.Parametros, yycolumn, yyline, yytext());}


"funcion" {return new Symbol(sym.Funcion, yycolumn, yyline, yytext());}
"fin_funcion" {return new Symbol(sym.FinFuncion, yycolumn, yyline, yytext());}

"ejecutar" {return new Symbol(sym.Ejecutar, yycolumn, yyline, yytext());}
[a-zA-Z0-9]+\(\) {return new Symbol(sym.LLamada, yycolumn, yyline, yytext());}

"imprimir" {return new Symbol(sym.Imprimir, yycolumn, yyline, yytext());}
"imprimir_nl" {return new Symbol(sym.ImprimirSalto, yycolumn, yyline, yytext());}

//[a-zA-Z]{1} {return new Symbol(sym.Letra, yycolumn, yyline, yytext());}


/* tipo de dato*/
( numero | cadena | boolean | caracter ) {return new Symbol(sym.TipoDato, yycolumn, yyline, yytext());}

/* Operadores logicos */
( and | or ) {return new Symbol(sym.OperadorLogico, yycolumn, yyline, yytext());}
( not) {return new Symbol(sym.Not, yycolumn, yyline, yytext());}


/*Operadores Relacionales */
( "mayor" ) {return new Symbol(sym.OperadorRelacionalM, yycolumn, yyline, yytext());}
( "menor" ) {return new Symbol(sym.OperadorRelacionalMM, yycolumn, yyline, yytext());}
( "mayor_o_igual" ) {return new Symbol(sym.OperadorRelacionalMMM, yycolumn, yyline, yytext());}
( "menor_o_igual" ) {return new Symbol(sym.OperadorRelacionalMMMM, yycolumn, yyline, yytext());}
( "es_igual" ) {return new Symbol(sym.OperadorRelacionalMMMMM, yycolumn, yyline, yytext());}
 ("es_diferente" ) {return new Symbol(sym.OperadorRelacional, yycolumn, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {return new Symbol(sym.OperadorAtribucion, yycolumn, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.OperadorIncremento, yycolumn, yyline, yytext());}

/* Parentesis etc  */
"(" {return new Symbol(sym.ParentesisA, yycolumn, yyline, yytext());}
")" {return new Symbol(sym.ParentesisC, yycolumn, yyline, yytext());}
"{" {return new Symbol(sym.LLaveA, yycolumn, yyline, yytext());}
"}" {return new Symbol(sym.LLaveC, yycolumn, yyline, yytext());}
"[" {return new Symbol(sym.CorcheteA, yycolumn, yyline, yytext());}
"]" {return new Symbol(sym.CorcheteC, yycolumn, yyline, yytext());}


 . {/*Ignore*/}