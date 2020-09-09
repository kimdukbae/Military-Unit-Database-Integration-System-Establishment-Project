package List;

import java.sql.*;
import java.util.*;

import Functions.Functions;
import main.ConMrg;

public class Equipment extends Functions {

	Scanner scan = new Scanner(System.in);

	Connection con = null;
	CallableStatement cstmt = null;

	@Override
	protected void infor() {
		try {
			con = ConMrg.getCon();
			System.out.print("����ȣ�� �Է��ϼ��� : ");
			String eq_id = scan.nextLine();
			String callname = "{call equip_infor(?,?)}";
			cstmt = con.prepareCall(callname);
			cstmt.setString(1, eq_id);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();

			String result_out = cstmt.getString(2);
			System.out.println(result_out);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void update() {
		try {
			con = ConMrg.getCon();
			System.out.print("������� ����ȣ �Է� : ");
			String eq_id2 = scan.nextLine();
			System.out.print("������ ��� ���� �Է� : ");
			int eq_stock = scan.nextInt();
			
			String callname2 = "{call update_equipment(?,?,?)}";
			cstmt = con.prepareCall(callname2);
			cstmt.setString(1, eq_id2);
			cstmt.setInt(2, eq_stock);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out2 = cstmt.getString(3);
			System.out.println(result_out2);
			System.out.println();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void add() {
		try {
			con = ConMrg.getCon();
			System.out.println("���� ����� ��� ����");
			System.out.print("����ȣ �Է� : ");
			String eq_id3 = scan.nextLine();
			System.out.print("�δ��ȣ �Է� : ");
			String eq_co_id = scan.nextLine();
			System.out.print("����̸� �Է� : ");
			String eq_name = scan.nextLine();
			System.out.print("������ �Է� : ");
			int eq_stock2 = scan.nextInt();
			System.out.print("������� �Է� : ");
			String eq_kind = scan.nextLine();
			
			String callname3 = "{call in_equipment(?,?,?,?,?,?)}";
			cstmt = con.prepareCall(callname3);
			cstmt.setString(1, eq_id3);
			cstmt.setString(2,eq_co_id);
			cstmt.setString(3,eq_name);
			cstmt.setInt(4,eq_stock2);
			cstmt.setString(5,eq_kind);
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out3 = cstmt.getString(6);
			System.out.println(result_out3);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showMenu(Scanner scan) {
		while(true) {
			System.out.printf("1.�����ȸ   2.��� �����   3.�� ��� ���   4.���ư���\n>>");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				this.infor();
				break;
			case 2:
				this.update();
				break;
			case 3:
				this.add();
				break;
			case 4:
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
	}

}
