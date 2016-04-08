package au.com.new1step.apps.vip.rs.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@XmlRootElement(name = "userInfo")
@Entity
@Table(name="userInfo") //not use customer table name here
@JsonIgnoreProperties("member") // alw this prevent circular reference in bidirection mapping
public class UserInfo {	
	/*
	  @GenericGenerator(name = "generator", strategy = "foreign", 
		parameters = @Parameter(name = "property", value = "member"))
		@Id
		@GeneratedValue(generator = "generator")
		@Column(name = "Id", unique = true, nullable = false)
	    private Long Id; 
	  */
	
	    @Id
		@Column(name="userId", unique = true, nullable = false)
		private String userId;
		@Column(name="password", nullable = false)
		private String password;
		@Column(name="role", nullable = false)
		private String role;
		@Column(name="appId", nullable = false)
		private String appId;
		
		//@PrimaryKeyJoinColumn(name="Id", referencedColumnName="memId") //- this will join memId to userId
		
		// by default no operations are cascaded
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="memId") 
		private Member member;

		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
	
		public Member getMember() {
			return member;
		}
		public void setMember(Member member) {
			this.member = member;
		}
    
		
		public String toString(){
			return String.format("{UserId=%s, Role=%s}", userId, role);
		}
		
}
