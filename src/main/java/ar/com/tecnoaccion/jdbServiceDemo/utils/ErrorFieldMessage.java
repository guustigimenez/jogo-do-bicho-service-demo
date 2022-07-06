package ar.com.tecnoaccion.jdbServiceDemo.utils;

import java.io.Serializable;
import java.util.Map;

public class ErrorFieldMessage implements Serializable {
    private Integer codigoError;
    private Map<String, String> fieldErrors;
    public ErrorFieldMessage(Integer codigoError, Map<String, String> fieldErrors) {
        this.codigoError = codigoError;
        this.fieldErrors = fieldErrors;
    }
    public Integer getCodigoError() {
        return codigoError;
    }
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }
    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}