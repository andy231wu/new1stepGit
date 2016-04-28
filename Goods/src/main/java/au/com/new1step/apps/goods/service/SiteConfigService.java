package au.com.new1step.apps.goods.service;

import au.com.new1step.apps.goods.mvc.model.SiteUser;

public interface SiteConfigService {
	
	public String siteUsersLocation();
	public String nameConfigureLocation();
	public String writeSiteUserDetails(SiteUser siteUser, String fullPath);
	public String searchSiteUser(SiteUser siteUser, String fullPath);
	
	
}
