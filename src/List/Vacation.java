package List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Functions.Functions;
import main.ConMrg;
import main.SoldierManagementProgram;

public class Vacation extends Functions {
	CallableStatement cstmt = null;
	Scanner scan = new Scanner(System.in);

	protected void infor() { // �ް� ���� ���
		try {
			
			con = ConMrg.getCon();
			
			call = "{call vac_infor(?,?)}";
			cstmt = con.prepareCall(call);
			cstmt.setString(1, SoldierManagementProgram.solNum);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();
			String result = cstmt.getString(2);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void updateStart() {	//�ް� ����� ���� (dbms���� ��ߺ��� varchar2������ ��ȯ ���.)
		try {
			con = ConMrg.getCon();
			
			String start;
			System.out.print("������� �Է��ϼ��� : ");
			start = scan.nextLine();
			call = "{call update_vacation_start(?,?,?)}";
			cstmt = con.prepareCall(call);
			cstmt.setString(1, SoldierManagementProgram.solNum);
			cstmt.setString(2, start);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			String result = cstmt.getString(3);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void updateEnd() {		//�ް� ������ ���� (dbms���� ���ͺ��� varchar2������ ��ȯ ���.)
		try {
			con = ConMrg.getCon();
			
			String end;
			System.out.print("�������� �Է��ϼ��� : ");
			end = scan.nextLine();
			call = "call update_vacation_end(?,?,?)";
			cstmt = con.prepareCall(call);
			cstmt.setString(1, SoldierManagementProgram.solNum);
			cstmt.setString(2, end);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			String result = cstmt.getString(3);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void updateKind() {
		try {
			
			con = ConMrg.getCon();
			
			System.out.println("�ٲٽ� �ް� ������ �Է�(�ް�/û���ް�/�ܹ�/����) : ");
			String kind = scan.nextLine();
			
			call = "{call update_vacation_kind(?,?,?)}";
			cstmt = con.prepareCall(call);
			cstmt.setString(1, SoldierManagementProgram.solNum);
			cstmt.setString(2, kind);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result = cstmt.getString(3);
			System.out.println(result);
			System.out.println();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showMenu(Scanner scan) {
		super.showMenu(scan);
		while (true) {
			System.out.print("1.��ȸ   2.����� ����   3.������ ����   4.��Ÿ ���� ����   5.���ư���\n>>");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				this.infor();
				break;
			case 2:
				this.updateStart();
				break;
			case 3:
				this.updateEnd();
				break;
			case 4:
				this.updateKind();
				break;
			case 5:
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
	}
}
