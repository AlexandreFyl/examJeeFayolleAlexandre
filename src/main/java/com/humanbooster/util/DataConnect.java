package com.humanbooster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    public static Connection getConnexion() throws SQLException, ClassNotFoundException{
    	   Class.forName("com.mysql.jdbc.Driver");     
        
        String url ="jdbc:mysql://localhost:3306/examjeefayollealexandre?serverTimezone=Europe/Paris";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }


}


