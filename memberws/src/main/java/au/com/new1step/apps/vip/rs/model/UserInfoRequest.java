package au.com.new1step.apps.vip.rs.model;
/*
 * this class only hold a userInfo object, In the real world your Request object 
 * would contain more information such as a security context or 
 * some type of paging information, so it may seem a bit overkill here
 *  but I am including it to help show the pattern. 
 */
public class UserInfoRequest {
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
