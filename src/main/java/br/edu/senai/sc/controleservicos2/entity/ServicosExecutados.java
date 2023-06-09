package br.edu.senai.sc.controleservicos2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServicosExecutados {
    @Id
    private int contrato;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataExecucao;
    @ManyToOne
    @JoinColumn(name = "servicos")
    private Servicos servicos;
    @ManyToOne
    @JoinColumn(name = "tecnico")
    private Tecnico tecnico;
}
