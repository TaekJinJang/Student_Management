package StudentManagement;

import java.util.ArrayList;

public class OBJ_Student extends OBJ_Management{
	public Student s;
	public OBJ_Student() {
		s = Student.sObj.genStuObj();
	}
	class Student {
		public ArrayList<String> nameList;
		public ArrayList<String> schoolNumberList;
		public static Student sObj;
		// 이름과 학번 ArrayList
		
		
		//객체 생성 못하도록 막음
		// 특별한 의미가 있는것은 아니고, 조만간 다룰 static method 에 대한 예습
		private Student() {
		}
		

		//객체를 하나만 생성하도록 싱글톤으로 관리
		// 이것 역시 static method 에 대한 예습
		public Student genStuObj() {
			//s = Student.sObj.genStuObj();
			if (sObj==null) {
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
	
}
