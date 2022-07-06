package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;

import java.util.ArrayList;

public class ListaEvento {

    private int id;
    private String leyenda;
    private String logo;
    private ArrayList<ListaSorteo> listaSorteos;

    public ListaEvento(int id, String leyenda, String logo, ArrayList<ListaSorteo> listaSorteos) {
        this.id = id;
        this.leyenda = leyenda;
        this.logo = logo;
        this.listaSorteos = listaSorteos;
    }

    public ListaEvento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ArrayList<ListaSorteo> getListaSorteos() {
        return listaSorteos;
    }

    public void setListaSorteos(ArrayList<ListaSorteo> listaSorteos) {
        this.listaSorteos = listaSorteos;
    }
}
