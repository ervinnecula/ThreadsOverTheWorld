package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import services.AccountService;

@ManagedBean
@SessionScoped
public class AccountBean implements Serializable  {

	private static final long serialVersionUID = 8718167203864397551L;
	
	@ManagedProperty("#{accountService}")
	private AccountService accountService;
	
	private String nickname;
	private String email;
	private String type;
	private String newPassword;
	private Part newPicture;
	private StreamedContent picture;
	
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
	
	public Part getNewPicture() {
		return newPicture;
	}
	
	public void setNewPicture(Part newPicture) {
		this.newPicture = newPicture;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void updateInfo() throws IOException{
		Part uploadedPhoto = getNewPicture();
		InputStream newPicture = uploadedPhoto.getInputStream();
		
		accountService.updateAccountOverview(nickname,email,newPassword,newPicture);
	}

	public StreamedContent getPicture() throws IOException {
		
		InputStream img = new FileInputStream("C:/buletin.jpg");
		DefaultStreamedContent dsc = new DefaultStreamedContent(img);
		return dsc;
	}

	public void setChart(StreamedContent picture) {
		this.picture = picture;
	}

}
