%{
    
    const {Literal} = require('./Expresiones/Literal');

    const {Print} = require('./Instrucciones/Print');
    
    
    const { Permanencia}=  require("./Permanencia/Permanencia")
    const { error } =require("./Error/Error")
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
            let s= Permanencia.getInstance()
            s.add_error(new error("Lexico","No se reconoce el caracter "+yytext,yylineno+1,yylloc.first_column+1));
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

     PRINT_ST          ';' {  $$ = $1;  }
    | error            ';'  {  
                                console.log("error sintactico en linea " + (yylineno+1) );
                                //colocar el siguiente codigo en el archivo grammar.js en el= if(!recovering) como penultima instruccion
                                //let s=Singleton.getInstance();
                                //s.add_error(new error("Sintactico", `El caracter ${(this.terminals_[symbol] || symbol)} no se esperaba en esta posicion`, yyloc.last_line, yyloc.last_column+1))                  
                            } 
;


/*---------------------------------  imprimir  -------------------------------------------*/

PRINT_ST 
    : 't_console' '(' Expr ')'  { $$ = new Print($3  , @1.first_line, @1.first_column); }
    | 't_console' '('      ')'  { $$ = new Print(null, @1.first_line, @1.first_column); }
;

/*--------------------------------   Expresion -------------------------------------------*/

Expr :
 
     DECIMAL       {  $$ = new Literal($1,                   Type.NUMBER , @1.first_line, @1.first_column); }
    | NUMBER        {  $$ = new Literal($1,                   Type.NUMBER , @1.first_line, @1.first_column); }
    | STRING        {  $$ = new Literal($1.replace(/\"/g,""), Type.STRING , @1.first_line, @1.first_column); }
    | STRINGG       {  $$ = new Literal($1.replace(/\'/g,""), Type.STRING , @1.first_line, @1.first_column); }
    | STRINGGG      {  $$ = new Literal($1.replace(/\`/g,""), Type.STRING , @1.first_line, @1.first_column); }
    | true          {  $$ = new Literal($1,                   Type.BOOLEAN, @1.first_line, @1.first_column); }
    | false         {  $$ = new Literal($1,                   Type.BOOLEAN, @1.first_line, @1.first_column); }

;