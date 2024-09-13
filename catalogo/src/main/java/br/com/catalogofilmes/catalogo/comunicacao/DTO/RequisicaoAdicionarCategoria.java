package br.com.catalogofilmes.catalogo.comunicacao.DTO;

/**
 * Classe que define os dados necessários para a requisição de cadastro de categorias
 * @author Arthur de Sá Tenório
 * @category Classe de DTO (Data Transfer Object)
 */

public class RequisicaoAdicionarCategoria {
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
