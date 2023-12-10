package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCursoAluno;

public class CursoTest {
   public static void main(String[] args) throws SQLException {

    Connection conexao = Conexao.getConnection();
    CursoDao cursoDao = new CursoDao(conexao);
    Scanner scanner = new Scanner(System.in);

//* metodo cadastrar funcionando
//     Professor professor = new Professor(4, null, null);
//     Curso cursoCadastrar = new Curso("Algoritimo", 60, StatusCurso.CONCLUIDO, professor);
  
//     int resultadoCadastro = cursoDao.cadastrar(cursoCadastrar);

//     System.out.println("Curso cadastrado: " + resultadoCadastro);

//* metodo consultar funcionando 
   
//   List<Curso> cursosConsultados = cursoDao.consultar();

//* metodo remover funcionando

      // Curso cursoRemover = new Curso(0, null, 0, null, null);  
      // System.out.println("Digite o ID do curso que deseja remover: ");
      // int idCursoRemover = scanner.nextInt();

      // cursoRemover.setId(idCursoRemover);

      // int resultadoRemocao = cursoDao.remover(cursoRemover);

      // System.out.println("Remoção realizada com sucesso! " + resultadoRemocao);


//* metodo alterar funcionando
//          System.out.println("Digite o id do curso que deseja alterar:");
//         int idAlterar = scanner.nextInt();
//         scanner.nextLine();

//         Curso alterCurso = new Curso(idAlterar, null, 0, null, null);
//         alterCurso.setId(idAlterar);
        
//         System.out.println("Novo Nome: ");
//         alterCurso.setNome(scanner.nextLine());

//         System.out.println("Nova Carga Horaria: ");
//         int cargHoraria = scanner.nextInt();
//         scanner.nextLine();
//         alterCurso.setCargaHoraria(cargHoraria);

// ///PARTE PARA ALTERAR O STATUS DO CURSO
//         System.out.println("Digite o número correspondente ao novo status do curso:");
//         System.out.println("1 - ABERTO");
//         System.out.println("2 - FECHADO");
//         System.out.println("3 - CONCLUIDO");

//         int escolha = scanner.nextInt();

//         switch (escolha) {
//             case 1:
//                 alterCurso.setStatus(StatusCurso.ABERTO);
//                 break;
//             case 2:
//                 alterCurso.setStatus(StatusCurso.FECHADO);
//                 break;
//             case 3:
//                 alterCurso.setStatus(StatusCurso.CONCLUIDO);
//                 break;
//             default:
//                 System.out.println("Opção inválida. O status não foi alterado.");
//                 return;
//         }

//         System.out.println("Digite o ID do novo professor: ");
//         int profId = scanner.nextInt();
//         scanner.nextLine();
//       Professor professor = new Professor(profId, null, null);
//         alterCurso.setProfessor(professor);

//         cursoDao.alterar(alterCurso);

      // * metodo Visualizar Perfil do Professor 
      // Professor professorTest = new Professor(5, null, null);
      // cursoDao.VisualizarPerfilProfessor(professorTest);
   }
}
