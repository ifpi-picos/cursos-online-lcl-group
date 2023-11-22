package br.edu.ifpi.entidades;

import br.edu.ifpi.enums.StatusMatricula;

public class CursoAluno {
    private Curso curso;
    private Aluno aluno;
    private StatusMatricula status;
    private boolean nota;
    
    public CursoAluno(Curso curso, Aluno aluno, StatusMatricula status, boolean nota) {
        this.curso = curso;
        this.aluno = aluno;
        this.status = status;
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

    public boolean isNota() {
        return nota;
    }

}
