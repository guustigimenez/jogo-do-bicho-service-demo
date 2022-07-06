package ar.com.tecnoaccion.jdbServiceDemo.models.entities.models;

public class Sorteo {

    public int id;

    public String horario;

    public Sorteo(int id, String horario) {
        this.id = id;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
