package StudentManagement;

public class OBJ_ManagementMain extends OBJ_Student {

	public static void main(String []args) {

		OBJ_Management m = new OBJ_Management();
		while (true) {
			try {
				// 메뉴 출력
				m.printMenu();
				// 메뉴 선택 번호 입력 받기
				m.setInputNum();

				// 선택값에 따른 분기
				switch (m.getInputNum()) {
				case 1:
					System.out.print("이름 : ");
					m.setName();
					System.out.print("학번 : ");
					m.setSchoolNumber();
					Student.sObj.addStudent(m.getName(), m.getSchoolNumber());
					break;
				case 2:
					System.out.print("학번 : ");
					m.setSchoolNumber();
					Student.sObj.delStudent(m.getSchoolNumber());
					break;
				case 3:
					System.out.println("학번 : ");
					m.setSchoolNumber();
					Student.sObj.searchStudent(m.getSchoolNumber());
					break;
				case 4:
					Student.sObj.printStudent();
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
