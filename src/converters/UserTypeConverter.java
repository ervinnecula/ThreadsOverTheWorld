package converters;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import utils.UserTypes;
@Converter
public class UserTypeConverter implements AttributeConverter<UserTypes, String>, Serializable{
	
	public String convertToDatabaseColumn(UserTypes ut) {
		if(ut == UserTypes.ADMIN){
			return "ADMIN";
		}
		if(ut == UserTypes.MODERATOR){
			return "MODERATOR";
		}
		else{
			return "NORMAL";
		}
	}
	
	public UserTypes convertToEntityAttribute(String type) {
		if(type.equals("ADMIN")){
			return UserTypes.ADMIN;
		}
		if(type.equals("MODERATOR")){
			return UserTypes.MODERATOR;
		}
		else{
			return UserTypes.NORMAL;
		}
	}
}
