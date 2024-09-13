package br.com.catalogofilmes.catalogo.negocio.colecao;

import java.util.List;

import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaDuplicadaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;

/**
 * Interface que define as atribuições da classe CategoriaNegocio
 * @author Arthur de Sá Tenório
 * @category Interface de coleção
 */

public interface IColecaoCategoria {
    public void adicionarCategoria (String nome) throws CategoriaDuplicadaException;
    public void editarCategoria (long id, String nome) throws CategoriaNaoEncontradaException, CategoriaDuplicadaException;

    public List<Categoria> listarTodos();
    public Categoria listarPorId(long id) throws CategoriaNaoEncontradaException;
    public List<Categoria> listarPorNome(String nome) throws CategoriaNaoEncontradaException;
}
