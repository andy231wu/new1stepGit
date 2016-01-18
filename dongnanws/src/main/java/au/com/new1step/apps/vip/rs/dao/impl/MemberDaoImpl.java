package au.com.new1step.apps.vip.rs.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import au.com.new1step.apps.util.AbstractSessionUtil;
import au.com.new1step.apps.vip.rs.dao.MemberDao;
import au.com.new1step.apps.vip.rs.exception.DongnanRsException;
import au.com.new1step.apps.vip.rs.model.Member;

@Repository
public class MemberDaoImpl extends AbstractSessionUtil implements MemberDao {
	@Override
	@SuppressWarnings("unchecked")
	public Member fetchMemberById(Integer memId) throws DongnanRsException{		  
       Session session = sessionFactory.getCurrentSession();
       List<Member> members = session.createCriteria(Member.class)
							    	    .add(Restrictions.eq("memId", memId))								    	    
							    	    .list();           
       
       if(members == null || members.size() == 0){
    	   throw new DongnanRsException("Member Id: " + memId + " Not Found.");
       }
		session.clear();						    	    
        return members.get(0);            
		
	}
	
	@Override
	public List<Member> fetchMembersByName(String name) throws DongnanRsException{
	   Session session = sessionFactory.getCurrentSession();
	  
	   @SuppressWarnings("unchecked")
	   List<Member> members = session.createCriteria(Member.class)
			                             .add(Restrictions.eq("name",name))
			                             .list();
	   if(members == null || members.size() == 0){
    	   throw new DongnanRsException("Member Name: " + name + " Not Found.");
       }
	   return members;
	}
	@Override
	public List<Member> fetchMembersByPhone(String phone) throws DongnanRsException{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		 List<Member> members = session.createCriteria(Member.class)
				                             .add(Restrictions.eq("phone",phone))
				                             .list();
	   if(members == null || members.size() == 0){
		   throw new DongnanRsException("Member Phone: " + phone + " Not Found.");
	   }
	   return members;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Member> fetchAllMembers(){
		return sessionFactory.getCurrentSession().createQuery("from Member").list();		
	}
	
	@Override
	public void insertMember(Member member) throws DongnanRsException{		
		Session session = sessionFactory.getCurrentSession();
	    Integer id = (Integer)session.save(member);	
	    if(id < 1){
	    	throw new DongnanRsException("Fail to insert Member.");
	    }
	}
	@Override
	public void updateMember(Member member) throws DongnanRsException{
		fetchMemberById(member.getMemId()); // check if the member is existing
		Session session = sessionFactory.getCurrentSession();
		session.update(member); 
		
	}
	@Override
	public void deleteMember(Member member) throws DongnanRsException{
		fetchMemberById(member.getMemId());	// check if the member is existing		
		Session session = sessionFactory.getCurrentSession();		
		session.delete(member);  
	}	
}
