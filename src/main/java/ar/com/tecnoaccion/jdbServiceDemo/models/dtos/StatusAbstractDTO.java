package ar.com.tecnoaccion.jdbServiceDemo.models.dtos;

import ar.com.tecnoaccion.jdbServiceDemo.models.TipoStatus;
import ar.com.tecnoaccion.jdbServiceDemo.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class StatusAbstractDTO {
    private TipoStatus status = TipoStatus.OK;
    private List<ErrorMessage> errores = new ArrayList<>();
    public TipoStatus getStatus() {
        return status;
    }
    public void setStatus(TipoStatus status) {
        this.status = status;
    }
    public List<ErrorMessage> getErrores() {
        return errores;
    }
    public void setErrores(List<ErrorMessage> errores) {
        this.errores = errores;
    }
}
