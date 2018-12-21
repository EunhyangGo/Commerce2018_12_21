package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.commerce.vo.CommerceVO;


public class CommerceService {
	List<CommerceVO> ioList; //매입매출 데이터 List
	List<CommerceVO> pList; // 상품정보  List
	List<CommerceVO> cList; // 매입매출정보 List
	Scanner sc;
	
	String ioFile; // 매입매출
	String pFile;  // 상품정보
	String inforFile; // 매입매출정보(저장용)
	
	public CommerceService(String ioFile, String pFile) {
		ioList = new ArrayList();
		pList = new ArrayList();
		cList = new ArrayList();
		sc = new Scanner(System.in);
		this.ioFile = ioFile;
		this.pFile = pFile;
		this.inforFile = inforFile;
		
		
	}

	
	public void ioInoutInsert(CommerceVO vo) {
		// 단가 * 수량
		int intTotal = vo.getIntInP()*vo.getIntQuan();
		int intTotal2 = vo.getIntOutP() * vo.getIntQuan();				
		vo.setIntTotal(intTotal);
		vo.setIntToTal2(intTotal2);
		this.ioList.add(vo);
	}
	// 매입매출.txt파일에서 파일을 읽어서 ioFile에 저장할 method
	public void readioFile() {
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(ioFile);
			buffer = new BufferedReader(fr);
			
			while(true) {
				String reader = buffer.readLine();
				if(reader == null) break;
				String[] iolist = reader.split(":");
				
				CommerceVO vo = new CommerceVO();
				vo.setStrDate(iolist[0]);
				vo.setStrIO(iolist[2]);
				vo.setStrCode(iolist[1]);
				vo.setIntInP(Integer.valueOf(iolist[3]));
				vo.setIntQuan(Integer.valueOf(iolist[4]));
				ioList.add(vo);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void pFileread() {
			FileReader fr;
			BufferedReader buffer;
			
			try {
				fr = new FileReader(pFile);
				buffer = new BufferedReader(fr);
				
				while(true) {
					String reader =buffer.readLine();
					if(reader == null)break;
					String[] pfiles = reader.split(":");
					String strCode = pfiles[0];
					for(CommerceVO vo : ioList ) {
					if(vo.getStrCode().equals(strCode)) {
						vo.setStrName(pfiles[1]);
						//vo.setIntP(Integer.valueOf(pfiles[2]));
						//vo.setIntQuan(Integer.valueOf(pfiles[3]));
						pList.add(vo);
					}
					}
					
				}
				fr.close();
				buffer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
	public void matchFile() {
		for(CommerceVO vo : ioList) {
			String strCode = vo.getStrCode();
			for(CommerceVO co : pList) {
				if(co.getStrCode().equals(strCode)) {
					co.setStrName(vo.getStrName());
					//co.setIntInP(vo.getIntInP());
					//co.setIntQuan(vo.getIntQuan());
				}
			}
					
		}
	}
    public void writeCList() {
    	PrintWriter pw;
    	
    	try {
			pw = new PrintWriter(inforFile);
			for(CommerceVO vo : cList) {
				pw.println(vo.getStrDate() + ":" 
			+vo.getStrIO()+":"+vo.getStrCode()+":"+vo.getStrName()+":"
			+ vo.getIntTotal()+ vo.getIntToTal2());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void showList() {
    	System.out.println("=====================================");
    	System.out.println("거래일자\t거래구분\t상품코드\t상품명\t단가\t수량\t매입금액\t매출금액");
    	System.out.println("======================================");
    	
    	for(CommerceVO vo : ioList ) {
    		System.out.print(vo.getStrDate() + ":" +vo.getStrIO()+ ":"+vo.getStrCode()+ ":"+
    				vo.getStrName()+ ":"+vo.getIntInP()+ ":"+vo.getIntQuan()
    				+ ":"+vo.getIntTotal()+ ":"+
    				vo.getIntToTal2()+"\n");
    		
    	}
    		
    		
    }
		
		
		
	

	

}
