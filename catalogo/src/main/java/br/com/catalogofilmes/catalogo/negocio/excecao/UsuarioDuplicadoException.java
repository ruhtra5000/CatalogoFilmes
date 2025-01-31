package br.com.catalogofilmes.catalogo.negocio.excecao;

/**
 * @author Arthur de Sá Tenório
 * @category Classe de exceção personalizada
 */

public class UsuarioDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;
    private String email;
    
    public UsuarioDuplicadoException(String email){
        super("Já existe um usuário com o e-mail " + email);
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}
