package au.com.new1step.apps.vip.ws.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserDetails {
	private String name;
	private BigDecimal bankBalance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(BigDecimal bankBalance) {
		this.bankBalance = bankBalance;
	}

}
