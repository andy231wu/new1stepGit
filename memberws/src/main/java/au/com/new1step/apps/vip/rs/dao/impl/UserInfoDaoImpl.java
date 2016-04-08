package au.com.new1step.apps.vip.rs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



import au.com.new1step.apps.util.AbstractSessionUtil;
import au.com.new1step.apps.vip.rs.dao.UserInfoDao;
import au.com.new1step.apps.vip.rs.exception.UserInfoRsException;
import au.com.new1step.apps.vip.rs.model.Member;
import au.com.new1step.apps.vip.rs.model.UserInfo;

@Repository
public class UserInfoDaoImpl extends AbstractSessionUtil implements UserInfoDao {
	
	@Override
	//@SuppressWarnings("unchecked")
	public UserInfo fetchUserInfoByUserId(String UserId) throws UserInfoRsException {		  
       Session session = sessionFactory.getCurrentSession();
      
       UserInfo userInfo = (UserInfo)session.createCriteria(UserInfo.class)
							    	    .add(Restrictions.idEq(UserId)) 
							    	    .uniqueResult();  					    	    
        return userInfo;  
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UserInfo> fetchAllUserInfos(String appId){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from UserInfo ui where ui.appId = :appId order by ui.userId asc"; 
        Query query = session.createQuery(sql);
        query.setParameter("appId", appId);
		return query.list();  
	}
		
	@Override
	public String insertUserInfo(UserInfo userInfo) throws UserInfoRsException{		
		Session session = sessionFactory.getCurrentSession();		
	    String id = (String)session.save(userInfo);		   
	    return id;
	}
	@Override
	public void updateUserInfo(UserInfo userInfo) throws UserInfoRsException{		
		Session session = sessionFactory.getCurrentSession();		
		UserInfo exist = (UserInfo)session.get(UserInfo.class, userInfo.getUserId());
		userInfo.setMember(exist.getMember());
		session.merge(userInfo);		
		
	}
	@Override
	public void deleteUserInfo(UserInfo userInfo) throws UserInfoRsException{
		Session session = sessionFactory.getCurrentSession();
	   	     
		UserInfo result = (UserInfo)session.get(UserInfo.class, userInfo.getUserId());
		if(result != null){
		   session.delete(result); 
		}
		
	}	
}
