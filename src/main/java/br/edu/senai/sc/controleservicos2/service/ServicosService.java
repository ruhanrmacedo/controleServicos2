package br.edu.senai.sc.controleservicos2.service;

import br.edu.senai.sc.controleservicos2.entity.Servicos;
import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import br.edu.senai.sc.controleservicos2.repository.ServicosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosService {

    private final ServicosRepository servicosRepository;

    public ServicosService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public Servicos cadastrarServicos(Servicos servicos){
        servicosRepository.save(servicos);

        return servicos;
    }

    public void excluirServicos(Long codigoServico){
        servicosRepository.deleteById(codigoServico);
    }

    public Optional<Servicos> consultarServicosPorCodigo(Long codigoServico){
        return servicosRepository.findById(codigoServico);
    }

    public List<Servicos> localizarDescricao(String descricao){
        return servicosRepository.findServicosByDescricaoContaining(descricao);
    }

    public void alterarValor(Double valorClaro, Long codigoServico){
        Optional<Servicos> servicos = servicosRepository.findById(codigoServico);
        if(Optional.ofNullable(servicos).isPresent()){
            servicos.get().setValorClaro(valorClaro);
            servicosRepository.save(servicos.get());
        }
    }



}
