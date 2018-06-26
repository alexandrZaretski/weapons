package model.pool;

import model.manager.PropertyManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    public static PropertyManager manager = new PropertyManager("dbConfig");
    private static String url = manager.getProperty("url");
    private static String userName = manager.getProperty("user");
    private static String password = manager.getProperty("password");
    public static String poolSize = manager.getProperty("pool_size");
    public static String database = manager.getProperty("testdatabase");

    public static Connection createConnection() throws SQLException {
        System.out.println(userName);
        System.out.println(password);
        System.out.println(url);
        return DriverManager.getConnection(url, userName, password);
    }

    public static Connection createConnection(String database) throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}