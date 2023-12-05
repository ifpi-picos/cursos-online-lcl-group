package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.entidades.Aluno;
//import br.edu.ifpi.enums.StatusAluno;

public class AlunoDao implements Dao<Aluno> {
    private Connection conexao;

    public AlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Aluno aluno) {
        try (PreparedStatement stm = conexao.prepareStatement("INSERT INTO aluno (nome, email, status) VALUES (?,?,?)")) {
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setString(3, aluno.getStatus());

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
    public List<Aluno> consultar() {
        List<Aluno> alunos = new ArrayList<>();
        try (PreparedStatement stm = conexao.prepareStatement("SELECT * FROM aluno")) {
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n___________Lista de alunos__________");
            while (resultSet.next()) {
                int idAluno = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String status = resultSet.getString("status");

                Aluno aluno = new Aluno(idAluno, nome, email, null);
                alunos.add(aluno);
                System.out.println(idAluno + " | " + nome + " | " + email + " | " + status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar alunos.");
        }
        return alunos;
    }


    @Override
    public int remover(Aluno aluno) {
        String sqlDelete = "DELETE FROM aluno WHERE ID = ?";

        try {

            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, aluno.getidAluno());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover o aluno: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int alterar(Aluno aluno) {
        String sqlAlterar = "UPDATE FROM aluno where id = ?";
        try (PreparedStatement stm = conexao.prepareStatement("UPDATE aluno SET nome=?, email=?, status=? WHERE id=?")) {
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setString(3, aluno.getStatus());
            stm.setInt(4, aluno.getidAluno());

            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

