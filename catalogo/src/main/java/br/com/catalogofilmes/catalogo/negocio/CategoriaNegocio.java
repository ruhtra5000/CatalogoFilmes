package br.com.catalogofilmes.catalogo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catalogofilmes.catalogo.dados.IRepositorioCategoria;
import br.com.catalogofilmes.catalogo.negocio.colecao.IColecaoCategoria;
import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaDuplicadaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;

/**
 * Classe que implementa as regras de negócio ligadas a Categoria
 * @author Arthur de Sá Tenório
 * @category Classe de negócio
 */

@Service
public class CategoriaNegocio implements IColecaoCategoria{
    @Autowired
    private IRepositorioCategoria repositorioCategoria;

    @Override
    public void adicionarCategoria(String nome) throws CategoriaDuplicadaException {
        Categoria testeCategoria = repositorioCategoria.findByNome(nome);
        if(testeCategoria != null)
            throw new CategoriaDuplicadaException(nome);

        Categoria c = new Categoria(nome);
        repositorioCategoria.save(c);
    }

    @Override
    public void editarCategoria(long id, String nome) throws CategoriaNaoEncontradaException, CategoriaDuplicadaException {
        Categoria testeCategoria = repositorioCategoria.findByNome(nome);
        if(testeCategoria != null)
            throw new CategoriaDuplicadaException(nome);
        
        Categoria c = listarPorId(id);
        c.setNome(nome);
        repositorioCategoria.save(c);
    }

    @Override
    public List<Categoria> listarTodos() {
        return repositorioCategoria.findAll();
    }

    @Override
    public Categoria listarPorId(long id) throws CategoriaNaoEncontradaException {
        Categoria c = repositorioCategoria.findById(id);
        if (c == null) throw new CategoriaNaoEncontradaException();
        return c;
    }

    @Override
    public List<Categoria> listarPorNome(String nome) throws CategoriaNaoEncontradaException {
        List<Categoria> categorias = repositorioCategoria.findAllByNome(nome);
        if (categorias.isEmpty()) throw new CategoriaNaoEncontradaException();
        return categorias;
    }
}

