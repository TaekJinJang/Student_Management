package StudentManagement;

public class OBJ_ManagementMain extends OBJ_Student {

	public static void main(String []args) {

		OBJ_Management m = new OBJ_Management();
		while (true) {
			try {
				// �޴� ���
				m.printMenu();
				// �޴� ���� ��ȣ �Է� �ޱ�
				m.setInputNum();

				// ���ð��� ���� �б�
				switch (m.getInputNum()) {
				case 1:
					System.out.print("�̸� : ");
					m.setName();
					System.out.print("�й� : ");
					m.setSchoolNumber();
					Student.sObj.addStudent(m.getName(), m.getSchoolNumber());
					break;
				case 2:
					System.out.print("�й� : ");
					m.setSchoolNumber();
					Student.sObj.delStudent(m.getSchoolNumber());
					break;
				case 3:
					System.out.println("�й� : ");
					m.setSchoolNumber();
					Student.sObj.searchStudent(m.getSchoolNumber());
					break;
				case 4:
					Student.sObj.printStudent();
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
