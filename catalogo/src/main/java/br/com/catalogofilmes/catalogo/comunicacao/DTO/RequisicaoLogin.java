package br.com.catalogofilmes.catalogo.comunicacao.DTO;

/**
 * Classe que define os dados necessários para a requisição de login
 * @author Arthur de Sá Tenório
 * @category Classe de DTO (Data Transfer Object)
 */

public class RequisicaoLogin {
    private String email;
    private String senha;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
