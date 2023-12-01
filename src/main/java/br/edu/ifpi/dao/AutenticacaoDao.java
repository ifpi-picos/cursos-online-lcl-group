package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso;

public class AutenticacaoDao {
    private Connection conexao;

    public AutenticacaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public Aluno autenticarAluno(String email) {
        String sql = "SELECT id, nome, email, status FROM aluno WHERE email = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                Aluno aluno = new Aluno(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        StatusAluno.valueOf(resultSet.getString("status")));

                System.out.println("Aluno autenticado com sucesso!");
                return aluno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Professor autenticarProfessor(String email) {
        String sql = "SELECT id, nome, email FROM professor WHERE email = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                Professor professor = new Professor(
                        resultSet.getString("nome"),
                        resultSet.getInt("id"),
                        resultSet.getString("email"));

                System.out.println("Professor autenticado com sucesso!");
                return professor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curso autenticarCurso(String nome) {
        String sql = "SELECT curso.id as curso_id, curso.nome as curso_nome, curso.carga_horaria, curso.status, " +
                "professor.id as professor_id, professor.nome as professor_nome, professor.email " +
                "FROM curso " +
                "JOIN professor ON curso.id_professor = professor.id " +
                "WHERE curso.nome = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                int cursoId = resultSet.getInt("curso_id");
                String cursoNome = resultSet.getString("curso_nome");
                int cursoCargaHoraria = resultSet.getInt("carga_horaria");
                StatusCurso cursoStatus = StatusCurso.valueOf(resultSet.getString("status"));
                int professorId = resultSet.getInt("professor_id");
                String professorNome = resultSet.getString("professor_nome");
                String professorEmail = resultSet.getString("email");

                Professor professor = new Professor(professorNome, professorId, professorEmail);
                Curso curso = new Curso(cursoId, cursoNome, cursoCargaHoraria, cursoStatus, professor);

                System.out.println("Curso autenticado com sucesso!");
                return curso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// Livya Kelly ás 03:48 quase desistindo...
