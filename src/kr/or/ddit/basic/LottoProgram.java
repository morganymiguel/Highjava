package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoProgram {
	private List<Integer> list;// 로또번호
	private List<List> l = new ArrayList<List>();
	private int num =0;
	Scanner sc = new Scanner(System.in);

	private void getNum() {// 로또번호 저장;
		Set<Integer> setNum = new HashSet<>();

		while (setNum.size() < 6) {
			setNum.add((int) (Math.random() * (45 - 1) + 1));
		}
		list = new ArrayList<Integer>(setNum);
		Collections.shuffle(list);
		l.add(list);
	}

	public void startedLotto() {

		int input = 0;
		do {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 : "); // 1
			input = sc.nextInt();
			if (input == 1) {
				buyLotto();
			}else if(input == 2){
				System.out.println("감사합니다");
			}else{
			System.out.println("==========다시=============");
			}
		} while (input != 2);
	}

	private void buyLotto() {
		System.out.println("Lotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");

		System.out.print("금액 입력 : "); // 2500
		int input = sc.nextInt();
		if (input < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		} else if (input > 101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		} else {

			int lotto = input / 1000;//로또번호 수 ;
			int charge = input % 1000;//거스름돈

			System.out.println("행운의 로또번호는 아래와 같습니다.");
			for (int i = 0; i < lotto; i++) {
				getNum();
			}
			for (int i = 1; i <= l.size(); i++) {
				System.out.println("로또번호" + i + " : " + l.get(i-1));
			}
			l.clear();
			list.clear();
			System.out.println("받은 금액은 " + input+ "이고, 거스름돈은 " + charge + "원입니다. ");
			System.out.println("==========================");
		}
	}

	public static void main(String[] args) {
		new LottoProgram().startedLotto();

//		
//		로또번호1 : 2,3,4,5,6,7
//		로또번호2 : 20,21,22,23,24,25
//				
//		받은 금액은 2500원이고 거스름돈은 500원입니다.
//		

	}

}
