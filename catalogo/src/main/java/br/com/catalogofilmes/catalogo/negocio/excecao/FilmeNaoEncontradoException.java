package br.com.catalogofilmes.catalogo.negocio.excecao;

/**
 * @author Arthur de Sá Tenório
 * @category Classe de exceção personalizada
 */

public class FilmeNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public FilmeNaoEncontradoException(){
        super("Filme(s) não encontrado(s)!");
    }
}
