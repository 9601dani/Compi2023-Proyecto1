package com.dani.appmovil.Objects;
import com.dani.appmovil.Objects.*;
%%
%public
%class LexerMov
%unicode
%line
%column
%type Token
%state COMMENT
/* %cup */
UP="up"
DOWN="down"
LEFT="left"
RIGHT="right"
PUSH="push"
FLOOR="FLOOR"
CEIL="CEIL"

cero=[0]
digit=[0-9]
number=({digit})+
decimalNumber=({digit})+ \. ({digit})+
lineTerminator = \r|\n|\r\n
whiteSpace     = {lineTerminator} | [ \t\f | " "]

%{
//     private Symbol token(int type, Object value) {
//             return new Symbol(type, return new Token(value, type,  yycolumn + 1, yyline + 1));
//     }
//     private Symbol token(int type) {
//             return new Symbol(type, return new Token(null, type, yycolumn + 1, yyline + 1));
//     }
        private Token methodWithToken(int type){
            Token tok= new Token(yytext(), type, yycolumn + 1, yyline + 1);
            System.out.printf(tok.toString());
            return tok;
        }
//return token(DECIMAL, yytext());

%}
%eofval{
         return methodWithToken(TokenType.EOF);
//    return new Token(yytext(), TokenType.EOF, yycolumn + 1, yyline + 1);
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
          return methodWithToken(TokenType.DOWN);
      }
    {PUSH}
      {
          return methodWithToken(TokenType.PUSH);
      }
    {RIGHT}
      {
          return methodWithToken(TokenType.RIGHT);
      }
    {LEFT}
      {
          return methodWithToken(TokenType.LEFT);
      }
    {UP}
      {
          return methodWithToken(TokenType.UP);
      }
    {FLOOR}
      {
          return methodWithToken(TokenType.FLOOR);
      }
    {CEIL}
      {
          return methodWithToken(TokenType.CEIL);
      }
    {number}
      {
          return methodWithToken(TokenType.NUM);
      }
   {decimalNumber}
      {
          return methodWithToken(TokenType.DECIMAL);
      }
   /*simbolos aritmeticos*/
   [-]
      {
          return methodWithToken(TokenType.RESTA);
      }
   [/]
      {
          return methodWithToken(TokenType.DIVISION);
      }
   [*]
      {
          return methodWithToken(TokenType.MULTIPLY);
      }
   [+]
      {
          return methodWithToken(TokenType.SUMA);
      }
   [(]
      {
          return methodWithToken(TokenType.L_PARENT);
      }
   [)]
      {
          return methodWithToken(TokenType.R_PARENT);
      }
   [;]
      {
          return methodWithToken(TokenType.PUNTO_COMA);
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
    [^]
      {
          /*ignore all*/
      }
    {whiteSpace}  {/*ignore*/}
}