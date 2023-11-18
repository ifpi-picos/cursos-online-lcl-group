package br.edu.ifpi.dao;

import java.sql.Connection;
import java.util.List;

public class CursoDao implements Dao<CursoDao>{
      private Connection conexao;

      public CursoDao(Connection conexao) {
        this.conexao = conexao;
    }


    @Override
    public int cadastrar(CursoDao entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public List<CursoDao> consultar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public int remover(CursoDao entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public int alterar(CursoDao entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }
    
}
