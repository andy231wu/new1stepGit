package au.com.new1step.apps.goods.mvc.model;

public class BirthAndDeathDates {
	private String name;
	private String yyyyB;
	private String mmB;
	private String ddB;
	private String yyyyD;
	private String mmD;
	private String ddD;
	private String mmS;
	private String ddS;
	
	public String getYyyyB() {
		return yyyyB;
	}
	public void setYyyyB(String yyyyB) {
		this.yyyyB = yyyyB;
	}
	public String getMmB() {
		return mmB;
	}
	public void setMmB(String mmB) {
		if(mmB.length() == 1){
			mmB = "0" + mmB;
		}
		this.mmB = mmB;
	}
	public String getDdB() {
		return ddB;
	}
	public void setDdB(String ddB) {
		if(ddB.length() == 1){
			ddB = "0" + ddB;
		}
		this.ddB = ddB;
	}
	public String getYyyyD() {
		return yyyyD;
	}
	public void setYyyyD(String yyyyD) {
		this.yyyyD = yyyyD;
	}
	public String getMmD() {
		return mmD;
	}
	public void setMmD(String mmD) {
		if(mmD.length() == 1){
			mmD = "0" + mmD;
		}
		this.mmD = mmD;
	}
	public String getDdD() {
		return ddD;
	}
	public void setDdD(String ddD) {
		if(ddD.length() == 1){
			ddD = "0" + ddD;
		}
		this.ddD = ddD;
	}
	public String getBirthDate() {
		return yyyyB+mmB+ddB;
	}
	
	public String getBirthDateDesc() {
		return yyyyB+"年"+mmB+"月"+ddB + "日";
	}
	
	public String getDeathDate() {
		return yyyyD+mmD+ddD;
	}
	
	public String getDeathDateDesc() {
		return yyyyD+"年"+mmD+"月"+ddD + "日";
	}
	public String getSearchDateDesc() {
		return mmS+"月"+ddS + "日";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMmS() {
		return mmS;
	}
	public void setMmS(String mmS) {
		if(mmS.length() == 1){
			mmS = "0" + mmS;
		}
		this.mmS = mmS;
	}
	public String getDdS() {
		return ddS;
	}
	public void setDdS(String ddS) {
		if(ddS.length() == 1){
			ddS = "0" + ddS;
		}
		this.ddS = ddS;
	}
	
}
