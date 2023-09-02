package com.barber.barbershopmanager.Produto;

public class Produto extends Entityid {

    public String nome;
    public String descricao;
    public Double precoVenda;
    public Double precoCompra;
    public Status status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Produto(String nome, String descricao, Double precoVenda, Double precoCompra, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.status = status;
    }
}