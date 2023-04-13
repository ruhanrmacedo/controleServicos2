package br.edu.senai.sc.controleservicos2.repository;
import br.edu.senai.sc.controleservicos2.dto.ServicoTecnicoDTO;
import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface ServicosExecutadosRepository extends JpaRepository<ServicosExecutados, Long> {

    /*public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome-da-unidade-de-persistencia");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT new br.edu.senai.sc.controleservicos2.dto.ServicoTecnicoDTO(se.contrato, se.dataExecucao, s.descricao, t.nome) " +
                "FROM ServicosExecutados se " +
                "JOIN se.servicos s " +
                "JOIN se.tecnico t";

        TypedQuery<ServicoTecnicoDTO> query = em.createQuery(jpql, ServicoTecnicoDTO.class);
        List<ServicoTecnicoDTO> servicoTecnicoDTOList = query.getResultList();

        for (ServicoTecnicoDTO servicoTecnicoDTO : servicoTecnicoDTOList) {
            System.out.println(servicoTecnicoDTO.toString());
        }

        em.close();
        emf.close();
    }*/
}
