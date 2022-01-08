package com.bagas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static String user = "root";
    private static String password = "root";
    private static String host = "localhost";
    private static String db = "java_akdmk";
    private static String port = "3306";
    private Connection connection;

    private static DbConnector instance;

    private DbConnector() {
    }

    public static DbConnector getInstance() {
        if (instance == null) {
            instance = new DbConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Sukses\n===========================");
                return connection;
            } catch (SQLException e) {
                System.out.println("Koneksi Gagal");
            }

        }
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
