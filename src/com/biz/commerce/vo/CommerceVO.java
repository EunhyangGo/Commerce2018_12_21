package com.biz.commerce.vo;
/*
 * 매입매출데이터.txt파일로부터 
 * 데이터를 읽어서 List를 만들때 사용할 데이터 클래스(VO)선언
 */
public class CommerceVO {
	// 거래일자:상품코드:거래구분:단가:수량 형식의
	// 데이터를 읽어서 각 member변수에 저장
	// 각 member변수는 정보은닉과 캡슐화를 하기 위해 private으로 선언한다.
	private String strDate; //거래일자
	private String strIO;  //거래구분
	private int intP; //단가
	private int intQuan; //수량
	
	/*
	 * private으로 선언된 변수는 
	 * 외부에서 직접접근할 수 없으므로 getter와 setter메서드를 생성해서
	 * 변수에 값을 저장하고, 읽을 수 있도록 통로를 만든다.
	 */
	
	/*
	 * 상품정보의 각 요소를 저장할 칼럼 member 변수 선언
	 * 
	 * 외부에서 직접 접근하지 못하도록 정보를 은닉하고
	 * 캡슐화한다.
	 * 
	 */
	private String strName; //상품명
	private String strCode; // 상품코드
	private String strTax; //과세
	private int intInP; //매입단가
	private int intOutP; //매출단가
	private String strPum; //품목
	private String strX; //주매입처
	private int intTotal;
	private int intToTal2;
	
	/*
	 * private으로 선언된 member변수에
	 * 접근(저장, 읽기)를 수행할 
	 * getter, setter 선언
	 */
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
	/*
	 * VO에 데이터를 저장한 후
	 * 데이터를 확인하는 디버깅용 메서드를 재정의한다.(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strIO=" + strIO + ", intP=" + intP + ", intQuan=" + intQuan
				+ ", strName=" + strName + ", strCode=" + strCode + ", strTax=" + strTax + ", intInP=" + intInP
				+ ", intOutP=" + intOutP + ", strPum=" + strPum + ", strX=" + strX + ", intTotal=" + intTotal
				+ ", intToTal2=" + intToTal2 + "]";
	}
	
	

	
	

}
