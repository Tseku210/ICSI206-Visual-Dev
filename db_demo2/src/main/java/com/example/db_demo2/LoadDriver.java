package com.example.db_demo2;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

import javax.sql.StatementEvent;
import java.sql.*;

public class LoadDriver {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            String url = "jdbc:mysql://localhost:3306/classicmodels";
            String username = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + resultSet.getString(2));
            }
            connection.close();
        } catch (Exception ex) {
            // handle the error
            System.out.println("bye");
        }
    }
}
