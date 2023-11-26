package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.ProfessorDao;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Professor;

public class App {
    public static void main(String[] args) {
        try {
            Connection conexao = Conexao.getConexao();
            AlunoDao alunoDao = new AlunoDao(conexao);
            ProfessorDao professorDao = new ProfessorDao(conexao);
            AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);

            Aluno alunoTeste = autenticacaoDao.autenticarAluno("livyakelly@gmail.com");
            Professor professorTeste = autenticacaoDao.autenticarProfessor("jesielviana@gmail.com");

            alunoDao.someMethod();

            Conexao.fecharConexao(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
