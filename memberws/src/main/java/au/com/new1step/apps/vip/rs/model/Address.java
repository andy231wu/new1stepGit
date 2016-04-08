package au.com.new1step.apps.vip.rs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@XmlRootElement(name = "address")
@Entity
@Table(name="address") // not use customer table name here
@JsonIgnoreProperties("member") // alw this prevent circular reference in bidirection mapping
public class Address {
		@Id		
		@Column(name="addressId")	
		@GeneratedValue
		private Long AddressId; 
	    
		@Column(name="addressLine1", nullable = false)
		private String addressLine1;
		@Column(name="addressLine2", nullable = true)
		private String addressLine2;
		@Column(name="state", length = 3, nullable = false)
		private String state;
		@Column(name="postcode", nullable = false)
		private String postcode;		
		
		// by default no operations are cascaded
		@ManyToOne(fetch = FetchType.LAZY)		
		@JoinColumn(name="memId")			
		private Member member;	
		

		public Long getAddressId() {
			return AddressId;
		}

		public void setAddressId(Long addressId) {
			AddressId = addressId;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPostcode() {
			return postcode;
		}

		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
        
		public Member getMember() {
			return member;
		}

		public void setMember(Member member) {
			this.member = member;
		}
		
		
}
