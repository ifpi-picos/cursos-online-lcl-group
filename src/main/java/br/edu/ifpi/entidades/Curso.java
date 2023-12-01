package br.edu.ifpi.entidades;

import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private int idCurso;
    private String nome;
    private int cargaHoraria;
    private StatusCurso status;
    private Professor professor;

    public Curso(String nome, int cargaHoraria, StatusCurso status, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.professor = professor;
    }

    public Curso(int idCurso, String nome, int cargaHoraria, StatusCurso status, Professor professor) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.professor = professor;
    }

    public int getId() {
        return idCurso;
    }

    public void setId(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public StatusCurso getStatus() {
        return status;
    }

    public void setStatus(StatusCurso status) {
        this.status = status;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getStatusCurso() {
        return null;
    }

    public void matricularAluno(Aluno aluno) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        CursoAluno cursoAluno = new CursoAluno(this, aluno);
        cursoAlunoDao.cadastrar(cursoAluno);
    }

    public void alunosMatriculados() throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.totaldeAlunosMatriculadosCurso(this);
    }

    public void mediaAlunos() throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.mediaAlunos(this);
    }
}
