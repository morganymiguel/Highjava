package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {
/*
 	문제)이름, 전화번호, 주소를 멤버로 갖는 Phone클래스를 만들고
 	Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 	
 	조건)
 		- 아래의 메뉴를 구성하고 해당 기능을 작성한다.
 		---------------------------------
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 		---------------------------------
 	
 		- 위 기능 중 삭제, 검색 기능은 '이름'을 입력 받아서 처리한다.
 	실행예시)
 		---------------------------------
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 		---------------------------------
 		번호입력 => 1
 */
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new PhoneBookTest().startedMain();
	}

	private void startedMain() {
		
		int input;
		do {
			
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호입력: ");
			input = sc.nextInt();
			if(input == 1) {
				putData();
			}else if(input == 2) {
				
			}else if(input == 3) {
				
			}else if(input == 4	) {
				
			}else if(input == 5) {
				
			}else if(input == 0){
				System.out.println("프로그램 종료");
			}else{
				System.out.println("잘못 입력하였습니다. 다시 입력하세요. ");
			}
		}while(input != 0);
	}

	private void putData() {
		HashMap<String, Phone>map = new HashMap<>();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = sc.next();
		
		System.out.print("전화번호 >> ");
		String pnum = sc.next();
		
		System.out.print("주소 >> ");
		String addr = sc.next();
		map.put(name, new Phone(name, pnum, addr));
		
		System.out.println("'"+name+ "' 전화번호 정보 등록 완료");
		System.out.println(map.getClass());
		System.out.println();
		
		
	}

}
class Phone{
	private String name;
	private String pnum;
	private String addr;
	Phone(){}
	
	
	public Phone(String name, String pnum, String addr) {
		super();
		this.name = name;
		this.pnum = pnum;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
