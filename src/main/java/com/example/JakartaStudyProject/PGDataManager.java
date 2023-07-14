package com.example.JakartaStudyProject;

import java.sql.*;

public class PGDataManager {
    String url = "jdbc:postgresql://localhost:5432/bookstore";
    String user = "postgres";
    String password = "PGPassword";

    public Connection connectionWithPG() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllCustomer(Connection conn, boolean asc) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            if (asc) {
                resultSet = statement.executeQuery("SELECT * FROM customers");
            } else {
                resultSet = statement.executeQuery("SELECT * FROM customers order by id desc");
            }

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");

                System.out.println("ID: " + id + ", Firstname: " + firstname + ", Lastname: " + lastname);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addANewCustomer(Connection conn, String firstname, String lastname) {
        try {
            String insertQuery = "INSERT INTO customers (firstname, lastname) VALUES (?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setString(1, firstname);
            insertStatement.setString(2, lastname);

            insertStatement.executeUpdate();
            insertStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCountOfTable(Connection conn, String tableName) {

        int res = 0;
        
        try {
            String sql = "SELECT COUNT(*) AS count FROM " + tableName;
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                res = resultSet.getInt("count");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;

    }
}
