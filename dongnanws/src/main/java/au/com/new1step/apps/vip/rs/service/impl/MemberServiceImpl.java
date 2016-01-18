package au.com.new1step.apps.vip.rs.service.impl;

import java.util.Arrays;
import java.util.List; 

import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
	
	@Override 
	@Transactional
	public MemberResponse fetchMemberById(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			response.setMembers(Arrays.asList(memberDao.fetchMemberById(request.getMember().getMemId())));
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
	@Override 
	@Transactional
	public MemberResponse fetchMembersByName(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			response.setMembers(memberDao.fetchMembersByName(request.getMember().getName()));
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse fetchMembersByPhone(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			response.setMembers(memberDao.fetchMembersByPhone(request.getMember().getPhone()));
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional	
	public MemberResponse fetchAllMembers(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
			 List<Member> list = memberDao.fetchAllMembers();
		     response.setMembers(list);
		}catch(Exception ex){
			 //String stackTrace = ExceptionUtils.getStackTrace(ex);			
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse insertMember(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
		     memberDao.insertMember(request.getMember());
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse updateMember(MemberRequest request){
		MemberResponse response = new MemberResponse();
		try{
		     memberDao.updateMember(request.getMember());
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public MemberResponse deleteMember(MemberRequest request){	
		MemberResponse response = new MemberResponse();
		try{
		     memberDao.deleteMember(request.getMember());
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		}
		return response;
	}
}