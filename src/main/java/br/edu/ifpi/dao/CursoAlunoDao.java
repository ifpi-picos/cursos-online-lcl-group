package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.CursoAluno;

public class CursoAlunoDao implements Dao<CursoAluno> {
    private Connection conexao;

    public CursoAlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(CursoAluno cursoAluno) {
        String sql = "INSERT INTO CURSO_ALUNO (id_curso, id) VALUES (?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, cursoAluno.getIdCurso());
            stm.setInt(2, cursoAluno.getIdAluno());

            int row = stm.executeUpdate();
            System.err.println(row);
            System.out.println(row); 
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;

    }

    @Override
    public List<CursoAluno> consultar() {
        List<CursoAluno> cursosAlunos = new ArrayList<>();
        String sql = "SELECT * FROM curso_aluno order by id asc";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                int idCurso = resultSet.getInt("id_curso");
                int idAluno = resultSet.getInt("id_aluno");

                System.out.println("id curso: " + idCurso + ", id aluno: " + idAluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursosAlunos;
    }

    @Override
    public int remover(CursoAluno entidade) {
		return 0;
    }

    @Override
    public int alterar(CursoAluno entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    public void totaldeAlunosMatriculadosCurso(Curso curso) {
        String sql = "SELECT COUNT(id_aluno) as alunos FROM curso_aluno WHERE id_curso = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, curso.getId());
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("alunos");
                System.out.println("Total de alunos matriculados: " + total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mediaAlunos(Curso curso){
        String sql = "SELECT AVG(nota) as media FROM curso_aluno WHERE id_curso = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, curso.getId());
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                float media = resultSet.getInt("media");
                System.out.println("Media de alunos: " + media);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

