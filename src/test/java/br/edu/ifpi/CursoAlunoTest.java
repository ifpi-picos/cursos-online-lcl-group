package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso; 
import br.edu.ifpi.entidades.CursoAluno;

public class CursoAlunoTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConnection();
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(conexao);
        Curso curso = new Curso(0, null, 0, null, null);
        Aluno aluno = new Aluno(0, null, null, null);

        // CursoAluno cursoAluno = new CursoAluno(3,1,8); // pega o curso_aluno que vc ja cadastrou na tabela e cadastra/autera a nota
        // CursoAluno c2 = new CursoAluno(3,7,7);
        CursoAluno c3 = new CursoAluno(3,1,5);
        // cursoAluno.setIdCurso(7); //pega o id do curso
        // cursoAluno.setIdAluno(7); // pega o id do aluno
        // cursoAlunoDao.cadastrar(cursoAluno);
        cursoAlunoDao.cadastrar(c3);

        // int resultadoCadastro = cursoAlunoDao.cadastrar(cursoAluno);
        //System.out.println("Cadastro realizado com sucesso!! " + resultadoCadastro);
        //* metodo consultar funcionando */

        //cursoAlunoDao.consultar();

        // //* metodo remover funcionanddo
        // CursoAluno cursoRemover = new CursoAluno(null, null, (float) 0);
        // cursoRemover.setIdCurso(7); //pega o id do curso
        // cursoRemover.setIdAluno(7); // pega o id do aluno

        // int idCursoRemover = cursoAlunoDao.remover(cursoRemover);
        // System.out.println("Remoção realizada com sucesso! " + idCursoRemover);



     }

}
