package codepro;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import utils.AuthAnswerEnum;
import utils.LoggerProducer;

@ManagedBean
@SessionScoped
public class AccountService implements Serializable {

	private static final long serialVersionUID = 5420091903964226441L;

/*	private static Session session;
	@Inject
	private static final Logger logger = Logger.getLogger(LoggerProducer.class);
*/

	public AuthAnswerEnum loginService(String nickname, String password){
		
		 Configuration configuration = new Configuration();
         configuration.configure("hibernate.cfg.xml");
         StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
         SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
         Session session = sessionFactory.openSession();
         
		Transaction tx = null;
		
/*		try{*/
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM UserModel WHERE nickname=:nickname AND password=:password"); 
			query.setString("nickname", nickname);
			query.setString("password", password);
			
			if(query.list().size() > 0){
				System.out.println("Found something");
			};
	
			tx.commit();
			
/*		}catch(HibernateException e){
			logger.error(e);
			if (tx != null) tx.rollback();
		}
		finally{
			session.close();
		}
		*/
		return AuthAnswerEnum.L_QUERY_ERROR;
	}
}