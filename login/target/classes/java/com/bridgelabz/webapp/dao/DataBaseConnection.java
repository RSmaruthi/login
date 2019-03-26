package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/******************************************************************************
 * Purpose:DataBaseConnection Class to establish connection to database
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class DataBaseConnection {

	public static Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/WebApp";
		final String userId = "root";
		final String password = "password";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, userId, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}
}
