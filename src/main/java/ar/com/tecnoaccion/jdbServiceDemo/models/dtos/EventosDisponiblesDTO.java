package ar.com.tecnoaccion.jdbServiceDemo.models.dtos;

import ar.com.tecnoaccion.jdbServiceDemo.models.entities.models.Sorteadora;

import java.util.List;

public class EventosDisponiblesDTO {

    private int orden;

    private String descEve;

    private String logo;

    private int idEvento;

    private String tipoSorteo;

    private List<Sorteadora> listaEventos;


    public EventosDisponiblesDTO(int orden, String descEve, String logo, int idEvento, String tipoSorteo, List<Sorteadora> listaEventos) {
        this.orden = orden;
        this.descEve = descEve;
        this.logo = logo;
        this.idEvento = idEvento;
        this.tipoSorteo = tipoSorteo;
        this.listaEventos = listaEventos;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTipoSorteo() {
        return tipoSorteo;
    }

    public void setTipoSorteo(String tipoSorteo) {
        this.tipoSorteo = tipoSorteo;
    }

    public List<Sorteadora> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Sorteadora> listaEventos) {
        this.listaEventos = listaEventos;
    }
}
