package br.edu.ifpi.dao;

import java.sql.Connection;

import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {
    private Connection conexao;

      public ProfessorDao(Connection conexao) {
        this.conexao = conexao;
    
}
