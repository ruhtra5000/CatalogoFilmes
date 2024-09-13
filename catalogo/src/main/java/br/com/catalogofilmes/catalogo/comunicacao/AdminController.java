package br.com.catalogofilmes.catalogo.comunicacao;

import org.springframework.web.bind.annotation.RestController;

import br.com.catalogofilmes.catalogo.comunicacao.DTO.RequisicaoCadastroFilme;
import br.com.catalogofilmes.catalogo.comunicacao.DTO.RequisicaoEditarFilme;
import br.com.catalogofilmes.catalogo.comunicacao.DTO.RequisicaoEditarUsuario;
import br.com.catalogofilmes.catalogo.negocio.entidade.Filme;
import br.com.catalogofilmes.catalogo.negocio.entidade.Usuario;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.FilmeNaoEncontradoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioDuplicadoException;
import br.com.catalogofilmes.catalogo.negocio.excecao.UsuarioNaoEncontradoException;
import br.com.catalogofilmes.catalogo.negocio.fachada.FachadaAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Classe responsável pelas requisições dos administradores do sistema.
 * @author Arthur de Sá Tenório
 * @category Classe de controlador
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private FachadaAdmin fachadaAdmin;

    @PatchMapping("/editarUsuario")
    public ResponseEntity<String> editarUsuario(@RequestBody RequisicaoEditarUsuario r){
        try {
            fachadaAdmin.editarUsuario(r.getId(), r.getNome(), r.getEmail(), r.getSenha(), r.getAdmin());
            return ResponseEntity.ok("Edição realizada com sucesso!");
        }
        catch(UsuarioNaoEncontradoException | UsuarioDuplicadoException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios () {
        return fachadaAdmin.listarTodosUsuarios();
    }

    @GetMapping("/usuarios/id/{id}")
    public Usuario listarUsuarioPorId(@PathVariable long id) {
        try {
            return fachadaAdmin.listarUsuarioPorId(id);
        } 
        catch (UsuarioNaoEncontradoException err) {
            return null;
        }
    }

    @GetMapping("/usuarios/nome/{nome}")
    public List<Usuario> listarUsuariosPorNome(@PathVariable String nome) {
        try {
            return fachadaAdmin.listarUsuariosPorNome(nome);
        } 
        catch (UsuarioNaoEncontradoException e) {
            return null;
        }
    }
    
    @PostMapping("/filme/adicionar")
    public ResponseEntity<String> adicionarNovoFilme(@RequestBody RequisicaoCadastroFilme r) {
        fachadaAdmin.adicionarNovoFilme(r.getNome(), r.getSinopse(), r.getDuracao(), r.getCategorias());
        return ResponseEntity.ok("Filme adicionado com sucesso!");
    }
    
    @PatchMapping("/filme/editar")
    public ResponseEntity<String> editarFilme(@RequestBody RequisicaoEditarFilme r) {
        try {
            fachadaAdmin.editarFilme(r.getId(), r.getNome(), r.getSinopse(), r.getDuracao(), 
                                     r.getCategorias());
            return ResponseEntity.ok("Edição realizada com sucesso!");
        } catch (FilmeNaoEncontradoException err) {
           return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

    @GetMapping("/filme")
    public List<Filme> listarTodosFilmes () {
        return fachadaAdmin.listarTodosFilmes();
    }

    @GetMapping("/filme/id/{id}")
    public Filme listarFilmePorId(@PathVariable long id) {
        try {
            return fachadaAdmin.listarFilmePorId(id);
        } 
        catch (FilmeNaoEncontradoException err) {
            return null;
        }
    }
    
    @GetMapping("/filme/nome/{nome}")
    public List<Filme> listarFilmePorNome(@PathVariable String nome) {
        try {
            return fachadaAdmin.listarFilmePorNome(nome);
        } 
        catch (FilmeNaoEncontradoException err) {
            return null;
        }
    }
    
    @GetMapping("/filme/categ/{categoria}")
    public List<Filme> listarFilmePorCategoria(@PathVariable String categoria) {
        try {
            return fachadaAdmin.listarFilmePorCategoria(categoria);
        } 
        catch (CategoriaNaoEncontradaException err) {
            return null;
        }
    }
    

    
}
