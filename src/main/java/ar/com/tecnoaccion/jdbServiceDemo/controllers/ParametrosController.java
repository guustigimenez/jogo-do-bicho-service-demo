package ar.com.tecnoaccion.jdbServiceDemo.controllers;


import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.parametros.jsonclasses.ParametrosJuego;
import ar.com.tecnoaccion.jdbServiceDemo.services.ParametrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parametros")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ParametrosController {

    private ParametrosService parametrosService;

    public ParametrosController(ParametrosService parametrosService) {
        this.parametrosService = parametrosService;
    }
    @CrossOrigin("https://jdb-plataforma-22-6-22.web.app")
    @GetMapping("/init")
    public ResponseEntity<?> getParametrosIniciales(@RequestParam(name="codigoJuego") Integer codigoJuego){
        return ResponseEntity.ok(parametrosService.getParametrosIniciales(codigoJuego));
    }
    @CrossOrigin("https://jdb-plataforma-22-6-22.web.app")
    @GetMapping("/init-json")
    public ResponseEntity<ParametrosJuego> getParametrosInicialesJson(){
        return ResponseEntity.ok(parametrosService.getParametrosInicialesJson());
    }

}
