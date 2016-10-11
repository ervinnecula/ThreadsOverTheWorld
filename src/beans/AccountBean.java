package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import services.AccountService;
import utils.AuthAnswerEnum;

@ManagedBean
@SessionScoped
public class AccountBean implements Serializable  {

	private static final long serialVersionUID = 8718167203864397551L;
	
	@ManagedProperty("#{accountService}")
	private AccountService accountService;
	
	private String nickname;
	private String email;
	private String type;
	private String password;
	private Part newPicture;
	private StreamedContent picture;
	private HttpSession session;
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
		
		accountService.updateAccountOverview(nickname,email,password,newPicture);
	}

	public StreamedContent getPicture() throws IOException {
		
		//accountService.
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		InputStream img = new FileInputStream("C:/buletin.jpg");
		DefaultStreamedContent dsc = new DefaultStreamedContent(img);
		return dsc;
	}

	public void setPicture(StreamedContent picture) {
		this.picture = picture;
	}
	
	public void login(){
		
		AuthAnswerEnum answer = accountService.loginService(nickname, password);
		
		if(answer == AuthAnswerEnum.L_MATCH){
			session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			session.setAttribute("nickname", nickname);
		}
		else if(answer == AuthAnswerEnum.L_WRONG_PASS){
			FacesContext.getCurrentInstance().
			addMessage("loginForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mmmmm...","Password is so so wrong."));
		}
		else if(answer == AuthAnswerEnum.L_WRONG_NICKNAME){
			FacesContext.getCurrentInstance().
			addMessage("loginForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not good.","This nickname doesn't even exist"));
		}
		else if(answer == AuthAnswerEnum.L_QUERY_ERROR){
			FacesContext.getCurrentInstance().
			addMessage("loginForm:messages", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Something went wrooong.","Checking your account went wrong, try again later. We're so so sorry for this."));
		}
	}
	
	public void register(){
		AuthAnswerEnum answer = accountService.registerService(nickname, email, password);
		
		if(answer == AuthAnswerEnum.R_GOOD){
			FacesContext.getCurrentInstance().
			addMessage("registerForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "All good","Please login."));	
		}
		else if(answer == AuthAnswerEnum.R_NICK_TAKEN){
			FacesContext.getCurrentInstance().
			addMessage("registerForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nickname taken.","Try to think of something else"));
		}
		else if(answer == AuthAnswerEnum.R_PASS_NO_ALPHANUMERIC){
			FacesContext.getCurrentInstance().
			addMessage("registerForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad password choice.","Try something that contains both numbers and letters."));	
		}
		else if(answer == AuthAnswerEnum.R_PASS_SHORT){
			FacesContext.getCurrentInstance().
			addMessage("registerForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad password choice.","Try something with more than 8 characters."));
		}
		else if(answer == AuthAnswerEnum.R_QUERY_ERROR){
			FacesContext.getCurrentInstance().
			addMessage("registerForm:messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrooong.","Checking your account went wrong, try again later. We're so so sorry for this."));
		}
		
	}

}
