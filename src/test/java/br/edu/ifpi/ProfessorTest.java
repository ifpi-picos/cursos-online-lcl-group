package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;

public class ProfessorTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConnection();
        ProfessorDao professorDao = new ProfessorDao(conexao);
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);


        Professor novoProfessor = new Professor("Jesiel Viana", "jesielviana@gmail.com");
        int resultadoCadastro = professorDao.cadastrar(novoProfessor);
    }
}
