package au.com.new1step.apps.vip.rs.model;

import java.util.List;

public class UserInfoResponse {
	private List<UserInfo> userInfos;
	private String errorMessage;
	private Boolean success = true;
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	

}
