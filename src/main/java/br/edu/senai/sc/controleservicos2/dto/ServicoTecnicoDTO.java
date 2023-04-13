package br.edu.senai.sc.controleservicos2.dto;

public class ServicoTecnicoDTO {
    private String descricao;
    private String nome;

    public ServicoTecnicoDTO() {}

    public ServicoTecnicoDTO(String descricao, String nome) {
        this.descricao = descricao;
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeTecnico) {
        this.nome = nomeTecnico;
    }
}

