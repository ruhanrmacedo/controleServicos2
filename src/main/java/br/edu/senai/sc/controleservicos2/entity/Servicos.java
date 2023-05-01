package br.edu.senai.sc.controleservicos2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servicos {
    @Id
    private Long codigoServico;
    private String descricao;
    private Double valorClaro;
    private Double valorTecnico;

    @OneToMany(mappedBy = "servicos")
    private List<ServicosExecutados> servicosExecutados;


}
