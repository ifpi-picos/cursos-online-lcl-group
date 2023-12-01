package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://db.eqoonavdkllfswzrsdwu.supabase.co:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "LCLgrupo@01";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}