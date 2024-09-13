package br.com.catalogofilmes.catalogo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catalogofilmes.catalogo.negocio.entidade.Filme;

/**
 * Interface que é responsável por interagir com o armazenamento de filmes
 * @author Arthur de Sá Tenório
 * @category Interface de repositório
 */

@Repository
public interface IRepositorioFilme extends JpaRepository <Filme, Long>{
    public Filme findById (long id);
    public List<Filme> findAllByNome (String nome);
}
