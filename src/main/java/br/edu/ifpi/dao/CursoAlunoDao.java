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

    // Criação do método para visualizar boletim do aluno
    public List<CursoAluno> consultarBoletimAluno(Aluno aluno) {
            String sql = "SELECT curso.nome as nome, curso_aluno.nota as nota " +
                         "FROM curso_aluno " +
                         "JOIN curso ON curso.id = curso_aluno.id_curso " +
                         "WHERE curso_aluno.id_aluno = ?";
        
            List<CursoAluno> cursos = new ArrayList<>();
        
            try {
                PreparedStatement stm = conexao.prepareStatement(sql);
                stm.setInt(1, aluno.getId());
                ResultSet resultSet = stm.executeQuery();
                AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
        
                System.out.println("\n----- Rendimento -----");
                while (resultSet.next()) {
                    String nomeCurso = resultSet.getString("nome");
                    Curso curso = autenticacaoDao.autenticarCurso(nomeCurso);
        
                    Double nota = resultSet.getDouble("nota");
                    cursos.add(new CursoAluno(curso, aluno));
                    System.out.println(curso.getNome() + " | " + nota);
                }
        
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        
            return cursos;
        }

    // Criação do método para exibir a lista de alunos com suas notas de um curso específico.
    public void consultarPorCurso(Curso curso) throws SQLException {
    String sql = "SELECT curso_aluno.nota as nota, aluno.nome as nome " +
                 "FROM curso_aluno " +
                 "JOIN aluno ON aluno.id = curso_aluno.id_aluno " +
                 "WHERE curso_aluno.id_curso = ?";

    PreparedStatement stm = conexao.prepareStatement(sql);
    stm.setInt(1, curso.getId());
    ResultSet resultSet = stm.executeQuery();

    System.out.println("\n______ Lista de Alunos ______");
    while (resultSet.next()) {
        String nomeAluno = resultSet.getString("nome");
        Double nota = resultSet.getDouble("nota");

        System.out.println(nomeAluno + " | " + nota);
    
        }
    }

}

