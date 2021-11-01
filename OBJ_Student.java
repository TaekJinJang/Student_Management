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
		// �̸��� �й� ArrayList
		
		
		//��ü ���� ���ϵ��� ����
		// Ư���� �ǹ̰� �ִ°��� �ƴϰ�, ������ �ٷ� static method �� ���� ����
		private Student() {
		}
		

		//��ü�� �ϳ��� �����ϵ��� �̱������� ����
		// �̰� ���� static method �� ���� ����
		public Student genStuObj() {
			//s = Student.sObj.genStuObj();
			if (sObj==null) {
				sObj = new Student();
				//array list �� ���⼭ ����
				sObj.nameList = new ArrayList<String>();
				sObj.schoolNumberList = new ArrayList<String>();
			}
			return sObj;
		} // genStuObj
		
		public void addStudent(String name, String schoolNumber) {
			// �̹� ��ϵ� �й����� �˻�( �̸��� �ߺ��� �� ������ �й��� �ߺ��� �� ����.)
			boolean Flag = true;
			if(Student.sObj.schoolNumberList.size() != 0) {
				for(int i = 0; i < Student.sObj.schoolNumberList.size(); ++i) {
					if (schoolNumber.equals(Student.sObj.schoolNumberList.get(i))) {
						System.out.println("\n* �̹� ��ϵ� ���� �Դϴ�.");
						System.out.println("* ���� : " + Student.sObj.schoolNumberList.get(i) + " : " + Student.sObj.nameList.get(i) + "\n");
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
				System.out.println("\n* ������ �л��� �����ϴ�.\n");
			}
		} // delStudent

		//�л� �̸����� �˻�
		public void searchStudent(String schoolNumber) {
			if(Student.sObj.schoolNumberList.size() != 0) {
				for(int i=0;i<Student.sObj.schoolNumberList.size();++i) {
					if(schoolNumber.equals(Student.sObj.schoolNumberList.get(i))) {
						System.out.println("�̸� : " + Student.sObj.nameList.get(i));
						System.out.println("�̸� : " + Student.sObj.schoolNumberList.get(i));
					}
				}
			} else {
				System.out.println("\n* " + schoolNumber + "�� �ش��ϴ� �л��� �����ϴ�.\n");
			}
		} 

		//�л� ���
		public void printStudent() {
			if(Student.sObj.nameList.size() < 1) {
				System.out.println("\n* ��ϵ� �л��� �����ϴ�.");
				System.out.println("* �л� ��� �� ��ȸ�Ͻñ� �ٶ��ϴ�.\n");
			}else {
				System.out.println("---------- �л� ��� ----------");
				for(int i = 0;i < Student.sObj.nameList.size(); ++i) {
					System.out.println("* "+(i+1) + "��° �л� : " + Student.sObj.schoolNumberList.get(i) + " : " + Student.sObj.nameList.get(i));
				}
				System.out.println("----------------------------");
				System.out.println();
			}
		}
	} // Student class
	
}
