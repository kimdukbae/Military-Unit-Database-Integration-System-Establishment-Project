package List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Functions.Functions;
import main.ConMrg;
import main.SoldierManagementProgram;

public class Medical extends Functions {
	CallableStatement cstmt = null;
	Scanner scan = new Scanner(System.in);
	
	protected void infor() { // �λ� ���� ���
		try {
			
			con = ConMrg.getCon();
			
			call = "{call medical_infor(?,?)}";
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
	
	protected void add() {		//�Ƿ� ���� ��� (��¥ dbms���� �ڷ�����ȯ���)
		try {
			
			con = ConMrg.getCon();
			
			String mname,mdate,mcon;
			int mdocunum;
			System.out.print("������ȣ�� �Է��ϼ��� : ");
			mdocunum = scan.nextInt();
			System.out.print("�λ󳻿��� �Է��ϼ��� : ");
			mname = scan.next();
			System.out.print("��¥�� �Է��ϼ��� : ");
			mdate = scan.next();
			System.out.print("ġ������ �Է��ϼ��� : ");
			mcon = scan.next();
			call = "call medical_add(?,?,?,?,?)";
			cstmt = con.prepareCall(call);
			cstmt.setInt(1, mdocunum);
			cstmt.setString(2, mname);
			cstmt.setString(3, mdate);
			cstmt.setString(4, mcon);
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstmt.execute();
			String result = cstmt.getString(5);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showMenu(Scanner scan) {
		super.showMenu(scan);
		while (true) {
			System.out.print("1.�λ� Ȯ��   2.���� �߰�   3.���ư���\n>>");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				this.infor();
				break;
			case 2:
				this.add();
				break;
			case 3:
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
	}
}
