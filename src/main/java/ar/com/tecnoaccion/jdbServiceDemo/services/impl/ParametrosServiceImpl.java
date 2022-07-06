package ar.com.tecnoaccion.jdbServiceDemo.services.impl;


import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.ParametrosWrapperDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses.ParametrosJuego;
import ar.com.tecnoaccion.jdbServiceDemo.services.ParametrosService;
import ar.com.tecnoaccion.juego.library.models.dtos.TipoStatus;
import ar.com.tecnoaccion.juego.library.models.dtos.billetera.BilleteraInDTO;
import ar.com.tecnoaccion.juego.library.services.CuponWebServices;
import ar.com.tecnoaccion.juego.library.utils.ObjectMapperUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;

@Service("ParametrosService")
public class ParametrosServiceImpl implements ParametrosService {
    private CuponWebServices cuponWebServices;
    private static Logger logger = LoggerFactory.getLogger(ParametrosServiceImpl.class);

    @Value("${spring.application.jsonobject.param.init.billetera}")
    private String keyParamInicialBilletera;
    @Value("${spring.application.jsonobject.param.init.eventos}")
    private String keyParamInicialEventos;

  public ParametrosServiceImpl(CuponWebServices cuponWebServices) {
      this.cuponWebServices = cuponWebServices;
  }

     @Override
    public ParametrosWrapperDTO getParametrosIniciales(Integer codigoJuego) {
        ParametrosWrapperDTO parametrosWrapperDTO = new ParametrosWrapperDTO();
        JSONObject jsonObject = cuponWebServices.getParametrosIniciales(codigoJuego);
        BilleteraInDTO billeteraInDTO = ObjectMapperUtils.map(jsonObject.get(keyParamInicialBilletera), BilleteraInDTO.class);

        parametrosWrapperDTO.setSaldo(billeteraInDTO.getSaldo());
        parametrosWrapperDTO.setCodigoJuego(codigoJuego);

        return parametrosWrapperDTO;
    }

    @Override
    public ParametrosJuego getParametrosInicialesJson() {
        //TODO completar lo que viene desde cuponService en el metodo comentado con los valores que correspondan segun los otros juegos.
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("datosQueVendrianDeCuponService", Arrays.asList("Datos", "Que vendrian", "De cupon"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object object;
        ParametrosJuego parametrosIniciales = new ParametrosJuego();
        try{
            logger.info("Consulta a json file por parametros iniciales.");
            parametrosIniciales = objectMapper.readValue(new File("src/main/java/ar/com/tecnoaccion/jdbServiceDemo/jsonmocks/parametros.json"), ParametrosJuego.class);
            object = objectMapper.readValue(jsonObject.toString(), Object.class);
            parametrosIniciales.setObject(object);
        } catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            parametrosIniciales.setStatus(TipoStatus.ERROR);
        }

        return parametrosIniciales;
    }


}
