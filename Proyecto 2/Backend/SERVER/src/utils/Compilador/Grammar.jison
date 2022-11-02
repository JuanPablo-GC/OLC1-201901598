%{

    const {Literal} = require('./Expresiones/Literal');
    const {Print} = require('./Instrucciones/Imprimir');
    
    
%}

%lex
%options case-insensitive
decimal {number}"."{number}
number  [0-9]+

stringsimple     [\'][^']* [\']
stringplantilla  [\`][^`]* [\`]
%s  string 
%%

<INITIAL>["]   {this.begin('string');/*console.log("+entre en el estado string");*/ tmp="";}

<string>[^"\\]      { /*console.log("dentro del estado string: "+yytext);*/  tmp= tmp+yytext;   this.begin('string'); }
<string>[\\][n]     { tmp= tmp+yytext;   this.begin('string'); }
<string>[\\][t]     { tmp= tmp+yytext;   this.begin('string'); }
<string>[\\][r]     { tmp= tmp+yytext;   this.begin('string'); }
<string>[\\]["]     { tmp= tmp+yytext;   this.begin('string'); }
<string>[\\][\\]    { tmp= tmp+yytext;   this.begin('string'); }
<string>[\"]        {
                    //console.log("-saliendo del estado string->" +tmp);
                    this.begin('INITIAL');
                    yytext= tmp;
                    return 'STRING'
                    }




\s+                   /* skip whitespace */
"//".*                              // comentario simple línea
[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/] // comentario multiple líneas

"true"                  return 'true'
"false"                 return 'false'
{decimal}               return 'DECIMAL'
{number}                return 'NUMBER'

{stringsimple}          return 'STRINGG'
{stringplantilla}       return 'STRINGGG'

"**"                    return '**'
"++"                    return '++'
"--"                    return '--'
"+"                     return '+'
"-"                     return '-'
"*"                     return '*'
"/"                     return '/'
"%"                     return '%'
";"                     return ';'
":"                     return ':'
"."                     return '.'
"?"                     return '?'
","                     return ','
"["                     return '['
"]"                     return ']'

"<="                    return '<='
">="                    return '>='
"<"                     return '<'
">"                     return '>'
"=="                    return '=='
"!="                    return '!='
"||"                    return '||'
"&&"                    return '&&'
"!"                     return '!'
"="                     return '='

"("                     return '('
")"                     return ')' 
"{"                     return '{'
"}"                     return '}'
"void"                  return 't_void'
"length"                return 't_length'
"push"                  return 't_push'
"pop"                   return 't_pop'
"array"                 return 't_array'
"if"                    return 't_if'
"else"                  return 't_else'
"while"                 return 't_while'
"const"                 return 't_const'
"number"                return 't_number'
"string"                return 't_string'
"boolean"               return 't_boolean'
"let"                   return 't_let'
"do"                    return 't_do'
"for"                   return 't_for'
"console.log"           return 't_console'
"function"              return 't_function'
"return"                return 't_return'
"graficar_ts"           return 't_graficar_ts'

([a-zA-Z_])[a-zA-Z0-9_ñÑ]*	return 'ID';
<<EOF>>		            return 'EOF'
.      { 
           
    }




/lex

%left '||'
%left '&&'
%left '==', '!='
%left '>=', '<=', '<', '>'
%left '+' '-'
%left '*' '/'
%left '**' '%' 

%right '!'

%start Init

%%

Init    
    : Instructions EOF  {  return $1;  }
;

Instructions
    : Instructions Instruction  { $1.push($2); $$ = $1; }
    | Instruction               { $$ = [$1];            }
;

Instruction
    : BLOQUE                {  $$ = $1;  }
    | CONST             ';' {  $$ = $1;  }
    | LET               ';' {  $$ = $1;  }
    | ASIGNACION        ';' {  $$ = $1;  }
    | INCREDECRE        ';' {  $$ = $1;  }
    | PRINT_ST          ';' {  $$ = $1;  }
    | IF_ST                 {  $$ = $1;  }
    | WHILE_ST              {  $$ = $1;  }
    | FOR                   {  $$ = $1;  }
    | DOWHILE           ';' {  $$ = $1;  }
    | OP_TERNARIO       ';' {  $$ = $1;  }
    | FUNCION               {  $$ = $1;  }
    | CALLFUNCION       ';' {  $$ = $1;  }
    | ARRAY_DECLARACION ';' {  $$ = $1;  }
    | ARRAY_MANEJO      ';' {  $$ = $1;  }
    | GRAFICAR_TS       ';' {  $$ = $1;  } 

    | error            ';'  {  
                                console.log("error sintactico en linea " + (yylineno+1) );
                                //colocar el siguiente codigo en el archivo grammar.js en el= if(!recovering) como penultima instruccion
                                //let s=Singleton.getInstance();
                                //s.add_error(new error("Sintactico", `El caracter ${(this.terminals_[symbol] || symbol)} no se esperaba en esta posicion`, yyloc.last_line, yyloc.last_column+1))                  
                            } 
;

/* --------------------------------------- array instruccion --------------------------------------- */

ARRAY_DECLARACION
    :'t_let' ID ':' TIPOS '[' ']'  '=' '[' CALLFUNCION_PARAMETROS ']'  
    |'t_let' ID ':' TIPOS '[' ']'                                      
    |'t_let' ID ':' TIPOS '[' ']'  '=' '['                        ']'  
;

ARRAY_MANEJO
    : ID '.' 't_push' '(' Expr ')'                        
    | ID '.' 't_pop'  '(' ')'                             
    | ID              '=' '[' CALLFUNCION_PARAMETROS ']'  
    | ID '[' Expr ']' '='  Expr                           
;

/*--------------------------------------- graficar tabla de simbolos --------------------------------------- */

GRAFICAR_TS
    : 't_graficar_ts' '(' ')' 
;

/* --------------------------------------- funcion   -------------------------------------  */




TIPOS
    : t_boolean { $$=$1; }
    | t_string  { $$=$1; }
    | t_number  { $$=$1; }
;


    


/* ---------------------- Operador ternario como instruccion ---------------------- */


/* ---------------------- incremento y decremento como instruction ---------------------- */



/*------------------------  Declaracion de variables (let y const)  -----------------------  */



/*------------------------------    Asignacion de variables  ------------------------------  */


/*---------------------------------   condicionantes    ---------------------------------*/


/* --------------------------------- ciclos --------------------------------- */



/*--------------------------------- bloque de instrucciones ---------------------------------*/

/*---------------------------------  imprimir  -------------------------------------------*/

PRINT_ST 
    : 't_console' '(' Expr ')'  { $$ = new Print($3  , @1.first_line, @1.first_column); }
    | 't_console' '('      ')'  { $$ = new Print(null, @1.first_line, @1.first_column); }
;

/*--------------------------------   Expresion -------------------------------------------*/

Expr 
    : 
    DECIMAL       {  $$ = new Literal($1,                   Type.NUMBER , @1.first_line, @1.first_column); }
    | NUMBER        {  $$ = new Literal($1,                   Type.NUMBER , @1.first_line, @1.first_column); }
    | STRING        {  $$ = new Literal($1.replace(/\"/g,""), Type.STRING , @1.first_line, @1.first_column); }
    | STRINGG       {  $$ = new Literal($1.replace(/\'/g,""), Type.STRING , @1.first_line, @1.first_column); }
    | STRINGGG      {  $$ = new Literal($1.replace(/\`/g,""), Type.STRING , @1.first_line, @1.first_column); }
    | true          {  $$ = new Literal($1,                   Type.BOOLEAN, @1.first_line, @1.first_column); }
    | false         {  $$ = new Literal($1,                   Type.BOOLEAN, @1.first_line, @1.first_column); }


;