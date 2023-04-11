package br.edu.senai.sc.controleservicos2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoTecnico;
    private String nome;
    private String cpf;
    private LocalDateTime dataAdmissao;

    @OneToMany(mappedBy = "tecnico")
    private List<ServicosExecutados> servicosExecutados;



}
