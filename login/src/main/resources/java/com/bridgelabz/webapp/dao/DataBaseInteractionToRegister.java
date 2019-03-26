package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.webapp.model.User;

/******************************************************************************
 * Purpose:DataBaseInteractionToRegister Class to add the user details to
 * database
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class DataBaseInteractionToRegister {

	// to get the link to the database
	Connection connection = DataBaseConnection.getConnection();

	/**
	 * in this method adding user information to the database
	 * 
	 * @param userInfo accepting user data
	 */
	public void addUserInfo(User userInfo) {
		// initializing preparedStatement variable before using it
		PreparedStatement preStat = null;

		// query for inserting the details
		String sqlQuery = "Insert into User(id,firstName,lastName,userName,email,password,mobileNo) values(?,?,?,?,?,?,?)";

		try {
			// getting preparedStatement using prepareStatement query
			preStat = connection.prepareStatement(sqlQuery);
			// setting all the values to insert
			preStat.setInt(1, userInfo.getId());
			preStat.setString(2, userInfo.getFirstName());
			preStat.setString(3, userInfo.getLastName());
			preStat.setString(4, userInfo.getUserName());
			preStat.setString(5, userInfo.getEmail());
			preStat.setString(6, userInfo.getPassword());
			preStat.setString(7, userInfo.getMobileNo());

			preStat.executeUpdate();// to execute the query of inserted values to change in database

			// for class designer purpose
			System.out.println("your data is sucessfully added....!!!!!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * @param userName accepted to check the name is exist in database or not
	 * @return true or false
	 */
	public boolean checkUserName(String userName) {
		// initializing preparedStatement variable before using it
		PreparedStatement preStat = null;
		boolean isValidUser = false;// for return
		String sqlQuery = "Select * from User where userName=? ";// query to get the userName existed
		try {
			// getting preparedStatement using prepareStatement query
			preStat = connection.prepareStatement(sqlQuery);
			// setting all the values to get
			preStat.setString(1, userName);
			// executeQuery will return the int
			ResultSet resultSet = preStat.executeQuery();
			if (resultSet.next()) {
				// it will be true if it is effected to database
				return isValidUser = true;
			} else
				// it will be false if not effected to database
				return isValidUser;

		} catch (SQLException e) {
			return isValidUser; // if exception occurs false wiil be returned
		}

	}

}
