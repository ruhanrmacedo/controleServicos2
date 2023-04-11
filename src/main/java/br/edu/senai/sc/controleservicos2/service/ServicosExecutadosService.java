package br.edu.senai.sc.controleservicos2.service;

import br.edu.senai.sc.controleservicos2.dto.ServicosExecutadosDTO;
import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import br.edu.senai.sc.controleservicos2.repository.ServicosExecutadosRepository;
import br.edu.senai.sc.controleservicos2.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosExecutadosService {

    private final ServicosExecutadosRepository servicosExecutadosRepository;
    private final TecnicoRepository tecnicoRepository;

    public ServicosExecutadosService(ServicosExecutadosRepository servicosExecutadosRepository, TecnicoRepository tecnicoRepository) {
        this.servicosExecutadosRepository = servicosExecutadosRepository;
        this.tecnicoRepository = tecnicoRepository;
    }
    public void registrarServico(ServicosExecutadosDTO servicosExecutadosDTO){

    }

    public void consultar(){

    }

    public Optional<ServicosExecutados>localizarContrato(Long contrato){
        return servicosExecutadosRepository.findById(contrato);
    }

    public List<ServicosExecutados> localizarContratos(){
        return servicosExecutadosRepository.findAll();
    }

}

  /*public void alterarTecnico(int contrato, int codigoTecnico){
        Optional<ServicosExecutados> servicosExecutados = servicosExecutadosRepository.findById(contrato);
        Optional<Tecnico> tecnico = tecnicoRepository.findById(codigoTecnico);

        if(servicosExecutados.isPresent() && tecnico.isPresent()){
            servicosExecutados.get().setTecnico(tecnico.get());
            servicosExecutadosRepository.save(servicosExecutados.get());
        }
    }
}*/
