package ar.com.tecnoaccion.jdbServiceDemo.services;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.ParametrosWrapperDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses.ParametrosJuego;

public interface ParametrosService {

     ParametrosWrapperDTO getParametrosIniciales(Integer codigoJuego);

     ParametrosJuego getParametrosInicialesJson();


}
