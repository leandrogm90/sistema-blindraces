package com.speedrunsbrasil.blindraces.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() 
			throws ClassNotFoundException, 
				   SQLException{
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://ec2-54-221-210-97.compute-1.amazonaws.com:5432/diin26j12fbm3?sslmode=require";
		String user = "ngeuzqugzylmdd";
		String password = "e9533084a25f2feb0ee0a2a792978887f2f68244756ee80c1b50575a08ec2057";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;				
	}

}
