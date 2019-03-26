package com.bridgelabz.webapp.util;

import java.util.regex.Pattern;

public class Utility {
public static boolean getValidPhoneNumber(String number) {
		if (Pattern.matches("[789]{1}[0-9]{9}", number)) {
			return true;

		}
		return false;
	}

		public static boolean getValidFirstName(String firstName) {
		if (Pattern.matches("[a-zA-Z]{3,20}", firstName)) {
			return true;

		}
		return false;
	}

	public static boolean getValidLastName(String lastName) {
		if (Pattern.matches("[a-zA-Z ]{1,10}", lastName)) {
			return true;

		}
		return false;
	}

	
	public static boolean getValidEmail(String email) {
		if (Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
				email)) {
			return true;

		}
		return false;
	}

	
	public static boolean getValidUserName(String userName) {
		if (Pattern.matches("[a-zA-Z]{3,10}", userName)) {
			return true;

		}
		return false;
	}

	
	public static boolean getValidPassword(String password) {
		if (Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$", password)) {
			return true;

		}
		return false;
	}
}
