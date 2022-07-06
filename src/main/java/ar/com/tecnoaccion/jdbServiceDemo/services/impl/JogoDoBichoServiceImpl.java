package ar.com.tecnoaccion.jdbServiceDemo.services.impl;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.CuponInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.ETicketDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.SorteoSorteadoraDTO;
import ar.com.tecnoaccion.jdbServiceDemo.services.JogoDoBichoService;
import ar.com.tecnoaccion.jdbServiceDemo.services.ParametrosService;
import ar.com.tecnoaccion.juego.library.models.dtos.frontend.InitJuegoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ApuestasService")
public class JogoDoBichoServiceImpl implements JogoDoBichoService {

    private ParametrosService parametrosService;

   /* @Autowired
    private CuponWebServices cuponWebServices;
*/

    @Override
    public ETicketDTO grabarApuesta(CuponInDTO cuponInDTO) {
       ETicketDTO eTicketDTO = new ETicketDTO();
       SorteoSorteadoraDTO sorteoSorteadoraDTO1= new SorteoSorteadoraDTO("Federal", "12:30");
        SorteoSorteadoraDTO sorteoSorteadoraDTO2= new SorteoSorteadoraDTO("Maranhao", "12:30");
        List<SorteoSorteadoraDTO> listaSorteos=new ArrayList<SorteoSorteadoraDTO>();
        listaSorteos.add(sorteoSorteadoraDTO1);
        listaSorteos.add(sorteoSorteadoraDTO2);
        LineaApuestaInDTO lineaApuestaDTO= cuponInDTO.getLineaApuestaList().get(0);
        LineaApuestaInDTO lineaApuestaDTO1= cuponInDTO.getLineaApuestaList().get(1);
        List<LineaApuestaInDTO> listaApuestas= new ArrayList<LineaApuestaInDTO>();
        listaApuestas.add(lineaApuestaDTO);
        listaApuestas.add(lineaApuestaDTO1);

        eTicketDTO.setOrganizacion(cuponInDTO.getCodOrganizacion());
        eTicketDTO.setEvento(cuponInDTO.getEvento());
        eTicketDTO.setFecEmision("08/06/2022 14:58:03");
        eTicketDTO.setFecSorteo("08/06/2022 14:58:03");
        eTicketDTO.setJuego(0);
        eTicketDTO.setIdCupon("cf9c4055-7a0a-4b87-9298-1f08c660d52e");
        eTicketDTO.setLineasApu(listaApuestas);
        eTicketDTO.setLogoJuego("logo.png");
        eTicketDTO.setImporteTotal(cuponInDTO.getImporteTotal());
        eTicketDTO.setNuc(4156156);
        eTicketDTO.setLogoOrganizacion("logoOrg.png");
        eTicketDTO.setSorteos(listaSorteos);
        eTicketDTO.setEvento("JDB");

        return eTicketDTO;
    }

    @Override
    public InitJuegoDTO initJuego(Integer codigoJuego) {
       return null;
    }
}
