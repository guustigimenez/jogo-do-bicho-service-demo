package ar.com.tecnoaccion.jdbServiceDemo.services.impl;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.TotalesOutDTO;
import ar.com.tecnoaccion.jdbServiceDemo.services.TotalesService;
import org.springframework.stereotype.Service;

@Service
public class TotalesServiceImpl implements TotalesService {

    @Override
    public TotalesOutDTO getTotales() {

        TotalesOutDTO totalesOutDTO = new TotalesOutDTO(50,25,10,15);

        return totalesOutDTO;
    }
}
