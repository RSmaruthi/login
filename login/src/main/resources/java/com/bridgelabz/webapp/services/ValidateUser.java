package com.bridgelabz.webapp.services;

import com.bridgelabz.webapp.model.ForgotPassword;
import com.bridgelabz.webapp.model.User;
import com.bridgelabz.webapp.util.Utility;

/******************************************************************************
 * Purpose:ValidateUser Class contains of static methods which are reused
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class ValidateUser {
	/**
	 * @param user accepted to validate
	 * @return error included string or empty
	 */
	public static String getvalidateUser(User user) {

		String result = "";
		// for firstName
		if (user.getFirstName().trim().equals("") || user.getFirstName() == null
				|| !Utility.getValidFirstName(user.getFirstName())) {
			result = result + "Invalid firstName\n";
		}
		// for LastName
		if (user.getLastName().trim().equals("") || user.getLastName() == null
				|| !Utility.getValidLastName(user.getLastName())) {
			result = result + "Invalid lastName\n";

		}
		// for userName
		if (user.getUserName().trim().equals("") || user.getUserName() == null
				|| !Utility.getValidUserName(user.getUserName())) {
			result = result + "Invalid userName\n";
		}
		// for email
		if (user.getEmail().trim().equals("") || user.getEmail() == null || !Utility.getValidEmail(user.getEmail())) {
			result = result + "Invalid Email\n";
		}
		// for password
		if (user.getPassword().equals("") || !Utility.getValidPassword(user.getPassword())) {
			result = result + "\n" + "Invalid Password";
		}
		// for mobile number
		if (user.getMobileNo().equals("") || user.getMobileNo() == null
				|| !Utility.getValidPhoneNumber(user.getMobileNo())) {
			result = result + "\n" + "Invalid Mobile number";
		}
		return result;
	}

	/**
	 * @param forgotPasswordObj accepted to validate
	 * @return error included string or empty
	 */
	public static String validateForgotPassword(ForgotPassword forgotPasswordObj) {
		String result = "";
		// for username
		if (forgotPasswordObj.getUserName().trim().equals("") || forgotPasswordObj.getUserName() == null
				|| !Utility.getValidUserName(forgotPasswordObj.getUserName())) {
			result = result + "Invalid userName\n";
		}
		// for password
		if (forgotPasswordObj.getEmail().trim().equals("") || forgotPasswordObj.getEmail() == null
				|| !Utility.getValidEmail(forgotPasswordObj.getEmail())) {
			result = result + "Invalid Email\n";
		}
		// for password
		if (forgotPasswordObj.getPassword().equals("") || !Utility.getValidPassword(forgotPasswordObj.getPassword())) {
			result = result + "\n" + "Invalid Password";
		}
		return result;
	}

}
