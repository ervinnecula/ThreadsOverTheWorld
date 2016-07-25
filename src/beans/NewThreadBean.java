package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import services.NewThreadService;

@ManagedBean(name="newThreadBean")
@SessionScoped
public class NewThreadBean implements Serializable {
	
	@ManagedProperty("#{newThreadService}")
	private NewThreadService newThreadService;
		
	private String title;
	private String body;
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setNewThreadService(NewThreadService newThreadService){
		this.newThreadService = newThreadService;
	}
	
	public NewThreadService getNewThreadService(){
		return this.newThreadService;
	}
	
	public void saveNewThread(){
		newThreadService.saveNewThread(title, body);
	}
}
