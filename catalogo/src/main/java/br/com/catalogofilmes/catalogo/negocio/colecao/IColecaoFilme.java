package br.com.catalogofilmes.catalogo.negocio.colecao;

import java.util.List;

import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import br.com.catalogofilmes.catalogo.negocio.entidade.Filme;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.FilmeNaoEncontradoException;

/**
 * Interface que define as atribuições da classe FilmeNegocio
 * @author Arthur de Sá Tenório
 * @category Interface de coleção
 */

public interface IColecaoFilme {
    public void adicionarFilme(String nome, String sinopse, int duracao, List<Categoria> categorias);
    public void editarFilme(long id, String nome, String sinopse, int duracao, 
                            List<Categoria> categorias) throws FilmeNaoEncontradoException;

    public List<Filme> listarTodos();
    public Filme listarPorId(long id) throws FilmeNaoEncontradoException;
    public List<Filme> listarPorNome(String nome) throws FilmeNaoEncontradoException;
    public List<Filme> listarPorCategoria(String categoria) throws CategoriaNaoEncontradaException;
}
