package com.biz.commerce.vo;

public class CommerceVO {
	private String strDate; //거래일자
	private String strIO;  //거래구분
	private int intP; //단가
	private int intQuan; //수량
	
	private String strName; //상품명
	private String strCode; // 상품코드
	private String strTax; //과세
	private int intInP; //매입단가
	private int intOutP; //매출단가
	private String strPum; //품목
	private String strX; //주매입처
	private int intTotal;
	private int intToTal2;
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrIO() {
		return strIO;
	}
	public void setStrIO(String strIO) {
		this.strIO = strIO;
	}
	public int getIntP() {
		return intP;
	}
	public void setIntP(int intP) {
		this.intP = intP;
	}
	public int getIntQuan() {
		return intQuan;
	}
	public void setIntQuan(int intQuan) {
		this.intQuan = intQuan;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrCode() {
		return strCode;
	}
	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}
	public String getStrTax() {
		return strTax;
	}
	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}
	public int getIntInP() {
		return intInP;
	}
	public void setIntInP(int intInP) {
		this.intInP = intInP;
	}
	public int getIntOutP() {
		return intOutP;
	}
	public void setIntOutP(int intOutP) {
		this.intOutP = intOutP;
	}
	public String getStrPum() {
		return strPum;
	}
	public void setStrPum(String strPum) {
		this.strPum = strPum;
	}
	public String getStrX() {
		return strX;
	}
	public void setStrX(String strX) {
		this.strX = strX;
	}
	public int getIntTotal() {
		return intTotal;
	}
	public void setIntTotal(int intTotal) {
		this.intTotal = intTotal;
	}
	public int getIntToTal2() {
		return intToTal2;
	}
	public void setIntToTal2(int intToTal2) {
		this.intToTal2 = intToTal2;
	}
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strIO=" + strIO + ", intP=" + intP + ", intQuan=" + intQuan
				+ ", strName=" + strName + ", strCode=" + strCode + ", strTax=" + strTax + ", intInP=" + intInP
				+ ", intOutP=" + intOutP + ", strPum=" + strPum + ", strX=" + strX + ", intTotal=" + intTotal
				+ ", intToTal2=" + intToTal2 + "]";
	}
	
	

	
	

}
