package services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import entities.ThreadModel;
import utils.LoggerProducer;

@ManagedBean
@SessionScoped
public class NewThreadService{
	
	private static final long serialVersionUID = -646333935481697492L;

	@Inject
	private static final Logger logger = Logger.getLogger(LoggerProducer.class);
	
	public void saveNewThread(String title, String body){
		ThreadModel tm = new ThreadModel(title,body, null, "", "", "");
		
	 	logger.info(tm.toString());
	}

}
