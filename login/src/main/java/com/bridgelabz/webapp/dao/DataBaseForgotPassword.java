package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.webapp.model.ForgotPassword;


public class DataBaseForgotPassword {
	Connection connection = DataBaseConnection.getConnection();

	public boolean toCheckEmailUser(ForgotPassword forgotObj) {

		PreparedStatement preStat = null;		boolean isValidUser = false;
		String sqlQuery = "Select * from User where email=? and userName=? ";
		try {
			preStat = connection.prepareStatement(sqlQuery);
						preStat.setString(2, forgotObj.getUserName());
			preStat.setString(1, forgotObj.getEmail());
			ResultSet resultSet = preStat.executeQuery();			if (resultSet.next()) {
				return isValidUser = true;
			} else
				return isValidUser;

		} catch (SQLException e) {
			return isValidUser;
		}

	}

	public void updatePassword(ForgotPassword forgotObj) {
		PreparedStatement preStat = null;
		String sqlQuery = "UPDATE User SET password=? where userName=? and email=?";
																				
		try {
			preStat = connection.prepareStatement(sqlQuery);
						preStat.setString(1, forgotObj.getPassword());
			preStat.setString(2, forgotObj.getUserName());
			preStat.setString(3, forgotObj.getEmail());

			preStat.executeUpdate();
			System.out.println("your data is updated sucessfully....!!!!!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
