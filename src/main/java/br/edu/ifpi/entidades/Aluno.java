package br.edu.ifpi.entidades;

public class Aluno {
    private String nome;
    private int id;
    private String email;

    public Aluno(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
