package au.com.new1step.apps.goods.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import au.com.new1step.apps.goods.dao.RequestDao;
import au.com.new1step.apps.goods.db.model.RequestInfo;
import au.com.new1step.apps.goods.service.impl.RequestServiceImpl;
import au.com.new1step.apps.util.AbstractSessionUtil;


@Repository("requestDao")
public class RequestDaoImpl extends AbstractSessionUtil implements RequestDao {	
		   
	private final static Logger logger = LoggerFactory.getLogger(RequestDaoImpl.class);
	
			@Override		
			public RequestInfo fetchRequestByRequestId(Long reqId) {		  
		       Session session = sessionFactory.getCurrentSession();
		      
		       RequestInfo requestInfo = (RequestInfo)session.createCriteria(RequestInfo.class)
									    	    .add(Restrictions.idEq(reqId)) 
									    	    .uniqueResult();  					    	    
		        return requestInfo;  
			}	
			
			@Override
			@SuppressWarnings("unchecked")
			public List<RequestInfo> fetchAllRequests(){
				logger.info("BEFORE FETCHALLREQUESTS");
				Session session = sessionFactory.getCurrentSession();
				logger.info("AFTER GET-CURRENT-SESSION");
				String sql = "from RequestInfo req order by req.reqId desc"; 
		        Query query = session.createQuery(sql);
		        logger.info("AFTER CREATE QUERY");
				return query.list();  
			}
				
			@Override
			public Long insertRequest(RequestInfo requestInfo) {				
				Session session = sessionFactory.getCurrentSession();			
			    Long id = (Long)session.save(requestInfo);	
			    return id;
			}
			@Override
			public void updateRequest(RequestInfo requestInfo){		
				Session session = sessionFactory.getCurrentSession();		
				//RequestInfoInfo exist = (RequestInfoInfo)session.get(RequestInfo.class, RequestInfoInfo.getRequestInfoId());
				//RequestInfoInfo.setMember(exist.getMember());
				//session.merge(RequestInfo);		
				session.update(requestInfo);
				
			}
			@Override
			public void deleteRequest(RequestInfo requestInfo){
				Session session = sessionFactory.getCurrentSession();
			   	     
				RequestInfo result = (RequestInfo)session.get(RequestInfo.class, requestInfo.getReqId());
				if(result != null){
				   session.delete(result); 
				}
				
			}	

	}