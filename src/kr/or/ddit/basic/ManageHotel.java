package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ManageHotel {
	HashMap<Integer, Room> map = new HashMap<>();
	List<HashMap<Integer, Room>> list = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	ManageHotel(){
		for(int i = 201; i<=209; i++) {
			map.put(i,new Room(i, "싱글룸","-"));
		}
		for(int i = 301; i<=309; i++	) {
			map.put(i, new Room(i, "더블룸", "-"));
		}
		for(int i =401; i<=409; i++) {
			map.put(i, new Room(i, "스위트룸", "-"));
		}
		Collection<Room> values = map.values();
		for(HashMap<Integer, Room> a: list) {
			list.add(a.)
		}
		
	}

	public static void main(String[] args) {
		new ManageHotel().started();

	}

	private void started() {
	
		while (true) {
			int choice = display();
			switch (choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				checked();
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				break;
			default:
				System.out.println("잘못입력했습니다.");
				System.out.println("다시 입력해주세요.");
				System.out.println();
			}

		}

	}

	private void checked() {
		// TODO Auto-generated method stub

	}

	private void checkOut() {
		// TODO Auto-generated method stub

	}

	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.print("방 번호 입력 >> ");

	}

	private int display() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");

		return sc.nextInt();
	}

}

class Room {
	private int roomNum;
	private String kind;
	private String name;

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room() {
	}

	public Room(int roomNum, String kind, String name) {
		super();
		this.roomNum = roomNum;
		this.kind = kind;
		this.name = name;
	}

}