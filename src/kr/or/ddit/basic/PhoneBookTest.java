package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
  next(), nextInt(), nextDouble(),....
  ==> 사이띄기, tab키, enter키를 구분문자로 분리해서 분리된 자료만 읽어간다.
  
  nextLine()
  ==> 한 줄 단위로 입력한다. 
  즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어가서 Enter키 앞까지를 반환한다.
  
  --> Scanner로 입력하면 입력한 값은 입력 버퍼에 저장된 후에 차례로 꺼내와서 처리한다.
  
  가가가
  나나나
  
  
 */


public class PhoneBookTest {
   // - Map의 구조는 key값을 '이름'을 사용하고,
   // value값으로 'Phone클래스의 인스터스'로 한다.
   private HashMap<String, Phone> phoneBookMap;
   private Scanner sc;

   // 생성자
   public PhoneBookTest() {
      sc = new Scanner(System.in);
      phoneBookMap = new HashMap<String, Phone>();
   }

   public static void main(String[] args) {
      new PhoneBookTest().phoneBookStart();

   }

   private int displayMenu() {

      System.out.println();
      System.out.println("-----------------");
      System.out.println("1. 전화번호 등록");
      System.out.println("2. 전화번호 수정");
      System.out.println("3. 전화번호 삭제");
      System.out.println("4. 전화번호 검색");
      System.out.println("5. 전화번호 전체 출력");
      System.out.println("0. 프로그램 종료");
      System.out.println("-----------------");
      System.out.print("번호입력 >> ");
      return sc.nextInt();
   }

   // 시작 메서드
   public void phoneBookStart() {
      while (true) {
         int choice = displayMenu();
         switch (choice) {
         case 1: // 등록
            insert();
            break;
         case 2: // 수정
            update();
            break;
         case 3: // 삭제
            delete();
            break;
         case 4: // 검색
            search();
            break;
         case 5: // 전체 출력
            displayAll();
            break;
         case 0: // 프로그램 종료
            System.out.println("프로그램을 종료합니다.");
            return;
         default:
            System.out.println("번호를 잘못 입력했습니다.");
            System.out.println("다시 입력하세요.");
         }
      }
   }

   // 1. 새로운 전화번호 정보를 등록하는 메서드
   private void insert() {
      System.out.println();
      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
      System.out.println("이름 >> ");
      String name = sc.next();

      // 이미 등록된 사람이지 여부 검사
      if (phoneBookMap.containsKey(name)) {
         System.out.println(name + "님은 이미 등록된 사람입니다.");
         return;
      } else {
         System.out.println("전화번호 >> ");
         String tel = sc.next();
         sc.nextLine();// 입력 버퍼 비우기
         //입력 버퍼 비우기는 nextLine()메서드를 사용하기 전에 
         //nextLine()이외의 입력 메서드를 사용했을 경우에만 사용한다.
         
         System.out.println("주소 >> ");
         String addr = sc.nextLine();

         // 방법1
         Phone p = new Phone(name, tel, addr);
         phoneBookMap.put(name, p);

         // 방법2
         phoneBookMap.put(name, new Phone(name, tel, addr));

         System.out.println(name + "님 전화번호 정보 등록 완료!!");
      }
   }

   // 2.전화번호 정보를 수정하는 메서드
   private void update() {
      System.out.println();
      System.out.println("수정할 전화번호 정보를 입력하세요.");
      System.out.println("이름 >> ");
      String name = sc.next();

      // 해당 정보가 없으면 수정 작업 진행불가...
      if (!phoneBookMap.containsKey(name)) {
         System.out.println(name + "님의 전화번호 정보가 없습니다.");
         return;
      }
      System.out.println("새로운 전화번호 >> ");
      String newTel = sc.next();
      sc.nextLine();
      System.out.println("새로운 주소 >> ");
      String newAddr = sc.nextLine();

      // Map의 수정작업 ==> 같은 key값에 새로운 value값을 저장하기
      phoneBookMap.put(name, new Phone(name, newTel, newAddr));
      System.out.println(name + "님의 전화번호 정보를 변경했습니다.");

   }

   // 3. 전화번호 정보를 삭제하는메서드
   private void delete() {
      System.out.println();
      System.out.println("삭제할 전화번호 정보를 입력하세요.");
      System.out.println("이름 >> ");
      String name = sc.next();

      // 검사
      if (!phoneBookMap.containsKey(name)) {
         System.out.println(name + "님의 전화번호 정보가 없습니다.");
         return;
      } else {
         phoneBookMap.remove(name);
         System.out.println(name + "님의 전화번호 정보를 삭제했습니다.");
      }
   }

   // 4.
   private void search() {
      System.out.println();
      System.out.println("검색할 전화번호 정보를 입력하세요.");
      System.out.println("이름 >> ");
      String name = sc.next();
      
      // 검사
      if (!phoneBookMap.containsKey(name)) {
         System.out.println(name + "님의 전화번호 정보가 없습니다.");
         return;
      }

      Phone p = phoneBookMap.get(name);
      System.out.println(name + "님의 전화번호 정보");
      System.out.println("==============================================");
      System.out.println("이  름 : " + p.getName());
      System.out.println("전화번호 : " + p.getTel());
      System.out.println("주  소 : " + p.getAddr());
      System.out.println("==============================================");

   }

   // 5. 전체 전화번호를 출려하는 메서드
   private void displayAll() {
      System.out.println();

      Set<String> phoneKeySet = phoneBookMap.keySet();
      System.out.println("==============================================");
      System.out.println("번호      이   름      전화번호      주    소");
      System.out.println("==============================================");
      if (phoneKeySet.size() == 0) {
         System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
      } else {
         int cnt = 0;
         for (String key : phoneKeySet) {
            cnt++;
            // key값(name)을 이용하여 value값(Phone객체) 구하기
            Phone p = phoneBookMap.get(key);
//               System.out.println(phoneBookMap.get(key));

            System.out.println(cnt + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAddr());

         }
      }

      System.out.println("==============================================");
      System.out.println("출력 끝...");
      System.out.println();

   }
}

// 전화번호 정보를 저장할 class 작성
// 이름, 전화번호, 주소를 멤버로 갖는 phone클래스 만들기
class Phone {
   private String name;
   private String tel;
   private String addr;

   public Phone() {
   }

   public Phone(String name, String tel, String addr) {
      super();
      this.name = name;
      this.tel = tel;
      this.addr = addr;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   
   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }

   @Override
   public String toString() {
      return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
   }
}