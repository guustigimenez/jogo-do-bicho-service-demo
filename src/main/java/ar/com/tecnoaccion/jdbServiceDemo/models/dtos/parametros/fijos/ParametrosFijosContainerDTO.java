package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.fijos;

import ar.com.tecnoaccion.juego.library.models.dtos.StatusAbstractDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ParametrosFijosContainerDTO extends StatusAbstractDTO {
    private String descripcionJuego;

    @JsonProperty("desde")
    private Integer cifraDesde;

    @JsonProperty("hasta")
    private Integer cifraHasta;

    @JsonProperty("cantidadNumeros")
    private Integer numsPorLinea;

    @JsonProperty("puedeRepetir")
    private Boolean permiteRepetirNum;

    private Integer lineasAuto;

    private BigDecimal importeLinea;


    public String getDescripcionJuego() {
        return descripcionJuego;
    }

    public void setDescripcionJuego(String descripcionJuego) {
        this.descripcionJuego = descripcionJuego;
    }

    public Integer getCifraDesde() {
        return cifraDesde;
    }

    public void setCifraDesde(Integer cifraDesde) {
        this.cifraDesde = cifraDesde;
    }

    public Integer getCifraHasta() {
        return cifraHasta;
    }

    public void setCifraHasta(Integer cifraHasta) {
        this.cifraHasta = cifraHasta;
    }

    public Integer getNumsPorLinea() {
        return numsPorLinea;
    }

    public void setNumsPorLinea(Integer numsPorLinea) {
        this.numsPorLinea = numsPorLinea;
    }

    public Boolean getPermiteRepetirNum() {
        return permiteRepetirNum;
    }

    public void setPermiteRepetirNum(Boolean permiteRepetirNum) {
        this.permiteRepetirNum = permiteRepetirNum;
    }

    public Integer getLineasAuto() {
        return lineasAuto;
    }

    public void setLineasAuto(Integer lineasAuto) {
        this.lineasAuto = lineasAuto;
    }

    public BigDecimal getImporteLinea() {
        return importeLinea;
    }

    public void setImporteLinea(BigDecimal importeLinea) {
        this.importeLinea = importeLinea;
    }

}
