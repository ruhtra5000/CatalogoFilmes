package br.com.catalogofilmes.catalogo.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catalogofilmes.catalogo.negocio.colecao.IColecaoCategoria;
import br.com.catalogofilmes.catalogo.negocio.colecao.IColecaoFilme;
import br.com.catalogofilmes.catalogo.negocio.colecao.IColecaoUsuario;
import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import br.com.catalogofilmes.catalogo.negocio.entidade.Filme;
import br.com.catalogofilmes.catalogo.negocio.entidade.Usuario;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaDuplicadaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.FilmeNaoEncontradoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioDuplicadoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioNaoEncontradoException;

/**
 * Fachada de administrador, definindo o ponto de acesso da administração ao sistema.
 * @author Arthur de Sá Tenório
 * @category Classe de fachada
 */

@Service
public class FachadaAdmin {
    @Autowired
    private IColecaoUsuario colecaoUsuario;
    @Autowired
    private IColecaoFilme colecaoFilme;
    @Autowired
    private IColecaoCategoria colecaoCategoria;

    /**
     * Métodos de listagem e ações envolvendo o usuário 
     */
    public void editarUsuario(long id, String nome, String email, String senha, boolean admin) 
                              throws UsuarioNaoEncontradoException, UsuarioDuplicadoException {
        colecaoUsuario.editarUsuario(id, nome, email, senha, admin);
    }

    public List<Usuario> listarTodosUsuarios(){
        return colecaoUsuario.listarTodos();
    }

    public Usuario listarUsuarioPorId(long id) throws UsuarioNaoEncontradoException{
        return colecaoUsuario.listarPorId(id);
    }

    public List<Usuario> listarUsuariosPorNome(String nome) throws UsuarioNaoEncontradoException{
        return colecaoUsuario.listarPorNome(nome);
    }
    
    /**
     * Métodos relacionados a administração de filme
     */
    public void adicionarNovoFilme(String nome, String sinopse, int duracao, List<Categoria> categorias) {
        colecaoFilme.adicionarFilme(nome, sinopse, duracao, categorias);
    }

    public void editarFilme(long id, String nome, String sinopse, int duracao, List<Categoria> categorias) 
                            throws FilmeNaoEncontradoException{
        colecaoFilme.editarFilme(id, nome, sinopse, duracao, categorias);
    }

    public List<Filme> listarTodosFilmes(){
        return colecaoFilme.listarTodos();
    }

    public Filme listarFilmePorId(long id) throws FilmeNaoEncontradoException {
        return colecaoFilme.listarPorId(id);
    }
    
    public List<Filme> listarFilmePorNome(String nome) throws FilmeNaoEncontradoException {
        return colecaoFilme.listarPorNome(nome);
    }

    public List<Filme> listarFilmePorCategoria(String categoria) throws CategoriaNaoEncontradaException {
        return colecaoFilme.listarPorCategoria(categoria);
    }
    
    /**
     * Métodos ligados a administração das categorias
     */
    public void adicionarNovaCategoria(String nome) throws CategoriaDuplicadaException {
        colecaoCategoria.adicionarCategoria(nome);
    }

    public void editarCategoria(long id, String nome) throws CategoriaNaoEncontradaException, CategoriaDuplicadaException {
        colecaoCategoria.editarCategoria(id, nome);
    }

    public List<Categoria> listarTodasCategorias(){
        return colecaoCategoria.listarTodos();
    }
    
    public Categoria listarCategoriaPorId(long id) throws CategoriaNaoEncontradaException {
        return colecaoCategoria.listarPorId(id);
    }

    public List<Categoria> listarCategoriaPorNome(String nome) throws CategoriaNaoEncontradaException {
        return colecaoCategoria.listarPorNome(nome);
    }
}
