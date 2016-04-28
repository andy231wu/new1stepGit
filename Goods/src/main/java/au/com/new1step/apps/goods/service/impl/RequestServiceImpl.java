package au.com.new1step.apps.goods.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.new1step.apps.goods.dao.RequestDao;
import au.com.new1step.apps.goods.dao.impl.RequestDaoImpl;
import au.com.new1step.apps.goods.db.model.RequestInfo;
import au.com.new1step.apps.goods.mvc.model.RequestResponse;
import au.com.new1step.apps.goods.service.RequestService;

@Service ("requestService")        
public class RequestServiceImpl implements RequestService {
	
	@Resource
	private RequestDao requestDao;
	
	
	private final static Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);
	
	@Override 
	@Transactional
	public RequestResponse  fetchRequestByRequestId(RequestInfo request){
		RequestResponse response = new RequestResponse();
		try{
			RequestInfo theRequest = requestDao.fetchRequestByRequestId(request.getReqId());
			response.setRequestInfos(Arrays.asList(theRequest));
		    logger.info("Success - fetchRequestByRequestId.");
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage("Error - fetchRequestById.");
			logger.info("Error - fetchRequestById: " + ex.getMessage());
		}
		return response;
	}
	
	
	@Override 
	@Transactional	
	public RequestResponse fetchAllRequests(){
		RequestResponse response = new RequestResponse();
		try{
			 List<RequestInfo> list = requestDao.fetchAllRequests();
		     response.setRequestInfos(list);
		     logger.info("Success - fetchAllRequests.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - fetchAllRequests.");
			 logger.info("Error - fetchAllRequests: " + ex.getMessage());
		}
		return response;
	}
		
	@Override 
	@Transactional
	public RequestResponse insertRequest(RequestInfo request){
		
		RequestResponse response = new RequestResponse();
		try{
		     Long requestId = requestDao.insertRequest(request);
		     List<RequestInfo> requests = new ArrayList<RequestInfo>();
		     RequestInfo theRequest = new RequestInfo();
		     theRequest.setReqId(requestId);
		     requests.add(theRequest);
		     response.setRequestInfos(requests);
		     
		     logger.info("Success - insertRequest.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - insertRequest.");
			 logger.info("Error - insertRequest: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public RequestResponse updateRequest(RequestInfo request){
		RequestResponse response = new RequestResponse();
		try{
		     requestDao.updateRequest(request);
		     logger.info("Success - updateRequest.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - updateRequest.");
			 logger.info("Error - updateRequest: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public RequestResponse  deleteRequest(RequestInfo request){	
		RequestResponse response = new RequestResponse();
		try{
		     requestDao.deleteRequest(request);
		     logger.info("Success - deleteRequest.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - deleteRequest: " + ex.getMessage());
		}
		return response;
	}
	
	
	public void setRequestDao(RequestDao requestDao){
		this.requestDao = requestDao;
	}
	
	public RequestDao getRequestDao(){
		return this.requestDao;
	}
}
