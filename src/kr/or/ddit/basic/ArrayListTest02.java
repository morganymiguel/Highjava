package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에 이들 중 '김'씨 성의 이름을 모두 출력하시오. 
 * (단, 입력은 Scanner객체를 이용한다.)
 *
 * 문제2) 5명의 
 * */

public class ArrayListTest02 {
	public static void main(String[] args) {

//		Test01();

//		homework02();

//		homework03();

//		teachers01();
//		teachers02();
//		teachers03();
	}

	private static void teachers03() {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<>();
		System.out.println("별명을 5번 입력하세요: ");
		for(int i =1; i<=5; i++) {
			System.out.print(i+"번째 별명: ");
			aliasList.add(scan.next());
		}
		
		System.out.println();
		int maxLength = aliasList.get(0).length();
		for(int i = 1; i<aliasList.size(); i++) {
			if( maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}
		System.out.println("제일 긴 별명들...");
		for(int i = 0; i<aliasList.size(); i++) {
			if(aliasList.get(i).length() == maxLength) {
				System.out.println(aliasList.get(i));
			}
		}
		
	}

	public static void Test01() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		boolean A = true;
		while (A) {
			System.out.print("이름을 입력하시오: ");
			String input = sc.nextLine();
			if (input.equals("<")) {
				A = false;
				continue;
			} else {
				arr.add(input);
				System.out.println("입력완료.");
				System.out.println("----------------------");

			}

		}
//1번째 풀이방법
//		for (int i = 0; i < arr.size(); i++) {
//			if (arr.get(i).charAt(0) == '김') {
//				System.out.println(arr.get(i));
//			}
//		}
		for (String s : arr) {
			if (s.startsWith("김")) {
				System.out.println(s);
			} else {
			}
		}
	}// TEST01

	static void homework02() {
		/*
		 * 문제2) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중에 별명의 길이가 제일 긴 별명을 출력하시오. (단, 각 별명의
		 * 길이는 모두 다르게 입력한다.)
		 */
		ArrayList<String> arr = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 별명: ");
			arr.add(sc.nextLine());
		}
		int temp = arr.get(0).length();
		int check = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (temp < arr.get(i).length()) {
				temp = arr.get(i).length();
				check = i;
			}

		}
		System.out.println((check + 1) + "번째 별명[" + arr.get(check) + "]이 가장김.");

	}

	static void homework03() {
		/*
		 * 문제3) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에 별명의 길이가 제일 긴 별명들을 출력하시오 (단, 각 별명으
		 * ㅣ길이가 같은 것이 존재 할 수 있다.) 가장 긴 걸 찾아서 돌려서 출력
		 */
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<Integer> length = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		int temp = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 사람의 별명: ");
			arr.add(sc.nextLine());
		}

		for (String a : arr) {
			length.add(a.length());

		}

		for (int b : length) {
			if (temp <= b) {
				temp = b;
			}
		}

		for (int i = 0; i < length.size(); i++) {
			if (temp == arr.get(i).length()) {
				System.out.print(arr.get(i) + " ");
			}
		}

	}

	public static void teachers01() {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<>();
		System.out.println("5명의 이름을 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 이름: ");
			String name = scan.next();
			nameList.add(name);
		}
		System.out.println();
		for (int i = 0; i < nameList.size(); i++) {
//			if(nameList.get(i).charAt(0) =='김') {
//				System.out.println(nameList.get(i));
//			}

			if (nameList.get(i).substring(0, 1).equals("김")) {

			}
			if (nameList.get(i).indexOf("김") == 0) {
				System.out.println(nameList.get(i));
			}
			if (nameList.get(i).startsWith("김")) {
				System.out.println(nameList.get(i));
			}
		}
	

	}//String객체에서 제공해주는 메서드들을 잘 알고있어야한다.

	public static void teachers02() {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> aliasList = new ArrayList<>();
		System.out.println("서로 다른 길이의 별멸을 5번 입력하세요. ");
		
		for(int i =1; i<=5; i++) {
			System.out.print(i +"번째 별명: ");
			String alias = scan.next();
			aliasList.add(alias);
		}
		System.out.println();
		String maxAlias = aliasList.get(0);
		
		for(int i = 0; i<aliasList.size();i++) {
			if(maxAlias.length()<aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);
			}
		}
		System.out.println("제일 긴 별명: "+maxAlias);
		
		
	}
}