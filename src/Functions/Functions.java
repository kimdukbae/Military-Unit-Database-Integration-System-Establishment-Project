package Functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class Functions {
	protected int menu;
	protected String solNum;
	protected String name;
	protected String call;
	protected Connection con;

	public void setId(String solNum, String name,Connection con) {
		this.solNum = solNum;
		this.name = name;
		this.con = con;
	}

	protected void infor() {// ��ȸ, ��� �� ������ȸ
		// �������� �κ��� �̰��� ��� ����.(��� �޼ҵ� ����).
		// �߰� ���� �κ��̳� �޶����� �κ��� List���� �ش� �޼ҵ� '�������̵�' �ؼ� ������ �� ��.
		System.out.println("��ȸ �ϰڽ��ϴ�.");
	}

	protected void add() {// �߰�, ����, �ź� ����, ���

	}

	protected void delete() {// ����

	}

	protected void update() {// ��Ÿ ����, ��� ����

	}

	public void showMenu(Scanner scan) {
		System.out.println();
		System.out.print(">>������ ���� �ϼ���.\n>>");
		// �� Ŭ���� ���� switch - case�� �޸��ؼ� �޴� ���.
	}

	protected Functions() {
	}

	private static class LazyHolder {
		public static final Functions INSTANCE = new Functions();
	}

	public static Functions getInstance() {
		return LazyHolder.INSTANCE;
	}

	
}
