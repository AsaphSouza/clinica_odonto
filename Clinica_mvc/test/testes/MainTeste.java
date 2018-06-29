package testes;

import model.entidades.Assistente;
import model.entidades.Consulta;
import model.entidades.Dentista;
import model.entidades.Endereco;
import model.entidades.Medicamento;
import model.entidades.Paciente;
import model.entidades.Pergunta;
import model.entidades.Questionario;
import model.entidades.Recepcionista;
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
        
//          Endereco endereco = new Endereco("Garanhuns", "Brasil", "Pernambuco", "Brás Cubas", "Casa",635,"Heliópolis");
//          Calendar c = Calendar.getInstance();
//          c.set(1999, 11, 1); // no mes tem que colocar um a menos 
//          Paciente pac = new Paciente("Carine Wanderley",'F', "87999168963",c.getTime() ,"11740635485",
//                  "Programadora Senior","carine.wp@hotmail.com", endereco, false);
//          System.out.println(pac);
//          em.persist(pac);
//          System.out.println(pac);
//            

    }

}
