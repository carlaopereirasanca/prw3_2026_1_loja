package br.edu.ifsp.carlao2005.dao;

import br.edu.ifsp.carlao2005.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    // EntityManager, que será usado por todos os métodos:
    private EntityManager em;

    // Construtor que já recebe o EntityManager criado:
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    // Método para gravar uma categoria no BD:
    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }
}
