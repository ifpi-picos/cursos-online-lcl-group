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
import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;

public class ProfessorTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConnection();
        ProfessorDao professorDao = new ProfessorDao(conexao);
        AlunoDao AlunoDao = new AlunoDao(conexao);
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
        CursoAlunoDao CursoAlunoDao = new CursoAlunoDao(conexao);
        Scanner scanner = new Scanner(System.in);

 // * metodo cadastrar funcionando 
       // Professor novoProfessor = new Professor("messial", "messias@gmail.com");
        // int resultadoCadastro = professorDao.cadastrar(novoProfessor);

 // * metodo consultar funcionando
        //List<Professor> professoresCadastrados = professorDao.consultar();

// * metodo remover funcionando

    //Professor professorRemover = new Professor("Rafael", "rafael@gmail.com");
      //System.out.println("Digite o ID do curso que deseja remover: ");
      //int idProfessorRemover = scanner.nextInt();

      //professorRemover.setIdProfessor(idProfessorRemover);

      //int resultadoRemocao = professorDao.remover(professorRemover);

      //System.out.println("Remoção realizada com sucesso! " + resultadoRemocao);

// * metodo alterar funcionando
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

//* metodo cadastrarNotas funcionando
//CursoAluno cursoAluno = new CursoAluno(null, null, (float) 0); // pega o curso_aluno que vc ja cadastrou na tabela e cadastra/autera a nota
//cursoAluno.setIdCurso(3); //pega o id do curso
//cursoAluno.setIdAluno(1); // pega o id do aluno

// Substitua pelo valor da nota desejada

//int rowsAffected = professorDao.cadastrarNotas(cursoAluno, (float) 9.5);

//* metodo exibirCursosMinistrados funcionando

//int idProfessorExistente = 2;  //ID real do professor que deseja saber os cursos ministrados
//! se quiser crie um scanner para pedir o id no terminal

//Professor professorExistente = new Professor(idProfessorExistente, null, null);
//professorExistente.setIdProfessor(idProfessorExistente);

//List<Curso> cursosMinistrados = professorDao.cursosMinistrados(professorExistente); 
//for (Curso curso : cursosMinistrados) {
    //System.out.println("Nome: " + curso.getNome());
   // System.out.println("Carga Horária: " + curso.getCargaHoraria());
   // System.out.println("Status: " + curso.getStatus());
   // System.out.println("ID: " + curso.getId());
   // System.out.println("-----");

    }
}
