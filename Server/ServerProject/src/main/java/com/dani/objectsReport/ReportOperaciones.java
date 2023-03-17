package com.dani.objectsReport;

public class ReportOperaciones {
    private String operador;
    private int linea;
    private int columna;

    public ReportOperaciones(String operador, int linea, int columna) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
