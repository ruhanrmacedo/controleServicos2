package br.edu.senai.sc.controleservicos2.repository;

import br.edu.senai.sc.controleservicos2.entity.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {

    List<Servicos> findServicosByDescricaoContaining(String descricao);


    
}
