package br.edu.senai.sc.controleservicos2.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServicosExecutadosDTO {

    private int contrato;
    private LocalDateTime dataExecucao;
    private Long servicos;
    private Long tecnico;

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public LocalDateTime getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(LocalDateTime dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Long getServicos() {
        return servicos;
    }

    public void setServicos(Long servicos) {
        this.servicos = servicos;
    }

    public Long getTecnico() {
        return tecnico;
    }

    public void setTecnico(Long tecnico) {
        this.tecnico = tecnico;
    }

    public void setDescricao(String s) {
    }
}
