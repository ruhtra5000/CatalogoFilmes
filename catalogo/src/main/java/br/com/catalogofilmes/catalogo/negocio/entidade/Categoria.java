package br.com.catalogofilmes.catalogo.negocio.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Classe que denota os atributos de uma categoria
 * @author Arthur de Sá Tenório
 * @category Classe de entidade básica
 */

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    //Construtores
    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    //Getters e Setters
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
