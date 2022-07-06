package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;

import java.util.ArrayList;

public class Programa {

    private String descripcionJuego;
    private int alcanceMaximo;
    private int maxCantidadCifras;
    private int maximaCantidadLineas;
    private double importeMinimoCupon;
    private int importeMaximoCupon;
    private ArrayList<ParametrosTipoApuesta> parametrosTipoApuesta;

    public Programa(String descripcionJuego, int alcanceMaximo, int maxCantidadCifras, int maximaCantidadLineas, double importeMinimoCupon, int importeMaximoCupon, ArrayList<ParametrosTipoApuesta> parametrosTipoApuesta) {
        this.descripcionJuego = descripcionJuego;
        this.alcanceMaximo = alcanceMaximo;
        this.maxCantidadCifras = maxCantidadCifras;
        this.maximaCantidadLineas = maximaCantidadLineas;
        this.importeMinimoCupon = importeMinimoCupon;
        this.importeMaximoCupon = importeMaximoCupon;
        this.parametrosTipoApuesta = parametrosTipoApuesta;
    }

    public Programa() {
    }

    public String getDescripcionJuego() {
        return descripcionJuego;
    }

    public void setDescripcionJuego(String descripcionJuego) {
        this.descripcionJuego = descripcionJuego;
    }

    public int getAlcanceMaximo() {
        return alcanceMaximo;
    }

    public void setAlcanceMaximo(int alcanceMaximo) {
        this.alcanceMaximo = alcanceMaximo;
    }

    public int getMaxCantidadCifras() {
        return maxCantidadCifras;
    }

    public void setMaxCantidadCifras(int maxCantidadCifras) {
        this.maxCantidadCifras = maxCantidadCifras;
    }

    public int getMaximaCantidadLineas() {
        return maximaCantidadLineas;
    }

    public void setMaximaCantidadLineas(int maximaCantidadLineas) {
        this.maximaCantidadLineas = maximaCantidadLineas;
    }

    public double getImporteMinimoCupon() {
        return importeMinimoCupon;
    }

    public void setImporteMinimoCupon(double importeMinimoCupon) {
        this.importeMinimoCupon = importeMinimoCupon;
    }

    public int getImporteMaximoCupon() {
        return importeMaximoCupon;
    }

    public void setImporteMaximoCupon(int importeMaximoCupon) {
        this.importeMaximoCupon = importeMaximoCupon;
    }

    public ArrayList<ParametrosTipoApuesta> getParametrosTipoApuesta() {
        return parametrosTipoApuesta;
    }

    public void setParametrosTipoApuesta(ArrayList<ParametrosTipoApuesta> parametrosTipoApuesta) {
        this.parametrosTipoApuesta = parametrosTipoApuesta;
    }
}
