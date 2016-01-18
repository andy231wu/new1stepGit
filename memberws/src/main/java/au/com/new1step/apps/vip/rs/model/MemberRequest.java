package au.com.new1step.apps.vip.rs.model;
/*
 * this class only hold a member object, In the real world your Request object 
 * would contain more information such as a security context or 
 * some type of paging information, so it may seem a bit overkill here
 *  but I am including it to help show the pattern. 
 */
public class MemberRequest {
	private Member member;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
