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
<<<<<<< HEAD
import br.edu.ifpi.supabase.SupabaseClient;
=======
import br.edu.ifpi.enums.StatusAluno;
>>>>>>> f6f675bb211024fffb32b93dae5b8f076d0f3e94

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
