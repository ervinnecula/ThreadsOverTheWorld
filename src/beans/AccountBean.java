package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;

@ManagedBean(name="accountBean")
@SessionScoped
public class AccountBean implements Serializable  {

	private static final long serialVersionUID = 8718167203864397551L;
	
	private String nickname;
	private String email;
	private String type;
	private String newPassword;
	private Part picture;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public Part getPicture() {
		return picture;
	}
	public void setPicture(Part picture) {
		this.picture = picture;
	}
	
	public void updateInfo() throws IOException{
		
		Part uploadedPhoto = getPicture();
		System.out.println(uploadedPhoto.getInputStream());
		System.out.println(nickname);
		System.out.println(email);
		
		//TODO
	}
	
}
