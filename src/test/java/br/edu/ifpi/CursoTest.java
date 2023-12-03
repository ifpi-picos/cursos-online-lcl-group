package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;

public class CursoTest {
   public static void main(String[] args) throws SQLException {

    Connection conexao = Conexao.getConnection();
    CursoDao cursoDao = new CursoDao(conexao);
    Scanner scanner = new Scanner(System.in);

//* metodo cadastrar e consultar funcionando
    //Professor professor = new Professor(2, "Jesiel Viana", "jesielviana@gmail.com");
    //Curso cursoCadastrar = new Curso("POO", 100, StatusCurso.ABERTO, professor);
  
    //int resultadoCadastro = cursoDao.cadastrar(cursoCadastrar);

   // System.out.println("Curso cadastrado: " + resultadoCadastro);
   
  //List<Curso> cursosConsultados = cursoDao.consultar();

  //* metodo remover funcionando

      //Curso cursoRemover = new Curso(0, null, 0, null, null);  // Supondo que você tenha um construtor vazio
      //System.out.println("Digite o ID do curso que deseja remover: ");
      //int idCursoRemover = scanner.nextInt();

      //cursoRemover.setId(idCursoRemover);

      //int resultadoRemocao = cursoDao.remover(cursoRemover);

      //System.out.println("Remoção realizada com sucesso! " + resultadoRemocao);




   }
}
