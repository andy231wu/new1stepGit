package au.com.new1step.apps.vip.rs.dao;

import java.util.List;





import org.springframework.stereotype.Repository;

import au.com.new1step.apps.vip.rs.exception.DongnanRsException;
import au.com.new1step.apps.vip.rs.model.Member;


public interface MemberDao {
	public Member fetchMemberById(Integer memId) throws DongnanRsException;
	public List<Member> fetchMembersByName(String name) throws DongnanRsException;
	public List<Member> fetchMembersByPhone(String phone) throws DongnanRsException;
	public List<Member> fetchAllMembers();
	public void insertMember(Member member) throws DongnanRsException;
	public void updateMember(Member member) throws DongnanRsException;
	public void deleteMember(Member member) throws DongnanRsException;
}
