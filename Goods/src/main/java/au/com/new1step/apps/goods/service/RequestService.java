package au.com.new1step.apps.goods.service;

import au.com.new1step.apps.goods.db.model.RequestInfo;
import au.com.new1step.apps.goods.mvc.model.RequestResponse;

public interface RequestService {
	public RequestResponse  fetchRequestByRequestId(RequestInfo request); 		
	public RequestResponse  fetchAllRequests();	
	public RequestResponse  insertRequest(RequestInfo request);
	public RequestResponse  updateRequest(RequestInfo request);
	public RequestResponse  deleteRequest(RequestInfo request);
}
