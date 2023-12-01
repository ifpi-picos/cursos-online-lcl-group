package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
import br.edu.ifpi.enums.StatusCurso;

public class App {
    public static void main(String[] args) throws SQLException {

        Connection conexao = Conexao.getConnection();
        AlunoDao alunoDao = new AlunoDao(conexao);
        CursoDao cursoDao = new CursoDao(conexao);
        ProfessorDao professorDao = new ProfessorDao(conexao);
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
        CursoAlunoDao CursoAlunoDao = new CursoAlunoDao(conexao);

        Aluno camilla = autenticacaoDao.autenticarAluno("camilla@gmail.com");
        Professor joaoPaulo = autenticacaoDao.autenticarProfessor("joaopaulo@gmail.com");
    }

}
