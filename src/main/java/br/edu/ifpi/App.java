package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.ProfessorDao;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.supabase.SupabaseClient;

public class App {
    public static void main(String[] args) {

        try {
            Connection conexao = Conexao.getConnection();
            AlunoDao alunoDao = new AlunoDao(conexao);
            ProfessorDao professorDao = new ProfessorDao(conexao);
            AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);

            Aluno alunoTeste = autenticacaoDao.autenticarAluno("livyakelly@gmail.com");
            Professor professorTeste = autenticacaoDao.autenticarProfessor("jesielviana@gmail.com");

            alunoDao.someMethod();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
