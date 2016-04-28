package au.com.new1step.apps.goods.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.new1step.apps.goods.dao.UserDao;
import au.com.new1step.apps.goods.db.model.User;
import au.com.new1step.apps.goods.service.UserResponse;
import au.com.new1step.apps.goods.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override 
	@Transactional
	public UserResponse  fetchUserByUserId(User user){
		UserResponse response = new UserResponse();
		try{
			User theUser = userDao.fetchUserByUserId(user.getUserId());
			response.setUsers(Arrays.asList(theUser));
		    logger.info("Success - fetchUserByUserId.");
		}catch(Exception ex){
			response.setSuccess(false);
			response.setErrorMessage("Error - fetchUserById.");
			logger.info("Error - fetchUserById: " + ex.getMessage());
		}
		return response;
	}
	
	
	@Override 
	@Transactional	
	public UserResponse fetchAllUsers(){
		UserResponse response = new UserResponse();
		try{
			 List<User> list = userDao.fetchAllUsers();
		     response.setUsers(list);
		     logger.info("Success - fetchAllUsers.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - fetchAllUsers.");
			 logger.info("Error - fetchAllUsers: " + ex.getMessage());
		}
		return response;
	}
		
	@Override 
	@Transactional
	public UserResponse insertUser(User user){
		UserResponse response = new UserResponse();
		try{
		     String userId = userDao.insertUser(user);
		     List<User> users = new ArrayList<User>();
		     User theUser = new User();
		     theUser.setUserId(userId);
		     users.add(theUser);
		     response.setUsers(users);
		     
		     logger.info("Success - insertUser.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - insertUser.");
			 logger.info("Error - insertUser: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public UserResponse updateUser(User user){
		UserResponse response = new UserResponse();
		try{
		     userDao.updateUser(user);
		     logger.info("Success - updateUser.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - updateUser.");
			 logger.info("Error - updateUser: " + ex.getMessage());
		}
		return response;
	}
	
	@Override 
	@Transactional
	public UserResponse  deleteUser(User user){	
		UserResponse response = new UserResponse();
		try{
		     userDao.deleteUser(user);
		     logger.info("Success - deleteUser.");
		}catch(Exception ex){
			 response.setSuccess(false);
			 response.setErrorMessage("Error - deleteUser.");
			 logger.info("Error - deleteUser: " + ex.getMessage());
		}
		return response;
	}
	
		/*
		@Override 
		@Transactional
		public UserResponse login(UserRequest request){
			UserResponse response = new UserResponse();
			try{
			//	SecurityManager mgr = new SecurityManager();
				manager.login(request.getUser().getUserId(), request.getUser().getPassword());
				
			     String userId = request.getUser().getUserId();
			     List<User> users = new ArrayList<User>();
			     User user = new User();
			     user.setUserId(userId);
			     users.add(user);
			     response.setUsers(users);
			     
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