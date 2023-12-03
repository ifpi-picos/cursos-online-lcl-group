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

    public Professor(int idProfessor, String nome, String email) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
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
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public void inserirNota(CursoAluno cursoAluno, float nota) throws Exception {
=======
    public int getId() {
        return 0;
    }

    public void inserirNota(CursoAluno cursoAluno, Boolean nota) throws Exception {
>>>>>>> eec89d6bc83daa2a63b51e3b30d886058dd04072
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.inserirNota(cursoAluno, nota);
    }

    public void cadastrarCurso (Curso curso) throws Exception {
        CursoDao cursoDao = new CursoDao(Conexao.getConnection());
        cursoDao.cadastrar(curso);
    }

}
