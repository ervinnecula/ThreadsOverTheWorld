package services;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import entities.ThreadModel;
import utils.LoggerProducer;

@ManagedBean
@SessionScoped
public class NewThreadService implements Serializable{
	
	private static final long serialVersionUID = -646333935481697492L;

	@Inject
	private static final Logger logger = Logger.getLogger(LoggerProducer.class);
	
	public void saveNewThread(String title, String body, UIInput tags, String category){
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		ArrayList<String> tagList = getTagsAsArrayList(tags);
		
		ThreadModel tm = new ThreadModel(title,body, tagList, timeStamp, "", category);
		
	 	logger.info(tm.toString());
	}
	
	public ArrayList<String> getTagsAsArrayList(UIInput tags){
		ArrayList<String> tagList = new ArrayList<String>();
		String stringTags = (String)tags.getValue();
		String[] tagArray = stringTags.split("\\|");		
		
		for(String tag:tagArray){
			tagList.add(tag);
		}
		return tagList;	
	}
	
}
