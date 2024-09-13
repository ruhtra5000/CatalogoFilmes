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
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.FilmeNaoEncontradoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioDuplicadoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioNaoEncontradoException;

/**
 * Fachada geral do sistema, englobando ações que quaisquer usuários podem realizar.
 * @author Arthur de Sá Tenório 
 * @category Classe de fachada
*/

@Service
public class FachadaGeral {
    @Autowired
    private IColecaoUsuario colecaoUsuario;
    @Autowired
    private IColecaoFilme colecaoFilme;
    @Autowired
    private IColecaoCategoria colecaoCategoria;

    /**
     * Métodos ligados a criar uma nova conta e logar no sistema
     */
    public void cadastrarUsuario(String nome, String email, String senha, boolean admin) 
                                 throws UsuarioDuplicadoException{
        colecaoUsuario.cadastrarUsuario(nome, email, senha, admin);
    }
    
    public Usuario realizarLogin(String email, String senha) throws UsuarioNaoEncontradoException{
        return colecaoUsuario.listarPorEmailSenha(email, senha);
    }


    /**
     * Métodos relacionados aos filmes 
     */
    public List<Filme> listarTodosFilmes(){
        return colecaoFilme.listarTodos();
    }

    public Filme listarPorId(long id) throws FilmeNaoEncontradoException{
        return colecaoFilme.listarPorId(id);
    }

    public List<Filme> buscarFilmePorNome(String nome) throws FilmeNaoEncontradoException{
        return colecaoFilme.listarPorNome(nome);
    }

    public List<Filme> listarPorCategoria(String categoria) throws CategoriaNaoEncontradaException{
        return colecaoFilme.listarPorCategoria(categoria);
    }

    
    /**
     * Métodos relacionados as categorias, nesse caso, apenas listagem
     */
    public List<Categoria> listarTodasCategorias(){
        return colecaoCategoria.listarTodos();
    }
}   
