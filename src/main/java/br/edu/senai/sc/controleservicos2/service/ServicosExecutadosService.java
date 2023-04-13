package br.edu.senai.sc.controleservicos2.service;

import br.edu.senai.sc.controleservicos2.dto.ServicoTecnicoDTO;
import br.edu.senai.sc.controleservicos2.dto.ServicosExecutadosDTO;
import br.edu.senai.sc.controleservicos2.entity.Servicos;
import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import br.edu.senai.sc.controleservicos2.repository.ServicoTecnicoProjection;
import br.edu.senai.sc.controleservicos2.repository.ServicosExecutadosRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicosExecutadosService {

    private final ServicosExecutadosRepository servicosExecutadosRepository;
    private final TecnicoService tecnicoService;
    private final ServicosService servicosService;

    public ServicosExecutadosService(ServicosExecutadosRepository servicosExecutadosRepository, TecnicoService tecnicoService, ServicosService servicosService) {
        this.servicosExecutadosRepository = servicosExecutadosRepository;
        this.tecnicoService = tecnicoService;
        this.servicosService = servicosService;
    }
    public void registrarServico(ServicosExecutadosDTO servicosExecutadosDTO) throws Exception {
        ServicosExecutados servicosExecutados = new ServicosExecutados();
        servicosExecutados.setContrato(servicosExecutadosDTO.getContrato());
        servicosExecutados.setDataExecucao(servicosExecutadosDTO.getDataExecucao());

        Optional<Servicos> servicos = servicosService.consultarServicosPorCodigo(servicosExecutadosDTO.getServicos());
        Optional<Tecnico> tecnico = tecnicoService.consultarTecnicoPorCodigo(servicosExecutadosDTO.getTecnico());

        if (!servicos.isPresent() || servicos.isEmpty())
            throw new Exception("Serviço não encontrado!");

        servicosExecutados.setServicos(servicos.get());

        if (!tecnico.isPresent() || tecnico.isEmpty())
            throw new Exception("Técnico não encontrado!");

        servicosExecutados.setTecnico(tecnico.get());


        servicosExecutadosRepository.save(servicosExecutados);
    }

    public List<ServicoTecnicoDTO> findAllServicoTecnicoDTO() {
        List<ServicoTecnicoProjection> listProjection = servicosExecutadosRepository.findAllProjectedBy();
        List<ServicoTecnicoDTO> listDTO = new ArrayList<>();
        for (ServicoTecnicoProjection projection : listProjection) {
            ServicoTecnicoDTO dto = new ServicoTecnicoDTO();
            dto.setDescricao(projection.getDescricao());
            dto.setNome(projection.getNome());
            listDTO.add(dto);
        }
        return listDTO;
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
