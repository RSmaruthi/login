package com.bridgeit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	
	public static boolean validateMobileNumber(String mobileNumber) {
		String regex = "^[7-9][0-9]{9}$";
		return mobileNumber.matches(regex);
}

	public static boolean validateStringForAlphanumericOflength(String str, int length) {
		if (str == null)
			return false;
		if (str.trim().equals(""))
			return false;
		if (str.trim().contains(" "))
			return false;
		if (!Character.isLetter(str.charAt(0)))
			return false;
		if (str.length() >length || str.length() < 3)
			return false;
		return true;
	}

	
	public static boolean validateEmail(String email) {
		String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher;
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}