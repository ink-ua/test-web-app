package ua.pp.constantine.testtask.web.model.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.pp.constantine.testtask.web.model.PlainUser;

public class PlainUserValidator implements Validator {
	
	public static final int USERNAME_MIN_LENGTH = 3;
    public static final int USERNAME_MAX_LENGTH = 32;
    
	public static final int PASSWORD_MIN_LENGTH = 6;

    public boolean supports(Class<?> clazz) {
        return PlainUser.class.equals(clazz);
    }

    public void validate(Object obj, Errors err) {
    	PlainUser user = (PlainUser) obj;
        String username = user.getUsername();
    	validateUsername(username, err);
    	String password = user.getPassword();
		validatePassword(password, username, err);
    }

    public static void validateUsername(String username, Errors err) {
    	if(username == null || username.isEmpty()) {
    		err.rejectValue("username", "username.empty");
    	} else {
	        if(username.length() < USERNAME_MIN_LENGTH) {
	            err.rejectValue("username", "username.min", new Integer[]{ USERNAME_MIN_LENGTH }, null);
	        } else if(username.length() > USERNAME_MAX_LENGTH) {
	            err.rejectValue("username", "username.max", new Integer[]{ USERNAME_MAX_LENGTH }, null);
	        }
	
	        if(!username.matches("[-_a-zA-Z0-9]+")) {
	            err.rejectValue("username", "username.invalid");
	        }
    	}
    }
    
    public static void validatePassword(String password, String username, Errors err) {
		if(password == null || password.isEmpty()) {
    		err.rejectValue("password", "password.empty");
    	} else {
			if (password.length() < PASSWORD_MIN_LENGTH) {
				err.rejectValue("password", "password.length", new Integer[]{ PASSWORD_MIN_LENGTH }, null);
			}
			if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")) {
				err.rejectValue("password", "password.upperlower");
			}
			if (!password.matches(".*[0-9].*")) {
				err.rejectValue("password", "password.digit");
			}
			if(username != null && password.contains(username)) {
				err.rejectValue("password", "password.containsusername");
			}
    	}
	}
}
