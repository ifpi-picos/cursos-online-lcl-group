package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;

public class ProfessorTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConnection();
        ProfessorDao professorDao = new ProfessorDao(conexao);
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
        Scanner scanner = new Scanner(System.in);

 // * metodo cadastrar funcionando 
        //Professor novoProfessor = new Professor("Rafael", "rafael@gmail.com");
        //int resultadoCadastro = professorDao.cadastrar(novoProfessor);

 // * metodo consultar funcionando
        //List<Professor> professoresCadastrados = professorDao.consultar();

// * metodo remover funcionando

    //Professor professorRemover = new Professor("Rafael", "rafael@gmail.com");
      //System.out.println("Digite o ID do curso que deseja remover: ");
      //int idProfessorRemover = scanner.nextInt();

      //professorRemover.setIdProfessor(idProfessorRemover);

      //int resultadoRemocao = professorDao.remover(professorRemover);

      //System.out.println("Remoção realizada com sucesso! " + resultadoRemocao);

// * metodo alterar 
//System.out.println("Digite o id do professor que deseja alterar:");
//int alterarId = scanner.nextInt();
//scanner.nextLine();

//Professor alterProfe = new Professor(alterarId, null, null);
//alterProfe.setIdProfessor(alterarId);

//System.out.println("Novo Nome: ");
//alterProfe.setNome(scanner.nextLine());

//System.out.println("Novo Email: ");
//alterProfe.setEmail(scanner.next());

//professorDao.alterar(alterProfe);

//List<Professor> professoresCadastrados = professorDao.consultar();

//* metodo */
    }
}
