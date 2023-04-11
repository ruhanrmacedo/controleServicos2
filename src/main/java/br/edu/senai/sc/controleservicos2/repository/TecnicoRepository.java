package br.edu.senai.sc.controleservicos2.repository;

import br.edu.senai.sc.controleservicos2.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

}
