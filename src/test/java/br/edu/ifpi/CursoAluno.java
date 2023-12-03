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

public class CursoAluno {
    public CursoAluno(Curso curso, Aluno aluno) {
    }

    public static void main(String[] args) throws SQLException {
         Connection conexao = Conexao.getConnection();
         CursoAlunoDao CursoAlunoDao = new CursoAlunoDao(conexao);
         

//! método cadastrar
        Professor professor = new Professor(2, "Jesiel Viana", "jesielviana@gmail.com");
        Curso curso = new Curso(3, "ADS", 60, StatusCurso.ABERTO, professor );
        Aluno aluno = new Aluno(1, "Camilla", "camilla@gmail.com", StatusAluno.ATIVO); 

        
        CursoAluno cursoAlunoCadastrar = new CursoAluno(curso, aluno);
        int resultadoCadastro = cursoAlunoDao.cadastrar(cursoAlunoCadastrar);
        System.out.println("Linhas afetadas (Cadastro): " + resultadoCadastro);

    }
}
