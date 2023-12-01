package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() {
        Connection conexacao = null;
        try {
            conexacao = DriverManager.getConnection("postgres://postgres.eqoonavdkllfswzrsdwu:[YOUR-PASSWORD]@aws-0-sa-east-1.pooler.supabase.com:6543/postgres", "postgres",
                    "LCLgrupo@01");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conexacao;
    }





   // private static final String URL = "jdbc:postgresql://localhost:5433/sistemaacademico";
    //private static final String USERNAME = "postgres";
    //private static final String PASSWORD = "0407,";

    //public static Connection getConnection() throws SQLException {
   //     return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   // }

    
}