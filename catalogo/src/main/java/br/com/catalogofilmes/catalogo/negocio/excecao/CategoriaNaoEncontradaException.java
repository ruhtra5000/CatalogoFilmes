package br.com.catalogofilmes.catalogo.negocio.excecao;

/**
 * @author Arthur de Sá Tenório
 * @category Classe de exceção personalizada
 */

public class CategoriaNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException(){
        super("Categoria(s) não encontrada(s)!");
    }
}
