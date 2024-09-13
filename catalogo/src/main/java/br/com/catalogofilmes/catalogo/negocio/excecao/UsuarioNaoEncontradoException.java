package br.com.catalogofilmes.catalogo.negocio.excecao;

/**
 * @author Arthur de Sá Tenório
 * @category Classe de exceção personalizada
 */

public class UsuarioNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(){
        super("Usuário(s) não encontrado(s)!");
    }
}
