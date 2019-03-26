package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.webapp.model.User;


public class DataBaseInteractionToRegister {

	Connection connection = DataBaseConnection.getConnection();

	
	public void addUserInfo(User userInfo) {
		PreparedStatement preStat = null;

		String sqlQuery = "Insert into User(id,firstName,lastName,userName,email,password,mobileNo) values(?,?,?,?,?,?,?)";

		try {
			preStat = connection.prepareStatement(sqlQuery);
			preStat.setInt(1, userInfo.getId());
			preStat.setString(2, userInfo.getFirstName());
			preStat.setString(3, userInfo.getLastName());
			preStat.setString(4, userInfo.getUserName());
			preStat.setString(5, userInfo.getEmail());
			preStat.setString(6, userInfo.getPassword());
			preStat.setString(7, userInfo.getMobileNo());

			preStat.executeUpdate();
			System.out.println("your data is sucessfully added....!!!!!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	
	public boolean checkUserName(String userName) {
		PreparedStatement preStat = null;
		boolean isValidUser = false;
		String sqlQuery = "Select * from User where userName=? ";		try {
			preStat = connection.prepareStatement(sqlQuery);
			preStat.setString(1, userName);
			ResultSet resultSet = preStat.executeQuery();
			if (resultSet.next()) {
				return isValidUser = true;
			} else
				return isValidUser;

		} catch (SQLException e) {
			return isValidUser; 		}

	}

}
