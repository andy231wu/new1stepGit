package au.com.new1step.apps.goods.dao;

import java.util.List;

import au.com.new1step.apps.goods.db.model.RequestInfo;


public interface RequestDao {
	 RequestInfo fetchRequestByRequestId(Long reqId);	
	 List<RequestInfo> fetchAllRequests();	
	 Long insertRequest(RequestInfo requestInfo);
	 void updateRequest(RequestInfo requestInfo);
	 void deleteRequest(RequestInfo requestInfo);
}
