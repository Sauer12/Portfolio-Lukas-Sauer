package sk.lukassauer;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/employees_database";
        int rowsAffected;
        try {
            // Establish Connection Object
            Connection connection = DriverManager.getConnection(url, "root", "Neviem123");

            // create a statement object to send to the database
            Statement statement = connection.createStatement();

            // Execute the statement object
            ResultSet resultSet = statement.executeQuery("select * from employees_tbl");

            // Insert data
            rowsAffected = statement.executeUpdate("insert into employees_tbl (id, name, dept, salary) "
            + "values (1100, 'Peter', 'Sales', 5000);");
            System.out.println("Executed an Insert statement");


            // Process the result
            System.out.println("Rows affected: " + rowsAffected);

//            int salaryTotal = 0;
//            while(resultSet.next()) {
//                salaryTotal += resultSet.getInt("salary");
//                System.out.println(resultSet.getString("name"));
//            }
//
//            System.out.println("Total salary: " + salaryTotal);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
