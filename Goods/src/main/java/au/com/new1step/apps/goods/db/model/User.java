package au.com.new1step.apps.goods.db.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="userId", unique = true, nullable = false)
	private String userId;
	@Column(name="password", nullable= false)
	private String password;
	@Column(name="firstname")
	private String firstname;
	@Column(name="surname")
	private String surname;
	@Column(name="email")
	private String email;
	@Column(name="role")
	private String role;
	@Column(name="department")
    private String Department;
	
	@OneToMany(mappedBy="requestor")
	private Set<RequestInfo> requestors; 
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
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
	public Set<RequestInfo> getRequestors() {
		return requestors;
	}
	public void setRequestors(Set<RequestInfo> requestors) {
		this.requestors = requestors;
	}
	

}
