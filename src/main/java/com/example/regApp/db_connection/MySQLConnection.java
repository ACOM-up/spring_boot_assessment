/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.regApp.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Arosha
 */
public class MySQLConnection {

    public static Connection getConnection() throws Exception {
        String dbRoot = "jdbc:mysql://";
        String hostName = "localhost:3306/";
        String dbName = "db_user";
        String dbUrl = dbRoot + hostName + dbName;

        String hostUserName = "root";
        String hostPassword = "root";

        Class.forName("com.mysql.jdbc.Driver");
        Connection myConn = DriverManager.getConnection(dbUrl, hostUserName, hostPassword);

        return myConn;
    }
}
