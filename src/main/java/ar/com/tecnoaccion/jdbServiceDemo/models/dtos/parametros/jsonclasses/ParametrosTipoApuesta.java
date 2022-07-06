package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;


import java.util.ArrayList;

public class ParametrosTipoApuesta {

    private String tipoApuesta;
    private ParametrosGenerales parametrosGenerales;

    public ParametrosTipoApuesta(String tipoApuesta, ParametrosGenerales parametrosGenerales) {
        this.parametrosGenerales = parametrosGenerales;
        this.tipoApuesta = tipoApuesta;
    }

    public ParametrosTipoApuesta() {
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(String tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public ParametrosGenerales getParametrosGenerales() {
        return parametrosGenerales;
    }

    public void setParametrosGenerales(ParametrosGenerales parametrosGenerales) {
        this.parametrosGenerales = parametrosGenerales;
    }
}
