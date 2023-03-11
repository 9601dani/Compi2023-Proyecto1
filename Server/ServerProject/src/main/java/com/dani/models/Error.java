package com.dani.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(namespace = "", localName = "errors")
public class Error {
    @JacksonXmlProperty(localName = "error")
    private ErrorModel err;

    public Error(ErrorModel err) {
        this.err = err;
    }

    public ErrorModel getErr() {
        return err;
    }

    public void setErr(ErrorModel err) {
        this.err = err;
    }
}
