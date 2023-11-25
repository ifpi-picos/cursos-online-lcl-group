package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5433/sistemaacademico";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0407,";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}