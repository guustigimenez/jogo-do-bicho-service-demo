package ar.com.tecnoaccion.jdbServiceDemo.models.entities.models;

import java.util.List;

public class Sorteadora {

    public int id;

    public String leyenda;

    public String logo;

    List<Sorteo> listaSorteos;


    public Sorteadora(int id, String leyenda, String logo, List<Sorteo> listaSorteos) {
        this.id = id;
        this.leyenda = leyenda;
        this.logo = logo;
        this.listaSorteos = listaSorteos;
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

    public List<Sorteo> getListaSorteos() {
        return listaSorteos;
    }

    public void setListaSorteos(List<Sorteo> listaSorteos) {
        this.listaSorteos = listaSorteos;
    }
}
