package br.edu.ifpi.entidades;
import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.enums.StatusAluno;

public class Aluno {
    private int idAluno;
    private String nome;
    private String email;
    private StatusAluno status;

    public Aluno(int idAluno ,String nome, String email, StatusAluno status) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.email = email;
        this.status = status;   
    }

    public Aluno(String nome, String email, StatusAluno status) {
        this.nome = nome;
        this.email = email;
        this.status = status;
    }

    public int getid() {
        return idAluno;
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


    public String getStatus() {
        return this.status == StatusAluno.ATIVO? "ATIVO" : "INATIVO";    
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public void gerarBoletim(Aluno aluno) throws SQLException{
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.consultarBoletimAluno(this);
    }

    public int getId() {
        return 0;
    }

    public void realizarMatricula(Curso curso) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        CursoAluno cursoAluno = new CursoAluno(curso, this);
        cursoAlunoDao.cadastrar(cursoAluno);
    }

    public void cancelarMatricula(Curso curso) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        CursoAluno cursoAluno = new CursoAluno(curso, this);
        cursoAlunoDao.remover(cursoAluno);
    }

    public void cursosConcluidos() throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.cursosConcluidos(this);
    }
    
    public void mostrarBoletim() throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.consultarBoletimAluno(this);
    }

    public void exibirPerfilAluno() throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.VisualizarPerfilAluno(this);
        cursoAlunoDao.consultarBoletimAluno(this);
    }
}
