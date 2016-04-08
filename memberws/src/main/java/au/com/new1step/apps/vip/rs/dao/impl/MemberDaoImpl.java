package au.com.new1step.apps.vip.rs.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import au.com.new1step.apps.util.AbstractSessionUtil;
import au.com.new1step.apps.vip.rs.dao.MemberDao;
import au.com.new1step.apps.vip.rs.exception.MemberRsException;
import au.com.new1step.apps.vip.rs.model.Member;

@Repository
public class MemberDaoImpl extends AbstractSessionUtil implements MemberDao {
	@Override
	//@SuppressWarnings("unchecked")
	public Member fetchMemberById(Integer memId) throws MemberRsException{		  
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
		String sql = "from Member mem where mem.appId = '" + appId + "' order by mem.name asc"; 
        return session.createQuery(sql).list();  
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
	public Integer insertMember(Member member) throws MemberRsException{		
		Session session = sessionFactory.getCurrentSession();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		member.setDateCreated(date);
	    Integer id = (Integer)session.save(member);	
	    if(id < 1){
	    	throw new MemberRsException("Fail to insert Member.");
	    }
	    return id;
	}
	@Override
	public void updateMember(Member member) throws MemberRsException{
		/* method 1
		fetchMemberById(member.getMemId()); // check if the member is existing
		Session session = sessionFactory.getCurrentSession();
		session.update(member); 
		*/
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(member);
		
	}
	@Override
	public void deleteMember(Member member) throws MemberRsException{
		Session session = sessionFactory.getCurrentSession();		
		/* method 1
		Member result = (Member)session.createCriteria(Member.class)
	    	    .add(Restrictions.eq("memId", member.getMemId()))								    	    
	    	    .uniqueResult();
		*/
		
	        session.delete(member);
	     /* may be not need read first
		Member result = (Member)session.get(Member.class, member.getMemId());
		if(result != null){
		   session.delete(result); 
		}
		*/
	}	
}
