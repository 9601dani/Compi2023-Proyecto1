package com.dani;
import java_cup.runtime.Symbol;
import static com.dani.server.ParserJsonSym.*;


%%
%public
%class Lexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup
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
     private Symbol token(int type, Object value) {
      /*System.out.println("encontre : "+value.toString());*/
             return new Symbol(type,  new Token(value.toString(), type,  yycolumn + 1, yyline + 1));
     }

     private Symbol token(int type) {
     /* System.out.println("encontres : "+yytext());*/
             return new Symbol(type,  new Token(yytext(), type, yycolumn + 1, yyline + 1));
     }
       /* private Token token(int type){
            Token tok= new Token(yytext(), type, yycolumn + 1, yyline + 1);
            System.out.printf(tok.toString());
            return tok;
        }*/
//return token(DECIMAL, yytext());

%}
%eofval{
        return token(EOF);
//    return new Token(yytext(), EOF, yycolumn + 1, yyline + 1);
%eofval}
%eofclose
%state RESERVED_WORDS
%state COLORS
%%
<YYINITIAL>{
//     ({digit}*){punto}({digit}* | {numberInteger}+) {return new Token(yytext(), DEC, yycolumn + 1, yyline + 1);}
//     {numberInteger}({digit}*) {return token(NUM, yytext());}
    [{]
      {
          return token(LLAVE_A);
      }
    [}]
      {
          return token(LLAVE_C);
      }
    [:]
      {
          return token(DOS_PUNTOS);
      }
    [;]
      {
          return token(PUNTO_COMA);
      }
    [,]
      {
          return token(COMA);
      }
    [\[]
      {
           return token(L_CORCHETE);
      }
    [\]]
      {
           return token(R_CORCHETE);
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
          return token(ENTERO);
      }
    {decimalNumber}
      {
          return token(DECIMAL);
      }
    {palabra}
      {
          return token(PALABRA);
      }
    [\"]
      {
          yybegin(RESERVED_WORDS);
          return token(COMILLA);
      }
    {whiteSpace}  {/*ignore*/}
    [^]
      {
          return token(ERROR);
      }
}
<RESERVED_WORDS>{
    [\"]
      {
          yybegin(YYINITIAL);
          return token(COMILLA);
      }
    {number}
      {
          return token(ENTERO);
      }
    {decimalNumber}
      {
          return token(DECIMAL);
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
    /*PALABRAS RESERVADAS*/
      {WORLDS}
       {
          return token(WORLDS);
      }
      {WORLD}
      {
          return token(WORLD);
      }
      {ALL}
      {
          return token(ALL);
      }
    {NAME}
      {
          return token(NAME);
      }
    {ROWS}
      {
          return token(ROWS);
      }

    {COLS}
      {
          return token(COLS);
      }
    {CONFIG}
      {
          return token(CONFIG);
      }
    {BOX_COLOR}
      {
          return token(BOX_COLOR);
      }
    {BOX_ON_TARGET_COLOR}
      {
          return token(BOX_ON_TARGET_COLOR);
      }
    {TARGET_COLOR}
      {
          return token(TARGET_COLOR);
      }
    {BRICK_COLOR}
      {
          return token(BRICK_COLOR);
      }
    {HALL_COLOR}
      {
          return token(HALL_COLOR);
      }
    {UNDEFINED_COLOR}
      {
          return token(UNDEFINED_COLOR);
      }
    {PLAYER_COLOR}
      {
          return token(PLAYER_COLOR);
      }
    {BOARD}
      {
          return token(BOARD);
      }
    {POS_X}
      {
          return token(POS_X);
      }
    {POS_Y}
      {
          return token(POS_Y);
      }
    {TYPE}
      {
          return token(TYPE);
      }
    {BRICK}
      {
          return token(BRICK);
      }
    {HALL}
      {
          return token(HALL);
      }
    {BOXES}
      {
          return token(BOXES);
      }
    {TARGETS}
      {
          return token(TARGETS);
      }
    {PLAYER}
      {
          return token(PLAYER);
      }
    [#]
      {
                   yybegin(COLORS);
      }
    {palabra}
      {
          return token(PALABRA);
      }
      [,]
            {
                return token(COMA);
            }
    {whiteSpace}  {/*ignore*/}
    [^]
      {
          return token(ERROR);
      }
}
<COLORS>{
    [\"]
          {
              yybegin(YYINITIAL);
              return token(COMILLA);
          }
    {palabraColor}
          {
              return token(PALABRA_COLOR);
          }
    [^]
          {
              return token(ERROR);
          }
}