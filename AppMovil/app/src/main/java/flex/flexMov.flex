package com.dani.appmovil.objects;
import java_cup.runtime.Symbol;
import static com.dani.appmovil.parserMov.ParserMovSym.*;
/*import static com.dani.appmovil.models.ConstruccionMatriz.*;*/
%%
%public
%class LexerMov
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup
%state COMMENT

UP="up"
DOWN="down"
LEFT="left"
RIGHT="right"
PUSH="push"
FLOOR="FLOOR"
CEIL="CEIL"
SUMA="+"
RESTA="-"
MULTIPLI="*"
DIVISION="/"
numberInteger=[1-9]
cero=[0]
digit=[0-9]
number={numberInteger}({digit}*)
decimalNumber=({digit})+ \. ({digit})+
negativo=-{number}
lineTerminator = \r|\n|\r\n
whiteSpace     = {lineTerminator} | [ \t\f] | " "]
SYM= [&!@¨~!$%\|'¡\?!]+
%{
     private Symbol token(int type, Object value) {
            return new Symbol(type, new Token(value.toString(), type,  yycolumn + 1, yyline + 1));
     }
     private Symbol token(int type) {
             return new Symbol(type, new Token(yytext(), type, yycolumn + 1, yyline + 1));
     }
       /* private Token methodWithToken(int type){
            Token tok= new Token(yytext(), type, yycolumn + 1, yyline + 1);
            System.out.printf(tok.toString());
            return tok;
        }
       */

%}
%eofval{
         return token(EOF);
//    return new Token(yytext(), EOF, yycolumn + 1, yyline + 1);
%eofval}
%eofclose
%%
<YYINITIAL>{
    [#]
      {
            yybegin(COMMENT);
      }
    {DOWN}
      {
          CANTIDAD_DOWN++;
          listMovimientosFinales.add(new MotionArr(DOWN,yyline+1,yycolumn+1,0));
          return token(DOWN);
      }
    {PUSH}
      {
          return token(PUSH);
      }
    {RIGHT}
      {
           listMovimientosFinales.add(new MotionArr(RIGHT,yyline+1,yycolumn+1,0));
          CANTIDAD_RIGHT++;
          return token(RIGHT);
      }
    {LEFT}
      {
           listMovimientosFinales.add(new MotionArr(LEFT,yyline+1,yycolumn+1,0));
          CANTIDAD_LEFT++;
          return token(LEFT);
      }
    {UP}
      {
           listMovimientosFinales.add(new MotionArr(UP,yyline+1,yycolumn+1,0));
          CANTIDAD_UP++;
          return token(UP);
      }
    {FLOOR}
      {
           reportOperaciones.add(new OperacionesMovReport("FLOOR",yyline+1,yycolumn+1));
          return token(FLOOR);
      }
    {CEIL}
      {
           reportOperaciones.add(new OperacionesMovReport("CEIL",yyline+1,yycolumn+1));
          return token(CEIL);
      }
    {number}
      {
          return token(NUM, yytext());
      }
   {decimalNumber}
      {
          return token(DECIMAL, yytext());
      }

   /*simbolos aritmeticos*/
   {RESTA}
      {
           reportOperaciones.add(new OperacionesMovReport("RESTA",yyline+1,yycolumn+1));
          return token(RESTA);
      }
    {DIVISION}
      {
           reportOperaciones.add(new OperacionesMovReport("DIVISION",yyline+1,yycolumn+1));
          return token(DIVISION);
      }
   {MULTIPLI}
      {
           reportOperaciones.add(new OperacionesMovReport("MULTIPLICACION",yyline+1,yycolumn+1));
          return token(MULTIPLICACION);
      }
   {SUMA}
      {
           reportOperaciones.add(new OperacionesMovReport("SUMA",yyline+1,yycolumn+1));
          return token(SUMA);
      }
   [(]
      {
          return token(L_PARENT);
      }
   [)]
      {
          return token(R_PARENT);
      }
   [;]
      {
          return token(PUNTO_COMA);
      }
       {SYM}
                        {
                            return token(SYM);
                        }
   {whiteSpace}  {/*ignore*/}
   [^]
      {
              /*ignore all*/
      }
}
<COMMENT>{
    [\n]
      {
        yybegin(YYINITIAL);
      }
      {DOWN}
            {
                yybegin(YYINITIAL);
                return token(DOWN);
            }
          {PUSH}
            {
           yybegin(YYINITIAL);
                return token(PUSH);
            }
          {RIGHT}
            {
           yybegin(YYINITIAL);
                return token(RIGHT);
            }
          {LEFT}
            {
           yybegin(YYINITIAL);
                return token(LEFT);
            }
          {UP}
            {
           yybegin(YYINITIAL);
                return token(UP);
            }
          {FLOOR}
            {
           yybegin(YYINITIAL);
                return token(FLOOR);
            }
          {CEIL}
            {
           yybegin(YYINITIAL);
                return token(CEIL);
            }
    {whiteSpace}  {/*ignore*/}
    [^]
      {
          /*ignore all*/
      }

}