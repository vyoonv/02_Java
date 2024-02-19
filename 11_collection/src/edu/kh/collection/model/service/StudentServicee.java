package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentServicee {
	
	private Scanner sc = new Scanner(System.in); 
	
	// 학생 정보를 저장할 List 생성
	
		// java.util.List 인터페이스 : List에 반드시 필요한 필수 기능들을 모아둔 인터페이스 
		// * 인터페이스는 객체를 생성할 수 없음, 부모 참조변수로서의 역할은 가능 
		
		// java.util.ArrayList : 배열 형태 List (가장 대표적인 List 자식 클래스)
		
		// ArrayList() 기본 생성자 : 기본 크기 10칸 리스트 생성
		//							->리스트는 크기가 늘었다 줄었다 하므로 큰 의미 없음 
		
		// ArrayList(용량) : 용량만큼의 리스트 생성 
		// 					 -> 너무 큰 값을 작성하면 메모리 소모가 많음 
	
	private List<Student> studentList = new ArrayList<Student>(); 
	
	
	
	public StudentServicee() {
		
		studentList.add(new Student ("홍길동", 18, "서울시", 'M', 80)) ; 
		studentList.add(new Student ("가나다", 19, "성남시", 'F', 75)) ; 
		studentList.add(new Student ("라마바", 20, "시흥시", 'M', 60)) ; 
		studentList.add(new Student ("사아자", 21, "강원도", 'F', 92)) ; 
		studentList.add(new Student ("박나나", 22, "대전", 'M', 55)) ; 
		
	
	}

	
	public void displayMenu() {
		
		int menuNum = 0; 
		
		do {
			
			System.out.println("\n=========학생 관리 프로그램=========\n");
			System.out.println("1.학생 정보 추가");
			System.out.println("2. 학생 정보 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			
			try {
				
				menuNum = sc.nextInt(); 
				System.out.println();
				
				switch(menuNum) {
				
				case 1 : System.out.println(addStudent()); break; 
				case 2 : selectAll(); break; 
				case 3 : System.out.println(updateStudent()); break; 
				case 4 : System.out.println(removeStudent()); break; 
				case 5 : /*searchName1()*/; break; 
				case 6 : /*searchName2()*/; break;
				case 0 : System.out.println("프로그램 종료"); break; 
				default : System.out.println("메뉴에 작성된 번호만 입력하세요.");				
				
				}
				
				
			} catch (InputMismatchException e) { 
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시도해주세요.");
				sc.nextLine();  //입력버퍼에 남아있는 잘못된 코드 제거 
				
				menuNum = -1; // 첫 반복시 잘못 입력하는 경우 
						// menuNum이 0을 가지고 있어 종료되는데, 
						// 이를 방지하기 위해 임의값 -1 대입 
			} 
			

		} while(menuNum !=0);  

		
	}
	
	
	
	public String addStudent() throws InputMismatchException{
	//학생 정보 추가 출력/이름,나이,지역,성별,점수 입력 받은 후 Student 객체 생성 후 List에 추가 
		
		
		
		System.out.println("학생 정보 추가");
		
		System.out.println("이름 : ");
		String name = sc.next(); 
		System.out.println("나이 : ");
		int age = sc.nextInt(); 
		sc.nextLine(); 
		System.out.println("지역 : ");
		String region = sc.nextLine(); 
		System.out.println("성별 : ");
		char gender = sc.next().charAt(0); 
		System.out.println("점수 : ");
		int score = sc.nextInt(); 
		
		if(studentList.add(new Student(name, age, region, gender, score))) {
			
			return "성공"; 
			
		} else {
			return "실패"; 
		}
		
		
		
		
		
		
		
	}
	
	
	public void selectAll() {
		// - List에 저장된 데이터의 개수를 얻어오는 방법 : int List.size()
				// -> 배열명.length 대신 사용 
		
		System.out.println("학생 전체 조회");
		
		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다");
			return; 
		}
		
		int index = 0; 
		for( Student std : studentList) {
			System.out.println(index++ + "번 : ");
			System.out.println(std);
		}
		
		//studentList가 비어있는 경우 "학생정보가 없습니다" 출력
		//컬렉션이 비어있다면 true 반환 
		 // 현재 메소드를 종료하고 호출한 곳으로 돌아감 
		// 단, 반환값은 없다(void)
		//향상된 for문 (for each문 )
				// - 컬렉션, 배열의 모든 요소를 순차적으로 반복접근 할 수 있는 for문 
				// 순차적 : 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가 
				
				//작성법 
				// for( 컬렉션 또는 배열에서 꺼낸 1개의 요소를 저장할 변수 : 컬렉션명 또는 배열명 ) { }
				//std에는 for문 반복시마다 0,1,2 인덱스 요소들 한번씩 저장됨 
		
		
		
	}
	
	
	public String updateStudent() throws InputMismatchException {
		
		//List.set(int index, Student e) 
				// -> List의 i번째 요소를 전달받은 e로 변경 
				// -> 반환값 Student == 변경 전 Student 객체가 담겨있다.
		
		System.out.println("회원 정보 수정");
		
		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt(); 
		//인덱스 번호 입력 받기 
		
		if(studentList.isEmpty()) {
		//1) 학생 정보가 studentList에 있는지 검사 
			return "입력된 학생 정보가 없습니다"; 
			
		} else if( index < 0) {		
		//2) 입력된 숫자가 0보다 작은지 검사 
			return "음수는 입력할 수 없습니다"; 
		
		} else if(index > studentList.size()) {
		//3) studentList 범위 내 인덱스 번호인지 검사 
		return "범위 내 번호만 입력해주세요"; 
		} else {	//수정 코드 작성 
			
			//+번째 저장된 학생 정보 출력
			System.out.println(index + "번째 저장된 학생 정보");
			System.out.println(studentList.get(index));
			
			System.out.println("이름 : ");
			String name = sc.next(); 
			System.out.println("나이 : ");
			int age = sc.nextInt(); 
			sc.nextLine(); 
			System.out.println("지역 : ");
			String region = sc.nextLine(); 
			System.out.println("성별 : ");
			char gender = sc.next().charAt(0); 
			System.out.println("점수 : ");
			int score = sc.nextInt(); 
			
			Student temp = studentList.set(index, new Student(name, age, region, gender, score)); 
			//                         set(int index, E element)
			return temp.getName() + "의 정보가 변경되었습니다"; 
			
			
		}
		
		
	}
 	
	
	public String removeStudent() throws InputMismatchException {
		
		// Student List.remove(int index)
				// 리스트에서 index번째 요소를 제거 
				// 이 때, 제거된 요소가 반환된다. 
				// *  List는 중간에 비어있는 인덱스가 없게 하기 위해서 
				// remove() 동작시 뒤쪽 요소를 한칸씩 당겨온다
		
		//학생정보제거/인덱스 번호 입력
		
		System.out.println("학생 정보 제거");
		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt(); 
		
		//1) 학생 정보가 studentList에 있는지 검사 
		//2) 입력된 숫자가 0보다 작은지 검사 
		//3) studentList 범위 내 인덱스 번호인지 검사 	
		//4) 만약 문자열을 입력한 경우 -> 예외처리 throws	
		//학생 정보 제거 
		
		if(studentList.isEmpty()) {
			return "입력된 정보가 없습니다"; 
		} else if (index<0) {
			return "음수는 입력할 수 없습니다"; 
		} else if (index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다"; 
		} else {
			
			//정말 삭제할지 여부 검사 
			//입력 받은 문자 char 형태로 저장
			System.out.println("정말 삭제하시겠습니까? (y/n) : ");
			char ch = sc.next().toUpperCase().charAt(0); 
			//Y 입력 받은 경우 정보제거 후 정보 제거됨을 출력
			//아니라면 "취소" 출력 
			if (ch == 'Y') {
				Student temp = studentList.remove(index); 
				//remove(int index) 
				return temp.getName() + "의 정보가 제거되었습니다"; 
				
				
			} else {
				return "취소"; 
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	

}





