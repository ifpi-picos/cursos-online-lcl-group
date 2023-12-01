package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.enums.StatusAluno;

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
            while (resultSet.next()) {
                Aluno aluno = new Aluno(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        StatusAluno.valueOf(resultSet.getString("status"))
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }


    @Override
    public int remover(Aluno aluno) {
        try (PreparedStatement stm = conexao.prepareStatement("DELETE FROM aluno WHERE id = ?")) {
            stm.setInt(1, aluno.getId());
            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int alterar(Aluno aluno) {
        try (PreparedStatement stm = conexao.prepareStatement("UPDATE aluno SET nome=?, email=?, status=? WHERE id=?")) {
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setString(3, aluno.getStatus());
            stm.setInt(4, aluno.getId());

            int rowsAffected = stm.executeUpdate();
            System.out.println(rowsAffected);
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

