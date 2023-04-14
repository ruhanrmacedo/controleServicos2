package br.edu.senai.sc.controleservicos2.dto;

public class TecnicoDTO {

    private String nome;
    private int quantidadeContratos;
    private Double somaValorClaro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeContratos() {
        return quantidadeContratos;
    }

    public void setQuantidadeContratos(int quantidadeContratos) {
        this.quantidadeContratos = quantidadeContratos;
    }

    public Double getSomaValorClaro() {
        return somaValorClaro;
    }

    public void setSomaValorClaro(Double somaValorClaro) {
        this.somaValorClaro = somaValorClaro;
    }
}
