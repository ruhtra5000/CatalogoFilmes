package br.com.catalogofilmes.catalogo.comunicacao.DTO;

/**
 * Classe que define os dados necessários para a requisição de cadastro de usuarios
 * @author Arthur de Sá Tenório
 * @category Classe de DTO (Data Transfer Object)
 */

public class RequisicaoCadastroUsuario {
    private String nome;
    private String email;
    private String senha;
    private boolean admin;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public boolean isAdmin() {
        return this.admin;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
