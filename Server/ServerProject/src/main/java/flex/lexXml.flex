package com.dani;
import java_cup.runtime.Symbol;
import static com.dani.parserXml.ParserXmlSym.*;
%%
%public
%class LexXml
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup
XML="xml"
VERSION="version"
ENCODING="encoding"
WORLDS= "worlds"
WORLD="world"
ALL="all"
NAME="name"
ROWS="rows"
COLS="cols"
CONFIG="config"

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

letter=[a-zA-Z]
digit=[0-9]
number=({digit})+
decimalNumber={number} \. {number}
palabra=[a-zA-Z_][a-zA-z][a-zA-z0-9]*
palabraColor=([a-f0-9]{6} | [a-f0-9]{3})
literal = ({letter})* \- ({number}|{decimalNumber}) | {number} | {decimalNumber}
lineTerminator = \r|\n|\r\n
whiteSpace     = {lineTerminator} | [ \t\f | " "]
SYM= [&!@*¨~!$%_<>\|:'¡\?!·]+
%{
    private Symbol token(int type, Object value) {
     System.out.println("Encontre un: "+ type+" "+value.toString());
            return new Symbol(type, new Token(value.toString(), type,  yycolumn + 1, yyline + 1));
     }
     private Symbol token(int type) {
      System.out.println("Encontre un: "+ yytext()+" "+type);
             return new Symbol(type, new Token(yytext(), type, yycolumn + 1, yyline + 1));
     }
/*
        private Token token(int type){
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
%state LITERALS, COLORS

%%
<YYINITIAL>{
//     ({digit}*){punto}({digit}* | {numberInteger}+) {return new Token(yytext(), DEC, yycolumn + 1, yyline + 1);}
//     {numberInteger}({digit}*) {return token(NUM, yytext());}
[\"]
            {
                  yybegin(LITERALS);
                  return token(SIG_COMILLAS);
            }
    [<]
      {
          return token(SIGNO_A);
      }
    [>]
      {
          return token(SIGNO_C);
      }
    [/]
     {
          return token(DIVISION);
     }

    {number}
      {
          return token(ENTERO);
      }
    {decimalNumber}
      {
          return token(DECIMAL);
      }
          {SYM}
          {
              return token(SYM);
          }
      /*palabras reservadas*/
           {ALL}
          {
                return token(ALL);
          }
          {WORLD}
            {
               return token(WORLD);
            }
           {WORLDS}
            {
                return token(WORLDS);
            }
            {XML}
            {
                return token(XML);
            }
            {ENCODING}
            {
                 return token(ENCODING);
            }
            {VERSION}
            {
                 return token(VERSION);
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
            [=]
            {
                return token(SIG_IGUAL);
            }
            [?]
            {
                return token(INTERROGACION);
            }

           [#]
            {
                         yybegin(COLORS);
            }


          {palabra}
            {
                return token(PALABRA);
            }
          {whiteSpace}  {/*ignore*/}
          [^]
            {
                return token(ERROR);
            }
}
<LITERALS>{
    [\"]
          {
              yybegin(YYINITIAL);
              return token(SIG_COMILLAS);
          }
    {literal}
      {

          return token(LITERAL);
      }
            {SYM}
            {
                return token(SYM);
            }

      {whiteSpace}  {/*ignore*/}

    [^] {return token(ERROR);}
}
<COLORS>{
    [\<]
          {
              yybegin(YYINITIAL);
              return token(SIGNO_A);
          }
    {palabraColor}
          {
              return token(PALABRA);
          }
     {whiteSpace}  {/*ignore*/}
    [^]
          {
              return token(ERROR);
          }
}