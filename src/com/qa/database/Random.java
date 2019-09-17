package com.qa.database;

import java.util.Scanner;

public class Random {
	
	public static void main(String[] args) {
		
		String ting = "m";
		String n = "hio";
		int a = 9;
		System.out.println( "INSERT INTO " + ting + "(name,age) VALUES ( '" + n + "'," + a + ");");
	
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter table you want to access");
		String table = myObj.nextLine();
		System.out.println("Table is " + table);
		

	}

}
