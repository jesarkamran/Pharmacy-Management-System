package org.example;

import java.sql.*;

public class ConnectionDB {
    Connection connection;
    Statement statement;
    public ConnectionDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","demo","db");
            statement = connection.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
