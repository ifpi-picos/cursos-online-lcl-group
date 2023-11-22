package br.edu.ifpi.entidades;

public class Aluno {
    private int idAluno;
    private String nome;
    private String email;
    private Curso curso;

    public Aluno(String nome, String email, Curso curso) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }
    
    public Aluno( int idAluno, String nome, String email, Curso curso) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdAluno() {
            return idAluno;
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
    
    
}
