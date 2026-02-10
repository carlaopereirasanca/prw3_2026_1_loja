package br.edu.ifsp.carlao2005.testes;

import br.edu.ifsp.carlao2005.dao.CategoriaDao;
import br.edu.ifsp.carlao2005.dao.ProdutoDao;
import br.edu.ifsp.carlao2005.modelo.Categoria;
import br.edu.ifsp.carlao2005.modelo.Produto;
import br.edu.ifsp.carlao2005.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        /*
        // Criando a Categoria "INFORMATICA".
        Categoria informatica = new Categoria("INFORMATICA");

        // Criando o EntityManager:
        EntityManager em = JPAUtil.getEntityManager();

        // Criando o CategoriaDAO:
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando a transação:
        em.getTransaction().begin();

        // Finalizando a transação:
        em.getTransaction().commit();

        // Fechando o EntityManager
        em.close();
        */


        /*
        // Criando a Categoria "INFORMATICA".
        Categoria informatica = new Categoria("INFORMATICA");

        // Criando o EntityManager:
        EntityManager em = JPAUtil.getEntityManager();

        // Criando o CategoriaDAO:
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando a transação:
        em.getTransaction().begin();

        // Mudando para o estado managed:
        em.persist(informatica);

        // Trocando o texto no objeto:
        informatica.setNome("INFORMATICA & COMPUTAÇÃO");

        // Finalizando a transação:
        em.getTransaction().commit();

        // Fechando o EntityManager
        em.close();

         */



        /*
        // Criando a Categoria "ELETRO".
        Categoria informatica = new Categoria("ELETRO");

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando a transação:
        em.getTransaction().begin();

        // Mudando para o estado managed:
        em.persist(informatica);

        // Trocando o texto no objeto:
        informatica.setNome("ELETRO antes commit");

        // Finalizando a transação:
        em.getTransaction().commit();

        // Fechando o EntityManager
        em.close();

        // Trocando o texto no objeto:
        informatica.setNome("ELETRO depois close");
         */




        /*
        // Criando a Categoria "ESPORTE":
        Categoria esporte = new Categoria("ESPORTE");

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando a transação:
        em.getTransaction().begin();

        // Mudando para o estado managed:
        em.persist(esporte);

        // Trocando o texto no objeto:
        esporte.setNome("ESPORTE atualizado");

        // Não vamos fechar a transação....
        // Vamos atualizar com flush():
        em.flush();

        // Vamos tornar 'esporte' detached:
        em.clear();

        // Precisamos agora alterar o nome... Como voltar de detached para managed?
        // Usamos o método merge().
        // Atenção! Não basta usar o método, precisa "renovar" a referência!
        esporte = em.merge(esporte);

        // Trocando o texto no objeto:
        esporte.setNome("ESPORTE depois de merge");

        // Finalizando a transação:
        em.getTransaction().commit();

        // Fechando o EntityManager
        em.close();

        */



        // Criando a Categoria "ESPORTE2":
        Categoria esporte = new Categoria("ESPORTE2");

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando a transação:
        em.getTransaction().begin();

        // Mudando para o estado managed:
        em.persist(esporte);

        // Trocando o texto no objeto:
        esporte.setNome("ESPORTE2 atualizado");

        // Apagando...
        em.remove(esporte);

        // Finalizando a transação:
        em.getTransaction().commit();

        // Fechando o EntityManager
        em.close();




    }
}


