package au.com.new1step.apps.vip.rs.dao;

import java.util.List;

import au.com.new1step.apps.vip.rs.exception.UserInfoRsException;
import au.com.new1step.apps.vip.rs.model.UserInfo;


public interface UserInfoDao {
	 UserInfo fetchUserInfoByUserId(String UserId) throws UserInfoRsException;	
	 List<UserInfo> fetchAllUserInfos(String appId);	
	 String insertUserInfo(UserInfo userInfo) throws UserInfoRsException;
	 void updateUserInfo(UserInfo userInfo) throws UserInfoRsException;
	 void deleteUserInfo(UserInfo userInfo) throws UserInfoRsException;
}
