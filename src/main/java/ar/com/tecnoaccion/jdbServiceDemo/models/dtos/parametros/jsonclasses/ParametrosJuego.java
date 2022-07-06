package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses;

import ar.com.tecnoaccion.juego.library.models.dtos.StatusAbstractDTO;

import java.util.ArrayList;

public class ParametrosJuego extends StatusAbstractDTO {

    private ArrayList<Programa> programas;
    private ArrayList<EventosDisponibles> eventosDisponibles;

    private Object object;

    public ParametrosJuego(ArrayList<Programa> programas, ArrayList<EventosDisponibles> eventosDisponibles) {
        this.programas = programas;
        this.eventosDisponibles = eventosDisponibles;
    }

    public ParametrosJuego() {
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<Programa> programas) {
        this.programas = programas;
    }

    public ArrayList<EventosDisponibles> getEventosDisponibles() {
        return eventosDisponibles;
    }

    public void setEventosDisponibles(ArrayList<EventosDisponibles> eventosDisponibles) {
        this.eventosDisponibles = eventosDisponibles;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
