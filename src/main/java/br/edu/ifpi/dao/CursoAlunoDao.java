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
        try (PreparedStatement statement = conexao.prepareStatement("INSERT INTO CURSO_ALUNO (id_curso, id_aluno) VALUES (?,?)")) {
            statement.setInt(1, cursoAluno.getIdCurso());
            statement.setInt(2, cursoAluno.getIdAluno());

            int rowsAffected = statement.executeUpdate();
            System.err.println(rowsAffected); // 1

            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CursoAluno> consultar() {
        ArrayList<CursoAluno> cursoAlunos = new ArrayList<>();

        try (PreparedStatement stm = conexao.prepareStatement("SELECT * FROM curso_aluno order by id asc")) {
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de cursos -----");
            while (resultSet.next()) {
                int idCurso = resultSet.getInt("id_curso");
                int idAluno = resultSet.getInt("id_aluno");

                cursoAlunos.add(new CursoAluno(new Curso(idCurso, null, null, idAluno, null), new Aluno(idAluno, null, null, null)));
            }

            return cursoAlunos;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int remover(CursoAluno cursoAluno) {
        try (PreparedStatement stm = conexao.prepareStatement("DELETE FROM curso_aluno WHERE ID_CURSO = ? AND ID_ALUNO = ?")) {
            stm.setInt(1, cursoAluno.getIdCurso());
            stm.setInt(2, cursoAluno.getIdAluno());

            int rowsAffected = stm.executeUpdate();
            System.err.println(rowsAffected);

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
    public int alterar(CursoAluno cursoAluno) {
        try (PreparedStatement stm = conexao.prepareStatement("UPDATE curso_aluno SET id_curso = ? WHERE id_aluno = ?")) {
            stm.setInt(1, cursoAluno.getIdCurso());
            stm.setInt(2, cursoAluno.getIdAluno());

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

    // Criar método para visualizar boletim do aluno

}
