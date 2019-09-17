package com.qa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	Constants c = new Constants();
	Connection conn = null;
	Statement stmt = null;
	
   public void accessDB() throws SQLException, ClassNotFoundException {
   //public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Class.forName(c.JDBC_DRIVER);
       System.out.println("Connecting to database...");
       conn = DriverManager.getConnection(c.DB_URL,c.USER,c.PASS);
       System.out.println("Creating statement...");
       stmt = conn.createStatement();
   }   
   
       
   //create database
   public void createDB() throws SQLException{
//       stmt.executeUpdate("CREATE DATABASE students");
       stmt.executeUpdate("USE students");
   }
       
   //create table
   public void createTable(String tableName) throws SQLException {
	   String sql = "CREATE TABLE " + tableName + "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100) NOT NULL, age INT NOT NULL);";
       stmt.executeUpdate(sql);
       System.out.println("Created table...");
   } 
       
   //create record in table
   public void createRec(String tableName, String name, int age) throws SQLException {    
       String sql2 = "INSERT INTO " + tableName + "(name,age) VALUES ('" + name + "'," + age + ");";
       stmt.executeUpdate(sql2);
       System.out.println("Inserted record...");
   }   
     //update record
    public void updateRec() throws SQLException{
   		String sql3 = "UPDATE students SET age = 22 WHERE id = 2;";
       stmt.executeUpdate(sql3);
    }  
       
       
    //read table	       
    public void readTable(String tableName) throws SQLException {
       String sql4 = "SELECT * FROM " + tableName + ";";
       ResultSet rs = stmt.executeQuery(sql4);
       while (rs.next()) {
    	   int id = rs.getInt("id");
    	   String name = rs.getString("name");
    	   int age = rs.getInt("age");
    	   System.out.println("ID: " + id + ", NAME: " + name + ", AGE: " + age);
    	   }
       rs.close();
       
    }  
       
	       
    //delete from table
    public void deleteRec() throws SQLException {
       String sql5 = "DELETE FROM students WHERE id = 2;";
       stmt.executeUpdate(sql5);
    }
    public void close_all() throws SQLException {
	   stmt.close();
	   conn.close();
    }
}
