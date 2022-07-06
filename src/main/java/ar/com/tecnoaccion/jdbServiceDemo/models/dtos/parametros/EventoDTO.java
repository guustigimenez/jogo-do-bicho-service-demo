package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros;

import java.util.List;

public class EventoDTO {
    private Integer orden;
    private String key;
    private Integer idEvento;
    private String descEve;
    private String logo;
    private String icono;
    private String fecSorteo;
    private String fecCierre;
    private Integer programa;
    private String tipoSorteo;

    //TODO Resolver la clase para los extractos
    //private List<LoteriaFWDTO> extractos;

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescEve() {
        return descEve;
    }

    public void setDescEve(String descEve) {
        this.descEve = descEve;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getFecSorteo() {
        return fecSorteo;
    }

    public void setFecSorteo(String fecSorteo) {
        this.fecSorteo = fecSorteo;
    }

    public String getFecCierre() {
        return fecCierre;
    }

    public void setFecCierre(String fecCierre) {
        this.fecCierre = fecCierre;
    }

    public Integer getPrograma() {
        return programa;
    }

    public void setPrograma(Integer programa) {
        this.programa = programa;
    }

    public String getTipoSorteo() {
        return tipoSorteo;
    }

    public void setTipoSorteo(String tipoSorteo) {
        this.tipoSorteo = tipoSorteo;
    }

}
