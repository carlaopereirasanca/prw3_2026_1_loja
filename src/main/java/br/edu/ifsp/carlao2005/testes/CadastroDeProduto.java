package br.edu.ifsp.carlao2005.testes;

import br.edu.ifsp.carlao2005.dao.CategoriaDao;
import br.edu.ifsp.carlao2005.dao.ProdutoDao;
import br.edu.ifsp.carlao2005.modelo.Categoria;
import br.edu.ifsp.carlao2005.modelo.Produto;
import br.edu.ifsp.carlao2005.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;

public class CadastroDeProduto {

    public static void main(String[] args) {

        //cadastrarProdutos();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        BigDecimal precoDeskjet = produtoDao.buscarPrecoDoProdutoComNome("Deskjet 3776");

        System.out.println("\nPreço da Deskjet: " + precoDeskjet);

    }

    /////////////////////////////////////////////////


    private static void cadastrarProdutos() {

        // Criando a Categoria "CELULARES":
        Categoria celulares = new Categoria("CELULARES");
        // Criando a Categoria "INFORMATICA":
        Categoria informatica = new Categoria("INFORMATICA");

        // Criando objetos da Classe Produto, associados a categoria CELULARES:
        Produto celular1 = new Produto("Celular UM", "Motorola",
                new BigDecimal("1000"), celulares);
        Produto celular2 = new Produto("Celular DOIS", "Samsung",
                new BigDecimal("2000"), celulares);

        // Criando objetos da Classe Produto, associados a categoria INFORMATICA:
        Produto comp1 = new Produto("Deskjet 3776", "HP",
                new BigDecimal("700"), informatica);
        Produto comp2 = new Produto("Notebook i7", "DELL",
                new BigDecimal("9000"), informatica);

        // Criando o EntityManager:
        EntityManager em = JPAUtil.getEntityManager();

        // Criando os DAOs:
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando a transação:
        em.getTransaction().begin();
        // Persistindo os objetos:
        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(informatica);
        produtoDao.cadastrar(celular1);
        produtoDao.cadastrar(celular2);
        produtoDao.cadastrar(comp1);
        produtoDao.cadastrar(comp2);
        // Finalizando (commit) a transação:
        em.getTransaction().commit();
        // Fechando o EntityManager:
        em.close();
    }







}


