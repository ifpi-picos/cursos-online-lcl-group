package br.edu.ifpi.entidades;

import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private String Id;
    private String nome;
    private int cargaHoraria;
    private StatusCurso status;
    private Professor professor;

    public Curso(String id, String nome, int cargaHoraria, StatusCurso status, Professor professor) {
        Id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.professor = professor;
    }

    public Curso(String nome, int cargaHoraria, StatusCurso status, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.professor = professor;
    }

    public String getId() {
        return Id;
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

    
    
    
}
