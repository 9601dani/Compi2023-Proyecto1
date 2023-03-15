package com.dani.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(namespace = "", localName = "errors")
public class Error {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "error")
    private ArrayList<ErrorModel>  err;

    public Error( ArrayList<ErrorModel> err) {
        this.err = err;
    }

    public  ArrayList<ErrorModel> getErr() {
        return err;
    }

    public void setErr( ArrayList<ErrorModel> err) {
        this.err = err;
    }
}
