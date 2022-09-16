package codigo;
import static codigo.Tokens.*;
import java.util.ArrayList;
%%
%class Lexer
%type Tokens
%ignorecase 
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r]+
%{
    public String lexeme;
%}
%%

if |
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*ignore*/}

("\n") {lexeme=yytext(); return Linea;}

"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"mod" {lexeme=yytext(); return Módulo;}
"potencia" {lexeme=yytext(); return Potencia;}









/* variable */
_[a-zA-Z0-9_]+_ {lexeme=yytext(); return Variable;}
[0-9]+(\.[0-9]+?)? {lexeme=yytext(); return Numero;}
\"[^\"]*\" {lexeme=yytext(); return Cadena;}

"Verdadero" {lexeme=yytext(); return Booleano;}
"Falso" {lexeme=yytext(); return Booleano;}
'{1}[a-zA-Z]{1}'{1}   {lexeme=yytext(); return Caracter;}
\‘\$\{[4-9][0-9]\}\’   {lexeme=yytext(); return Caracter;}

"inicio" {lexeme=yytext(); return Global;}
"fin" {lexeme=yytext(); return Global;}


\/\/[^\n]*  {lexeme=yytext(); return Comentario;}
\/\*[^*\/]*\*\/ {lexeme=yytext(); return ComentarioMultilinea;}

"ingresar" {lexeme=yytext(); return Ingresar;}
"como" {lexeme=yytext(); return Como;}
"con_valor" {lexeme=yytext(); return ConValor;}


"->" {lexeme=yytext(); return Asignacion;}
";" {lexeme=yytext(); return PuntoComa;}
"," {lexeme=yytext(); return Coma;}

"si" {lexeme=yytext(); return Si;}
"entonces" {lexeme=yytext(); return Entonces;}
"fin_si" {lexeme=yytext(); return FinSi;}
"de_lo_contrario" {lexeme=yytext(); return DeloContrario;}
"o_si" {lexeme=yytext(); return OSi;}

"segun" {lexeme=yytext(); return Segun;}
"hacer" {lexeme=yytext(); return Hacer;}
"fin_segun" {lexeme=yytext(); return FinSegun;}

/* ciclo for */
"para" {lexeme=yytext(); return Para;}
"hasta" {lexeme=yytext(); return Hasta;}
"fin_para" {lexeme=yytext(); return FinPara;}
"con incremental" {lexeme=yytext(); return Incremental;}

/* ciclo mientras*/
"mientras" {lexeme=yytext(); return Mientras;}
"fin_mientras" {lexeme=yytext(); return FinMientras;}


"repetir" {lexeme=yytext(); return Repetir;}
"hasta_que" {lexeme=yytext(); return HastaQue;}


/* retornar*/
"retornar" {lexeme=yytext(); return Retornar;}


"metodo" {lexeme=yytext(); return Metodo;}
"fin_metodo" {lexeme=yytext(); return FinMetodo;}
"con_parametros" {lexeme=yytext(); return Parametros;}


"funcion" {lexeme=yytext(); return Funcion;}
"fin_funcion" {lexeme=yytext(); return FinFuncion;}

"ejecutar" {lexeme=yytext(); return Ejecutar;}
[a-zA-Z0-9]+\(\) {lexeme=yytext(); return LLamada;}

"imprimir" {lexeme=yytext(); return Imprimir;}
"imprimir_nl" {lexeme=yytext(); return ImprimirSalto;}

//[a-zA-Z]{1} {lexeme=yytext(); return Letra;}


/* tipo de dato*/
( byte | numero | caracter | cadena | float | boolean | string ) {lexeme=yytext(); return TipoDato;}

/* Operadores logicos */
( "and" | "or" | "not") {lexeme=yytext(); return OperadorLogico;}

/*Operadores Relacionales */
( "mayor" | "menor" | "mayor_o_igual" | "menor_o_igual" | "es_igual" | "es_diferente") {lexeme = yytext(); return OperadorRelacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return OperadorAtribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return OperadorIncremento;}

/* Parentesis etc  */
"(" {lexeme = yytext(); return ParentesisA;}
")" {lexeme = yytext(); return ParentesisC;}
"{" {lexeme = yytext(); return LLaveA;}
"}" {lexeme = yytext(); return LLaveC;}
"[" {lexeme = yytext(); return CorcheteA;}
"]" {lexeme = yytext(); return CorcheteC;}



 . {lexeme=yytext(); return ERROR;}