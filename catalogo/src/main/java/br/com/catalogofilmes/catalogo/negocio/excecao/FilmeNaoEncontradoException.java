package br.com.catalogofilmes.catalogo.negocio.excecao;

public class FilmeNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public FilmeNaoEncontradoException(){
        super("Filme(s) não encontrado(s)!");
    }
}
