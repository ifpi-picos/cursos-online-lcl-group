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
        String sql = "INSERT INTO CURSO_ALUNO (id_Curso, id_Aluno, nota) VALUES (?,?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, cursoAluno.getIdCurso());
            stm.setInt(2, cursoAluno.getIdAluno());
            stm.setFloat(3, cursoAluno.getNota());

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
System.out.println("___________Lista de alunos maticulados__________");
            while (resultSet.next()) {
                int idCurso = resultSet.getInt("id_curso");
                int idAluno = resultSet.getInt("id_aluno");
                Float nota = resultSet.getFloat("nota");

                System.out.println("id curso: " + idCurso + " | id aluno: " + idAluno + " | Nota: " + nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursosAlunos;
    }

    @Override
    public int remover(CursoAluno entidade) {
        String sql = "DELETE FROM curso_aluno WHERE id_curso = ? AND id_aluno = ?";
        
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, entidade.getIdCurso());
            stm.setInt(2, entidade.getIdAluno());
            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int alterar(CursoAluno entidade) {
      return 0;
      // Método não foi implementado
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
                Float media = resultSet.getFloat("media");
                System.out.println("Nota média geral dos alunos em " + curso.getNome() + ": " + media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void porcentagemAlunosAprovados(Curso curso) {
        String sql = "SELECT COUNT(*) as total, " +
                "COUNT(CASE WHEN nota >= 7 THEN 1 END) as aprovados " +
                "FROM curso_aluno " +
                "WHERE id_curso = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, curso.getId());
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                int aprovados = resultSet.getInt("aprovados");
                float porcentagem = ((float)aprovados/total) * 100;

                System.out.println("Porcentagem de alunos aprovados em " + curso.getNome() + ": "
                    + porcentagem + "%");
            }
        } catch (SQLException e) {

        }
    }

    public void porcentagemAlunosReprovados(Curso curso) {
        String sql = "SELECT COUNT(*) as total, " +
                "COUNT(CASE WHEN nota < 7 THEN 1 END) as reprovados " +
                "FROM curso_aluno " +
                "WHERE id_curso = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, curso.getId());
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                int reprovados = resultSet.getInt("reprovados");
                float porcentagem = ((float)reprovados/total) * 100;

                System.out.println("Porcentagem de alunos reprovados em " + curso.getNome() + ": "
                    + porcentagem + "%");
            }
        } catch (SQLException e) {

        }
    }

    public void cursosMatriculados (Aluno aluno) throws SQLException {
        String sql = "SELECT curso.nome as curso_nome, curso.id as id_curso " +
                    "FROM curso_aluno " +
                    "JOIN curso on curso.id = curso_aluno.id_curso " +
                    "WHERE curso_aluno.id_aluno = ? AND StatusMatricula = 'MATRICULADO' ";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, aluno.getidAluno());
        ResultSet resultSet = stm.executeQuery();

        System.out.println("\n_____Cursos matriculados_____");
        while (resultSet.next()) {
            String nomeCurso = resultSet.getString("curso_nome");
            int idCurso = resultSet.getInt("id_curso");

            System.out.println(idCurso + " | " + nomeCurso);
        }
    }

    public void cursosConcluidos (int aluno) throws SQLException {
        String sql =  "SELECT id_curso as alunos FROM curso_aluno WHERE id_aluno = ? AND nota >= 7";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, aluno);
        ResultSet resultSet = stm.executeQuery();

        System.out.println("\n_____ Cursos concluídos _____");
        while (resultSet.next()) {
            int idAluno = resultSet.getInt("alunos");
            System.out.println("Aluno ID: " + idAluno);
        }
    }

    public void inserirNota(CursoAluno cursoAluno, Float nota) {
        String sql = "UPDATE curso_aluno SET nota = ? WHERE id_curso = ? AND id_aluno = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setFloat(1, nota);
            stm.setInt(2, cursoAluno.getIdCurso());
            stm.setInt(3, cursoAluno.getIdAluno());
            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarBoletimAluno(Aluno aluno) throws SQLException {
        String sql = "SELECT curso.nome as curso_nome, curso_aluno.nota as nota " +
                    "FROM curso_aluno " +
                    "JOIN curso on curso.id = curso_aluno.id_curso " +
                    "WHERE curso_aluno.id_aluno = ?";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, aluno.getidAluno());
        ResultSet resultSet = stm.executeQuery();

        System.out.println("\n_____ Boletim _____");
        while (resultSet.next()) {
            String nomeCurso = resultSet.getString("curso_nome");
            float nota = resultSet.getFloat("nota");

            System.out.println("Curso: " + nomeCurso + ", nota: " + nota);
        }
    }

    public void VisualizarPerfilAluno(Aluno aluno) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE id = ?";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, aluno.getidAluno());
        ResultSet resultSet = stm.executeQuery();

        System.out.println("\n_____ Perfil do aluno _____");
        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String email = resultSet.getString("email");
            String status = resultSet.getString("status");

            System.out.println("Nome: " + nome);
            System.out.println("Email: " + email);
            System.out.println("Status: " + status);
        }
    }

    public void cadastrarNotas(CursoAluno cursoAluno, Double nota) {
    }
}
