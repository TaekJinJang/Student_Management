package StudentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import StudentManagement.OBJ_Student.Student;


public class OBJ_Management {
	
	private BufferedReader br;          // �Է� ����
	public int inputNum;              // ����ڰ� ������ �޴� ��ȣ
	private String name;				// �л� �̸� ����
	private String schoolNumber;		// �л� �й� ����
	//protected Student s;					// �л� Ŭ���� ����
	private static final int SCHOOL_NUM_LEN = 10;  // �й� �ڸ� ��
	//OBJ_Student s = new OBJ_Student();
	// default �����ڷ� ��ü ������ �� �Ҵ� �κ�
		// �����, �޴� ���� ��ȣ, student ��ü ����
		public OBJ_Management() {
			br = new BufferedReader( new InputStreamReader(System.in));
			inputNum = 0;
			
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

		public void printMenu() {
			System.out.println("========== �л� ���� ���α׷� ==========");
			System.out.println("1. �л� �߰�");
			System.out.println("2. �л� ����");
			System.out.println("3. �л� �˻�");
			System.out.println("4. �л� ��ȸ");
			System.out.println("5. ���α׷� ����");
			System.out.println("* ���α׷� ���� �� ��� �����ʹ� �Ҹ�˴ϴ�.");
		}

	
}
