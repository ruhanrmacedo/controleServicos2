package br.edu.senai.sc.controleservicos2.controller;

import br.edu.senai.sc.controleservicos2.dto.ServicosExecutadosDTO;
import br.edu.senai.sc.controleservicos2.dto.TecnicoDTO;
import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import br.edu.senai.sc.controleservicos2.repository.ServicosExecutadosRepository;
import br.edu.senai.sc.controleservicos2.service.ServicosExecutadosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/servicoExecutado")
public class ServicosExecutadosController {

    private final ServicosExecutadosService servicosExecutadosService;
    private final ServicosExecutadosRepository servicosExecutadosRepository;

    public ServicosExecutadosController(ServicosExecutadosService servicosExecutadosService, ServicosExecutadosRepository servicosExecutadosRepository) {
        this.servicosExecutadosService = servicosExecutadosService;
        this.servicosExecutadosRepository = servicosExecutadosRepository;
    }

    @PostMapping("/executados")
    @ApiResponses(value = {
            @ApiResponse(code = 545, message = "Erro de teste"),
            @ApiResponse(code = 207, message = "Executado com sucesso!")
    })
    @ApiOperation(value = "Cadastrar contrato executado")
    public ResponseEntity<String> servicosExecutados(@RequestBody ServicosExecutadosDTO servicosExecutadosDTO){
        try {
            servicosExecutadosService.registrarServico(servicosExecutadosDTO);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro na digitação"+exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Serviço registrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/contratos")
    @ApiOperation(value = "Localizar contratos")
    public ResponseEntity<List>localizarContratos(){
        try {
            List<ServicosExecutados> servicosExecutados = servicosExecutadosService.localizarContratos();
                return new ResponseEntity<>(servicosExecutados, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tecnicos")
    @ApiOperation(value = "Erro")
    public List<TecnicoDTO> listarTecnicos() {
        List<Object[]> results = servicosExecutadosRepository.listarTecnicosContratosValorClaro();
        List<TecnicoDTO> tecnicos = new ArrayList<>();
        for (Object[] result : results) {
            TecnicoDTO tecnico = new TecnicoDTO();
            tecnico.setNome((String) result[0]);
            tecnico.setQuantidadeContratos((Integer) result[1]);
            tecnico.setSomaValorClaro((Double) result[2]);
            tecnicos.add(tecnico);
        }
        return tecnicos;
    }


    /*GetMapping("/valorPorTécnico")
        public void valorPorTécnico(){

        }*/


}
