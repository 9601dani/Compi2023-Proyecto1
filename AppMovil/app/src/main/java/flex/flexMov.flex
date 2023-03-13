package com.dani.appmovil.objects;
import java_cup.runtime.Symbol;
import static com.dani.appmovil.objects.ParserMovSym.*;
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

numberInteger=[1-9]
cero=[0]
digit=[0-9]
number={numberInteger}({digit}*)
decimalNumber=({digit})+ \. ({digit})+
lineTerminator = \r|\n|\r\n
whiteSpace     = {lineTerminator} | [ \t\f] | " "]

%{
     private Symbol token(int type, Object value) {
            return new Symbol(type, new Token(value.toString(), type,  yycolumn + 1, yyline + 1));
     }
     private Symbol token(int type) {
             return new Symbol(type, new Token(null, type, yycolumn + 1, yyline + 1));
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
          return token(DOWN);
      }
    {PUSH}
      {
          return token(PUSH);
      }
    {RIGHT}
      {
          return token(RIGHT);
      }
    {LEFT}
      {
          return token(LEFT);
      }
    {UP}
      {
          return token(UP);
      }
    {FLOOR}
      {
          return token(FLOOR);
      }
    {CEIL}
      {
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
   [-]
      {
          return token(RESTA);
      }
   [/]
      {
          return token(DIVISION);
      }
   [*]
      {
          return token(MULTIPLY);
      }
   [+]
      {
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
    {whiteSpace}  {/*ignore*/}
    [^]
      {
          /*ignore all*/
      }

}