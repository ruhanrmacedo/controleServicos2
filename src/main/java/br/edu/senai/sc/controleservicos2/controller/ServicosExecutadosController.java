package br.edu.senai.sc.controleservicos2.controller;

import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import br.edu.senai.sc.controleservicos2.service.ServicosExecutadosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/servicoExecutado")
public class ServicosExecutadosController {

    private final ServicosExecutadosService servicosExecutadosService;

    public ServicosExecutadosController(ServicosExecutadosService servicosExecutadosService) {
        this.servicosExecutadosService = servicosExecutadosService;
    }

    @PostMapping
    public ResponseEntity<String> servicosExecutados(@RequestBody ServicosExecutados servicosExecutados){
        try {
            servicosExecutadosService.registrarServico(servicosExecutados);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro na digitação", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Serviço registrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/contratos")
    public ResponseEntity<List>localizarContratos(){
        try {
            List<ServicosExecutados> servicosExecutados = servicosExecutadosService.localizarContratos();
                return new ResponseEntity<>(servicosExecutados, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }


}
