package testes;

import Controller.ControllerPaciente;
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

          ControllerPaciente cp = new ControllerPaciente();
          Endereco endereco = new Endereco("Garanhuns", "Brasil", "Pernambuco", "Rua i", "Casa",22,"Severiano Moraes Filho");
          Calendar c = Calendar.getInstance();
          c.set(1999, 06, 1); // no mes tem que colocar um a menos 
          Paciente pac = new Paciente("Alexander",'M', "87999999999",c.getTime() ,"90408747005",
                  "Programador Pleno","alexander@gmail.com", endereco, false);
          cp.cadastrarPaciente(pac);
          
          //System.out.println(cp.buscarPacienteCPF("88877766655"));


        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
            emf.close();
        }

    }

}
