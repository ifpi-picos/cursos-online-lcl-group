package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;

public class CursoTest {
   public static void main(String[] args) throws SQLException {

    Connection conexao = Conexao.getConnection();
    CursoDao cursoDao = new CursoDao(conexao);
    Professor professor = new Professor(2, "Jesiel Viana", "jesielviana@gmail.com");
    Curso cursoCadastrar = new Curso("POO", 100, StatusCurso.ABERTO, professor);

    int resultadoCadastro = cursoDao.cadastrar(cursoCadastrar);

    System.out.println("Linhas afetadas (Cadastro): " + resultadoCadastro);
    

  List<Curso> cursosConsultados = cursoDao.consultar();
   }
}
