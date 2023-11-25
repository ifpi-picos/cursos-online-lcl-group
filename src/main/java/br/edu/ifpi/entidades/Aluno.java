package br.edu.ifpi.entidades;

public class Aluno {
    private int idAluno;
    private String nome;
    private String email;
    private Curso curso;
    private String status;

    public Aluno(String nome, String email, Curso curso, String status) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.status = status;
    }
    
    public Aluno( int idAluno, String nome, String email, Curso curso, String status) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.status = status;   
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

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
