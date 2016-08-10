package services;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import utils.LoggerProducer;

@ManagedBean
@SessionScoped
public class AccountService implements Serializable {

	private static final long serialVersionUID = 5420091903964226441L;
	
	@Inject
	private static final Logger logger = Logger.getLogger(LoggerProducer.class);
		
	public void updateAccountOverview(String nickname, String email, String newPassword, InputStream newPicture){
		
	}
}
