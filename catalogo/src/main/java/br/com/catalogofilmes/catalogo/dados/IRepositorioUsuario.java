package br.com.catalogofilmes.catalogo.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catalogofilmes.catalogo.negocio.entidade.Usuario;

import java.util.List;

@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario, Long> {
    public Usuario findById(long id);
    public List<Usuario> findAllByNome(String nome);
    public Usuario findByEmail(String email);
    public Usuario findByEmailAndSenha(String email, String senha);
}
