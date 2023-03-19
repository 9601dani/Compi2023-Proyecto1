
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.dani.appmovil.parserMov;

import static com.dani.appmovil.models.ConstruccionMatriz.erroForClient;
import static com.dani.appmovil.parserMov.ParserMovSym.*;

import java_cup.runtime.*;
import java.util.ArrayList;
import com.dani.appmovil.models.ErrorMovClient;
import com.dani.appmovil.objects.Motion;
import com.dani.appmovil.objects.Token;
/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserMov extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserMovSym.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserMov() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserMov(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserMov(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\010\005\000\002\010" +
    "\004\000\002\010\004\000\002\002\006\000\002\002\007" +
    "\000\002\002\004\000\002\002\004\000\002\003\003\000" +
    "\002\003\003\000\002\003\003\000\002\003\003\000\002" +
    "\007\005\000\002\007\005\000\002\007\003\000\002\005" +
    "\005\000\002\005\005\000\002\005\003\000\002\004\003" +
    "\000\002\004\003\000\002\006\005\000\002\006\006\000" +
    "\002\006\006\000\002\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\016\003\007\004\010\005\006\006\005\011" +
    "\004\012\014\001\002\000\004\022\ufff7\001\002\000\004" +
    "\022\ufff6\001\002\000\012\004\010\006\005\011\004\012" +
    "\014\001\002\000\010\013\057\022\055\023\056\001\002" +
    "\000\004\022\ufff8\001\002\000\020\002\051\003\052\004" +
    "\010\005\006\006\005\011\004\012\014\001\002\000\004" +
    "\022\016\001\002\000\004\013\015\001\002\000\004\022" +
    "\ufff9\001\002\000\020\002\uffff\003\uffff\004\uffff\005\uffff" +
    "\006\uffff\011\uffff\012\uffff\001\002\000\014\007\024\010" +
    "\026\014\020\015\021\022\025\001\002\000\014\016\ufff0" +
    "\017\ufff0\020\ufff0\021\ufff0\023\ufff0\001\002\000\014\016" +
    "\uffef\017\uffef\020\uffef\021\uffef\023\uffef\001\002\000\014" +
    "\016\uffea\017\uffea\020\uffea\021\uffea\023\uffea\001\002\000" +
    "\014\016\ufff3\017\045\020\ufff3\021\046\023\ufff3\001\002" +
    "\000\010\016\033\020\032\023\044\001\002\000\004\022" +
    "\041\001\002\000\014\007\024\010\026\014\020\015\021" +
    "\022\025\001\002\000\004\022\030\001\002\000\014\016" +
    "\uffee\017\uffee\020\uffee\021\uffee\023\uffee\001\002\000\014" +
    "\007\024\010\026\014\020\015\021\022\025\001\002\000" +
    "\010\016\033\020\032\023\034\001\002\000\014\007\024" +
    "\010\026\014\020\015\021\022\025\001\002\000\014\007" +
    "\024\010\026\014\020\015\021\022\025\001\002\000\014" +
    "\016\uffec\017\uffec\020\uffec\021\uffec\023\uffec\001\002\000" +
    "\010\016\ufff5\020\032\023\ufff5\001\002\000\010\016\ufff4" +
    "\020\ufff4\023\ufff4\001\002\000\010\016\033\020\032\023" +
    "\040\001\002\000\014\016\uffed\017\uffed\020\uffed\021\uffed" +
    "\023\uffed\001\002\000\014\007\024\010\026\014\020\015" +
    "\021\022\025\001\002\000\010\016\033\020\032\023\043" +
    "\001\002\000\014\016\uffeb\017\uffeb\020\uffeb\021\uffeb\023" +
    "\uffeb\001\002\000\004\013\ufffd\001\002\000\014\007\024" +
    "\010\026\014\020\015\021\022\025\001\002\000\014\007" +
    "\024\010\026\014\020\015\021\022\025\001\002\000\014" +
    "\016\ufff1\017\ufff1\020\ufff1\021\ufff1\023\ufff1\001\002\000" +
    "\014\016\ufff2\017\ufff2\020\ufff2\021\046\023\ufff2\001\002" +
    "\000\004\002\001\001\002\000\006\022\055\023\056\001" +
    "\002\000\004\013\054\001\002\000\020\002\000\003\000" +
    "\004\000\005\000\006\000\011\000\012\000\001\002\000" +
    "\004\013\ufffb\001\002\000\004\013\ufffa\001\002\000\020" +
    "\002\ufffe\003\ufffe\004\ufffe\005\ufffe\006\ufffe\011\ufffe\012" +
    "\ufffe\001\002\000\004\022\061\001\002\000\014\007\024" +
    "\010\026\014\020\015\021\022\025\001\002\000\010\016" +
    "\033\020\032\023\063\001\002\000\004\013\ufffc\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\010\002\012\003\011\010\010\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\003\057\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\002\052\003" +
    "\011\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\004\016\005\021\006" +
    "\026\007\022\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\012\004\016\005\021\006\026\007\036" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\004" +
    "\016\005\021\006\026\007\030\001\001\000\002\001\001" +
    "\000\012\004\016\005\021\006\026\007\035\001\001\000" +
    "\012\004\016\005\021\006\026\007\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\012\004\016\005\021\006\026" +
    "\007\041\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\004\016\005\047\006\026\001\001" +
    "\000\010\004\016\005\046\006\026\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\004\016\005\021\006\026\007\061\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserMov$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserMov$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserMov$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




            public ParserMov(LexerMov lexer){
                    super(lexer);
                }
        Motion movimiento;
                                        public Symbol scan() throws Exception {
                                               Symbol symbol = this.getScanner().next_token();
                                               if (symbol == null) {
                                                   return this.getSymbolFactory().newSymbol("END_OF_FILE", this.EOF_sym());
                                               }

                                               while(symbol != null && symbol.sym == ParserMovSym.SYM) {
                                                   this.report_expected_token_ids();
                                                   System.out.println("Ingorando: " + symbol.value.toString());
                                                   Token token = (Token) symbol.value;
                                                   erroForClient.add(new ErrorMovClient(token.getLexeme(),token.getLine(),token.getColumn(), "LEXICO","No_existe_esta_cadena_en_el_lenguaje"));
                                                   symbol = this.getScanner().next_token();
                                               }

                                               if (symbol == null) {
                                                   return this.getSymbolFactory().newSymbol("END_OF_FILE", this.EOF_sym());
                                               }

                                               return symbol;
                                       }
                                        public void syntax_error(Symbol cur_token) {
                                               Token token = (Token) cur_token.value;

                                               if (cur_token.sym ==ParserMovSym.EOF) {
                                       //          String er = "Simbolo inesperado, se esperaba: "+ simbolosTerminales.obtenerSimbolos(expected_token_ids()).toString();
                                                   String er = "Simbolo_inesperado";
                                                   erroForClient.add(new ErrorMovClient("Fin_del_archivo", token.getLine(),token.getColumn(), "SINTACTICO",er));
                                                   System.out.println(er);
                                               } else {
                                                   String er = "Simbolo_inesperado";
                                                   erroForClient.add(new ErrorMovClient(token.getLexeme(), token.getLine(), token.getColumn(),"SINTACTICO",er));
                                                   System.out.println(er);
                                               }
                                           }

                                           public void unrecovered_syntax_error(Symbol cur_token) {
                                               if (cur_token.sym == ParserMovSym.EOF) {
                                                   Token tok = (Token) cur_token.value;
                                                   String er = "No_se_puede_recuperar_el_error_ya_no_hay_mas_tokens";
                                                   erroForClient.add(new ErrorMovClient("FIN_ARCHIVO", tok.getLine(), tok.getColumn(), "SINTACTICO", er));
                                                   /*erroForClient=new ArrayList();*/
                                                   System.out.println(er);
                                               } else {
                                                   Token tok = (Token) cur_token.value;
                                                   //String er = "Error irrecuperable, un posible simbolo esperado: "+ simbolosTerminales.obtenerSimbolos(expected_token_ids()).toString();
                                                   String er = "no_se_puede_recuperar_el_error";
                                                   erroForClient.add(new ErrorMovClient(tok.getLexeme(), tok.getLine(), tok.getColumn(), "SINTACTICO", er));
                                                    /*erroForClient=new ArrayList();*/
                                                   System.out.println(er);
                                               }
                                           }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserMov$actions {
  private final ParserMov parser;

  /** Constructor */
  CUP$ParserMov$actions(ParserMov parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserMov$do_action_part00000000(
    int                        CUP$ParserMov$act_num,
    java_cup.runtime.lr_parser CUP$ParserMov$parser,
    java.util.Stack            CUP$ParserMov$stack,
    int                        CUP$ParserMov$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserMov$result;

      /* select the action based on the action number */
      switch (CUP$ParserMov$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= expr EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		ArrayList<Motion> start_val = (ArrayList<Motion>)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		RESULT = start_val;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserMov$parser.done_parsing();
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // expr ::= expr typeMov PUNTO_COMA 
            {
              ArrayList<Motion> RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).right;
		ArrayList<Motion> n1 = (ArrayList<Motion>)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).value;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Motion a1 = (Motion)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		
                n1.add(a1);
                RESULT=n1;
                
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr ::= typeMov PUNTO_COMA 
            {
              ArrayList<Motion> RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Motion a1 = (Motion)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		
            // RESULT= new ArrayList<Integer>();
             RESULT= new ArrayList<Motion>();
             RESULT.add(a1);
             //RESULT.add((Integer)a1);
             
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr ::= error PUNTO_COMA 
            {
              ArrayList<Motion> RESULT =null;

              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // typeMov ::= instr L_PARENT operacion1 R_PARENT 
            {
              Motion RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)).right;
		Object n1 = (Object)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)).value;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		
             RESULT= new Motion((Integer)n1,a1.intValue(),false);
             
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("typeMov",0, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // typeMov ::= PUSH instr L_PARENT operacion1 R_PARENT 
            {
              Motion RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)).right;
		Object n1 = (Object)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)).value;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		
            RESULT= new Motion((Integer)n1,a1.intValue(),true);
            
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("typeMov",0, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-4)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // typeMov ::= error L_PARENT 
            {
              Motion RESULT =null;

              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("typeMov",0, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // typeMov ::= error R_PARENT 
            {
              Motion RESULT =null;

              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("typeMov",0, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // instr ::= UP 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Token a = (Token)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT= UP;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("instr",1, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // instr ::= DOWN 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Token a = (Token)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT=DOWN;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("instr",1, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // instr ::= LEFT 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Token a = (Token)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT=LEFT;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("instr",1, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // instr ::= RIGHT 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Token a = (Token)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT=RIGHT;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("instr",1, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // operacion1 ::= operacion1 SUMA operacion1 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).value;
		int a2left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a2right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = a1 + a2 ; 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion1",5, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // operacion1 ::= operacion1 RESTA operacion1 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).value;
		int a2left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a2right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = a1 - a2 ; 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion1",5, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // operacion1 ::= operacion2 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = a1 ; 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion1",5, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // operacion2 ::= operacion2 MULTIPLICACION operacion2 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).value;
		int a2left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a2right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = a1 * a2 ; 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion2",3, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // operacion2 ::= operacion2 DIVISION operacion2 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)).value;
		int a2left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a2right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = a1 / a2 ; 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion2",3, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // operacion2 ::= operacion3 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = a1 ; 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion2",3, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // operacion3 ::= NUM 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Token a1 = (Token)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT = Double.parseDouble(a1.getLexeme()); 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion3",2, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // operacion3 ::= operacion4 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		RESULT =a1;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion3",2, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // operacion4 ::= L_PARENT operacion1 R_PARENT 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		RESULT =a1;
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion4",4, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-2)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // operacion4 ::= CEIL L_PARENT operacion1 R_PARENT 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		RESULT = Math.ceil(a1);
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion4",4, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // operacion4 ::= FLOOR L_PARENT operacion1 R_PARENT 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).right;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-1)).value;
		RESULT = Math.floor(a1);
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion4",4, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.elementAt(CUP$ParserMov$top-3)), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // operacion4 ::= DECIMAL 
            {
              Double RESULT =null;
		int a1left = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).left;
		int a1right = ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()).right;
		Token a1 = (Token)((java_cup.runtime.Symbol) CUP$ParserMov$stack.peek()).value;
		 RESULT = Double.parseDouble(a1.getLexeme()); 
              CUP$ParserMov$result = parser.getSymbolFactory().newSymbol("operacion4",4, ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserMov$stack.peek()), RESULT);
            }
          return CUP$ParserMov$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserMov$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserMov$do_action(
    int                        CUP$ParserMov$act_num,
    java_cup.runtime.lr_parser CUP$ParserMov$parser,
    java.util.Stack            CUP$ParserMov$stack,
    int                        CUP$ParserMov$top)
    throws java.lang.Exception
    {
              return CUP$ParserMov$do_action_part00000000(
                               CUP$ParserMov$act_num,
                               CUP$ParserMov$parser,
                               CUP$ParserMov$stack,
                               CUP$ParserMov$top);
    }
}

}
