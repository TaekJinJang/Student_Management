package StudentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import StudentManagement.Student;

public class Management {

	private BufferedReader br;          // �Է� ����
	private int inputNum;              // ����ڰ� ������ �޴� ��ȣ
	private String name;				// �л� �̸� ����
	private String schoolNumber;		// �л� �й� ����
	private Student s;					// �л� Ŭ���� ����
	private static final int SCHOOL_NUM_LEN = 10;  // �й� �ڸ� ��

	// default �����ڷ� ��ü ������ �� �Ҵ� �κ�
	// �����, �޴� ���� ��ȣ, student ��ü ����
	public Management() {
		br = new BufferedReader( new InputStreamReader(System.in));
		inputNum = 0;
		s = Student.genStuObj();
	}

	// �ʿ��� getter setter ����
	public void setInputNum() throws IOException { // ����½� ����ó���� ���� throws IOException �� ����
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
		// �й��� �ڸ��� �˻縦 ���� ��ȿ�� ����ÿ��� ���
		while(true) {
			this.schoolNumber = br.readLine();
			if(this.schoolNumber.length() != SCHOOL_NUM_LEN) {
				System.out.println("\n * �й��� " + SCHOOL_NUM_LEN + "�ڸ� �Դϴ�.");
				System.out.println("* �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
				System.out.print("�й� : ");
			} else {
				break;
			}
		}
	}

	public String getSchoolNumber() {
		return this.schoolNumber;
	}

	public static void printMenu() {
		System.out.println("========== �л� ���� ���α׷� ==========");
		System.out.println("1. �л� �߰�");
		System.out.println("2. �л� ����");
		System.out.println("3. �л� �˻�");
		System.out.println("4. �л� ��ȸ");
		System.out.println("5. ���α׷� ����");
		System.out.println("* ���α׷� ���� �� ��� �����ʹ� �Ҹ�˴ϴ�.");
	}

	public static void main(String [] args) {
		// Management ��ü ����
		Management m = new Management();

		while (true) {
			try {
				// �޴� ���
				printMenu();
				// �޴� ���� ��ȣ �Է� �ޱ�
				m.setInputNum();

				// ���ð��� ���� �б�
				switch (m.getInputNum()) {
				case 1:
					System.out.print("�̸� : ");
					m.setName();
					System.out.print("�й� : ");
					m.setSchoolNumber();
					m.s.addStudent(m.getName(), m.getSchoolNumber());
					break;
				case 2:
					System.out.print("�й� : ");
					m.setSchoolNumber();
					m.s.delStudent(m.getSchoolNumber());
					break;
				case 3:
					System.out.println("�й� : ");
					m.setSchoolNumber();
					m.s.searchStudent(m.getSchoolNumber());
					break;
				case 4:
					m.s.printStudent();
					break;
				case 5:
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
				default :
					//1~5�� �ƴ� �ٸ� ���� �Է½� ���� ������
					throw new Exception();
				}
				//����ó��
			} catch (Exception e) {
				System.out.println("\n ********************");
				System.out.println("�Է��� �ùٸ��� �ʽ��ϴ�.");
				System.out.println("1 ~ 5 ������ ���ڸ� �Է����ּ���");
				System.out.println("\n ********************");
			}
		}
	}

}
class Student {
	// �̸��� �й� ArrayList
	private ArrayList<String> nameList;
	private ArrayList<String> schoolNumberList;
	private static Student sObj;

	//��ü ���� ���ϵ��� ����
	// Ư���� �ǹ̰� �ִ°��� �ƴϰ�, ������ �ٷ� static method �� ���� ����
	private Student() {
	}

	//��ü�� �ϳ��� �����ϵ��� �̱������� ����
	// �̰� ���� static method �� ���� ����
	public static Student genStuObj() {
		if(sObj == null) {
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