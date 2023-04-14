package br.edu.senai.sc.controleservicos2.service;

import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import br.edu.senai.sc.controleservicos2.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public Tecnico cadastrarTecnico(Tecnico tecnico){
        tecnicoRepository.save(tecnico);

        return tecnico;
    }

    public void excluirTecnico(Long codigoTecnico){
        tecnicoRepository.deleteById(codigoTecnico);
    }


    public Optional<Tecnico> consultarTecnicoPorCodigo(Long codigoTecnico){
        return tecnicoRepository.findById(codigoTecnico);
    }

    public void alterarDataAdmissao(LocalDateTime dataAdmissao, Long codigoTecnico){
        Optional<Tecnico> tecnico = tecnicoRepository.findById(codigoTecnico);
        if(Optional.ofNullable(tecnico).isPresent()){
            tecnico.get().setDataAdmissao(dataAdmissao);
            tecnicoRepository.save(tecnico.get());
        }
    }
}
