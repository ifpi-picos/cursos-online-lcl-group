package br.edu.ifpi.entidades;

import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.enums.StatusCursoAluno;

public class CursoAluno {
    private Curso curso;
    private Aluno aluno;
    private int idCurso;
    private int idAluno;
    private StatusCursoAluno status;
    private Float nota;

    public CursoAluno(Curso curso, Aluno aluno, StatusCursoAluno status, Float nota) {
        this.curso = curso;
        this.aluno = aluno;
        this.status = status;
        this.nota = nota;
    }

    public CursoAluno(int idCurso, int idAluno, StatusCursoAluno status, float nota) {
        this.idCurso = idCurso;
        this.idAluno = idAluno;
        this.status = status;
        this.nota = nota;
    }

    public CursoAluno(){
     //criação de constructor vazio para não passar alguns parametros
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

    public StatusCursoAluno getStatus() {
        return status;
    }

    public void setStatus(StatusCursoAluno status) {
        this.status = status;
    }

    public Float getNota() {
        return nota;
    }
    
    public void setNota(Float nota) {
        this.nota = nota;
    }

    public void consultarBoletimAluno(Aluno aluno2) {
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public int getIdAluno() {
        return idAluno;
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

    public void cadastrarNotas(CursoAluno cursoAluno, Double nota) throws Exception {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.cadastrarNotas(cursoAluno, nota);
    }
}