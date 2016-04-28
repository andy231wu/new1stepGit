package au.com.new1step.apps.goods.mvc.model;

public class Login {
	private String id;
	private String password;
	private String app;
	private String defaultCode;
    private String code;
    private String verifyImageUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getDefaultCode() {
		return defaultCode;
	}
	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVerifyImageUrl() {
		return verifyImageUrl;
	}
	public void setVerifyImageUrl(String verifyImageUrl) {
		this.verifyImageUrl = verifyImageUrl;
	}

}
