package net.bit.academia.model.net.bit.academia.persistence.repositories.jdbc;

import java.sql.*;

public class EsempioCon {
    public static void find(String pattern) {
        final String URL = "jdbc:mysql://localhost/academia?serverTimezone=UTC";
        final String USER = "dev";
        final String PASSWORD = "mysqlpassword";
        final String ALL_AGENTS_BY_LASTNAME_LIKE =
                "SELECT id, firstname, lastname from AGENT WHERE lastname LIKE ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(ALL_AGENTS_BY_LASTNAME_LIKE)) {
//             Class.forName("com.mysql.jdbc.Driver");
//            System.out.println(con.getClass().getName());
//            System.out.println(st.getClass().getName());
            System.out.println("connessione effettuata");
            st.setString(1, "%" + pattern + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    System.out.println(id + " " + firstname + " " + lastname);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
