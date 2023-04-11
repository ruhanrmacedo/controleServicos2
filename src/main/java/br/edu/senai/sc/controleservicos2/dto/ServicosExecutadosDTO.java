package br.edu.senai.sc.controleservicos2.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServicosExecutadosDTO {

    private int contrato;
    private LocalDateTime dataExecucao;
    private Long servicos;
    private Long tecnico;
}
