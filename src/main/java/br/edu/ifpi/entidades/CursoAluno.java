package br.edu.ifpi.entidades;

import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.enums.StatusMatricula;

public class CursoAluno {
    private Curso curso;
    private Aluno aluno;
    private StatusMatricula status;
    private boolean nota;
    
    public CursoAluno(Curso curso, Aluno aluno, boolean nota) {
        this.curso = curso;
        this.aluno = aluno;
        this.nota = nota;
    }
 
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    public void setStatus(StatusMatricula status) {
        this.status = status;
    }

    public boolean getNota() {
        return nota;
    }
    
    public void setNota(boolean nota) {
        this.nota = nota;
    }

    public void consultarBoletimAluno(Aluno aluno2) {
    }

    public int getIdCurso() {
        return 0;
    }

    public int getIdAluno() {
        return 0;
    }

    public void cadastrar(CursoAluno cursoAluno) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.cadastrar(cursoAluno);
    }

    public void consultar (CursoAluno cursoaluno) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.consultar();
    }

    public void remover(CursoAluno cursoAluno) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.remover(cursoAluno);
    }
}