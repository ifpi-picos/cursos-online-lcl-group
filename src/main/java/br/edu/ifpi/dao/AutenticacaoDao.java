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

    public Aluno autenticarAluno(String email) throws SQLException {
        String sql = "SELECT id, nome, email, status FROM aluno WHERE email = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, email);
            try (ResultSet resultSet = stm.executeQuery()) {
                if (resultSet.next()) {
                    return new Aluno(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            StatusAluno.valueOf(resultSet.getString("status"))
                    );
                }
            }
        }

        System.out.println("Aluno não encontrado!");
        return null;
    }

    public Professor autenticarProfessor(String email) throws SQLException {
        String sql = "SELECT id, nome, email FROM professor WHERE email = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, email);
            try (ResultSet resultSet = stm.executeQuery()) {
                if (resultSet.next()) {
                    return new Professor(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email")
                    );
                }
            }
        }

        System.out.println("Professor não encontrado!");
        return null;
    }

    public Curso autenticarCurso(String nomeCurso) throws SQLException {
        String sql = "SELECT curso.id as curso_id, curso.nome as curso_nome, curso.carga_horaria, curso.status, " +
                "professor.id as professor_id, professor.nome as professor_nome, professor.email " +
                "FROM curso " +
                "JOIN professor ON curso.id_professor = professor.id " +
                "WHERE curso.nome = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, nomeCurso);
            try (ResultSet resultSet = stm.executeQuery()) {
                if (resultSet.next()) {
                    Curso curso = new Curso(
                            resultSet.getInt("curso_id"),
                            resultSet.getString("curso_nome"),
                            StatusCurso.valueOf(resultSet.getString("status")),
                            resultSet.getInt("carga_horaria")
                    );

                    Professor professor = new Professor(
                            resultSet.getInt("professor_id"),
                            resultSet.getString("professor_nome"),
                            resultSet.getString("email")
                    );

                    curso.setProfessor(professor);

                    System.out.println("Curso autenticado com sucesso!");
                    return curso;
                }
            }
        }

        System.out.println("Curso não encontrado!");
        return null;
    }

    public static void fecharConexao(Connection conexao) throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
            System.out.println("Conexão fechada com sucesso!");
        }
    }

    public static Curso autenticarCurso(int idCurso) {
        return null;
    }
}

