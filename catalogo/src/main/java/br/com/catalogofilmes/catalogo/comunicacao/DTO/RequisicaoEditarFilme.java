package br.com.catalogofilmes.catalogo.comunicacao.DTO;

import java.util.List;

import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;

public class RequisicaoEditarFilme {
    private long id;
    private String nome;
    private String sinopse;
    private int duracao;
    private List<Categoria> categorias;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}