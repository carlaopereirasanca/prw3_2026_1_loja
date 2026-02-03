package br.edu.ifsp.carlao2005;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        // Criando um objeto da Classe Produto:

        Produto celular = new Produto();
        celular.setNome("Samsung A51");
        celular.setDescricao("Bom preço, boa performance");
        celular.setPreco( new BigDecimal("1700") );

        // Criando uma factory de EntityManager:

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

        // Usando a factory acima pra criar o objeto EntityManager:

        EntityManager em = factory.createEntityManager();

        // Iniciando uma transação:
        em.getTransaction().begin();

        // Gravando o objeto no banco de dados:
        em.persist(celular);

        // "Comitando" a transação:
        em.getTransaction().commit();

        // Fechando este EntityManager,
        //já que não precisaremos mais dele:
        em.close();
    }
}
