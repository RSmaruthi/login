package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.webapp.model.ForgotPassword;

/******************************************************************************
 * Purpose:DataBaseForgotPassword Class to check the user forgotPassword details
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class DataBaseForgotPassword {
	// to get the link to the database
	Connection connection = DataBaseConnection.getConnection();

	/**
	 * @param forgotObj to check the email and username exist in db
	 * @return true or false
	 */
	public boolean toCheckEmailUser(ForgotPassword forgotObj) {

		PreparedStatement preStat = null;// initializing preparedStatement variable before using it
		boolean isValidUser = false;// for returning
		String sqlQuery = "Select * from User where email=? and userName=? ";// Query to get the username and email are
																				// same
		try {
			// getting preparedStatement using prepareStatement query
			preStat = connection.prepareStatement(sqlQuery);
			// setting all the values to query
			preStat.setString(2, forgotObj.getUserName());
			preStat.setString(1, forgotObj.getEmail());
			ResultSet resultSet = preStat.executeQuery();// int will be stored in resultSet
			if (resultSet.next()) {
				return isValidUser = true;
			} else
				return isValidUser;

		} catch (SQLException e) {
			return isValidUser;
		}

	}

	/**
	 * @param forgotObj to update the password for the user given
	 */
	public void updatePassword(ForgotPassword forgotObj) {
		PreparedStatement preStat = null;
		String sqlQuery = "UPDATE User SET password=? where userName=? and email=?";// Query to update the password
																					// which username and email are same
		try {
			// getting preparedStatement using prepareStatement query
			preStat = connection.prepareStatement(sqlQuery);
			// setting all the values to query
			preStat.setString(1, forgotObj.getPassword());
			preStat.setString(2, forgotObj.getUserName());
			preStat.setString(3, forgotObj.getEmail());

			preStat.executeUpdate();// executing the prepareStatement query
			System.out.println("your data is updated sucessfully....!!!!!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
