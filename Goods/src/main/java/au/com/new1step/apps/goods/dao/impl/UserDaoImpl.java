package au.com.new1step.apps.goods.dao.impl;

import java.util.List;







import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import au.com.new1step.apps.goods.dao.UserDao;
import au.com.new1step.apps.goods.db.model.User;
import au.com.new1step.apps.util.AbstractSessionUtil;

@Repository
public class UserDaoImpl extends AbstractSessionUtil implements UserDao {	
	    @Override		
		public User fetchUserByUserId(String UserId) {		  
	       Session session = sessionFactory.getCurrentSession();
	      
	       User user = (User)session.createCriteria(User.class)
								    	    .add(Restrictions.idEq(UserId)) 
								    	    .uniqueResult();  					    	    
	        return user;  
		}	
		
		@Override
		@SuppressWarnings("unchecked")
		public List<User> fetchAllUsers(){
			Session session = sessionFactory.getCurrentSession();
			String sql = "from User u order by u.userId asc"; 
	        Query query = session.createQuery(sql);
	       
			return query.list();  
		}
			
		@Override
		public String insertUser(User user) {		
			Session session = sessionFactory.getCurrentSession();		
		    String id = (String)session.save(user);		   
		    return id;
		}
		@Override
		public void updateUser(User user){		
			Session session = sessionFactory.getCurrentSession();		
			//UserInfo exist = (UserInfo)session.get(User.class, userInfo.getUserId());
			//userInfo.setMember(exist.getMember());
			//session.merge(user);		
			session.update(user);
			
		}
		@Override
		public void deleteUser(User user){
			Session session = sessionFactory.getCurrentSession();
		   	     
			User result = (User)session.get(User.class, user.getUserId());
			if(result != null){
			   session.delete(result); 
			}
			
		}	

}