package net.bit.academia.model.net.bit.academia.persistence.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost/academia?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "mysql";
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
