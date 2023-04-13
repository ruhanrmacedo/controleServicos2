package br.edu.senai.sc.controleservicos2.dto;


import br.edu.senai.sc.controleservicos2.entity.Servicos;
import br.edu.senai.sc.controleservicos2.entity.Tecnico;

import java.time.LocalDateTime;

public class ServicoTecnicoDTO {
    private int contrato;
    private LocalDateTime dataExecucao;
    private String descricaoServico;
    private String nomeTecnico;

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

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }
}
