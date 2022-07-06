package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.StatusAbstractDTO;

import java.util.List;

public class LineaApuestaOutDTO extends StatusAbstractDTO {
    private int orden;

    private String tipo;

    private List<String> nro;

    private int alcance;

    private double importeUnitario;

    private double importeTotal;

    public LineaApuestaOutDTO(){};
    public LineaApuestaOutDTO(int orden, String tipo, List<String> nro, int alcance, boolean flagImporte, double importeUnitario, double importeTotal) {
        this.orden = orden;
        this.tipo = tipo;
        this.nro = nro;
        this.alcance = alcance;
        this.importeUnitario = importeUnitario;
        this.importeTotal = importeTotal;
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

    public List<String> getNro() {
        return nro;
    }

    public void setNro(List<String> nro) {
        this.nro = nro;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public double getImporteUnitario() {
        return importeUnitario;
    }

    public void setImporteUnitario(double importeUnitario) {
        this.importeUnitario = importeUnitario;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
}
