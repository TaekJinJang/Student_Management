package StudentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import StudentManagement.OBJ_Student.Student;


public class OBJ_Management {
	
	private BufferedReader br;          // 입력 변수
	public int inputNum;              // 사용자가 선택한 메뉴 번호
	private String name;				// 학생 이름 변수
	private String schoolNumber;		// 학생 학번 변수
	//protected Student s;					// 학생 클래수 변수
	private static final int SCHOOL_NUM_LEN = 10;  // 학번 자리 수
	//OBJ_Student s = new OBJ_Student();
	// default 생성자로 객체 생성시 값 할당 부분
		// 입출력, 메뉴 선택 번호, student 객체 생성
		public OBJ_Management() {
			br = new BufferedReader( new InputStreamReader(System.in));
			inputNum = 0;
			
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

		public void printMenu() {
			System.out.println("========== 학생 관리 프로그램 ==========");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 삭제");
			System.out.println("3. 학생 검색");
			System.out.println("4. 학생 조회");
			System.out.println("5. 프로그램 종료");
			System.out.println("* 프로그램 종료 시 모든 데이터는 소멸됩니다.");
		}

	
}
