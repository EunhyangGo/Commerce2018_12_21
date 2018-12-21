package com.biz.commerce.exec;

import com.biz.commerce.service.CommerceService;

public class Exec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ioFile ="src/com/biz/commerce/매입매출데이터.txt";
		String pFile ="src/com/biz/commerce/상품정보.txt";
		String inforFile ="src/com/biz/commerce/";
		
		CommerceService cs = new CommerceService(ioFile, pFile);
		
		cs.readioFile();
		cs.pFileread();
		cs.showList();

	}

}
