package br.edu.ifsp.carlao2005.dao;

import br.edu.ifsp.carlao2005.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.math.BigDecimal;
import java.util.List;

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

    // Método para buscar um produto pelo seu id:
    public Produto buscarPorId(Long id) {

        return em.find(Produto.class, id);
    }

    // Método para buscar todos os produtos do BD.
    public List<Produto> buscarTodos() {

        // Vamos usar JPQL.
        // Em SQL seria: select * from produtos
        // Na JPQL: o objeto p da classe (entidade) Produto:
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    // Método para buscar todos os produtos, filtrando por nome:
    public List<Produto> buscarPorNome(String nome) {

        // Lembrando que na JPQL você usa as entidades e seus atributos,
        // e não o nome de tabelas ou colunas (como seria com SQL).
        // Parâmetro a ser informado: ':n'.
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    // Método para buscar um único produto, filtrando por nome:
    public Produto buscarUnicoPorNome(String nome)
                   throws NoResultException {

        String jpql = "SELECT p FROM Produto p WHERE p.nome = :n";
        return em.createQuery(jpql, Produto.class)
                .setParameter("n", nome)
                .getSingleResult();
    }

    // Método para buscar todos os produtos, filtrando pela categoria,
    // ou seja, pelo relacionamento:
    public List<Produto> buscarPorNomeDaCategoria(String cat) {

        // Lembrando que na JPQL você usa as entidades e seus atributos,
        // e não o nome de tabelas ou colunas (como seria com SQL).
        // Parâmetro a ser informado: ':cat'.
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :cat";
        return em.createQuery(jpql, Produto.class)
                .setParameter("cat", cat)
                .getResultList();
    }

    // Método para buscar o preço de um produto, filtrando por nome:
    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {

        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :n";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("n", nome)
                .getSingleResult();
    }





}
