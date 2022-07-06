package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones;

import java.util.ArrayList;
import java.util.List;

public class LineaApuestaInDTO {

    private int orden;

    private String tipo;

    private List<String> nro;

    private int alcance;

    private boolean flagImporte;

    private double importe;


    public LineaApuestaInDTO(int orden, String tipo, ArrayList nro, int alcance, boolean flagImporte, double importe) {
        this.orden = orden;
        this.tipo = tipo;
        this.nro = nro;
        this.alcance = alcance;
        this.importe = importe;
        this.flagImporte = flagImporte;

    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public List<String> getNro() {
        return nro;
    }

    public void setNro(List<String> nro) {
        this.nro = nro;
    }

    public boolean isFlagImporte() {
        return flagImporte;
    }

    public void setFlagImporte(boolean flagImporte) {
        this.flagImporte = flagImporte;
    }
}
