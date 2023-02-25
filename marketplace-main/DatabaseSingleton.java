package Singleton;

import java.sql.*;

public class DatabaseSingleton {

    private static DatabaseSingleton instance = null;
    private Connection connection;

    private DatabaseSingleton() {

    }


    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/market", "postgres", "222023");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet result(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}