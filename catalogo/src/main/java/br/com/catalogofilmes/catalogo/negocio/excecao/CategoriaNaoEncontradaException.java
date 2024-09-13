package br.com.catalogofilmes.catalogo.negocio.excecao;

public class CategoriaNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException(){
        super("Categoria(s) não encontrada(s)!");
    }
}
