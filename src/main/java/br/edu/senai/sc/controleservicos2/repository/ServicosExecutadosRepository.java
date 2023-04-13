package br.edu.senai.sc.controleservicos2.repository;
import br.edu.senai.sc.controleservicos2.entity.ServicosExecutados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServicosExecutadosRepository extends JpaRepository<ServicosExecutados, Long> {

}
