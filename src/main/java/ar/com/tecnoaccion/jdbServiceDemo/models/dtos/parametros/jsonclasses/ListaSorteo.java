package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;

public class ListaSorteo {
    private int id;
    private String horario;

    public ListaSorteo(int id, String horario) {
        this.id = id;
        this.horario = horario;
    }

    public ListaSorteo() {
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
