package au.com.new1step.apps.vip.rs.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 

import au.com.new1step.apps.vip.rs.model.UserInfoRequest;
import au.com.new1step.apps.vip.rs.model.UserInfoResponse;

//@Path("/rest")
@Produces("application/json")
@Consumes("application/json")
public interface UserInfoService {
		
	@POST	
	@Path("/fetchUserInfoByUserId")
	public UserInfoResponse fetchUserInfoByUserId(UserInfoRequest request); 
	
	@POST
	@Path("/fetchAllUserInfos")
	public UserInfoResponse fetchAllUserInfos(UserInfoRequest request);	
		
	
	@POST
	@Path("/insertUserInfo")
	public UserInfoResponse insertUserInfo(UserInfoRequest request);
	
	@POST
	@Path("/updateUserInfo")
	public UserInfoResponse updateUserInfo(UserInfoRequest request);
	
	@POST
	@Path("/deleteUserInfo")
	public UserInfoResponse deleteUserInfo(UserInfoRequest request);
	
}