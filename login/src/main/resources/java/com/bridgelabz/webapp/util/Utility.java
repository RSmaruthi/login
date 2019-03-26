package com.bridgelabz.webapp.util;

import java.util.regex.Pattern;

/******************************************************************************
 * Purpose:Utility Class contains of static methods which are reused
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class Utility {
	/**
	 * @param number accepts phone number validates the numbers is correct or not
	 * @return true for correct and incorrect is false
	 */
	public static boolean getValidPhoneNumber(String number) {
		if (Pattern.matches("[789]{1}[0-9]{9}", number)) {
			return true;

		}
		return false;
	}

	/**
	 * @param firstName accepted firstName validates the name length and it is
	 *                  alphabet is correct or not
	 * @return true for correct and incorrect is false
	 */
	public static boolean getValidFirstName(String firstName) {
		if (Pattern.matches("[a-zA-Z]{3,20}", firstName)) {
			return true;

		}
		return false;
	}

	/**
	 * @param lastName accepted lastName validates the name length and it is
	 *                 alphabet is correct or not
	 * @return true for correct and incorrect is false
	 */
	public static boolean getValidLastName(String lastName) {
		if (Pattern.matches("[a-zA-Z ]{1,10}", lastName)) {
			return true;

		}
		return false;
	}

	/**
	 * @param email accepted validating the string email contains @ symbol and .dot
	 *              i sexist
	 * @return true for correct and incorrect is false
	 */
	public static boolean getValidEmail(String email) {
		if (Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
				email)) {
			return true;

		}
		return false;
	}

	/**
	 * @param userName accepted userName validates the name length and it is
	 *                 alphabet is correct or not
	 * @return true for correct and incorrect is false
	 */
	public static boolean getValidUserName(String userName) {
		if (Pattern.matches("[a-zA-Z]{3,10}", userName)) {
			return true;

		}
		return false;
	}

	/**
	 * @param password accepted validating it contains of case-sensitive alphabet
	 *                 and length more than 7
	 * @return true for correct and incorrect is false
	 */
	public static boolean getValidPassword(String password) {
		if (Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$", password)) {
			return true;

		}
		return false;
	}
}
