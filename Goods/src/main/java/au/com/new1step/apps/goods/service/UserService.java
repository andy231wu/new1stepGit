package au.com.new1step.apps.goods.service;


import au.com.new1step.apps.goods.db.model.User;

public interface UserService {
	
		public UserResponse  fetchUserByUserId(User user); 		
		public UserResponse  fetchAllUsers();	
		public UserResponse  insertUser(User user);
		public UserResponse  updateUser(User user);
		public UserResponse  deleteUser(User user);

	}