package au.com.new1step.apps.vip.rs.dao;

import java.util.List;
import au.com.new1step.apps.vip.rs.exception.MemberRsException;
import au.com.new1step.apps.vip.rs.model.Member;


public interface MemberDao {
	public Member fetchMemberById(Integer memId) throws MemberRsException;
	public List<Member> fetchMembersByName(Member member) throws MemberRsException;
	public List<Member> fetchMembersByPhone(Member member) throws MemberRsException;
	public List<Member> fetchAllMembers(String appId);
	public List<Member> fetchAllActiveMembers(String appId);
	public List<Member> fetchAllInactiveMembers(String appId);	
	public List<Member> fetchAllActiveGoldMembers(String appId);
	public List<Member> fetchAllActiveSilverMembers(String appId);
	public List<Member> fetchAllActiveDiamondMembers(String appId);
	public List<Member> fetchAllActiveOrdinaryMembers(String appId);
	public Integer insertMember(Member member) throws MemberRsException;
	public void updateMember(Member member) throws MemberRsException;
	public void deleteMember(Member member) throws MemberRsException;
}
