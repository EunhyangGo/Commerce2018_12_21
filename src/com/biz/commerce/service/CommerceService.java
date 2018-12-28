package com.biz.commerce.service;
/*
 * 매입매출 관련 처리를 위한 클래스를 선언
 */
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
	/*
	 * 각 데이터를 관리할 list변수들 선언
	 */
	
	/*
	 * 매개변수로 받은 ioFile의 내용을 this.ioFile member변수에 저장하여
	 * 다른 method에서 사용할 수 있도록 준비
	 */
	List<CommerceVO> ioList; //매입매출 table List
	List<CommerceVO> pList; // 상품정보  table List 
	List<CommerceVO> cList; // 매입매출정보 List
	
	
	/*
	 * IoServcie 클래스로 객체를 생성할때 호출되는 생성자를 선언
	 */
	String ioFile; // 매입매출 파일 이름
	String pFile;  // 상품정보 파일 이름
	String inforFile ; // 매입매출정보(저장용)

	/*
	 * IoService 클래스로 객체를 생성할때 호출되는 생성자를 선언
	 * 
	 * 이 클래스는 Text파일을 읽어서 매입매출 관련 업무를 수행할 것이므로
	 * 생성자에게 Text파일의 경로정보를 매개변수로 받아서 변수에 저장하는 코드를 수행한다. 
	 */
	public CommerceService(String ioFile, String pFile) {
		
		ioList = new ArrayList(); // 매입매출정보의 list를 담을 ioList초기화해준다.
		pList = new ArrayList(); // 상품정보의 list를 담을 pList를 초기화 한다.
		
		cList = new ArrayList();
		
		this.ioFile = ioFile;
		this.pFile = pFile;
		this.inforFile = inforFile;
		
	}


	// 매입매출.txt파일에서 문자열을 읽어서 ioFile에 저장할 method 선언
	public void readioFile() {
		/*
		 * Text파일을 읽기 위한 FileReader 객체 선언
		 * FileReader로 읽은 내용에서 문자열을 쉽게 추출할 수 있도록
		 *				연결되는 BufferedReader의 buffer객체 선언
		 */
		FileReader fr;
		BufferedReader buffer;
		
		try {
			/*
			 * 생성자에서 값이 할당된 ioFile의 내용을 참조하여
			 * 파일을 읽기 위하여 open하는 코드
			 * 
			 * 이 코드는 작동되는 과정에서 불가항력적인
			 * 문제가 발생할 소지가 있으므로 
			 * 반드시 try...catch문으로 감싸 주어야 한다.
			 * 
			 */
			fr = new FileReader(ioFile);
			/*
			 * FileReader로 Open된 파일 정보를 buffer에 연결하여 준다.
			 * 이 코드가 실행되면 
			 * bufferedReader는 일단 파일을 읽어서 메모리의 buffer영역에 
			 * 저장해둔다.
			 * 
			 */
			buffer = new BufferedReader(fr);
			
			while(true) {
				/*
				 * 무한반복문을 이용해서
				 * buffer에 저장된 파일내용에서 한줄씩(문자열로)읽어서 처리한다.
				 * 
				 * 그리고 buffer에서 한줄을 읽어서 
				 * reader변수에 저장
				 * 
				 */
				String reader = buffer.readLine();
				/*
				 * 만약 reader에 저장된 값이 null이면 모든 문자열을 다 읽었다는 것이므로
				 * 반복문을 종료한다.
				 */
				if(reader == null) break;
				/*
				 * 반복문이 종료되지 않았으므로
				 * (reader 변수에 문자열이 담겨있다는 것)
				 * 코드가 실행되어 console에 해당 문자열을 표시한다.
				 */
				String[] iolist = reader.split(":");
				/*
				 * reader문자열을 콜론(:)으로 분리해서 IoListVO에 담고
				 * iolist에 추가하는 부분.
				 * String.split
				 */
				
				// 새로운 vo생성(선언과 초기화)
				CommerceVO vo = new CommerceVO();
				
				// vo의 각 member변수에 값을 저장(할당)
				vo.setStrDate(iolist[0]);
				vo.setStrIO(iolist[2]);
				vo.setStrCode(iolist[1]);
				
				// vo.io_price는 int형 변수 이므로 문자열을 int로 먼저 변경 후 저장한다.
				int intPrice = Integer.valueOf(iolist[3]);
				vo.setIntInP(intPrice);
				
				int intQuan = Integer.valueOf(iolist[4]);
				vo.setIntQuan(intQuan);
				ioList.add(vo);
				// member변수가 setting된 vo를 iolist에 추가
			}
			buffer.close();
			fr.close();
			// 파일을 모두 사용(읽기)했으므로 안전하게 닫아준다.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 상품정보.txt 파일에서 문자열을 읽어서 pList에 저장하는 메서도 선언
	 */
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
    /*
     * 상품정보.txt 파일을 읽어
     * pList가 잘 만들어졌는지 확인하는 메서드 선언
     */
    public void pView() {
    	for(CommerceVO vo :pList) {
    		System.out.println(vo);
    	}
    }
   
    /*
     * ioList와 pList에 담긴 데이터를 사용해서 
     * 매입매출List를 출력하는 메서드를 선언
     * 1. ioList에 담겨있는 상품코드를 사용해서
     * 		pList에 담겨있는 상품정보를 찾아서 가져오기.
     */
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
	/*
	 * 파일을 읽고 저장하기 위한 메서드 선언
	 */
    public void writeCList(String inforFile) {
    	
    	PrintWriter pw; //파일을 저장하기 위해 PrintWiter 객체 선언
    	
    	try {
			pw = new PrintWriter(inforFile); //pw변수를 지정하여 Printwriter 초기화 시켜준후 iofile저장
			for(CommerceVO vo : ioList) {
				int intIPrice = 0 ;
	    		int intOPrice = 0 ;
	    		
	    		String strInout = vo.getStrIO();
	    		int intInout = Integer.valueOf(strInout);
	    		String strIOTag;
	    		if(intInout ==1) {
	    			//매입
	    			intIPrice = vo.getIntP();
	    			intOPrice = 0;
	    			strIOTag = "매입";
	    			
	    		}else {
	    			//매출
	    			intIPrice = 0 ;
	    			intOPrice = vo.getIntP();
	    			strIOTag = "매출";
	    					
	    		} // 매입매출 구분하는 코드
				pw.println(vo.getStrDate() + ":" 
						+vo.getStrIO()+":"
						+vo.getStrCode()+":"
						+vo.getStrName()+":"
						+(intIPrice * vo.getIntQuan())
						+(intOPrice * vo.getIntQuan())); // 파일에 저장될 값 코드
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	/*
	 * ioList에 저장되어있는 매입매출정보 리스트를 console에 보여주는 메서드 선언
	 */
    public void showList() {
    	System.out.println("===================================================================");
    	System.out.println("거래일자\t거래구분\t상품코드\t상품명\t단가\t수량\t매입금액\t매출금액");
    	System.out.println("===================================================================");
    	
    	
    	for(CommerceVO vo : ioList ) {
    		if(vo== null) continue;
    		int intIPrice = 0 ;
    		int intOPrice = 0 ;
    		
    		String strInout = vo.getStrIO();
    		int intInout = Integer.valueOf(strInout);
    		String strIOTag;
    		if(intInout ==1) {
    			//매입
    			intIPrice = vo.getIntP();
    			intOPrice = 0;
    			strIOTag = "매입";
    			
    		}else {
    			//매출
    			intIPrice = 0 ;
    			intOPrice = vo.getIntP();
    			strIOTag = "매출";
    					
    		}
    		System.out.print(vo.getStrDate());
    		System.out.print(strIOTag +":");
    		System.out.print(vo.getStrCode()+":");
    		System.out.print(vo.getStrName()+":");
    		System.out.print(vo.getIntQuan() + ":");
    		System.out.print((intIPrice * Integer.valueOf(vo.getIntQuan()))+ ":");
    		System.out.println((intOPrice * Integer.valueOf(vo.getIntQuan()))+ ":");
    		    	

    	}
    		
    		
    }
		
		
		
	

	

}
