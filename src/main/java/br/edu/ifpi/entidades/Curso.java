package br.edu.ifpi.entidades;

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

    public Curso(int int1, String string, StatusCurso valueOf, int int2) {
    }

    public Curso(int idCurso2, Object object, Object object2, int idAluno, Object object3) {
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
    
}
