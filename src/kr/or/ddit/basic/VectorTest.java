package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 객체 생성
		Vector v1 = new Vector();

		System.out.println("처음 크기: " + v1.size());

		// collection에는 데이터를 객체만 저장할 수 있다.
		// 데이터 추가 ==> add(추가할 데이터)
		// 반환값: 추가 성공(true), 추가 실패시(false)
		v1.add("aaaa");
		v1.add(1512341234); // 박싱, 언박싱이 요즘은 자동으로 이뤄진다.
		v1.add(new Integer(111)); // 111 오토박싱 <--> 오토 언박싱
		v1.add('a');
		v1.add(new Character('g'));
		v1.add(true);
		boolean r = v1.add(3.14f);
		System.out.println("현재 크기: " + v1.size());
		System.out.println("반환값: " + r);
		System.out.println();

		// 데이터 추가: addElement(추가할 데이터)
		// ==> 예전 버전의 프로그램에서도 사용할 수 있도록 하기 위해 남아있는 메서드
		v1.addElement("CCC");
		System.out.println("v1: " + v1);// v1 = vq.toString(); 생략가능;
		// 데이터 추가: add(index, 데이터)
		// ==> 'index'번째에 '데이터'를 끼워 넣는다.
		// ==> 'index는 0부터 시작한다.
		// ==> 반환값은 없다.
		v1.add(1, "kkk");
		System.out.println(v1);
		// 데이터 꺼내오기: get(index)
		// ==> 'index'번째 데이터를 반홚나다.
		int data = (int) v1.get(2);

		System.out.println("data => " + data);
		String str = (String) v1.get(0);
		System.out.println("str => " + str);
		// 데이터 수정하기: set(index, 새로운 데이터)
		// ==> 'index'번째의 데이터를 , '새로운데이터'로 덮어쓴다.
		// ==> 바환값: 변경되기 전의 원래 데이터

		String temp = (String) v1.set(0, "zzzz");
		System.out.println("v1 => " + v1);
		System.out.println("원래의 데이터: " + temp);
		// 데이터 삭제하기: remove(index)
		// ==> '삭제할 데이터'를 찾아서 삭제된다.
		// ==> 사에할 데이터'가 여러개이면 앞에서부터 삭제된다.
		// ==> 반환값: 삭제성공(true), 삭제 실패(false);
		// ==> 삭제할 데이터가 '정수형'이거나 'char형'일 경우는 반드시 객체로 변환해서 사용해야 한다.

		v1.remove(0);
		System.out.println("v1 => " + v1);
		temp = (String) v1.remove(0);
		System.out.println("삭제된 데이터: " + temp);
		System.out.println("v1 =>" + v1);

		temp = "CCC";
		v1.remove(temp);
		System.out.println("삭제된 데이터: " + temp);
		System.out.println("v1 =>" + v1);
		v1.add(123);

//		v1.remove("123"); //오류가 뜬다. 객체로 변환해서 사용해야한다.
		v1.remove(new Integer(123));
		int temp1 = 123;
//		v1.remove(temp1);
		System.out.println("삭제된 데이터: " + temp1);
		System.out.println("v1 => " + v1);

//		v1.remove('a');//오류가 뜬다.
		v1.remove(new Character('a'));
		System.out.println("v1 => " + v1);

		v1.remove(3.14f);
		System.out.println("v1 => " + v1);

		v1.remove(true);
		System.out.println("v1 => " + v1);

		// -----------------------------------------------------
		/*
		 제네릭 타입(generic type) ==> 클래스 내부에서 사용할 데이터의 데이터 타입을 외부에서 지정하는 기법으로 객체를 선언할 때
		 < >안에 그 객체의 내부에서 사용할 데이터의 타입을 정해주는 것을 말한다.
		 이런 식으로 선언하게되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 이 대 제네릭으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다.
		 (int ==> Integer, boolean ==> Boolean, char ==>Character, ...)
		
		==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 형변환 없이 꺼내올 수 있다.
		


		 * */
		Vector<String> v2 = new Vector<String>();
		Vector<Integer> v3 = new Vector<Integer>();

		v2.add("안녕하세요");

		String temp2 = v2.get(0);
		Vector<Vector> vv = new Vector<Vector>();
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		//-----------------------------------------------------
		System.out.println("------------------------------------------------------------");
		v2.clear();
		System.out.println("v2의 size =>" + v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("CCC");
		Vector<String> v5 = new Vector<String>();
		v5.add("BBB");
		v5.add("CCC");
		v5.add("ZZZ");
		
		System.out.println("V2 => "+ v2);
		System.out.println("v4 => "+ v4);
		//데이터 삭제하기: removeAll(Collection객체)
		// ==> Collection객체가 가지고 있는 데이터를 모두 삭제한다.
		v2.removeAll(v4); // v2에 있는 것들 중에 v4가 가지고 있는 데이터와 일치하는 것들을 모두 삭제한다.
		System.out.println("v2 ==> "+ v2);
		v2.addAll(v4);//v4의 데이터를 모두 추가
		System.out.println("v2 ==> "+ v2);
		v2.removeAll(v5);//ZZZ가 있지만, v5가 가지고있는 데이터를 모두 지우는 거라 없으면 없는대로 실행이 되는 듯하다.
		System.out.println("v2 ==> "+ v2);
		
		for(int i = 0; i<v2.size(); i++) {
			System.out.println((i+1) + "번째 자로: "+ v2.get(i));
			
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		int i = 1;
		for(String s: v2) {
			System.out.println(i+"번째 자료: "+ s);
			
			i++;
		}
	
	}

}
