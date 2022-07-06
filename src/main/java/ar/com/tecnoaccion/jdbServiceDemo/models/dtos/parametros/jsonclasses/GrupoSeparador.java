package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;

public class GrupoSeparador {

    private String separadorDecenas;
    private String separadorTerno;

    public GrupoSeparador(String separacionDecenas, String separadorTerno) {
        this.separadorDecenas = separacionDecenas;
        this.separadorTerno = separadorTerno;
    }

    public GrupoSeparador() {
    }

    public String getSeparadorDecenas() {
        return separadorDecenas;
    }

    public void setSeparadorDecenas(String separadorDecenas) {
        this.separadorDecenas = separadorDecenas;
    }

    public String getSeparadorTerno() {
        return separadorTerno;
    }

    public void setSeparadorTerno(String separadorTerno) {
        this.separadorTerno = separadorTerno;
    }
}
