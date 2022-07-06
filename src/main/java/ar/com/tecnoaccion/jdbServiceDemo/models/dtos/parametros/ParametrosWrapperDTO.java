package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.fijos.ParametrosFijosContainerDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.variables.ParametrosVariablesContainerDTO;
import ar.com.tecnoaccion.juego.library.models.dtos.StatusAbstractDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.math.BigDecimal;

public class ParametrosWrapperDTO extends StatusAbstractDTO {

    private BigDecimal saldo;
    @JsonProperty("idJuego")
    private Integer codigoJuego;
    private String logoJuego;
    private ParametrosFijosContainerDTO parametros;
    @JsonUnwrapped
    private ParametrosVariablesContainerDTO parametrosVariablesContainerDTO;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getCodigoJuego() {
        return codigoJuego;
    }

    public void setCodigoJuego(Integer codigoJuego) {
        this.codigoJuego = codigoJuego;
    }

    public String getLogoJuego() {
        return logoJuego;
    }

    public void setLogoJuego(String logoJuego) {
        this.logoJuego = logoJuego;
    }

    public ParametrosFijosContainerDTO getParametros() {
        return parametros;
    }

    public void setParametros(ParametrosFijosContainerDTO parametros) {
        this.parametros = parametros;
    }

    public ParametrosVariablesContainerDTO getParametrosVariablesContainerDTO() {
        return parametrosVariablesContainerDTO;
    }

    public void setParametrosVariablesContainerDTO(ParametrosVariablesContainerDTO parametrosVariablesContainerDTO) {
        this.parametrosVariablesContainerDTO = parametrosVariablesContainerDTO;
    }
}
