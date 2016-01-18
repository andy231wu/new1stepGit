package au.com.new1step.apps.vip.rs.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 

import au.com.new1step.apps.vip.rs.model.MemberRequest;
import au.com.new1step.apps.vip.rs.model.MemberResponse;

//@Path("/rest")
@Produces("application/json")
@Consumes("application/json")
public interface MemberService {
		
	@POST	
	@Path("/fetchMemberById")
	public MemberResponse fetchMemberById(MemberRequest request); 
	@POST	
	@Path("/fetchMembersByName")
	public MemberResponse fetchMembersByName(MemberRequest request); 
	@POST	
	@Path("/fetchMembersByPhone")
	public MemberResponse fetchMembersByPhone(MemberRequest request); 
	@POST
	@Path("/fetchAllMembers")
	public MemberResponse fetchAllMembers(MemberRequest request);	
	@POST
	@Path("/fetchAllActiveMembers")
	public MemberResponse fetchAllActiveMembers(MemberRequest request);	
	
	@POST
	@Path("/fetchAllActiveGoldMembers")
	public MemberResponse fetchAllActiveGoldMembers(MemberRequest request);	
	@POST
	@Path("/fetchAllActiveSilverMembers")
	public MemberResponse fetchAllActiveSilverMembers(MemberRequest request);	
	@POST
	@Path("/fetchAllActiveDiamondMembers")
	public MemberResponse fetchAllActiveDiamondMembers(MemberRequest request);	
	@POST
	@Path("/fetchAllActiveOrdinaryMembers")
	public MemberResponse fetchAllActiveOrdinaryMembers(MemberRequest request);	
	
	@POST
	@Path("/fetchAllInactiveMembers")
	public MemberResponse fetchAllInactiveMembers(MemberRequest request);	
	
	@POST
	@Path("/insertMember")
	public MemberResponse insertMember(MemberRequest request);
	
	@POST
	@Path("/updateMember")
	public MemberResponse updateMember(MemberRequest request);
	
	@POST
	@Path("/deleteMember")
	public MemberResponse deleteMember(MemberRequest request);
	
}