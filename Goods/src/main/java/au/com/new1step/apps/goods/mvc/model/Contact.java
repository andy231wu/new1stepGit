package au.com.new1step.apps.goods.mvc.model;

import java.sql.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Contact {	
    private Long conId; 
    private String name;
    private String company;
    private String email;
    private String phone;    
    private String message;
    private Date   dateContact;
    private String result;
    private String defaultCode;
    private String code;
    private String verifyImageUrl;
    
    protected static final Log logger = LogFactory.getLog(Contact.class);
    
    public void setConId(Long conId) {
        this.conId = conId;
    }
    public Long getConId() {
        return conId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setDateContact(Date dateContact) {
        this.dateContact = dateContact;
    }
    public Date getDateContact() {
        return dateContact;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
    public void setDefaultCode(String defaultCode) {
        this.defaultCode = defaultCode;
    }
    public String getDefaultCode() {
        return defaultCode;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

	public String getVerifyImageUrl() {
		return verifyImageUrl;
	}
	public void setVerifyImageUrl(String verifyImageUrl) {
		this.verifyImageUrl = verifyImageUrl;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(name);
    	sb.append(" ");
    	sb.append(company);
    	sb.append(" ");
    	sb.append(email);
    	sb.append(" ");
    	sb.append(phone);
    	sb.append(" ");
    	sb.append("Message:\n\n");
    	sb.append(message);
    	logger.info(sb.toString());
        return sb.toString();
    }
}    

    /* temp keep for reference
    public int hashCode(){
        return firstName.hashCode() + lastName.hashCode();
    }

    public boolean equals(Object object){
        if (object instanceof Contact){
            Contact second = (Contact)object;
            return (firstName.equals(second.getFirstName()) && 
                lastName.equals(second.getLastName()));
        }
        return false;
    }

    public String toString(){
        return "[First Name = " + firstName + ", Last Name = " + lastName + "]";
    }
    */

