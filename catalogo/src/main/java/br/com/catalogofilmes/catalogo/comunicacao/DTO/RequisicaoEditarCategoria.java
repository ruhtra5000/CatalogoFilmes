package br.com.catalogofilmes.catalogo.comunicacao.DTO;

/**
 * Classe que define os dados necessários para a requisição de edição de uma categoria
 * @author Arthur de Sá Tenório
 * @category Classe de DTO (Data Transfer Object)
 */

public class RequisicaoEditarCategoria {
    private long id;
    private String nome;

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

}
