package ar.com.tecnoaccion.jdbServiceDemo.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoStatus {
    OK("ok"),
    ERROR("error");
    private String name;
    TipoStatus(String name) {
        this.name = name;
    }
    @JsonValue
    public String getName() {
        return name;
    }
}
