package validator;

import java.util.regex.Pattern;

public class PasswordValidator {
	static public boolean isPasswordShort(String password){
		return password.length()<8 ? true:false;
	}
	
	static public boolean isPasswordAlphaNumeric(String password){
		boolean hasLetters = false, hasDigits = false;
		for(int i = 0; i < password.length(); i++){
			if(Character.isLetter(password.charAt(i)))
				hasLetters = true;
			if(Character.isDigit(password.charAt(i)))
				hasDigits = true;
		}
		
		return hasLetters && hasDigits ? false:true;
	}
}
