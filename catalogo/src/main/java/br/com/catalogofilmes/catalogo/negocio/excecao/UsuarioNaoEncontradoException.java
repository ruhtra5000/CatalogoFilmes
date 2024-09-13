package br.com.catalogofilmes.catalogo.negocio.excecao;

public class UsuarioNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(){
        super("Usuário(s) não encontrado(s)!");
    }
}
