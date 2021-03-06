package com.bridgeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.dao.LoginUserDao;
import com.bridgeit.model.LoginInfo;
import com.bridgeit.model.PasswordInfo;
import com.bridgeit.model.User;
import com.bridgeit.util.Utility;


public class UserService {
	@Autowired
	LoginUserDao loginUserDao;

	public int register(User user) {
		return loginUserDao.addUser(user);
	}
	public boolean login(LoginInfo loginInfo) {
		return loginUserDao.checkUserIsPresent(loginInfo);
	}
	public boolean forgot(PasswordInfo passwordInfo)
	{
		return loginUserDao.checkIsUserEmailPresent(passwordInfo);
	}
	

	public ModelAndView validateUser(User user) {
		ModelAndView mav = new ModelAndView();
		if(user.getFirstName().contentEquals("") || user.getFirstName() == null || !Utility.validateStringForAlphanumericOflength(user.getFirstName(),20))
			return mav.addObject("message","invalid first name...!");
		else if(user.getLastName().contentEquals("") || user.getLastName() == null || !Utility.validateStringForAlphanumericOflength(user.getLastName(), 20))
			return mav.addObject("message","invalid lastst name...!");
		else if(user.getPhoneNumber().contentEquals("") || user.getPhoneNumber() == null || !Utility.validateMobileNumber(user.getPhoneNumber()))
			return mav.addObject("message","invalid mobile number...!");
		else if(user.getEmail().contentEquals("") || user.getEmail() == null || !Utility.validateEmail(user.getEmail()))
			return mav.addObject("message","invalid email...!");
		else if(user.getUserName().contentEquals("") || user.getUserName() == null || !Utility.validateStringForAlphanumericOflength(user.getUserName(), 20))
			return mav.addObject("message", "invalid username");
		else if(user.getPassword().contentEquals("") || user.getPassword() == null || !Utility.validateStringForAlphanumericOflength(user.getPassword(),20))
			return mav.addObject("message", "invalid password");
		
		return null;
	}
	
	public ModelAndView validateLoginInfo(LoginInfo loginInfo)
	{
		ModelAndView mav = new ModelAndView();
		if(loginInfo.getEmail().contentEquals("") || loginInfo.getEmail() == null )
			return mav.addObject("message", "invalid email");
		else if(loginInfo.getPassword().contentEquals("") || loginInfo.getPassword() == null || !Utility.validateStringForAlphanumericOflength(loginInfo.getPassword(),20))
			return mav.addObject("message", "invalid password");
		else return null;
	}
}