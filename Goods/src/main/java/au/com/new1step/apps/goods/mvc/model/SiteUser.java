package au.com.new1step.apps.goods.mvc.model;

public class SiteUser {
	private String appName;
	private String name;
	private String password;
	private String email;
	private String logoText;
	private String subtitle;
	private String maxShowImages;
	private String index;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;		
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogoText() {
		return logoText;
	}
	public void setLogoText(String logoText) {
		this.logoText = logoText;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getMaxShowImages() {
		return maxShowImages;
	}
	public void setMaxShowImages(String maxShowImages) {
		this.maxShowImages = maxShowImages;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	
}
