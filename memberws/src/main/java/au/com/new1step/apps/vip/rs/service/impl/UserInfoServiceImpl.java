package au.com.new1step.apps.vip.rs.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.com.new1step.apps.vip.rs.dao.UserInfoDao;
import au.com.new1step.apps.vip.rs.model.UserInfo;
import au.com.new1step.apps.vip.rs.model.UserInfoRequest;
import au.com.new1step.apps.vip.rs.model.UserInfoResponse;
import au.com.new1step.apps.vip.rs.service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Override 
	@Transactional
	public UserInfoResponse fetchUserInfoByUserId(UserInfoRequest request){
		UserInfoResponse response = new UserInfoResponse();
		try{
			response.setUserInfos(Arrays.asList(userInfoDao.fetchUserInfoByUserId(request.getUserInfo().getUserId())));
		    logger.info("Success - fetchUserInfoByUserId.");
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			logger.info("Error - fetchUserInfoById: " + ex.getMessage());
		}
		return response;
	}
	
	
	@Override 
	@Transactional	
	public UserInfoResponse fetchAllUserInfos(UserInfoRequest request){
		UserInfoResponse response = new UserInfoResponse();
		try{
			 List<UserInfo> list = userInfoDao.fetchAllUserInfos(request.getUserInfo().getAppId());
		     response.setUserInfos(list);
		     logger.info("Success - fetchAllUserInfos.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - fetchAllUserInfos: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public UserInfoResponse insertUserInfo(UserInfoRequest request){
		UserInfoResponse response = new UserInfoResponse();
		try{
		     String userId = userInfoDao.insertUserInfo(request.getUserInfo());
		     List<UserInfo> userInfos = new ArrayList<UserInfo>();
		     UserInfo userInfo = new UserInfo();
		     userInfo.setUserId(userId);
		     userInfos.add(userInfo);
		     response.setUserInfos(userInfos);
		     
		     logger.info("Success - insertUserInfo.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - insertUserInfo: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public UserInfoResponse updateUserInfo(UserInfoRequest request){
		UserInfoResponse response = new UserInfoResponse();
		try{
		     userInfoDao.updateUserInfo(request.getUserInfo());
		     logger.info("Success - updateUserInfo.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - updateUserInfo: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public UserInfoResponse deleteUserInfo(UserInfoRequest request){	
		UserInfoResponse response = new UserInfoResponse();
		try{
		     userInfoDao.deleteUserInfo(request.getUserInfo());
		     logger.info("Success - deleteUserInfo.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - deleteUserInfo: " + ex.getMessage());
		}
		return response;
	}
	
	/*
	@Override 
	@Transactional
	public UserInfoResponse login(UserInfoRequest request){
		UserInfoResponse response = new UserInfoResponse();
		try{
		//	SecurityManager mgr = new SecurityManager();
			manager.login(request.getUserInfo().getUserId(), request.getUserInfo().getPassword());
			
		     String userId = request.getUserInfo().getUserId();
		     List<UserInfo> userInfos = new ArrayList<UserInfo>();
		     UserInfo userInfo = new UserInfo();
		     userInfo.setUserId(userId);
		     userInfos.add(userInfo);
		     response.setUserInfos(userInfos);
		     
		     logger.info("Success - login.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
			 logger.info("Error - login: " + ex.getMessage());
		}
		return response;
	}
	*/
}