package ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.variables;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.EventoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ParametrosVariablesContainerDTO {
    private List<EventoDTO> eventosDisponibles = new ArrayList<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long versionFijos;

    public List<EventoDTO> getEventosDisponibles() {
        return eventosDisponibles;
    }

    public void setEventosDisponibles(List<EventoDTO> eventosDisponibles) {
        this.eventosDisponibles = eventosDisponibles;
    }

    public Long getVersionFijos() {
        return versionFijos;
    }

    public void setVersionFijos(Long versionFijos) {
        this.versionFijos = versionFijos;
    }

}
