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

public class App {
    public static void main(String[] args) throws SQLException {

        //Connection conexao = Conexao.getConnection();
        //AlunoDao alunoDao = new AlunoDao(conexao);
        //CursoDao cursoDao = new CursoDao(conexao);
        //ProfessorDao professorDao = new ProfessorDao(conexao);
        //AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
        //CursoAlunoDao CursoAlunoDao = new CursoAlunoDao(conexao);

        //Aluno novoAluno = new Aluno("Livya", "livya@gmail.com", StatusAluno.ATIVO);
        //int resultadoCadastro = alunoDao.cadastrar(novoAluno);
        //Aluno Livya = autenticacaoDao.autenticarAluno("livya@gmail.com");

        //Aluno novoAluno = new Aluno("Paulo", "paulo@gmail.com", StatusAluno.ATIVO);
        //int resultadoCadastro = alunoDao.cadastrar(novoAluno);
        //Aluno Paulo = autenticacaoDao.autenticarAluno("paulo@gmail.com");

        //Professor joaoPaulo = autenticacaoDao.autenticarProfessor("joaopaulo@gmail.com");

        //List<Aluno> alunosConsultados = alunoDao.consultar();

        //int resultadoRemocao = alunoDao.remover();

        // Fazer algo com o resultado, se necessário
        //System.out.println("Linhas afetadas (Remoção): " + resultadoRemocao);
    }
}
