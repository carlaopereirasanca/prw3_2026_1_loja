package br.edu.ifsp.carlao2005.dao;

import br.edu.ifsp.carlao2005.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDao {

    // EntityManager, que será usado por todos os métodos:
    private EntityManager em;

    // Construtor que já recebe o EntityManager criado:
    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    // Método para gravar um produto no BD:
    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
}
