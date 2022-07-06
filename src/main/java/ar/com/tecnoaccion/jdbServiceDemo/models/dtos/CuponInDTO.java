package ar.com.tecnoaccion.jdbServiceDemo.models.dtos;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CuponInDTO {

    private String evento;

    private List<SorteoSorteadoraDTO> sorteos;
    @JsonProperty("apuestas")
    private List<LineaApuestaInDTO> lineaApuestaList;

    private double importeTotal;

    private int cantLineas;

    private String codigoJuego;

    private String codOrganizacion;


    public CuponInDTO(String evento, List<SorteoSorteadoraDTO> sorteos, List<LineaApuestaInDTO> lineaApuestaList, double importeTotal, int cantLineas, String codigoJuego, String codOrganizacion) {
        this.evento = evento;
        this.sorteos = sorteos;
        this.lineaApuestaList = lineaApuestaList;
        this.importeTotal = importeTotal;
        this.cantLineas = cantLineas;
        this.codigoJuego = codigoJuego;
        this.codOrganizacion = codOrganizacion;
    }

    public String getCodOrganizacion() {
        return codOrganizacion;
    }

    public void setCodOrganizacion(String codOrganizacion) {
        this.codOrganizacion = codOrganizacion;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public List<SorteoSorteadoraDTO> getSorteos() {
        return sorteos;
    }

    public void setSorteos(List<SorteoSorteadoraDTO> sorteadoras) {
        this.sorteos = sorteadoras;
    }

    public List<LineaApuestaInDTO> getLineaApuestaList() {
        return lineaApuestaList;
    }

    public void setLineaApuestaList(List<LineaApuestaInDTO> lineaApuestaList) {
        this.lineaApuestaList = lineaApuestaList;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public int getCantLineas() {
        return cantLineas;
    }

    public void setCantLineas(int cantLineas) {
        this.cantLineas = cantLineas;
    }

    public String getCodigoJuego() {
        return codigoJuego;
    }

    public void setCodigoJuego(String codigoJuego) {
        this.codigoJuego = codigoJuego;
    }
}


