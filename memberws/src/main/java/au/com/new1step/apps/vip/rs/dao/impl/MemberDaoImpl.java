package au.com.new1step.apps.vip.rs.dao.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import au.com.new1step.apps.util.AbstractSessionUtil;
import au.com.new1step.apps.vip.rs.dao.MemberDao;
import au.com.new1step.apps.vip.rs.exception.MemberRsException;
import au.com.new1step.apps.vip.rs.model.Address;
import au.com.new1step.apps.vip.rs.model.Member;
import au.com.new1step.apps.vip.rs.model.UserInfo;

@Repository
public class MemberDaoImpl extends AbstractSessionUtil implements MemberDao {
	@Override
	//@SuppressWarnings("unchecked")
	public Member fetchMemberById(Long memId) throws MemberRsException{		  
       Session session = sessionFactory.getCurrentSession();
       // method 1
       Member member = (Member)session.createCriteria(Member.class)
							    	    .add(Restrictions.eq("memId", memId))
							    	   // .add(Restrictions.idEq(memId)) alw: you can using the statement as well
							    	    .uniqueResult();          
		//session.clear();						    	    
        return member;  
       
       /*
       // method 2;
       Member member = (Member)session.createQuery(
    		          " from Member where memId = '" + memId + "'").uniqueResult();
       return member;
       */
	}
	
	@Override
	public List<Member> fetchMembersByName(Member member) throws MemberRsException{
	   Session session = sessionFactory.getCurrentSession();
	  
	   @SuppressWarnings("unchecked")	   
	   List<Member> members = session.createCriteria(Member.class)
			                             .add(Restrictions.eq("name",member.getName()))
			                             .add(Restrictions.eq("appId",member.getAppId()))
			                             .add(Restrictions.eq("isActive",true))
			                             .list();
	   
	   if(members == null || members.size() == 0){
    	   throw new MemberRsException("Member Name: " + member.getName() + " Not Found.");
       }
	   return members;
	}
	@Override
	public List<Member> fetchMembersByPhone(Member member) throws MemberRsException{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		 List<Member> members = session.createCriteria(Member.class)
				                             .add(Restrictions.eq("phone",member.getPhone()))
				                             .add(Restrictions.eq("appId",member.getAppId()))
				                             .add(Restrictions.eq("isActive",true))
				                             .list();
	   if(members == null || members.size() == 0){
		   throw new MemberRsException("Member Phone: " + member.getPhone() + " Not Found.");
	   }
	   return members;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllMembers(String appId){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Member mem where mem.appId = :appId order by mem.name asc";         
        Query query = session.createQuery(sql);
        query.setParameter("appId", appId);
		return query.list();  
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllActiveMembers(String appId){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Member mem where mem.appId = '" + appId + "' and mem.isActive = true order by mem.name asc";
		return session.createQuery(sql).list(); 
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllInactiveMembers(String appId){
		Session session = sessionFactory.getCurrentSession();	
		String sql = "from Member mem where mem.appId = '" + appId + "' and mem.isActive = false order by mem.name asc";
		return session.createQuery(sql).list();   
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllActiveGoldMembers(String appId){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Member mem where mem.appId = '" + appId + "' and mem.isActive = true and mem.memClass = 'g' order by mem.name asc";
		return session.createQuery(sql).list(); 
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllActiveSilverMembers(String appId){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Member mem where mem.appId = '" + appId + "' and mem.isActive = true and mem.memClass = 's' order by mem.name asc";
		return session.createQuery(sql).list(); 
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllActiveDiamondMembers(String appId){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Member mem where mem.appId = '" + appId + "' and mem.isActive = true and mem.memClass = 'd' order by mem.name asc";
		return session.createQuery(sql).list(); 
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllActiveOrdinaryMembers(String appId){
		Session session = sessionFactory.getCurrentSession();	
		String sql = "from Member mem where mem.appId = '" + appId + "' and mem.isActive = true and mem.memClass = 'o' order by mem.name asc";
		return session.createQuery(sql).list(); 
	}
	
	@Override
	public Long insertMember(Member member) throws MemberRsException{		
		Session session = sessionFactory.getCurrentSession();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		member.setDateCreated(date);
		// one to many
		Set<Address> addresses = member.getAddresses();	 
		if(addresses != null && addresses.size() != 0){
		    for(Address addr : addresses){	    
		    	addr.setMember(member);	    	
		    }
		}
		// one to one
		UserInfo user = member.getUserInfo();
		if(user != null){
			user.setMember(member);	
		}
	    
	    Long id  = (Long)session.save(member);
	  
	    if(id <= 0){
	    	throw new MemberRsException("Fail to insert Member.");
	    }
	   
	    return id;
	    
	}
	@Override
	public void updateMember(Member member) throws MemberRsException{		
		Session session = sessionFactory.getCurrentSession();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		member.setDateCreated(date);
		
		// this will avoid null value of memId in address table
		// it required to pass addressid, so address can be updated
		// otherwise it will add new address
		Set<Address> addresses = member.getAddresses();	 
		if(addresses != null && addresses.size() != 0){
		    for(Address addr : addresses){	    
		    	addr.setMember(member);	    	
		    }
		}
		UserInfo user = member.getUserInfo();
		if(user != null){
			user.setMember(member);	
		}
	   
	    
		//session.merge(member);
		session.update(member);
		
	}
	@Override
	public void deleteMember(Member member) throws MemberRsException{
		Session session = sessionFactory.getCurrentSession();		
		/* method 1
		Member result = (Member)session.createCriteria(Member.class)
	    	    .add(Restrictions.eq("memId", member.getMemId()))								    	    
	    	    .uniqueResult();
		*/
		
	     
		Member result = (Member)session.get(Member.class, member.getMemId());
		if(result != null){
		   session.delete(result); 
		}
		
	}	
}
