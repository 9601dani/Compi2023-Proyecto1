package com.dani;

public class Token {
    public Object getTokenType;
    private String lexeme;
    private int tokenType;
    private int column;
    private int line;

    public Token(String lexeme, int tokenType, int column, int line) {
        this.lexeme = lexeme;
        this.tokenType = tokenType;
        this.column = column;
        this.line = line;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public int getTokenType() {
        return tokenType;
    }

    @Override
    public String toString() {
        return "Token{" +
                "lexeme='" + lexeme + '\'' +
                ", tokenType=" + tokenType +
                ", column=" + column +
                ", line=" + line +
                '}' + "\n";
    }
}
