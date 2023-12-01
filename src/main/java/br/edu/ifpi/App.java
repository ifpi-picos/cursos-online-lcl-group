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
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;

public class App {
    public static void main(String[] args) {
        try {
            Connection conexao = Conexao.getConnection();
            AlunoDao alunoDao = new AlunoDao(conexao);
            CursoDao cursoDao = new CursoDao(conexao);
            ProfessorDao professorDao = new ProfessorDao(conexao);
            AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
            CursoAlunoDao CursoAlunoDao = new CursoAlunoDao(conexao);

            Aluno camilla = autenticacaoDao.autenticarAluno("sapatona@gmail.com");
            Aluno alunoTeste = autenticacaoDao.autenticarAluno("americanas@gmail.com");
            
            Professor professorTeste = autenticacaoDao.autenticarProfessor("jesielviana@gmail.com");
            //Curso cursoTeste =autenticacaoDao.autenticarCurso("Engenharia de Software");

            //alunoTeste.gerarBoletim(alunoTeste);
            //alunoDao.someMethod();

            //alunoDao.cadastrar(new Aluno("Livya", "livyakelly@gmail", StatusAluno.ATIVO));
        
        


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
