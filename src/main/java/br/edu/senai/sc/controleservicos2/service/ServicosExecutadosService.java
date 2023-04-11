package br.edu.senai.sc.controleservicos2.service;

import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import br.edu.senai.sc.controleservicos2.repository.ServicosExecutadosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosExecutadosService {

    private final ServicosExecutadosRepository servicosExecutadosRepository;

    public ServicosExecutadosService(ServicosExecutadosRepository servicosExecutadosRepository) {
        this.servicosExecutadosRepository = servicosExecutadosRepository;
    }

    public ServicosExecutados registrarServico(ServicosExecutados servicosExecutados){
        servicosExecutadosRepository.save(servicosExecutados);

        return servicosExecutados;
    }

    public Optional<ServicosExecutados>localizarContrato(Long contrato){
        return servicosExecutadosRepository.findById(contrato);
    }

    public List<ServicosExecutados> localizarContratos(){
        return servicosExecutadosRepository.findAll();
    }

    public void alterarTecnico(Tecnico tecnico, int tecnico){
        Optional<ServicosExecutados> servicosExecutados = servicosExecutadosRepository.findById(tecnico)
        if(Optional.ofNullable(servicosExecutados).isPresent()){
            servicosExecutados.get().setTecnico(Tecnico tecnico);
            servicosExecutadosRepository.save(servicosExecutados.get());
        }
    }
}
