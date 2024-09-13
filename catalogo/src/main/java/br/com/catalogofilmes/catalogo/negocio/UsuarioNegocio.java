package br.com.catalogofilmes.catalogo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catalogofilmes.catalogo.dados.IRepositorioUsuario;
import br.com.catalogofilmes.catalogo.negocio.colecao.IColecaoUsuario;
import br.com.catalogofilmes.catalogo.negocio.entidade.Usuario;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioDuplicadoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioNaoEncontradoException;

/**
 * Classe que implementa as regras de negócio ligadas a Usuario
 * @author Arthur de Sá Tenório
 * @category Classe de negócio
 */

@Service
public class UsuarioNegocio implements IColecaoUsuario {
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Override
    public void cadastrarUsuario(String nome, String email, String senha, boolean admin) 
                                 throws UsuarioDuplicadoException {
        //Testa se o usuário tem email duplicado
        Usuario testeUsuario = repositorioUsuario.findByEmail(email);
        if(testeUsuario != null)
            throw new UsuarioDuplicadoException(email);
        
        Usuario u = new Usuario(nome, email, senha, admin);
        repositorioUsuario.save(u);
    }

    @Override
    public void editarUsuario(long id, String nome, String email, String senha, boolean admin) 
                              throws UsuarioNaoEncontradoException, UsuarioDuplicadoException {
        //Testa se a edição gerará conflito entre e-mails
        Usuario testeUsuario = repositorioUsuario.findByEmail(email);
        if(testeUsuario != null)
            throw new UsuarioDuplicadoException(email);
        
        Usuario u = listarPorId(id);
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        u.setAdmin(admin);
        repositorioUsuario.save(u);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorioUsuario.findAll();
    }

    @Override
    public Usuario listarPorId(long id) throws UsuarioNaoEncontradoException {
        Usuario u = repositorioUsuario.findById(id);
        if(u == null) 
            throw new UsuarioNaoEncontradoException();
        
        return u;
    }

    @Override
    public List<Usuario> listarPorNome(String nome) throws UsuarioNaoEncontradoException{
        List<Usuario> usuarios = repositorioUsuario.findAllByNome(nome);
        if(usuarios.isEmpty()) 
            throw new UsuarioNaoEncontradoException();
        
        return usuarios;
    }

    @Override
    public Usuario listarPorEmailSenha(String email, String senha) throws UsuarioNaoEncontradoException {
        Usuario u = repositorioUsuario.findByEmailAndSenha(email, senha);
        if (u == null) 
            throw new UsuarioNaoEncontradoException();
        
        return u;
    }
}
