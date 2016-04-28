package au.com.new1step.apps.goods.db.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="requestInfo")
public class RequestInfo {
	@Id
	@Column(name="reqId", unique=true, nullable=false)
	@GeneratedValue
	private Long reqId;
	
	
	@Column(name="recipientId", nullable=false)
	private String recipientId;
	@Column(name="itemNumber")
	private String itemNumber;
	@Column(name="itemName")
	private String itemName;
	@Column(name="dateShipped")
	private Date dateShipped;	
	@Column(name="state")
	private String state;
	@Column(name="message")
	private String message;
	@ManyToOne (fetch=FetchType.EAGER) // donot know why default is eager
	@JoinColumn(name="userId")
	private User requestor; 
	
	public Long getReqId() {
		return reqId;
	}
	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getDateShipped() {
		return dateShipped;
	}
	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/*
	public User getRecipient() {
		return recipient;
	}
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	*/
	public User getRequestor() {
		return requestor;
	}
	public void setRequestor(User requestor) {
		this.requestor = requestor;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
