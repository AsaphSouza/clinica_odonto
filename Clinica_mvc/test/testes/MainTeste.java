package testes;

import Entidades.Assistente;
import Entidades.Consulta;
import Entidades.Dentista;
import Entidades.Endereco;
import Entidades.Paciente;
import Entidades.Pergunta;
import Entidades.Questionario;
import Entidades.Recepcionista;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTeste {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICA_ODONTOLOGICA");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            testePersistencia(em);

            em.getTransaction().commit();

        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
            emf.close();
        }

    }

    private static void testePersistencia(EntityManager em) {
//        Assistente assistente = new Assistente("Anna Maria Braga","Enfermagem");
//        System.out.println(assistente);
//        em.persist(assistente);
//        System.out.println(assistente);

//          Endereco endereco = new Endereco("Garanhuns", "Brasil", "Pernambuco", "Brás Cubas", "Casa",635,"Heliópolis");
//          Calendar c = Calendar.getInstance();
//          c.set(1999, 11, 1); // no mes tem que colocar um a menos 
//          Paciente pac = new Paciente("Carine Wanderley",'F', "87999168963",c.getTime() ,"11740635485",
//                  "Programadora Senior","carine.wp@hotmail.com", endereco, false);
//          System.out.println(pac);
//          em.persist(pac);
//          System.out.println(pac);

            Questionario questionario = new Questionario("Amnese");
//          System.out.println(questionario);
//          em.persist(questionario);
//          System.out.println(questionario);
//          System.out.println(questionario);
            Dentista dentista = new Dentista("Josilane", "rolezeira");
            Pergunta p1 = new Pergunta("Quem nasceu primeiro, o ovo, ou a galinha?", "xadada",questionario, dentista);
            em.persist(p1);
    }

} 
