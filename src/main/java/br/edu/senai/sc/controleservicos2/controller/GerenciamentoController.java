package br.edu.senai.sc.controleservicos2.controller;

import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import br.edu.senai.sc.controleservicos2.service.TecnicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/api/gerenciamento")
public class GerenciamentoController {

    private final TecnicoService tecnicoService;

    public GerenciamentoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping("/teste")
    public ResponseEntity<Tecnico> teste(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Paulo");
        tecnico.setCpf("075.000.000-20");

        return new ResponseEntity<>(tecnico, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarTecnico(@RequestBody Tecnico tecnico){
        try {
            tecnicoService.cadastrarTecnico(tecnico);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar técnico", HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>("Técnico cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/alterar")
    public ResponseEntity<String> alterarTecnico(@RequestBody Tecnico tecnico, @PathVariable("codigoTecnico") int codigoTecnico) {
        try {
            tecnicoService.cadastrarTecnico(tecnico);
        } catch (Exception exception) {

            return new ResponseEntity<>("Erro ao alterar técnico", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Técnico alterado com sucesso", HttpStatus.CREATED);
    }

    @DeleteMapping("/excluirTecnico/{codigoTecnico}")
    public ResponseEntity<String> excluirTecnico(@PathVariable("codigoTecnico") Long codigoTecnico){
        try {
            tecnicoService.excluirTecnico(codigoTecnico);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir o técnico", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Técnico excluido com sucesso", HttpStatus.OK);
    }

    @GetMapping("consultarTecnico/{codigoServico}")
    public ResponseEntity<Tecnico> consultarServicos(@PathVariable("codigoTecnico") Long codigoTecnico) {
        try {
            Optional<Tecnico> tecnico = tecnicoService.consultarTecnicoPorCodigo(codigoTecnico);
            if (Optional.ofNullable(tecnico).isPresent())
                return new ResponseEntity<>(tecnico.get(), HttpStatus.OK);
            return new ResponseEntity<>(new Tecnico(), HttpStatus.NO_CONTENT);
        }catch (Exception exception){
            return new ResponseEntity<>(new Tecnico(), HttpStatus.BAD_REQUEST);
        }
    }




}
