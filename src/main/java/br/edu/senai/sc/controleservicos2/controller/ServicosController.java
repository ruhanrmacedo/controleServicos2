package br.edu.senai.sc.controleservicos2.controller;

import br.edu.senai.sc.controleservicos2.entity.Servicos;
import br.edu.senai.sc.controleservicos2.service.ServicosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/servicos")
public class ServicosController {

    private final ServicosService servicosService;

    public ServicosController(ServicosService servicosService) {
        this.servicosService = servicosService;
    }


    @GetMapping("/teste")
    public ResponseEntity<Servicos> teste(){
        Servicos servicos = new Servicos();
        servicos.setCodigoServico(2);
        servicos.setDescricao("PONTO EXTRA");
        servicos.setValorClaro(108.32);
        servicos.setValorTecnico(15.72);

        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarServico(@RequestBody Servicos servicos){
        try {
            servicosService.cadastrarServicos(servicos);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar serviço", HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>("Serviço cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/alterar/")
    public ResponseEntity<String> alterarServico(@RequestBody Servicos servicos, @PathVariable("codigoServico") int codigoServico){
        try {
            servicosService.cadastrarServicos(servicos);
        } catch (Exception exception) {

            return new ResponseEntity<>("Erro ao alterar serviços", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Serviço alterado com sucesso", HttpStatus.CREATED);

    }

    @PostMapping("/alterarValorClaro/{codigoServico}")
    public ResponseEntity<String> alterarValorClaro(@RequestParam Double valorClaro, @PathVariable("codigoServico") Long codigoServico){
        try {
            servicosService.alterarValor(valorClaro, codigoServico);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao alterar valor!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Valor alterado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/excluirServicos/{codigoServico}")
    public ResponseEntity<String> excluirServicos(@PathVariable("codigoServico") Long codigoServico){
        try {
            servicosService.excluirServicos(codigoServico);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir o serviço", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Serviço excluido com sucesso", HttpStatus.OK);
    }

    @GetMapping("consultarServicos/{codigoServico}")
    public ResponseEntity<Servicos> consultarServicos(@PathVariable("codigoServico") Long codigoServico) {
        try {
            Optional<Servicos> servicos = servicosService.consultarServicosPorCodigo(codigoServico);
            if (Optional.ofNullable(servicos).isPresent())
                return new ResponseEntity<>(servicos.get(), HttpStatus.OK);
            return new ResponseEntity<>(new Servicos(), HttpStatus.NO_CONTENT);
        }catch (Exception exception){
            return new ResponseEntity<>(new Servicos(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/servicos/descricao")
    public ResponseEntity<List<Servicos>> localizarDescricao(@RequestParam("descricao") String descricao){
        try {
            List<Servicos> servicos = servicosService.localizarDescricao(descricao);
            return new ResponseEntity<>(servicos, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
}
