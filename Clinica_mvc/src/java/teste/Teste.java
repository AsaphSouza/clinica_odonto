package teste;

import Controller.ControllerAssistente;
import Controller.ControllerDentista;
import Controller.ControllerPaciente;
import Controller.ControllerRecepcionista;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Hibernate.UsuarioHibernate;
import model.entidades.Usuario;

public class Teste {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICA_ODONTOLOGICA");
        EntityManager em = emf.createEntityManager();

        try {
            /*----------------------------------ASSISTENTE-----------------------------------*/
            ControllerAssistente ca = new ControllerAssistente();
            /* Cadastrar Assistente */
//			ca.getAssistente().setNome("Braga");
//			ca.getAssistente().setFormacao("Ortodentista");
//			ca.cadastrarAssitente();

            /*Buscar por nome*/
//			ca.setNome("Braga");
//			System.out.println(ca.buscarPorNome());
            /*Deletar Assistente*/
//			ca.setNome("Braga");
//			ca.setAssistente(ca.buscarPorNome());
//			ca.deletarAssistente();
//			System.out.println("Assistente deletado com sucesso.");
            /*Atualizar Assistente*/
//     		ca.setNome("Braga");
//			ca.setAssistente(ca.buscarPorNome());
//			ca.getAssistente().setFormacao("Bacharel em Ortodontilogia");
//			ca.atualizarAssistente();

            /*----------------------------------DENTISTA-----------------------------------*/
            ControllerDentista cd = new ControllerDentista();
            /*Cadastrar Dentista*/
//			cd.getDentista().setNome("Anna");
//			cd.getDentista().setCro("12345");
//			cd.getDentista().setFormacao("Odontologia");
//			cd.cadastrarDentista();

            /*Buscar por CRO*/
//			cd.getDentista().setCro("12345");
//			System.out.println(cd.buscarPeloCRO());
            /*Atualizar Dentista*/
//			cd.getDentista().setCro("12345");
//			cd.setDentista(cd.buscarPeloCRO());
//			cd.getDentista().setNome("Ana Fernanda");
//			cd.atualizarDentista();
            /*Deletar Dentista*/
//			cd.getDentista().setCro("12345");
//			cd.setDentista(cd.buscarPeloCRO());
//			cd.deletarDentista();
/*----------------------------------RECEPCIONISTA-----------------------------------*/
            ControllerRecepcionista cr = new ControllerRecepcionista();
            /*Cadastrar Recepcionista*/
//			cr.getRecepcionista().setNome("Rogério");
//			cr.getRecepcionista().setFormacao("Secretariado Bilíngue");
//			cr.cadastrarRecepcionista();

            /*Buscar Recepcionista*/
//			cr.setNome("Rogério");
//			System.out.println(cr.buscarPorNome());
            /*Atualizar Recepcionista*/
//			cr.setNome("Rogério");
//			cr.setRecepcionista(cr.buscarPorNome());
//			cr.getRecepcionista().setNome("Robério");
//			cr.atualizarRecepcionista();
//			
            /*Deletar Recepcionista*/
//			cr.setNome("Robério");
//			cr.setRecepcionista(cr.buscarPorNome());
//			cr.deletarRecepcionista();
            /*----------------------------------PACIENTE-----------------------------------*/
            ControllerPaciente cp = new ControllerPaciente();
            /*Cadastrar Paciente*/
//		cp.getPaciente().setNome("Héricles");
//			cp.getPaciente().setCpf("04624792009"); //--------> precisa ser um cpf válido.
//			cp.getPaciente().setSexo('M');
//			cp.getPaciente().setEmail("hericles@gmail.com");
//			cp.getPaciente().setProfissao("Engenheiro Civil");
//			cp.getPaciente().setTelefone("(87) 3761-8479");
//			cp.getPaciente().setUtilizaMedicamento(false);
//			cp.getEndereco().setRua("Manoel dos Santos");
//			cp.getEndereco().setPais("Brasil");
//			cp.getEndereco().setNumero(58);
//			cp.getEndereco().setEstado("Pernambuco");
//			cp.getEndereco().setComplemento("Casa");
//			cp.getEndereco().setCidade("Garanhuns");
//			cp.getEndereco().setBairro("Heliópolis");
//			cp.getPaciente().setEndereco(cp.getEndereco());
//		
//			 Calendar c = Calendar.getInstance();
//			 c.set(1999, 06, 1); // no mes tem que colocar um a menos
//			cp.getPaciente().setDataNascimento(c.getTime());
//			
//			cp.cadastrarPaciente();

            /*Buscar Paciente por cpf*/
//			cp.setCpf("04624792009");
//			System.out.println(cp.buscarPacienteCPF());
            /*Buscar todos*/
//			System.out.println(cp.buscarTodos());
            /*Buscar por cidade*/
//			cp.getEndereco().setCidade("Garanhuns");
//			System.out.println(cp.buscarPorCidades());
            /*Buscar por estado*/
//			cp.getEndereco().setEstado("Pernambuco");
//			System.out.println(cp.buscarPorEstado());
            /*Atualizar Paciente*/
//			cp.setCpf("04624792009");
//			cp.setPaciente(cp.buscarPacienteCPF());
//			cp.getPaciente().getEndereco().setNumero(52);
//			cp.atualizarPaciente();
//			
            /*Deletar Paciente*/
//			cp.setCpf("04624792009");
//			cp.setPaciente(cp.buscarPacienteCPF());
//			cp.deletarPaciente();


        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
            emf.close();
        }

    }

}
