package au.com.new1step.apps.goods.dao;

import java.util.List;

import au.com.new1step.apps.goods.db.model.User;



public interface UserDao {
	 User fetchUserByUserId(String UserId);	
	 List<User> fetchAllUsers();	
	 String insertUser(User user);
	 void updateUser(User user);
	 void deleteUser(User user);
}