package br.edu.senai.sc.controleservicos2.repository;
import br.edu.senai.sc.controleservicos2.dto.ServicoTecnicoDTO;
import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface ServicosExecutadosRepository extends JpaRepository<ServicosExecutados, Long> {

    @Query(nativeQuery = true, value = "SELECT t.nome, COUNT(se.contrato), SUM(se.servicos.valorClaro) " +
            "FROM servicos_executados se " +
            "JOIN tecnico t ON se.tecnico_codigo_tecnico = t.codigo_tecnico " +
            "GROUP BY t.nome")
    List<Object[]> listarTecnicosContratosValorClaro();


    @Query(value = "SELECT se.contrato, se.data_execucao, s.descricao, t.nome " +
            "FROM Servicos_Executados se " +
            "JOIN Servicos s ON se.servicos_codigo_servico = s.codigo_servico " +
            "JOIN Tecnico t ON se.tecnico_codigo_tecnico = t.codigo_tecnico " +
            "ORDER BY t.nome", nativeQuery = true)
    List<Object[]> listarTecnicosContratosServicos();
}
