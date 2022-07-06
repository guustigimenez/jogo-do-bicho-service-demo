package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;

public class ParametrosGenerales {

    private int maxCantidadCifras;
    private int minCantidadCifras;
    private String separador;
    private boolean puedeRepetir;
    private int alcance;
    private String conector;

    public ParametrosGenerales(int maxCantidadCifras, int minCantidadCifras, String separador, boolean puedeRepetir, int alcance, String conector) {
        this.maxCantidadCifras = maxCantidadCifras;
        this.minCantidadCifras = minCantidadCifras;
        this.separador = separador;
        this.puedeRepetir = puedeRepetir;
        this.alcance = alcance;
        this.conector = conector;
    }

    public ParametrosGenerales() {
    }

    public int getMaxCantidadCifras() {
        return maxCantidadCifras;
    }

    public void setMaxCantidadCifras(int maxCantidadCifras) {
        this.maxCantidadCifras = maxCantidadCifras;
    }

    public int getMinCantidadCifras() {
        return minCantidadCifras;
    }

    public void setMinCantidadCifras(int minCantidadCifras) {
        this.minCantidadCifras = minCantidadCifras;
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public boolean isPuedeRepetir() {
        return puedeRepetir;
    }

    public void setPuedeRepetir(boolean puedeRepetir) {
        this.puedeRepetir = puedeRepetir;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public String getConector() {
        return conector;
    }

    public void setConector(String conector) {
        this.conector = conector;
    }
}
