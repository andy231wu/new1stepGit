package au.com.new1step.apps.vip.rs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "userInfo")
@Entity
@Table(name="userInfo")
public class UserInfo {			
		@Id
		@Column(name="userId", unique = true, nullable = false)
		private String userId;
		@Column(name="password", nullable = false)
		private String password;
		@Column(name="role", nullable = false)
		private String role;
		@Column(name="appId", nullable = false)
		private String appId;
		
		//@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userInfo")		
		//private Member member;
		
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
		/*
		public Member getMember() {
			return member;
		}
		public void setMember(Member member) {
			this.member = member;
		}
       */
}
