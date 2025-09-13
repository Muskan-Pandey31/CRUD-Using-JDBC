package usingjdbc.crud;

import java.sql.*;

public class InsertDataUsingJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO assignment1(id, age, name, position, company) VALUES(2, 23, 'Swati', 'Software Developer', 'PCS');";


        try (Connection c = DriverManager.getConnection(url, username, password)) {
            System.out.println(" Connected to database successfully ");

            Statement statement = c.createStatement();
            int rowsAffected = statement.executeUpdate(insertQuery);
            if (rowsAffected > 0){
                System.out.println(" Insertion successful " + rowsAffected + " rows affected ");

            } else {
                System.out.println(" Insertion failed ");
            }

            statement.close();
            c.close();
            System.out.println();
            System.out.println(" Connection closed successfully");

        } catch (SQLException e) {
            System.out.println(" Connection failed: " + e.getMessage());

        }


    }
}
