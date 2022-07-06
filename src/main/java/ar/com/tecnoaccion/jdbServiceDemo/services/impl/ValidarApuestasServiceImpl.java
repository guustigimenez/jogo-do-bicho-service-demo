package ar.com.tecnoaccion.jdbServiceDemo.services.impl;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.exceptions.ValidacionException;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaOutDTO;
import ar.com.tecnoaccion.jdbServiceDemo.services.ValidarApuestasService;
import ar.com.tecnoaccion.jdbServiceDemo.utils.DefinedError;
import ar.com.tecnoaccion.jdbServiceDemo.utils.ValidacionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service("ValidarApuestasService")
public class ValidarApuestasServiceImpl implements ValidarApuestasService {

    /*
    C: centena seca
    CI: centena invertida
    CIR: centena invertida con repeticion
    M: millar seca
    MI: millar invertida
    MIR: millar invertida con repeticion
    MC: millar con centena seca
    MCI: millar con centena invertida
    MCIR: millar con centena invertida con repeticion
    TD: terna de decena
    G: grupo o bicho
    Cao: rango de centena seca
    Mao: rango de millar seca
*/
    @Override
    public LineaApuestaOutDTO validar(LineaApuestaInDTO lineaApuestaInDTO) {
        switch (lineaApuestaInDTO.getTipo()){
            case "C":
            case "M":
            case "MC":
            case "Mao":
            case "Cao":
                return validarApuestaSeca(lineaApuestaInDTO);
            case "CI":
            case "MI":
            case "MCI":
                return validarInvertida(lineaApuestaInDTO);
            case "CIR":
            case "MIR":
            case "MCIR":
                return validarInvertidaConRepeticion(lineaApuestaInDTO);
            case "TD":
                return validarTernoDeDecena(lineaApuestaInDTO);
            case "G":
                return validarGrupo(lineaApuestaInDTO);
            default:
                throw  new ValidacionException(DefinedError.ERROR_TIPO_JUGADA.getErrorCode(), DefinedError.ERROR_TIPO_JUGADA.getErrorMessage());
        }
    }

    @Override
    public LineaApuestaOutDTO validarApuestaSeca(LineaApuestaInDTO lineaApuestaInDTO){
        LineaApuestaOutDTO lineaApuestaOutDTO = new LineaApuestaOutDTO();
        lineaApuestaOutDTO.setAlcance(lineaApuestaInDTO.getAlcance());
        lineaApuestaOutDTO.setOrden(lineaApuestaInDTO.getOrden());
        lineaApuestaOutDTO.setTipo(lineaApuestaInDTO.getTipo());
        lineaApuestaOutDTO.setNro(lineaApuestaInDTO.getNro());
        double importeUnitario=0;
        double importeTotal=0;
        long rango = 0;

        if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoMillar)){
            for(int i=0; i < lineaApuestaInDTO.getNro().size(); i++){
                validarCifras(lineaApuestaInDTO.getTipo(),lineaApuestaInDTO.getNro().get(i),ValidacionUtils.millar);
            }
            if(lineaApuestaInDTO.isFlagImporte()){
                importeTotal = lineaApuestaInDTO.getImporte();
                BigDecimal importeUnitarioBD = BigDecimal.valueOf(importeTotal/lineaApuestaInDTO.getNro().size());
                if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoCentena))
                    importeUnitarioBD = importeUnitarioBD.divide(BigDecimal.valueOf(2));

                if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoRango)){
                    rango = calcularRango(lineaApuestaInDTO.getNro().get(0),lineaApuestaInDTO.getNro().get(1));
                    importeUnitarioBD = BigDecimal.valueOf(importeTotal/rango);
                }
                BigDecimal valorRedondeado = importeUnitarioBD.setScale(2, RoundingMode.HALF_DOWN);
                int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                if (flagDecimal == -1)
                    throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                lineaApuestaOutDTO.setImporteUnitario(valorRedondeado.doubleValue());
                lineaApuestaOutDTO.setImporteTotal(importeTotal);
            }else{
                importeUnitario = lineaApuestaInDTO.getImporte();
                lineaApuestaOutDTO.setImporteUnitario(importeUnitario);
                BigDecimal importeTotalBD = BigDecimal.valueOf(importeUnitario * lineaApuestaInDTO.getNro().size());
                if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoRango)){
                    rango = calcularRango(lineaApuestaInDTO.getNro().get(0),lineaApuestaInDTO.getNro().get(1));
                    importeTotalBD = BigDecimal.valueOf(importeUnitario * rango);
                }
                if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoCentena))
                    importeTotalBD =importeTotalBD.multiply(BigDecimal.valueOf(2));
                BigDecimal valorRedondeado = importeTotalBD.setScale(2, RoundingMode.DOWN);
                int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                if (flagDecimal == -1)
                    throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                lineaApuestaOutDTO.setImporteTotal(valorRedondeado.doubleValue());
            }
            return lineaApuestaOutDTO;
        }
        if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoCentena)){
            for(int i=0; i < lineaApuestaInDTO.getNro().size(); i++){
                validarCifras(lineaApuestaInDTO.getTipo(),lineaApuestaInDTO.getNro().get(i),ValidacionUtils.centena);
            }
            if(lineaApuestaInDTO.isFlagImporte()){
                importeTotal = lineaApuestaInDTO.getImporte();
                lineaApuestaOutDTO.setImporteTotal(importeTotal);
                BigDecimal importeUnitarioBD = BigDecimal.valueOf(importeTotal/lineaApuestaInDTO.getNro().size());
                if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoRango)){
                    rango = calcularRango(lineaApuestaInDTO.getNro().get(0),lineaApuestaInDTO.getNro().get(1));
                    importeUnitarioBD = BigDecimal.valueOf(importeTotal/rango);
                }
                BigDecimal valorRedondeado = importeUnitarioBD.setScale(2, RoundingMode.DOWN);
                int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                if (flagDecimal == -1)
                    throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                lineaApuestaOutDTO.setImporteUnitario(valorRedondeado.doubleValue());
            }else{
                importeUnitario = lineaApuestaInDTO.getImporte();
                lineaApuestaOutDTO.setImporteUnitario(importeUnitario);
                BigDecimal importeTotalBD = BigDecimal.valueOf(importeUnitario * lineaApuestaInDTO.getNro().size());
                if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoRango)){
                    rango = calcularRango(lineaApuestaInDTO.getNro().get(0),lineaApuestaInDTO.getNro().get(1));
                    importeTotalBD = BigDecimal.valueOf(importeUnitario*rango);
                }
                BigDecimal valorRedondeado = importeTotalBD.setScale(2, RoundingMode.DOWN);
                int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                if (flagDecimal == -1)
                    throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                lineaApuestaOutDTO.setImporteTotal(valorRedondeado.doubleValue());
            }
            return lineaApuestaOutDTO;
        }
        throw new ValidacionException(DefinedError.ERROR_TIPO_JUGADA.getErrorCode(), DefinedError.ERROR_TIPO_JUGADA.getErrorMessage());
    }
    @Override
    public LineaApuestaOutDTO validarGrupo(LineaApuestaInDTO lineaApuestaInDTO) {
        LineaApuestaOutDTO lineaApuestaOutDTO = new LineaApuestaOutDTO();
        lineaApuestaOutDTO.setOrden(lineaApuestaInDTO.getOrden());
        lineaApuestaOutDTO.setAlcance(lineaApuestaInDTO.getAlcance());
        lineaApuestaOutDTO.setNro(lineaApuestaInDTO.getNro());
        for (int i = 0; i < lineaApuestaInDTO.getNro().size(); i++) {
            if (validarCifras(lineaApuestaInDTO.getTipo(), lineaApuestaInDTO.getNro().get(i), ValidacionUtils.centena)) {
                if (validarImporte(lineaApuestaInDTO.getImporte())) {
                    return lineaApuestaOutDTO;
                }
                throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
            }
            throw new ValidacionException(DefinedError.ERROR_JUGADA_GRUPO.getErrorCode(), DefinedError.ERROR_JUGADA_GRUPO.getErrorMessage());
        }
        return lineaApuestaOutDTO;
    }
    @Override
    public LineaApuestaOutDTO validarInvertidaConRepeticion(LineaApuestaInDTO lineaApuestaInDTO){
        boolean totalFlag = lineaApuestaInDTO.isFlagImporte();
        long r = 0;
        long combinatoriaMillar=0;
        long combinatoria=0;
        long combinatoriaCentena=0;
        //Digitos enviados desde el frontend
        long n = lineaApuestaInDTO.getNro().size();
        LineaApuestaOutDTO lineaApuestaOutDTO = new LineaApuestaOutDTO();
        lineaApuestaOutDTO.setAlcance(lineaApuestaInDTO.getAlcance());
        lineaApuestaOutDTO.setOrden(lineaApuestaInDTO.getOrden());
        lineaApuestaOutDTO.setTipo(lineaApuestaInDTO.getTipo());
        lineaApuestaOutDTO.setNro(lineaApuestaInDTO.getNro());

       if(validarDuplicados(lineaApuestaInDTO.getNro())) {
           if (lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoMillar)) {
               r = ValidacionUtils.millar;
               if(n<r || n>10){
                   throw new ValidacionException(DefinedError.ERROR_DIGITOS.getErrorCode(), DefinedError.ERROR_DIGITOS.getErrorMessage());
               }
               combinatoriaMillar = combinatoriaExponencial(n, r);
           }
           if (lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoCentena)) {
               r = ValidacionUtils.centena;
               if(n<r || n>10){
                   throw new ValidacionException(DefinedError.ERROR_DIGITOS.getErrorCode(), DefinedError.ERROR_DIGITOS.getErrorMessage());
               }
               combinatoriaCentena = combinatoriaExponencial(n, r);
           }
           combinatoria = (combinatoriaMillar + combinatoriaCentena);
           if (totalFlag) {
               BigDecimal importeUnitario = BigDecimal.valueOf(lineaApuestaInDTO.getImporte() / combinatoria);
               if (importeUnitario.scale() > 2) {
                   BigDecimal valorRedondeado = importeUnitario.setScale(2, RoundingMode.HALF_DOWN);
                   int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                   if (flagDecimal == -1)
                       throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                   lineaApuestaOutDTO.setImporteUnitario(valorRedondeado.doubleValue());
                   BigDecimal importeTotalRedondeado = valorRedondeado.multiply(BigDecimal.valueOf(combinatoria)).setScale(2,RoundingMode.HALF_DOWN);
                   lineaApuestaOutDTO.setImporteTotal(importeTotalRedondeado.doubleValue());
                   return lineaApuestaOutDTO;
               }else{
                   lineaApuestaOutDTO.setImporteUnitario(importeUnitario.doubleValue());
                   lineaApuestaOutDTO.setImporteTotal(importeUnitario.doubleValue()*combinatoria);
                   return lineaApuestaOutDTO;
               }
           } else if (validarImporte(lineaApuestaInDTO.getImporte())) {
               //TODO: Maximo importe por apuesta
               BigDecimal importeTotal = BigDecimal.valueOf(lineaApuestaInDTO.getImporte() * combinatoria);
               BigDecimal importeTotalRedondeado = importeTotal.setScale(2, RoundingMode.HALF_DOWN);
               lineaApuestaOutDTO.setImporteTotal(importeTotalRedondeado.doubleValue());
               lineaApuestaOutDTO.setImporteUnitario(lineaApuestaInDTO.getImporte());
               return lineaApuestaOutDTO;
           }
           throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
       }
       throw new ValidacionException(DefinedError.ERROR_VALORES_DUPLICADOS.getErrorCode(),DefinedError.ERROR_VALORES_DUPLICADOS.getErrorMessage());
    }
    @Override
    public LineaApuestaOutDTO validarTernoDeDecena(LineaApuestaInDTO lineaApuestaInDTO){
        boolean flagTotal = lineaApuestaInDTO.isFlagImporte();
        long n = lineaApuestaInDTO.getNro().size();
        LineaApuestaOutDTO lineaApuestaOutDTO = new LineaApuestaOutDTO();
        lineaApuestaOutDTO.setAlcance(lineaApuestaInDTO.getAlcance());
        lineaApuestaOutDTO.setOrden(lineaApuestaInDTO.getOrden());
        lineaApuestaOutDTO.setTipo(lineaApuestaInDTO.getTipo());
        lineaApuestaOutDTO.setNro(lineaApuestaInDTO.getNro());
        for(int i=0; i < n; i++){
            validarCifras(lineaApuestaInDTO.getTipo(),lineaApuestaInDTO.getNro().get(i),ValidacionUtils.decena);
        }
        long combinatoria = combinatoriaTernoDeDecena(n);
        if(flagTotal){
            BigDecimal importeUnitario = BigDecimal.valueOf(lineaApuestaInDTO.getImporte()/combinatoria);
            if(importeUnitario.scale()>2) {
                BigDecimal valorRedondeado = importeUnitario.setScale(2, RoundingMode.DOWN);
                int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                if (flagDecimal == -1)
                    throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                lineaApuestaOutDTO.setImporteUnitario(valorRedondeado.doubleValue());
                lineaApuestaOutDTO.setImporteTotal(valorRedondeado.doubleValue()*combinatoria);
                return lineaApuestaOutDTO;
            }else{
                lineaApuestaOutDTO.setImporteUnitario(importeUnitario.doubleValue());
                lineaApuestaOutDTO.setImporteTotal(importeUnitario.doubleValue()*combinatoria);
                return lineaApuestaOutDTO;
            }

        }else if (validarImporte(lineaApuestaInDTO.getImporte())){
            //TODO: Maximo importe por apuesta
                BigDecimal importeTotal = BigDecimal.valueOf(lineaApuestaInDTO.getImporte()*combinatoria);
                BigDecimal importeTotalRedondeado = importeTotal.setScale(2, RoundingMode.HALF_DOWN);
                lineaApuestaOutDTO.setImporteUnitario(lineaApuestaInDTO.getImporte());
                lineaApuestaOutDTO.setImporteTotal(importeTotalRedondeado.doubleValue());
                return lineaApuestaOutDTO;
            }
        throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
    }
    @Override
    public LineaApuestaOutDTO validarInvertida(LineaApuestaInDTO lineaApuestaInDTO) {

        boolean totalFlag = lineaApuestaInDTO.isFlagImporte();
        long r = 0;
        long combinatoriaMillar=0;
        long combinatoria=0;
        long combinatoriaCentena=0;
        LineaApuestaOutDTO lineaApuestaOutDTO = new LineaApuestaOutDTO();
        lineaApuestaOutDTO.setAlcance(lineaApuestaInDTO.getAlcance());
        lineaApuestaOutDTO.setOrden(lineaApuestaInDTO.getOrden());
        lineaApuestaOutDTO.setTipo(lineaApuestaInDTO.getTipo());
        lineaApuestaOutDTO.setNro(lineaApuestaInDTO.getNro());
        //Digitos enviados desde el frontend
        long n = lineaApuestaInDTO.getNro().size();

        validarDuplicados(lineaApuestaInDTO.getNro());
        if (lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoMillar)) {
            r = ValidacionUtils.millar;
            combinatoriaMillar = combinatoria(n, r);
            if(n<r || n>10){
                throw new ValidacionException(DefinedError.ERROR_DIGITOS.getErrorCode(), DefinedError.ERROR_DIGITOS.getErrorMessage());
            }
        }
        if(lineaApuestaInDTO.getTipo().contains(ValidacionUtils.tipoCentena)){
            r= ValidacionUtils.centena;
            combinatoriaCentena = combinatoria(n,r);
            if(n<r || n>10){
                throw new ValidacionException(DefinedError.ERROR_DIGITOS.getErrorCode(), DefinedError.ERROR_DIGITOS.getErrorMessage());
            }
        }
        combinatoria=(combinatoriaMillar+combinatoriaCentena);
        if(totalFlag){
            BigDecimal importeUnitario = BigDecimal.valueOf(lineaApuestaInDTO.getImporte()/combinatoria);
            if(importeUnitario.scale()>2) {
                BigDecimal valorRedondeado = importeUnitario.setScale(2, RoundingMode.DOWN);
                int flagDecimal = valorRedondeado.compareTo(BigDecimal.valueOf(ValidacionUtils.importeMinimo));
                if (flagDecimal == -1)
                    throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
                lineaApuestaOutDTO.setImporteUnitario(valorRedondeado.doubleValue());
                BigDecimal totalRedondeado = valorRedondeado.multiply(BigDecimal.valueOf(combinatoria)).setScale(2);
                lineaApuestaOutDTO.setImporteTotal(totalRedondeado.doubleValue());
                return lineaApuestaOutDTO;
            }}else if (validarImporte(lineaApuestaInDTO.getImporte())){
            //TODO: Maximo importe por apuesta
                BigDecimal importeTotal = BigDecimal.valueOf(lineaApuestaInDTO.getImporte()*combinatoria);
                lineaApuestaOutDTO.setImporteTotal(importeTotal.doubleValue());
                lineaApuestaOutDTO.setImporteUnitario(lineaApuestaInDTO.getImporte());
                return lineaApuestaOutDTO;
            }
        throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(), DefinedError.ERROR_SALDO.getErrorMessage());
        }
        
    static long factorial(long n){
        long store_fact = 1;
        int i =1;
        while(i <= n){
            store_fact = store_fact*i;
            i++;
        }
        return store_fact;
    }
    static long combinatoria(long n ,long r){
        return factorial(n)/factorial(n-r);
    }
    static long combinatoriaExponencial(long n, long r){
        return (long) Math.pow(n,r);
    }
    static long combinatoriaTernoDeDecena(long n){
        return factorial(n)/factorial(3)*factorial(n-3);
    }
    static boolean validarCifras(String tipoJugadaIn, String numero, int cifras){
        if(numero.length() == cifras){
            return true;
        }
        if(tipoJugadaIn.contains(ValidacionUtils.tipoMillar)){
            throw new ValidacionException(DefinedError.ERROR_JUGADA_MILLAR.getErrorCode(), DefinedError.ERROR_JUGADA_MILLAR.getErrorMessage());
        }
        if(tipoJugadaIn.contains(ValidacionUtils.tipoCentena)) {
            throw new ValidacionException(DefinedError.ERROR_JUGADA_CENTENA.getErrorCode(), DefinedError.ERROR_JUGADA_CENTENA.getErrorMessage());
        }
        if(tipoJugadaIn.contains(ValidacionUtils.tipoDecena)) {
            throw new ValidacionException(DefinedError.ERROR_JUGADA_DECENA.getErrorCode(), DefinedError.ERROR_JUGADA_DECENA.getErrorMessage());
        }
        if(tipoJugadaIn.contains(ValidacionUtils.tipoGrupo)) {
            throw new ValidacionException(DefinedError.ERROR_JUGADA_GRUPO.getErrorCode(), DefinedError.ERROR_JUGADA_GRUPO.getErrorMessage());
        }
        return false;
    }
    static boolean validarImporte(double importe){
        if(importe>=ValidacionUtils.importeMinimo)
            return true;
        throw new ValidacionException(DefinedError.ERROR_SALDO.getErrorCode(),DefinedError.ERROR_SALDO.getErrorMessage());
    }
    static boolean validarDuplicados(List array) {
        Long distinctCount = array.stream().distinct().count();
        if(array.size() == distinctCount){
            return true;
        }
        throw new ValidacionException(DefinedError.ERROR_VALORES_DUPLICADOS.getErrorCode(),DefinedError.ERROR_VALORES_DUPLICADOS.getErrorMessage());
    }
    static long calcularRango(String numeroDesde, String numeroHasta){
        long primerValor = Long.parseLong(numeroDesde);
        long ultimoValor = Long.parseLong(numeroHasta);
        long rango;
        if(primerValor > ultimoValor){
            rango = primerValor - ultimoValor;
        } else {
            if(primerValor == ultimoValor){
                throw new ValidacionException(DefinedError.ERROR_RANGO.getErrorCode(),DefinedError.ERROR_RANGO.getErrorMessage());
            }
            rango = ultimoValor - primerValor;
        }
        return rango;
    }
}






