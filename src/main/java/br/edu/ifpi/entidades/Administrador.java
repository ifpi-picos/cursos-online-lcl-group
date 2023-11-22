package br.edu.ifpi.entidades;

public class Administrador {
    private int id;
    private String nome;
    private String email;
    private Curso curso;
    private Professor professor;

    public Administrador(String nome, String email, Curso curso, Professor professor){
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.professor = professor;
    }

    public Administrador (int id, String nome, String email, Curso curso, Professor professor){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}
