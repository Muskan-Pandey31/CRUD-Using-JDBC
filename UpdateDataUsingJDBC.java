package usingjdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataUsingJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "root";
        String updateQuery = "UPDATE assignment1\n" +
                "SET age = 21\n" +
                "WHERE name = 'Muskan';";


        try (Connection c = DriverManager.getConnection(url, username, password)) {
            System.out.println(" Connected to database successfully ");

            Statement statement = c.createStatement();
            int rowsAffected = statement.executeUpdate(updateQuery);

            if (rowsAffected > 0) {
                System.out.println(" Update successful " + rowsAffected + " rows affected ");

            } else {
                System.out.println(" Update failed ");
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
