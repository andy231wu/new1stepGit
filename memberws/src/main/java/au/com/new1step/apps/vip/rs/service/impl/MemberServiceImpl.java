package au.com.new1step.apps.vip.rs.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.new1step.apps.vip.rs.dao.MemberDao;
import au.com.new1step.apps.vip.rs.model.Member;
import au.com.new1step.apps.vip.rs.model.MemberRequest;
import au.com.new1step.apps.vip.rs.model.MemberResponse;
import au.com.new1step.apps.vip.rs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override 
	@Transactional
	public MemberResponse fetchMemberById(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			response.setMembers(Arrays.asList(memberDao.fetchMemberById(request.getMember().getMemId())));
		    logger.info("Success - fetchMemberById.");
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			logger.info("Error - fetchMemberById: " + ex.getMessage());
		}
		return response;
	}
	@Override 
	@Transactional
	public MemberResponse fetchMembersByName(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			response.setMembers(memberDao.fetchMembersByName(request.getMember()));
			logger.info("Success - fetchMembersByName.");
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			logger.info("Error - fetchMembersByName: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse fetchMembersByPhone(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			response.setMembers(memberDao.fetchMembersByPhone(request.getMember()));
			logger.info("Success - fetchMembersByPhone.");
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			logger.info("Error - fetchMembersByPhone: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllActiveMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllActiveMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllActiveGoldMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllActiveGoldMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllActiveSilverMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllActiveSilverMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllActiveOrdinaryMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllActiveOrdinaryMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllActiveDiamondMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllActiveDiamondMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllInactiveMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllInactiveMembers(request.getMember().getAppId());
		     response.setMembers(list);
		     logger.info("Success - fetchAllMembers.");
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllMembers: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse insertMember(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
		     int id = memberDao.insertMember(request.getMember());
		     List<Member> members = new ArrayList<Member>();
		     Member member = new Member();
		     member.setMemId(id);
		     members.add(member);
		     response.setMembers(members);
		     
		     logger.info("Success - insertMember.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - insertMember: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse updateMember(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
		     memberDao.updateMember(request.getMember());
		     logger.info("Success - updateMember.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - updateMember: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse deleteMember(MemberRequest request){	
		MemberResponse response = new MemberResponse();
		try{
		     memberDao.deleteMember(request.getMember());
		     logger.info("Success - deleteMember.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - deleteMember: " + ex.getMessage());
		}
		return response;
	}
}