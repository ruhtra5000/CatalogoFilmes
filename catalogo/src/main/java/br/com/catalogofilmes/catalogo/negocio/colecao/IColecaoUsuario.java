package br.com.catalogofilmes.catalogo.negocio.colecao;

import java.util.List;

import br.com.catalogofilmes.catalogo.negocio.entidade.Usuario;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioDuplicadoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioNaoEncontradoException;

/**
 * Interface que define as atribuições da classe UsuarioNegocio
 * @author Arthur de Sá Tenório
 * @category Interface de coleção
 */

public interface IColecaoUsuario {
    public void cadastrarUsuario(String nome, String email, String senha, boolean admin) 
                                throws UsuarioDuplicadoException; 
    public void editarUsuario(long id, String nome, String email, String senha, boolean admin)
                              throws UsuarioNaoEncontradoException, UsuarioDuplicadoException;
    
    public List<Usuario> listarTodos ();
    public Usuario listarPorId (long id) throws UsuarioNaoEncontradoException;
    public List<Usuario> listarPorNome (String nome) throws UsuarioNaoEncontradoException;
    public Usuario listarPorEmailSenha(String email, String senha) throws UsuarioNaoEncontradoException;
}
