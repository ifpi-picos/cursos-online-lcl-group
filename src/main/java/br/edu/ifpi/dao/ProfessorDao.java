package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {
    private Connection conexao;

      public ProfessorDao(Connection conexao) {
        this.conexao = conexao;
    
      }

    @Override
    public int cadastrar(Professor professor) {
        try (PreparedStatement stm = conexao.prepareStatement("INSERT INTO PROFESSOR (nome, email) VALUES (?,?)")) {
            stm.setString(1, professor.getNome());
            stm.setString(2, professor.getEmail());

            int rowsAffected = stm.executeUpdate();
            System.err.println(rowsAffected); // 1

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
    public List<Professor> consultar() {
        try (PreparedStatement stm = conexao.prepareStatement("SELECT * FROM professor order by id asc")) {
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de professores -----");
            while (resultSet.next()) {
                int idProfessor = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                System.out.println(idProfessor + " | " + nome + " | " + email);
            }

            return null;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int remover(Professor professor) {
        try (PreparedStatement stm = conexao.prepareStatement("DELETE FROM professor WHERE id = ?")) {
            stm.setInt(1, professor.getId());

            int rowsAffected = stm.executeUpdate();
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
    public int alterar(Professor professor) {
        try (PreparedStatement stm = conexao.prepareStatement("UPDATE professor SET nome = ?, email = ? WHERE id = ?")) {
            stm.setString(1, professor.getNome());
            stm.setString(2, professor.getEmail());
            stm.setInt(3, professor.getId());

            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);

            return rowsAffected;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int cadastrarNotas(CursoAluno cursoAluno, Double nota) {
      try (PreparedStatement stm = conexao.prepareStatement("UPDATE curso_aluno SET nota = ? WHERE id_aluno = ? AND id_curso = ?")) {
          stm.setDouble(1, nota);
          stm.setInt(2, cursoAluno.getIdAluno());
          stm.setInt(3, cursoAluno.getIdCurso());

          int rowsAffected = stm.executeUpdate();
          System.out.println(rowsAffected);

          return rowsAffected;
      } catch (SQLException e) {
          System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
      } catch (Exception e) {
          e.printStackTrace();
      }

      return 0;
  }

  // Fazer método para retornar os cursos ministrados pelo professor
  /*public List<Curso> cursosMinistrados(Professor professor) {
  }*/
}
