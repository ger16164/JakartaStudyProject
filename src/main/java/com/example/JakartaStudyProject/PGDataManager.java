package com.example.JakartaStudyProject;
import java.sql.*;

public class PGDataManager {
    String url = "jdbc:postgresql://localhost:5432/bookstore";
    String user = "postgres";
    String password = "PGPassword";

    public Connection connectionWithPG(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllCustomer(Connection conn){
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");

                System.out.println("ID: " + id + ", Firstname: " + firstname + ", Lastname: " + lastname);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
