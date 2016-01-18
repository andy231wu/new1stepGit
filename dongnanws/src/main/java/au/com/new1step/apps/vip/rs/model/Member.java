package au.com.new1step.apps.vip.rs.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement(name = "Member")
@Entity
@Table(name="MEMBER")
public class Member {    
	@Id
	@Column(name="MEMID", unique = true, nullable = false)
	@GeneratedValue
	private int memId; 
	
	@Column(name="NAME", nullable = false)
	private String name;
	@Column(name="PHONE")
	private String phone;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="MARK")
	private int mark; 
	@Column(name="COMMENT")
	private String comment;
	
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
	
	
	
}
