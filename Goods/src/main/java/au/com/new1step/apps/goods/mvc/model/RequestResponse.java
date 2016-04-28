package au.com.new1step.apps.goods.mvc.model;

import java.util.List;

import au.com.new1step.apps.goods.db.model.RequestInfo;

public class RequestResponse {
	private List<RequestInfo> requests;
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
	public List<RequestInfo> getRequests() {
		return requests;
	}
	public void setRequestInfos(List<RequestInfo> requests) {
		this.requests = requests;
	}
	

}
