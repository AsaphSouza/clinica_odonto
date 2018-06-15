package testes;

import Entidades.Dentista;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTeste {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICA_ODONTOLOGICA");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            testeDentista(em);

            em.getTransaction().commit();

        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
            emf.close();
        }

    }

    private static void testeDentista(EntityManager em) {
        Dentista dentista = new Dentista();

        dentista.setNome("André Santos");
        dentista.setFormacao("Bacharel em Odontologia");

        System.out.println(dentista);

        em.persist(dentista);

        System.out.println(dentista);
    }

} 
