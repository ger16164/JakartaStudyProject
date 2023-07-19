package com.example.JakartaStudyProject;

import java.sql.*;

public class PGDataManager {
    String url = "jdbc:postgresql://localhost:5432/bookstore";
    String user = "postgres";
    String password = "*****";

    public Connection connectionWithPG() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllCustomer(Connection conn) {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM customers")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                System.out.println("ID: " + id + ", Firstname: " + firstname + ", Lastname: " + lastname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addANewCustomer(Connection conn, String firstname, String lastname) {
        String insertQuery = "INSERT INTO customers (firstname, lastname) VALUES (?, ?)";
        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
            insertStatement.setString(1, firstname);
            insertStatement.setString(2, lastname);

            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCountOfTable(Connection conn, String tableName) {
        int res = 0;
        String sql = "SELECT COUNT(*) AS count FROM " + tableName;
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                res = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;

    }
}
