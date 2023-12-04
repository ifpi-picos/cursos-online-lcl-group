package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
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

        //* método cadastrar
        CursoAluno cursoAluno = new CursoAluno(null, null, (float) 0); // pega o curso_aluno que vc ja cadastrou na tabela e cadastra/autera a nota
        cursoAluno.setIdCurso(7); //pega o id do curso
        cursoAluno.setIdAluno(7); // pega o id do aluno

        //CursoAluno cursoAlunoCadastrar = new CursoAluno(curso, aluno, 0.0f);
        int resultadoCadastro = cursoAlunoDao.cadastrar(cursoAluno);
        System.out.println("Cadastro realizado com sucesso!! " + resultadoCadastro);

    }


    public void setIdAluno(int i) {
    }


    public void setIdCurso(int i) {
    }
}
