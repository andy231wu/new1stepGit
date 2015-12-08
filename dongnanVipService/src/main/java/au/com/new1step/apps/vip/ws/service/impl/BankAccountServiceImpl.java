package au.com.new1step.apps.vip.ws.service.impl;

import java.math.BigDecimal;

import javax.jws.WebService;

import au.com.new1step.apps.vip.ws.service.IFBankAccountService;
import au.com.new1step.apps.vip.ws.service.UserDetails;

@WebService(endpointInterface="au.com.new1step.apps.vip.ws.service.IFBankAccountService")
public class BankAccountServiceImpl implements IFBankAccountService{

	@Override
	public void addUserDetails(UserDetails userDetail) {
		System.out.println("1- user name: " + userDetail.getName());
		System.out.println("1- balance: " + userDetail.getBankBalance());
		
	}

	@Override
	public UserDetails getUserDetails(String userName) {
		UserDetails userDetails = new UserDetails();
		userDetails.setBankBalance(new BigDecimal(9933.39));
		userDetails.setName("Hi I am " + userName);
		return userDetails;
	}
	

}
