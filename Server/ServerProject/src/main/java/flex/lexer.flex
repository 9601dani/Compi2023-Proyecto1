package com.dani;
import  com.dani.Token;import com.dani.TokenType.*;


%%
%public
%class Lexer
%unicode
%line
%column
%type Token
//%cup
WORLDS= "worlds"
WORLD="world"
ALL="all"
NAME="name"
ROWS="rows"
FLOOR="FLOOR"
CEIL="CEIL"
COLS="cols"
CONFIG="config"/*OPCIONAL*/

BOX_COLOR= "box_color"
BOX_ON_TARGET_COLOR="box_on_target_color"
TARGET_COLOR="target_color"
BRICK_COLOR="brick_color"
HALL_COLOR="hall_color"
UNDEFINED_COLOR="undefined_color"
PLAYER_COLOR="player_color"
BOARD="board"
POS_X="posX"
POS_Y="posY"
TYPE="type"
BRICK="BRICK"
HALL="HALL"
BOXES="boxes"
TARGETS="targets"
PLAYER="player"

cero=[0]
digit=[0-9]
number=({digit})+
decimalNumber=({digit})+ \. ({digit})+
letter=[a-zA-Z]
palabra=[a-zA-Z_][a-zA-z][a-zA-z0-9]*
palabraColor=([a-f0-9]{6} | [a-f0-9]{3})
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
%state RESERVED_WORDS
%state COLORS
%%
<YYINITIAL>{
//     ({digit}*){punto}({digit}* | {numberInteger}+) {return new Token(yytext(), TokenType.DEC, yycolumn + 1, yyline + 1);}
//     {numberInteger}({digit}*) {return token(NUM, yytext());}
    [{]
      {
          return methodWithToken(TokenType.L_LLAVE);
      }
    [}]
      {
          return methodWithToken(TokenType.R_LLAVE);
      }
    [:]
      {
          return methodWithToken(TokenType.DOS_PUNTOS);
      }
    [;]
      {
          return methodWithToken(TokenType.PUNTO_COMA);
      }
    [,]
      {
          return methodWithToken(TokenType.COMA);
      }
    [\[]
      {
           return methodWithToken(TokenType.L_CORCHETE);
      }
    [\]]
      {
           return methodWithToken(TokenType.R_CORCHETE);
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
    {palabra}
      {
          return methodWithToken(TokenType.PALABRA);
      }
    [\"]
      {
          yybegin(RESERVED_WORDS);
      }
    {whiteSpace}  {/*ignore*/}
    [^]
      {
          return methodWithToken(TokenType.ERROR);
      }
}
<RESERVED_WORDS>{
    [\"]
      {
          yybegin(YYINITIAL);
      }
    {number}
      {
          return methodWithToken(TokenType.NUM);
      }
    {decimalNumber}
      {
                return methodWithToken(TokenType.NUM);
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
    /*PALABRAS RESERVADAS*/
    {NAME}
      {
          return methodWithToken(TokenType.NAME);
      }
    {ROWS}
      {
          return methodWithToken(TokenType.ROWS);
      }

    {COLS}
      {
          return methodWithToken(TokenType.COLS);
      }
    {CONFIG}
      {
          return methodWithToken(TokenType.CONFIG);
      }
    {BOX_COLOR}
      {
          return methodWithToken(TokenType.BOX_COLOR);
      }
    {BOX_ON_TARGET_COLOR}
      {
          return methodWithToken(TokenType.BOX_ON_TARGET_COLOR);
      }
    {TARGET_COLOR}
      {
          return methodWithToken(TokenType.TARGET_COLOR);
      }
    {BRICK_COLOR}
      {
          return methodWithToken(TokenType.BRICK_COLOR);
      }
    {HALL_COLOR}
      {
          return methodWithToken(TokenType.HALL_COLOR);
      }
    {UNDEFINED_COLOR}
      {
          return methodWithToken(TokenType.UNDEFINED_COLOR);
      }
    {PLAYER_COLOR}
      {
          return methodWithToken(TokenType.PLAYER_COLOR);
      }
    {BOARD}
      {
          return methodWithToken(TokenType.BOARD);
      }
    {POS_X}
      {
          return methodWithToken(TokenType.POS_X);
      }
    {POS_Y}
      {
          return methodWithToken(TokenType.POS_Y);
      }
    {TYPE}
      {
          return methodWithToken(TokenType.TYPE);
      }
    {BRICK}
      {
          return methodWithToken(TokenType.BRICK);
      }
    {HALL}
      {
          return methodWithToken(TokenType.HALL);
      }
    {BOXES}
      {
          return methodWithToken(TokenType.BOXES);
      }
    {TARGETS}
      {
          return methodWithToken(TokenType.TARGETS);
      }
    {PLAYER}
      {
          return methodWithToken(TokenType.PLAYER);
      }
    [#]
      {
                   yybegin(COLORS);
      }
    {palabra}
      {
          return methodWithToken(TokenType.PALABRA);
      }
    {whiteSpace}  {/*ignore*/}
    [^]
      {
          return methodWithToken(TokenType.ERROR);
      }
}
<COLORS>{
    [\"]
          {
              yybegin(YYINITIAL);
          }
    {palabraColor}
          {
              return methodWithToken(TokenType.PALABRA);
          }
}