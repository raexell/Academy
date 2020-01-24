package net.bit.academia.model.net.bit.academia.persistence.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost/academia?serverTimezone=UTC";
    public static final String USER = "dev";
    public static final String PASSWORD = "mysqlpassword";
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
