package ex1;

import java.util.Scanner;

public class ManagerMain {

	public static void main(String[] args) {
		EmpManager e = new EmpManager();
		DeptManager d = new DeptManager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("========================");
			System.out.println("1. 사원관리  2. 부서관리  3. 종료");
			System.out.println("========================");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				e.empManger();
				break;
			case 2:
				d.deptManger();
				break;
			case 3:
				System.exit(0);

			}
		}
	}

}