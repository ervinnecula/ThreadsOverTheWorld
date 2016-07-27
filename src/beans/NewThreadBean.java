package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;

import services.NewThreadService;

@ManagedBean(name="newThreadBean")
@SessionScoped
public class NewThreadBean implements Serializable {
	
	@ManagedProperty("#{newThreadService}")
	private NewThreadService newThreadService;
		
	private String title;
	private String body;
	private UIInput tags;
	private List<String> selectOptions;
	private String category;
	private String redirectToNewThread;
	
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
	
	public UIInput getTags(){
		return tags;
	}
	
	public void setTags(UIInput tags){
		this.tags = tags;
	}

	public void setNewThreadService(NewThreadService newThreadService){
		this.newThreadService = newThreadService;
	}
	
	public NewThreadService getNewThreadService(){
		return this.newThreadService;
	}
		
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getSelectOptions() {
		selectOptions = new ArrayList<String>();
		selectOptions.add("Sport");
		selectOptions.add("Science");
		selectOptions.add("Fun");
		
		return selectOptions;
	}

	public void saveNewThread(){
		newThreadService.saveNewThread(title, body, tags, category);
	}
	
	public String getRedirectToNewThread(){
		return "newThread.xhtml?faces-redirect=true";
	}
}
