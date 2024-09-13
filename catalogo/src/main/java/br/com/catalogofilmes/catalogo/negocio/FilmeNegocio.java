package br.com.catalogofilmes.catalogo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catalogofilmes.catalogo.dados.IRepositorioFilme;
import br.com.catalogofilmes.catalogo.negocio.colecao.IColecaoFilme;
import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import br.com.catalogofilmes.catalogo.negocio.entidade.Filme;
import br.com.catalogofilmes.catalogo.negocio.excecao.CategoriaNaoEncontradaException;
import br.com.catalogofilmes.catalogo.negocio.excecao.FilmeNaoEncontradoException;

@Service
public class FilmeNegocio implements IColecaoFilme {
    @Autowired
    private IRepositorioFilme repositorioFilme;

    @Override
    public void adicionarFilme(String nome, String sinopse, int duracao, List<Categoria> categorias) {
        Filme f = new Filme(nome, sinopse, duracao, categorias);
        repositorioFilme.save(f);
    }

    @Override
    public void editarFilme(long id, String nome, String sinopse, int duracao, 
                            List<Categoria> categorias) throws FilmeNaoEncontradoException {
        Filme f = listarPorId(id);
        f.setNome(nome);
        f.setSinopse(sinopse);
        f.setDuracao(duracao);
        f.setCategorias(categorias);
        repositorioFilme.save(f);
    }

    @Override
    public List<Filme> listarTodos() {
        return repositorioFilme.findAll();
    }

    @Override
    public Filme listarPorId(long id) throws FilmeNaoEncontradoException {
        Filme f = repositorioFilme.findById(id);
        if(f == null) throw new FilmeNaoEncontradoException();
        return f;
    }

    @Override
    public List<Filme> listarPorNome(String nome) throws FilmeNaoEncontradoException {
        List<Filme> filmes = repositorioFilme.findAllByNome(nome);
        if(filmes.isEmpty()) throw new FilmeNaoEncontradoException();
        return filmes;
    }

    @Override
    public List<Filme> listarPorCategoria(String categoria) throws CategoriaNaoEncontradaException {
        List<Filme> filmes = repositorioFilme.findAll();
        List<Filme> retorno = new ArrayList<Filme>();

        for (var filme : filmes){
            for(var categ : filme.getCategorias()){
                if(categ.getNome().equals(categoria)){
                    retorno.add(filme);
                    break;
                }
            }
        }

        return retorno;
    }
}
