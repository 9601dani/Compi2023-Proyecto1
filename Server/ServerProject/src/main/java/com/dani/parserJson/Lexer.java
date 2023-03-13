/* The following code was generated by JFlex 1.7.0 */

package com.dani.parserJson;
import com.dani.Token;
import java_cup.runtime.Symbol;
import static com.dani.parserJson.ParserJsonSym.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>lexer.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int RESERVED_WORDS = 2;
  public static final int COLORS = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\53\1\52\1\0\1\53\1\51\22\0\1\53\1\0\1\63"+
    "\1\72\4\0\1\70\1\71\1\66\1\67\1\60\1\64\1\46\1\65"+
    "\1\45\11\45\1\56\1\57\5\0\1\44\1\41\1\17\1\47\1\20"+
    "\1\13\1\47\1\43\1\21\1\47\1\42\1\14\2\47\1\15\2\47"+
    "\1\16\5\47\1\37\1\40\1\47\1\61\1\50\1\62\1\50\1\30"+
    "\1\50\1\7\1\26\1\22\1\5\1\12\1\23\1\25\1\33\1\24"+
    "\1\47\1\32\1\4\1\11\1\10\1\2\1\35\1\47\1\3\1\6"+
    "\1\31\1\34\1\47\1\1\1\27\1\36\1\47\1\54\1\53\1\55"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\4\1\1\2\2\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\14\1\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\0\1\24\3\25"+
    "\1\0\17\25\1\0\2\25\1\26\2\25\1\27\16\25"+
    "\1\30\1\25\1\31\1\25\1\32\1\33\1\34\6\25"+
    "\1\35\2\25\1\36\1\37\2\25\1\40\1\0\1\41"+
    "\1\42\1\25\1\43\1\44\7\25\1\45\1\0\1\46"+
    "\1\47\6\25\1\50\1\30\3\25\1\51\14\25\1\52"+
    "\10\25\1\53\3\25\1\54\4\25\1\55\1\25\1\56"+
    "\5\25\1\57\3\25\1\60";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\73\0\166\0\261\0\354\0\u0127\0\u0162\0\u019d"+
    "\0\u01d8\0\261\0\261\0\261\0\261\0\261\0\261\0\261"+
    "\0\261\0\261\0\u0213\0\u024e\0\u0289\0\u02c4\0\u02ff\0\u033a"+
    "\0\u0375\0\u03b0\0\u03eb\0\u0426\0\u0461\0\u049c\0\261\0\261"+
    "\0\261\0\261\0\261\0\261\0\261\0\261\0\u04d7\0\261"+
    "\0\u0512\0\u054d\0\u0588\0\u05c3\0\u05fe\0\u0639\0\u0674\0\u06af"+
    "\0\u06ea\0\u0725\0\u0760\0\u079b\0\u07d6\0\u0811\0\u084c\0\u0887"+
    "\0\u08c2\0\u08fd\0\u0938\0\u0973\0\u09ae\0\u09e9\0\u05c3\0\u0a24"+
    "\0\u0a5f\0\u0512\0\u0a9a\0\u0ad5\0\u0b10\0\u0b4b\0\u0b86\0\u0bc1"+
    "\0\u0bfc\0\u0c37\0\u0c72\0\u0cad\0\u0ce8\0\u0d23\0\u0d5e\0\u0d99"+
    "\0\u0dd4\0\u0e0f\0\u0512\0\u0e4a\0\u0512\0\u0512\0\u0512\0\u0e85"+
    "\0\u0ec0\0\u0efb\0\u0f36\0\u0f71\0\u0fac\0\u0512\0\u0fe7\0\u1022"+
    "\0\u0512\0\u0512\0\u105d\0\u1098\0\u0512\0\u10d3\0\u0512\0\u110e"+
    "\0\u1149\0\u0512\0\u0512\0\u1184\0\u11bf\0\u11fa\0\u1235\0\u1270"+
    "\0\u12ab\0\u12e6\0\u0512\0\u1321\0\u0512\0\u0512\0\u135c\0\u1397"+
    "\0\u13d2\0\u140d\0\u1448\0\u1483\0\u14be\0\261\0\u14f9\0\u1534"+
    "\0\u156f\0\u0512\0\u15aa\0\u15e5\0\u1620\0\u165b\0\u1696\0\u16d1"+
    "\0\u170c\0\u1747\0\u1782\0\u17bd\0\u17f8\0\u1833\0\u0512\0\u186e"+
    "\0\u18a9\0\u18e4\0\u191f\0\u195a\0\u1995\0\u19d0\0\u1a0b\0\u0512"+
    "\0\u1a46\0\u1a81\0\u1abc\0\u0512\0\u1af7\0\u1b32\0\u1b6d\0\u1ba8"+
    "\0\u0512\0\u1be3\0\u0512\0\u1c1e\0\u1c59\0\u1c94\0\u1ccf\0\u1d0a"+
    "\0\u0512\0\u1d45\0\u1d80\0\u1dbb\0\u0512";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\12\5\1\6\3\5\1\7\25\5\1\10\1\4"+
    "\1\5\1\4\1\11\2\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\10\4\1\23\1\5\1\24"+
    "\3\5\1\25\1\26\11\5\1\27\3\5\1\30\2\5"+
    "\1\31\1\5\1\32\1\33\1\34\3\5\1\35\1\5"+
    "\1\36\1\5\1\10\1\4\1\5\1\4\1\11\2\12"+
    "\4\4\1\17\2\4\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\5\0\1\47\1\0\1\47\2\0"+
    "\1\47\7\0\2\47\2\0\1\47\16\0\1\47\15\0"+
    "\1\50\103\0\44\51\2\0\2\51\10\0\2\51\11\0"+
    "\13\51\1\52\30\51\2\0\2\51\10\0\2\51\11\0"+
    "\17\51\1\53\24\51\2\0\2\51\10\0\2\51\55\0"+
    "\1\10\1\54\76\0\1\12\21\0\1\51\1\55\42\51"+
    "\2\0\2\51\10\0\2\51\11\0\1\51\1\56\42\51"+
    "\2\0\2\51\10\0\2\51\11\0\3\51\1\57\40\51"+
    "\2\0\2\51\10\0\2\51\11\0\6\51\1\60\35\51"+
    "\2\0\2\51\10\0\2\51\11\0\1\51\1\61\42\51"+
    "\2\0\2\51\10\0\2\51\11\0\1\51\1\62\1\63"+
    "\41\51\2\0\2\51\10\0\2\51\11\0\6\51\1\64"+
    "\26\51\1\65\6\51\2\0\2\51\10\0\2\51\11\0"+
    "\6\51\1\66\35\51\2\0\2\51\10\0\2\51\11\0"+
    "\7\51\1\67\34\51\2\0\2\51\10\0\2\51\11\0"+
    "\1\51\1\70\1\51\1\71\40\51\2\0\2\51\10\0"+
    "\2\51\11\0\15\51\1\72\26\51\2\0\2\51\10\0"+
    "\2\51\11\0\43\51\1\73\2\0\2\51\10\0\2\51"+
    "\15\0\1\74\1\0\1\74\2\0\1\74\7\0\2\74"+
    "\2\0\1\74\16\0\1\74\26\0\45\51\1\0\2\51"+
    "\10\0\2\51\11\0\14\51\1\75\30\51\1\0\2\51"+
    "\10\0\2\51\11\0\20\51\1\76\24\51\1\0\2\51"+
    "\10\0\2\51\55\0\1\77\26\0\2\51\1\100\42\51"+
    "\1\0\2\51\10\0\2\51\11\0\1\101\44\51\1\0"+
    "\2\51\10\0\2\51\11\0\3\51\1\102\41\51\1\0"+
    "\2\51\10\0\2\51\11\0\10\51\1\103\34\51\1\0"+
    "\2\51\10\0\2\51\11\0\3\51\1\104\3\51\1\105"+
    "\35\51\1\0\2\51\10\0\2\51\11\0\6\51\1\106"+
    "\17\51\1\107\16\51\1\0\2\51\10\0\2\51\11\0"+
    "\23\51\1\110\21\51\1\0\2\51\10\0\2\51\11\0"+
    "\2\51\1\111\42\51\1\0\2\51\10\0\2\51\11\0"+
    "\34\51\1\112\10\51\1\0\2\51\10\0\2\51\11\0"+
    "\3\51\1\113\41\51\1\0\2\51\10\0\2\51\11\0"+
    "\4\51\1\114\40\51\1\0\2\51\10\0\2\51\11\0"+
    "\5\51\1\115\37\51\1\0\2\51\10\0\2\51\11\0"+
    "\6\51\1\116\36\51\1\0\2\51\10\0\2\51\11\0"+
    "\20\51\1\117\24\51\1\0\2\51\10\0\2\51\11\0"+
    "\13\51\1\120\31\51\1\0\2\51\10\0\2\51\15\0"+
    "\1\121\1\0\1\121\2\0\1\121\7\0\2\121\2\0"+
    "\1\121\16\0\1\121\26\0\14\51\1\122\30\51\1\0"+
    "\2\51\10\0\2\51\11\0\13\51\1\123\31\51\1\0"+
    "\2\51\10\0\2\51\11\0\3\51\1\124\41\51\1\0"+
    "\2\51\10\0\2\51\11\0\5\51\1\125\37\51\1\0"+
    "\2\51\10\0\2\51\11\0\11\51\1\126\33\51\1\0"+
    "\2\51\10\0\2\51\11\0\5\51\1\127\37\51\1\0"+
    "\2\51\10\0\2\51\11\0\22\51\1\130\22\51\1\0"+
    "\2\51\10\0\2\51\11\0\2\51\1\131\42\51\1\0"+
    "\2\51\10\0\2\51\11\0\11\51\1\132\15\51\1\133"+
    "\15\51\1\0\2\51\10\0\2\51\11\0\21\51\1\134"+
    "\23\51\1\0\2\51\10\0\2\51\11\0\24\51\1\135"+
    "\20\51\1\0\2\51\10\0\2\51\11\0\11\51\1\136"+
    "\33\51\1\0\2\51\10\0\2\51\11\0\3\51\1\137"+
    "\41\51\1\0\2\51\10\0\2\51\11\0\11\51\1\140"+
    "\33\51\1\0\2\51\10\0\2\51\11\0\36\51\1\141"+
    "\1\142\5\51\1\0\2\51\10\0\2\51\11\0\35\51"+
    "\1\143\7\51\1\0\2\51\10\0\2\51\11\0\16\51"+
    "\1\144\26\51\1\0\2\51\10\0\2\51\11\0\13\51"+
    "\1\145\31\51\1\0\2\51\10\0\2\51\15\0\1\146"+
    "\1\0\1\146\2\0\1\146\7\0\2\146\2\0\1\146"+
    "\16\0\1\146\26\0\15\51\1\147\27\51\1\0\2\51"+
    "\10\0\2\51\11\0\4\51\1\150\40\51\1\0\2\51"+
    "\10\0\2\51\11\0\23\51\1\151\21\51\1\0\2\51"+
    "\10\0\2\51\11\0\4\51\1\152\40\51\1\0\2\51"+
    "\10\0\2\51\11\0\5\51\1\153\37\51\1\0\2\51"+
    "\10\0\2\51\11\0\1\51\1\154\17\51\1\155\23\51"+
    "\1\0\2\51\10\0\2\51\11\0\31\51\1\156\13\51"+
    "\1\0\2\51\10\0\2\51\11\0\11\51\1\157\33\51"+
    "\1\0\2\51\10\0\2\51\11\0\27\51\1\160\15\51"+
    "\1\0\2\51\10\0\2\51\11\0\22\51\1\161\22\51"+
    "\1\0\2\51\10\0\2\51\11\0\11\51\1\162\33\51"+
    "\1\0\2\51\10\0\2\51\11\0\41\51\1\163\3\51"+
    "\1\0\2\51\10\0\2\51\15\0\1\164\1\0\1\164"+
    "\2\0\1\164\7\0\2\164\2\0\1\164\16\0\1\164"+
    "\26\0\5\51\1\165\37\51\1\0\2\51\10\0\2\51"+
    "\11\0\24\51\1\166\20\51\1\0\2\51\10\0\2\51"+
    "\11\0\7\51\1\167\35\51\1\0\2\51\10\0\2\51"+
    "\11\0\1\51\1\170\43\51\1\0\2\51\10\0\2\51"+
    "\11\0\27\51\1\171\15\51\1\0\2\51\10\0\2\51"+
    "\11\0\30\51\1\172\14\51\1\0\2\51\10\0\2\51"+
    "\11\0\21\51\1\173\23\51\1\0\2\51\10\0\2\51"+
    "\11\0\23\51\1\174\21\51\1\0\2\51\10\0\2\51"+
    "\11\0\2\51\1\175\42\51\1\0\2\51\10\0\2\51"+
    "\15\0\1\176\1\0\1\176\2\0\1\176\7\0\2\176"+
    "\2\0\1\176\16\0\1\176\26\0\27\51\1\177\15\51"+
    "\1\0\2\51\10\0\2\51\11\0\3\51\1\200\41\51"+
    "\1\0\2\51\10\0\2\51\11\0\21\51\1\201\23\51"+
    "\1\0\2\51\10\0\2\51\11\0\5\51\1\202\21\51"+
    "\1\203\15\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\204\43\51\1\0\2\51\10\0\2\51\11\0\7\51"+
    "\1\205\35\51\1\0\2\51\10\0\2\51\11\0\27\51"+
    "\1\206\15\51\1\0\2\51\10\0\2\51\11\0\30\51"+
    "\1\207\14\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\210\43\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\211\43\51\1\0\2\51\10\0\2\51\11\0\21\51"+
    "\1\212\23\51\1\0\2\51\10\0\2\51\11\0\3\51"+
    "\1\213\41\51\1\0\2\51\10\0\2\51\11\0\11\51"+
    "\1\214\33\51\1\0\2\51\10\0\2\51\11\0\21\51"+
    "\1\215\23\51\1\0\2\51\10\0\2\51\11\0\6\51"+
    "\1\216\36\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\217\42\51\1\0\2\51\10\0\2\51\11\0\3\51"+
    "\1\220\41\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\221\43\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\222\43\51\1\0\2\51\10\0\2\51\11\0\4\51"+
    "\1\223\40\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\224\43\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\225\42\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\226\43\51\1\0\2\51\10\0\2\51\11\0\3\51"+
    "\1\227\41\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\230\42\51\1\0\2\51\10\0\2\51\11\0\27\51"+
    "\1\231\15\51\1\0\2\51\10\0\2\51\11\0\3\51"+
    "\1\232\41\51\1\0\2\51\10\0\2\51\11\0\24\51"+
    "\1\233\20\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\234\42\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\235\43\51\1\0\2\51\10\0\2\51\11\0\21\51"+
    "\1\236\23\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\237\43\51\1\0\2\51\10\0\2\51\11\0\11\51"+
    "\1\240\33\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\241\42\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\242\43\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\243\42\51\1\0\2\51\10\0\2\51\11\0\30\51"+
    "\1\244\14\51\1\0\2\51\10\0\2\51\11\0\3\51"+
    "\1\245\41\51\1\0\2\51\10\0\2\51\11\0\27\51"+
    "\1\246\15\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\247\43\51\1\0\2\51\10\0\2\51\11\0\21\51"+
    "\1\250\23\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\251\42\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\252\43\51\1\0\2\51\10\0\2\51\11\0\3\51"+
    "\1\253\41\51\1\0\2\51\10\0\2\51\11\0\1\51"+
    "\1\254\43\51\1\0\2\51\10\0\2\51\11\0\2\51"+
    "\1\255\42\51\1\0\2\51\10\0\2\51\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7670];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\5\1\11\11\14\1\10\11\1\0\1\11"+
    "\3\1\1\0\17\1\1\0\51\1\1\0\15\1\1\0"+
    "\11\1\1\11\57\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
     private Symbol token(int type, Object value) {
      System.out.println("encontre : "+value.toString());
             return new Symbol(type,  new Token(value.toString(), type,  yycolumn + 1, yyline + 1));
     }

     private Symbol token(int type) {
      System.out.println("encontres : "+yytext());
             return new Symbol(type,  new Token(yytext(), type, yycolumn + 1, yyline + 1));
     }
       /* private Token token(int type){
            Token tok= new Token(yytext(), type, yycolumn + 1, yyline + 1);
            System.out.printf(tok.toString());
            return tok;
        }*/
//return token(DECIMAL, yytext());



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 194) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {         return token(EOF);
//    return new Token(yytext(), EOF, yycolumn + 1, yyline + 1);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return token(ERROR);
            } 
            // fall through
          case 49: break;
          case 2: 
            { return token(ENTERO);
            } 
            // fall through
          case 50: break;
          case 3: 
            { /*ignore*/
            } 
            // fall through
          case 51: break;
          case 4: 
            { return token(LLAVE_A);
            } 
            // fall through
          case 52: break;
          case 5: 
            { return token(LLAVE_C);
            } 
            // fall through
          case 53: break;
          case 6: 
            { return token(DOS_PUNTOS);
            } 
            // fall through
          case 54: break;
          case 7: 
            { return token(PUNTO_COMA);
            } 
            // fall through
          case 55: break;
          case 8: 
            { return token(COMA);
            } 
            // fall through
          case 56: break;
          case 9: 
            { return token(L_CORCHETE);
            } 
            // fall through
          case 57: break;
          case 10: 
            { return token(R_CORCHETE);
            } 
            // fall through
          case 58: break;
          case 11: 
            { yybegin(RESERVED_WORDS);
          return token(COMILLA);
            } 
            // fall through
          case 59: break;
          case 12: 
            { yybegin(YYINITIAL);
          return token(COMILLA);
            } 
            // fall through
          case 60: break;
          case 13: 
            { return token(RESTA);
            } 
            // fall through
          case 61: break;
          case 14: 
            { return token(DIVISION);
            } 
            // fall through
          case 62: break;
          case 15: 
            { return token(MULTIPLY);
            } 
            // fall through
          case 63: break;
          case 16: 
            { return token(SUMA);
            } 
            // fall through
          case 64: break;
          case 17: 
            { return token(L_PARENT);
            } 
            // fall through
          case 65: break;
          case 18: 
            { return token(R_PARENT);
            } 
            // fall through
          case 66: break;
          case 19: 
            { yybegin(COLORS);
            } 
            // fall through
          case 67: break;
          case 20: 
            { yybegin(YYINITIAL);
              return token(COMILLA);
            } 
            // fall through
          case 68: break;
          case 21: 
            { return token(PALABRA);
            } 
            // fall through
          case 69: break;
          case 22: 
            { return token(DECIMAL);
            } 
            // fall through
          case 70: break;
          case 23: 
            { return token(ALL);
            } 
            // fall through
          case 71: break;
          case 24: 
            { return token(PALABRA_COLOR);
            } 
            // fall through
          case 72: break;
          case 25: 
            { return token(CEIL);
            } 
            // fall through
          case 73: break;
          case 26: 
            { return token(ROWS);
            } 
            // fall through
          case 74: break;
          case 27: 
            { return token(NAME);
            } 
            // fall through
          case 75: break;
          case 28: 
            { return token(COLS);
            } 
            // fall through
          case 76: break;
          case 29: 
            { return token(TYPE);
            } 
            // fall through
          case 77: break;
          case 30: 
            { return token(POS_X);
            } 
            // fall through
          case 78: break;
          case 31: 
            { return token(POS_Y);
            } 
            // fall through
          case 79: break;
          case 32: 
            { return token(HALL);
            } 
            // fall through
          case 80: break;
          case 33: 
            { return token(FLOOR);
            } 
            // fall through
          case 81: break;
          case 34: 
            { return token(WORLD);
            } 
            // fall through
          case 82: break;
          case 35: 
            { return token(BOARD);
            } 
            // fall through
          case 83: break;
          case 36: 
            { return token(BOXES);
            } 
            // fall through
          case 84: break;
          case 37: 
            { return token(BRICK);
            } 
            // fall through
          case 85: break;
          case 38: 
            { return token(WORLDS);
            } 
            // fall through
          case 86: break;
          case 39: 
            { return token(CONFIG);
            } 
            // fall through
          case 87: break;
          case 40: 
            { return token(PLAYER);
            } 
            // fall through
          case 88: break;
          case 41: 
            { return token(TARGETS);
            } 
            // fall through
          case 89: break;
          case 42: 
            { return token(BOX_COLOR);
            } 
            // fall through
          case 90: break;
          case 43: 
            { return token(HALL_COLOR);
            } 
            // fall through
          case 91: break;
          case 44: 
            { return token(BRICK_COLOR);
            } 
            // fall through
          case 92: break;
          case 45: 
            { return token(TARGET_COLOR);
            } 
            // fall through
          case 93: break;
          case 46: 
            { return token(PLAYER_COLOR);
            } 
            // fall through
          case 94: break;
          case 47: 
            { return token(UNDEFINED_COLOR);
            } 
            // fall through
          case 95: break;
          case 48: 
            { return token(BOX_ON_TARGET_COLOR);
            } 
            // fall through
          case 96: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
