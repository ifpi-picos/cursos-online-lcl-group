package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;

public class CursoDao implements Dao<Curso>{
      private Connection conexao;

      public CursoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Curso curso) {
        try (PreparedStatement statement = conexao.prepareStatement("INSERT INTO CURSO (NOME, STATUS, CARGA_HORARIA, ID_PROFESSOR) VALUES (?, ?, ?, ?)")) {
        statement.setString(1, curso.getNome());
        statement.setString(2, curso.getStatusCurso());
        statement.setInt(3, curso.getCargaHoraria());
        statement.setInt(4, curso.getProfessor().getId());

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        
    }

    @Override
    public List<Curso> consultar() {
    List<Curso> cursos = new ArrayList<>();
    String sql = "SELECT c.id, c.nome, c.status, c.carga_horaria, c.id_professor, p.nome as professor_nome, p.email as professor_email " +
                 "FROM curso c " +
                 "JOIN professor p ON c.id_professor = p.id";

    try (PreparedStatement stm = conexao.prepareStatement(sql)) {
        ResultSet resultSet = stm.executeQuery();

        while (resultSet.next()) {
            Professor professor = new Professor(
                resultSet.getInt("id_professor"),
                resultSet.getString("professor_nome"),
                resultSet.getString("professor_email")
            );

            Curso curso = new Curso(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                StatusCurso.valueOf(resultSet.getString("status")),
                resultSet.getInt("carga_horaria")
            );

            curso.setProfessor(professor);
            cursos.add(curso);
        }
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }

        return cursos;
    }


    @Override
    public int remover(Curso curso) {
        try (PreparedStatement stm = conexao.prepareStatement("DELETE FROM curso WHERE id = ?")) {
            stm.setInt(1, curso.getId());

            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return 0;
    }

    @Override
    public int alterar(Curso curso) {
        try (PreparedStatement stm = conexao.prepareStatement("UPDATE curso SET nome = ?, status = ?, carga_horaria = ?, id_professor = ? WHERE id = ?")) {
            stm.setString(1, curso.getNome());
            stm.setString(2, curso.getStatusCurso().toString());
            stm.setInt(3, curso.getCargaHoraria());
            stm.setInt(4, curso.getProfessor().getId());
            stm.setInt(5, curso.getId());

            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return 0;
    }

    public void matricularAlunoEmCurso(int idAluno, int idCurso) {
        try (Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO curso_aluno (id_curso, id_aluno) VALUES (?, ?)")) {

            statement.setInt(1, idCurso);
            statement.setInt(2, idAluno);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao matricular o aluno no curso", e);
        }
    }
}
