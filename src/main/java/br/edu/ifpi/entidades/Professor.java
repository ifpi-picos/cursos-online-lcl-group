package br.edu.ifpi.entidades;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;

public class Professor {
    private int idProfessor;
    private String nome;
    private String email;

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Professor(String nome, int idProfessor, String email) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
    }

    public Professor(int int1, String string, String string2) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return 0;
    }

    public void inserirNota(CursoAluno cursoAluno, float nota) throws Exception {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.inserirNota(cursoAluno, nota);
    }

    public void cadastrarCurso (Curso curso) throws Exception {
        CursoDao cursoDao = new CursoDao(Conexao.getConnection());
        cursoDao.cadastrar(curso);
    }
}
