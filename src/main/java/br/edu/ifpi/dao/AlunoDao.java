package br.edu.ifpi.dao;

import java.sql.Connection;
import java.util.List;

import br.edu.ifpi.entidades.Aluno;

public class AlunoDao implements Dao<Aluno>{
    private Connection conexao;

    public AlunoDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public int cadastrar(Aluno entidade) {
       
    }

    @Override
    public List<Aluno> consultar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public int remover(Aluno entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public int alterar(Aluno entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }
    
    
}
