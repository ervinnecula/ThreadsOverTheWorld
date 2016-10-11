package services;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.UserModel;
import utils.AuthAnswerEnum;
import utils.HibernateUtil;
import utils.LoggerProducer;
import utils.UserTypes;
import validator.PasswordValidator;

@ManagedBean
@SessionScoped
public class AccountService implements Serializable {

	private static final long serialVersionUID = 5420091903964226441L;

	private static Session session;
	@Inject
	private static final Logger logger = Logger.getLogger(LoggerProducer.class);
		
	public void updateAccountOverview(String nickname, String email, String newPassword, InputStream newPicture){
		
	}
//	
//	public byte[] loadAccountImage(){
//		
//	}
	
	public AuthAnswerEnum loginService(String nickname, String password){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			Query query = session.createQuery("FROM UserModel WHERE nickname=:nickname AND password=:password"); 
			query.setString("nickname", nickname);
			query.setString("password", password);
			
			if(query.list().size() > 0){
				return AuthAnswerEnum.L_MATCH;
			};
	
			
			query = session.createQuery("FROM UserModel WHERE nickname=:nickname");
			query.setString("nickname", nickname);
			
			if(query.list().size() > 0){
				return AuthAnswerEnum.L_WRONG_PASS;
			}
			else{
				return AuthAnswerEnum.L_WRONG_NICKNAME;
			}
			
		}catch(HibernateException e){
			logger.error(e);
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		
		return AuthAnswerEnum.L_QUERY_ERROR;
	}
	
	public AuthAnswerEnum registerService(String nickname, String email, String password){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			
			Query query = session.createQuery("FROM UserModel WHERE nickname=:nickname");
			query.setString("nickname", nickname);
			
			if(query.list().size() != 0){
				return AuthAnswerEnum.R_NICK_TAKEN;
			}
			if(PasswordValidator.isPasswordShort(password)){
				return AuthAnswerEnum.R_PASS_SHORT;
			}
			if(PasswordValidator.isPasswordAlphaNumeric(password)){
				return AuthAnswerEnum.R_PASS_NO_ALPHANUMERIC;
			}

			UserModel um = new UserModel();
			um.setNickname(nickname);
			um.setPassword(password);
			um.setType(UserTypes.NORMAL);
			
			session.persist(um);		
			
			return AuthAnswerEnum.R_GOOD;
			
		}
		catch(HibernateException e){
			logger.error(e);
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		return AuthAnswerEnum.R_QUERY_ERROR;		
	}
	
}
