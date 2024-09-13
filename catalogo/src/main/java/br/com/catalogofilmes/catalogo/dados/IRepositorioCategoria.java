package br.com.catalogofilmes.catalogo.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catalogofilmes.catalogo.negocio.entidade.Categoria;
import java.util.List;

/**
 * Interface que é responsável por interagir com o armazenamento de categorias
 * @author Arthur de Sá Tenório
 * @category Interface de repositório
 */

@Repository
public interface IRepositorioCategoria extends JpaRepository<Categoria, Long> {
    public Categoria findById(long id);
    public Categoria findByNome(String nome);
    public List<Categoria> findAllByNome(String nome);
}
