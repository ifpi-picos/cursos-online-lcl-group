package br.edu.ifpi.entidades;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.enums.StatusMatricula;

public class CursoAluno {
    private Curso curso;
    private Aluno aluno;
    private StatusMatricula status;
    private boolean nota;
    
    public CursoAluno(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
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

    public boolean isNota() {
        return nota;
    }

    public void consultarBoletimAluno(Aluno aluno2) {
    }

    public int getIdCurso() {
        return 0;
    }

    public int getIdAluno() {
        return 0;
    }
}