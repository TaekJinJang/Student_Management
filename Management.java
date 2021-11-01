package StudentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Management {

	private BufferedReader br;          // 입력 변수
	private int inputNum;              // 사용자가 선택한 메뉴 번호
	private String name;				// 학생 이름 변수
	private String schoolNumber;		// 학생 학번 변수
	private Student s;					// 학생 클래수 변수
	private static final int SCHOOL_NUM_LEN = 10;  // 학번 자리 수

	// default 생성자로 객체 생성시 값 할당 부분
	// 입출력, 메뉴 선택 번호, student 객체 생성
	public Management() {
		br = new BufferedReader( new InputStreamReader(System.in));
		inputNum = 0;
		s = Student.genStuObj();
	}

	// 필요한 getter setter 선언
	public void setInputNum() throws IOException { // 입출력시 예외처리를 위해 throws IOException 를 붙임
		this.inputNum = Integer.parseInt(br.readLine());
	}

	public int getInputNum() {
		return this.inputNum;
	}

	public void setName() throws IOException {
		this.name = br.readLine();
	}
	public String getName() {
		return this.name;
	}
	public void setSchoolNumber() throws IOException {
		// 학번은 자릿수 검사를 통해 유효성 통과시에만 출력
		while(true) {
			this.schoolNumber = br.readLine();
			if(this.schoolNumber.length() != SCHOOL_NUM_LEN) {
				System.out.println("\n * 학번은 " + SCHOOL_NUM_LEN + "자리 입니다.");
				System.out.println("* 다시 입력해 주시기 바랍니다.");
				System.out.print("학번 : ");
			} else {
				break;
			}
		}
	}

	public String getSchoolNumber() {
		return this.schoolNumber;
	}

	public static void printMenu() {
		System.out.println("========== 학생 관리 프로그램 ==========");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 삭제");
		System.out.println("3. 학생 검색");
		System.out.println("4. 학생 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("* 프로그램 종료 시 모든 데이터는 소멸됩니다.");
	}

	public static void main(String [] args) {
		// Management 객체 생성
		Management m = new Management();

		while (true) {
			try {
				// 메뉴 출력
				printMenu();
				// 메뉴 선택 번호 입력 받기
				m.setInputNum();

				// 선택값에 따른 분기
				switch (m.getInputNum()) {
				case 1:
					System.out.print("이름 : ");
					m.setName();
					System.out.print("학번 : ");
					m.setSchoolNumber();
					m.s.addStudent(m.getName(), m.getSchoolNumber());
					break;
				case 2:
					System.out.print("학번 : ");
					m.setSchoolNumber();
					m.s.delStudent(m.getSchoolNumber());
					break;
				case 3:
					System.out.println("학번 : ");
					m.setSchoolNumber();
					m.s.searchStudent(m.getSchoolNumber());
					break;
				case 4:
					m.s.printStudent();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				default :
					//1~5가 아닌 다른 숫자 입력시 예외 던지기
					throw new Exception();
				}
				//예외처리
			} catch (Exception e) {
				System.out.println("\n ********************");
				System.out.println("입력이 올바르지 않습니다.");
				System.out.println("1 ~ 5 사이의 숫자를 입력해주세요");
				System.out.println("\n ********************");
			}
		}
	}

}
class Student {
	// 이름과 학번 ArrayList
	private ArrayList<String> nameList;
	private ArrayList<String> schoolNumberList;
	private static Student sObj;

	//객체 생성 못하도록 막음
	// 특별한 의미가 있는것은 아니고, 조만간 다룰 static method 에 대한 예습
	private Student() {
	}

	//객체를 하나만 생성하도록 싱글톤으로 관리
	// 이것 역시 static method 에 대한 예습
	public static Student genStuObj() {
		if(sObj == null) {
			sObj = new Student();
			//array list 도 여기서 생성
			sObj.nameList = new ArrayList<String>();
			sObj.schoolNumberList = new ArrayList<String>();
		}
		return sObj;
	} // genStuObj
	
	public void addStudent(String name, String schoolNumber) {
		// 이미 등록된 학번인지 검사( 이름은 중복될 수 있지만 학번은 중복될 수 없다.)
		boolean Flag = true;
		if(Student.sObj.schoolNumberList.size() != 0) {
			for(int i = 0; i < Student.sObj.schoolNumberList.size(); ++i) {
				if (schoolNumber.equals(Student.sObj.schoolNumberList.get(i))) {
					System.out.println("\n* 이미 등록된 정보 입니다.");
					System.out.println("* 정보 : " + Student.sObj.schoolNumberList.get(i) + " : " + Student.sObj.nameList.get(i) + "\n");
					Flag = false;
				}
			}
		} // if
		if(Flag) {
			this.nameList.add(name);
			this.schoolNumberList.add(schoolNumber);
		}
	} // addstudent

	public void delStudent(String schoolNumber) {
		if(Student.sObj.schoolNumberList.size() != 0) {
			for(int i = 0;i <Student.sObj.schoolNumberList.size();++i) {
				if(schoolNumber.equals(Student.sObj.schoolNumberList.get(i))) {
					Student.sObj.nameList.remove(i);
					Student.sObj.schoolNumberList.remove(i);
				}
			}
		} else {
			System.out.println("\n* 삭제할 학생이 없습니다.\n");
		}
	} // delStudent

	//학생 이름으로 검색
	public void searchStudent(String schoolNumber) {
		if(Student.sObj.schoolNumberList.size() != 0) {
			for(int i=0;i<Student.sObj.schoolNumberList.size();++i) {
				if(schoolNumber.equals(Student.sObj.schoolNumberList.get(i))) {
					System.out.println("이름 : " + Student.sObj.nameList.get(i));
					System.out.println("이름 : " + Student.sObj.schoolNumberList.get(i));
				}
			}
		} else {
			System.out.println("\n* " + schoolNumber + "에 해당하는 학생이 없습니다.\n");
		}
	} 

	//학생 출력
	public void printStudent() {
		if(Student.sObj.nameList.size() < 1) {
			System.out.println("\n* 등록된 학생이 없습니다.");
			System.out.println("* 학생 등록 후 조회하시기 바랍니다.\n");
		}else {
			System.out.println("---------- 학생 목록 ----------");
			for(int i = 0;i < Student.sObj.nameList.size(); ++i) {
				System.out.println("* "+(i+1) + "번째 학생 : " + Student.sObj.schoolNumberList.get(i) + " : " + Student.sObj.nameList.get(i));
			}
			System.out.println("----------------------------");
			System.out.println();
		}
	}
} // Student class