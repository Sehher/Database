package com.qa.database;

import java.sql.SQLException;
import java.util.Scanner;

public class DBManagerApp {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBManager dbm = new DBManager();
		dbm.accessDB();
		//dbm.createDB();
		
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("Enter table you want to access");
		String table = myObj1.nextLine();
		
		Scanner myObj2 = new Scanner(System.in);
		System.out.println("Enter name");
		String nameInput = myObj2.nextLine();
		
		Scanner myObj3 = new Scanner(System.in);
		System.out.println("Enter age");
		int ageInput = myObj3.nextInt();
		
		
		dbm.createRec(table,nameInput, ageInput);
		dbm.readTable(table);
		dbm.close_all();
		
	}

	
}
