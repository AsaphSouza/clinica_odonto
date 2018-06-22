package testes;

import Entidades.Assistente;
import Entidades.Consulta;
import Entidades.Dentista;
import Entidades.Endereco;
import Entidades.Medicamento;
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
        
//          Endereco endereco = new Endereco("Garanhuns", "Brasil", "Pernambuco", "Brás Cubas", "Casa",635,"Heliópolis");
//          Calendar c = Calendar.getInstance();
//          c.set(1999, 11, 1); // no mes tem que colocar um a menos 
//          Paciente pac = new Paciente("Carine Wanderley",'F', "87999168963",c.getTime() ,"11740635485",
//                  "Programadora Senior","carine.wp@hotmail.com", endereco, false);
//          System.out.println(pac);
//          em.persist(pac);
//          System.out.println(pac);
//            
        Calendar data = Calendar.getInstance();
        data.set(2018, 05, 21);
        Dentista dentista = new Dentista();
        dentista.setCro(1l);
        Assistente assistente = new Assistente();
        assistente.setId(1l);
        Paciente paciente = new Paciente();
        paciente.setId(1l);
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setId(1l);
        Calendar dataMarcacao = Calendar.getInstance();
        dataMarcacao.set(2018, 02, 17);
        Consulta consulta = new Consulta("retorno", "Convenio", data.getTime(),
                dentista, assistente, paciente, recepcionista, dataMarcacao.getTime());
        em.persist(consulta);
    }

}
