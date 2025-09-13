package usingjdbc.crud;


import java.sql.*;

public class UsingJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "root";
        String query = "select * from assignment1";

//  But this is not required anymore Because in new version they implicitly loads folder when we connect the MySQL-JAR File.
//        try{
//           Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Drivers loaded successfully");
//
//        } catch (ClassNotFoundException c){
//            System.out.println(c.getMessage());
//
//        }

        try (Connection c = DriverManager.getConnection(url, username, password)) {
            System.out.println(" Connected to database successfully ");
//            System.out.println(c);
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
//            System.out.println(resultSet);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String company = resultSet.getString("company");
                System.out.println();
                System.out.println(" ID: " + id);
                System.out.println(" Age: " + age);
                System.out.println(" Name: " + name);
                System.out.println(" Position: " + position);
                System.out.println(" Company: " + company);
            }


            resultSet.close();
            statement.close();
            c.close();
            System.out.println();
            System.out.println(" Connection closed successfully");

        } catch (SQLException e) {
            System.out.println(" Connection failed: " + e.getMessage());

        }
    }
}
