package br.com.catalogofilmes.catalogo.negocio.excecao;

public class CategoriaDuplicadaException extends Exception {
    private static final long serialVersionUID = 1L;

    public CategoriaDuplicadaException(String nome){
        super("Categoria " + nome + " já existente.");
    }
}
