package com.dani;

public class Token {
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
