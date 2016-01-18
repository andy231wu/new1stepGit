package au.com.new1step.apps.rs.model;

import org.springframework.web.multipart.MultipartFile;
/*
 * this class only hold a member object, In the real world your Request object 
 * would contain more information such as a security context or 
 * some type of paging information, so it may seem a bit overkill here
 *  but I am including it to help show the pattern. 
 */
public class UploadRequest {
	private MultipartFile multipartFile;
	private Integer id;
	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
