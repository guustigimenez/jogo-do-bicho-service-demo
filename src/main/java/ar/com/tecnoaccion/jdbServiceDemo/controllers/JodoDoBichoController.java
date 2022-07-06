package ar.com.tecnoaccion.jdbServiceDemo.controllers;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.CuponInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;
import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaOutDTO;
import ar.com.tecnoaccion.jdbServiceDemo.services.JogoDoBichoService;
import ar.com.tecnoaccion.jdbServiceDemo.services.TotalesService;
import ar.com.tecnoaccion.jdbServiceDemo.services.ValidarApuestasService;
import ar.com.tecnoaccion.jdbServiceDemo.utils.CheckFieldErrors;
import ar.com.tecnoaccion.juego.library.services.CuponWebServices;
import ar.com.tecnoaccion.juego.library.utils.CheckObjectErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/apuestas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class JodoDoBichoController {

    private JogoDoBichoService jogoDoBichoService;
    private TotalesService totalesService;
    private ValidarApuestasService validarApuestasService;



    public JodoDoBichoController(JogoDoBichoService jogoDoBichoService, TotalesService totalesService,ValidarApuestasService validarApuestasService) {
        this.jogoDoBichoService = jogoDoBichoService;
        this.totalesService = totalesService;
        this.validarApuestasService = validarApuestasService;
    }
    @CrossOrigin("https://jdb-plataforma-22-6-22.web.app")
    @PostMapping("/grabarApuesta")
    public ResponseEntity<?> cargar(@Valid @RequestBody CuponInDTO cuponInDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CheckObjectErrors.map(bindingResult);
        }
        return ResponseEntity.ok(jogoDoBichoService.grabarApuesta(cuponInDTO));
    }
    @CrossOrigin("https://jdb-plataforma-22-6-22.web.app")
    @GetMapping("/init-juego")
    public ResponseEntity<?> initJuego(@RequestParam(name = "codigoJuego", defaultValue = "${spring.application.juego.codigo}") Integer codigoJuego){
        return ResponseEntity.ok(jogoDoBichoService.initJuego(codigoJuego));
    }

    @CrossOrigin("https://jdb-plataforma-22-6-22.web.app")
    @PostMapping("/validar")
    public ResponseEntity<?> validarApuesta(@RequestBody LineaApuestaInDTO lineaApuestaInDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return CheckFieldErrors.map(bindingResult);
        }
        return ResponseEntity.ok(validarApuestasService.validar(lineaApuestaInDTO));
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/totales")
    public ResponseEntity<?> getTotales() {
        return ResponseEntity.ok(totalesService.getTotales());
    }
}
