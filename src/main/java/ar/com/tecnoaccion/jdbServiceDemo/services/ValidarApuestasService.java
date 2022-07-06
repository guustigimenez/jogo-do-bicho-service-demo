package ar.com.tecnoaccion.jdbServiceDemo.services;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaOutDTO;

public interface ValidarApuestasService {
    LineaApuestaOutDTO validar(LineaApuestaInDTO lineaApuestaInDTO);
    LineaApuestaOutDTO validarApuestaSeca(LineaApuestaInDTO lineaApuestaInDTO);
    LineaApuestaOutDTO validarInvertida(LineaApuestaInDTO lineaApuestaInDTO);
    LineaApuestaOutDTO validarInvertidaConRepeticion(LineaApuestaInDTO lineaApuestaInDTO);
    LineaApuestaOutDTO validarTernoDeDecena(LineaApuestaInDTO lineaApuestaInDTO);
    LineaApuestaOutDTO validarGrupo(LineaApuestaInDTO lineaApuestaInDTO);
}
