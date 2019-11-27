package com.example.clientmap;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDAO {

    private static List<ClientMap> clientMapList = new ArrayList<ClientMap>();

    public static List<ClientMap> allEmployees(){
        // variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // Step 1: Loading or
        // registering Oracle JDBC driver class
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();

        }

        // Step 2: Opening database connection
        try {

            String msAccDB = "C:/Users/sathi/OneDrive/Documents/Database1.accdb";
            String dbURL = "jdbc:ucanaccess://"
                    + msAccDB;

            // Step 2.A: Create and
            // get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL and
            // retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            // processing returned data and printing into console

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String empName = resultSet.getString(2);
                int age = resultSet.getInt(3);
                loadClientMap(id,empName,age);

            }
        }
        catch(
                SQLException sqlex){
                sqlex.printStackTrace();
        }
        finally {
            // Step 3: Closing database connection
            try {
                if(null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return clientMapList;
    }

    public static void loadClientMap(int id, String empName, int age){
        ClientMap clientMap = new ClientMap(id,empName, age);
        clientMapList.add(clientMap);
    }

}
