/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.futurepath.core;

import dev.futurepath.model.Team;
import dev.futurepath.model.daos.TeamDataBaseDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Elena Cirstea
 */
public class MySQLConnection {
    private static final String DRIVER="com.mysql.jdbc.Driver"; //com.mysql.jdbc.Driver
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String DATABASE="countries";
    private static final String SERVER= "localhost";
    private static final String PORT="3306";
    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(
                    "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        Connection connection = MySQLConnection.getConnection();
        System.out.println("ehm    ."+connection);
        
        List<Team> teams = new TeamDataBaseDao().readAll();
        teams.forEach((t)->{
            System.out.println(t.getName());
    
    });
        
        
        
    }



}
