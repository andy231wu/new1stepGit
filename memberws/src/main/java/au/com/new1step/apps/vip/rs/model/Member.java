package au.com.new1step.apps.vip.rs.model;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement; 

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement(name = "member")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) WILL ALWAYS INGNORE, NOT GOOD
@Entity
//@Table(name="member") if you used customer naming strategy, @Table should comment out
public class Member implements Serializable {	
	
	private static final long serialVersionUID = -5898014969117364132L;

	@Id
	@Column(name="memId", unique = true, nullable = false)
	@GeneratedValue
	private int memId; 
	
	@Column(name="name", nullable = false)
	private String name;
	@Column(name="gender", length=1, nullable = false)
	private String gender;
	@Column(name="dob")
	private String dob;
	@Column(name="phone", nullable = false)
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="fileUrl")
	private String fileUrl;	
	@Column(name="address")
	private String address;
	@Column(name="mark")
	private int mark; 
	@Column(name="comment")
	private String comment;
	@Column(name="isActive")
	private boolean isActive;
	@Column(name="appId", nullable = false)
	private String appId;
	@Column(name="memClass")
	private String memClass;
	@Column(name="varRate")
	private float varRate;
	@Column(name="fixRate")
	private float fixRate;
	@Column(name="dateCreated", nullable = false)	
	//@Version() ???
	private Date dateCreated;
	
	
	//@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY) not working for serialization issue
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)	
	@JoinColumn(name="userId")	
	private UserInfo userInfo;
	
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMemClass() {
		return memClass;
	}
	public void setMemClass(String memClass) {
		this.memClass = memClass;
	}
	
	public float getFixRate() {
		return fixRate;
	}
	public void setFixRate(float fixRate) {
		this.fixRate = fixRate;
	}
	public float getVarRate() {
		return varRate;
	}
	public void setVarRate(float varRate) {
		this.varRate = varRate;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
