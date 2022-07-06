package ar.com.tecnoaccion.jdbServiceDemo.services;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.CuponInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.ETicketDTO;
import ar.com.tecnoaccion.juego.library.models.dtos.frontend.InitJuegoDTO;

public interface JogoDoBichoService {

    ETicketDTO grabarApuesta(CuponInDTO cuponInDTO);

    InitJuegoDTO initJuego(Integer codigoJuego);

}
