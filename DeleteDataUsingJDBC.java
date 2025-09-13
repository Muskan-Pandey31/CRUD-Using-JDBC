package usingjdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataUsingJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "root";
        String deleteQuery = "DELETE FROM assignment1 WHERE id = 2;";


        try (Connection c = DriverManager.getConnection(url, username, password)) {
            System.out.println(" Connected to database successfully ");

            Statement statement = c.createStatement();
            int rowsAffected = statement.executeUpdate(deleteQuery);

            if (rowsAffected > 0){
                System.out.println(" Deletion successful " + rowsAffected + " rows affected ");

            } else {
                System.out.println(" Deletion failed ");
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
