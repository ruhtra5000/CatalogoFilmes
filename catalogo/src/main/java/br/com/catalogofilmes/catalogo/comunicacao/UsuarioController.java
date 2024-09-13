package br.com.catalogofilmes.catalogo.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.catalogofilmes.catalogo.comunicacao.DTO.RequisicaoCadastroUsuario;
import br.com.catalogofilmes.catalogo.comunicacao.DTO.RequisicaoLogin;
import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import br.com.catalogofilmes.catalogo.negocio.entidade.Filme;
import br.com.catalogofilmes.catalogo.negocio.entidade.Usuario;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.FilmeNaoEncontradoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioDuplicadoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioNaoEncontradoException;
import br.com.catalogofilmes.catalogo.negocio.fachada.FachadaGeral;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Classe responsável pelas requisições de um usuário comum.
 * @author Arthur de Sá Tenório
 * @category Classe de controlador
 */

@RestController
public class UsuarioController {
    @Autowired
    private FachadaGeral fachadaGeral;

    @GetMapping("/login")
    public Usuario loginUsuario (@RequestBody RequisicaoLogin r) {
        try {
            return fachadaGeral.realizarLogin(r.getEmail(), r.getSenha());
        } 
        catch (UsuarioNaoEncontradoException err) {
            return null;
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastroUsuario(@RequestBody RequisicaoCadastroUsuario r) {
        try {
            fachadaGeral.cadastrarUsuario(r.getNome(), r.getEmail(), r.getSenha(), r.getAdmin());
            return ResponseEntity.ok("Cadastro realizado com sucesso!");
        }
        catch (UsuarioDuplicadoException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
    
    @GetMapping("/filmes")
    public List<Filme> listarFilmes() {
        return fachadaGeral.listarTodosFilmes();
    }

    @GetMapping("/filmes/id/{id}")
    public Filme listarFilmePorId(@PathVariable long id) {
        try {
            return fachadaGeral.listarPorId(id);
        } 
        catch (FilmeNaoEncontradoException err) {
            return null;
        }
    }

    @GetMapping("/filmes/nome/{nome}")
    public List<Filme> listarFilmesPorNome(@PathVariable String nome) {
        try {
            return fachadaGeral.buscarFilmePorNome(nome);
        } 
        catch (FilmeNaoEncontradoException err) {
            return null;
        }
    }

    @GetMapping("/filmes/categ/{categoria}")
    public List<Filme> listarFilmesPorCategoria(@PathVariable String categoria) {
        try {
            return fachadaGeral.listarPorCategoria(categoria);
        } 
        catch (CategoriaNaoEncontradaException err) {
            return null;
        }
    }

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return fachadaGeral.listarTodasCategorias();
    }
    
}
