package com.bridgelabz.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.webapp.model.Login;

public class DataBaseInterActionLogin {
	
	Connection connection = DataBaseConnection.getConnection();

	
	public boolean isUser(Login login) {
		PreparedStatement preStat = null;		boolean isValidUser = false;
		String sqlQuery = "Select * from User where userName=? and password=?";		try {
						preStat = connection.prepareStatement(sqlQuery);

						preStat.setString(1, login.getUserName());
			preStat.setString(2, login.getPassword());
			ResultSet resultSet = preStat.executeQuery();			
			if (resultSet.next()) {
				return isValidUser = true;
			} else
				return isValidUser;

		} catch (SQLException e) {
			return isValidUser;
		}

	}
}
