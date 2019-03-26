package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.webapp.model.Login;

/******************************************************************************
 * Purpose:DataBaseInterActionLogin Class to get the user details from database
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class DataBaseInterActionLogin {
	// to get the link to the database
	
	Connection connection = DataBaseConnection.getConnection();

	/**
	 * in this method checking the username and the password if valid return boolean
	 * 
	 * @param login contains of LoginPoja Class Variables
	 * @return true or false
	 */
	public boolean isUser(Login login) {
		PreparedStatement preStat = null;// initializing preparedStatement variable before using it
		boolean isValidUser = false;// for returning
		String sqlQuery = "Select * from User where userName=? and password=?";// Query to get the username and password
																				// are same
		try {
			// getting preparedStatement using prepareStatement query
			preStat = connection.prepareStatement(sqlQuery);

			// setting all the values to query
			preStat.setString(1, login.getUserName());
			preStat.setString(2, login.getPassword());
			ResultSet resultSet = preStat.executeQuery();// int will be stored in resultSet
			if (resultSet.next()) {
				return isValidUser = true;
			} else
				return isValidUser;

		} catch (SQLException e) {
			return isValidUser;
		}

	}
}
