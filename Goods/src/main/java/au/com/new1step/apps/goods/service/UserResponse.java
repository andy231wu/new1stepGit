package au.com.new1step.apps.goods.service;

import java.util.List;

import au.com.new1step.apps.goods.db.model.User;

public class UserResponse {
	private List<User> users;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
