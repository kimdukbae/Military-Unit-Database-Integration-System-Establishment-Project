package List;

import Functions.Functions;
import main.ConMrg;
import main.SoldierManagementProgram;

import java.util.*;
import java.sql.*;

public class Train extends Functions {
	CallableStatement cstmt = null;
	Statement st = null;
	ResultSet rs = null;
	Scanner scan = new Scanner(System.in);
	
	protected void infor() { // ü�� ���� ���
		try {
			
			con = ConMrg.getCon();
			
			call = "select * from train";
			st = con.prepareStatement(call);
			rs = st.executeQuery(call);
			
			System.out.println("�Ʒ��̸�\t\t �δ��ȣ\t\t �Ʒý�����\t\t �Ʒ�������\t\t �Ʒ����");
			while(rs.next()) {
				String t_name = rs.getString(1);
				String t_co = rs.getString(2);
				String t_start = rs.getString(3);
				String t_end = rs.getString(4);
				String t_addr = rs.getString(5);
				
				System.out.printf("%s\t\t %s %s\t\t %s\t\t %s", t_name, t_co, t_start, t_end, t_addr);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void add() {		//�Ƿ� ���� ��� (��¥ dbms���� �ڷ�����ȯ���)
		try {
			
			con = ConMrg.getCon();
			
			String name, co, start, end, addr;
			System.out.print("�Ʒ� �̸� : ");
			name = scan.nextLine();
			System.out.print("�Ʒ��� �����ϴ� �δ��ȣ : ");
			co = scan.nextLine();
			System.out.print("�Ʒ� ������ : ");
			start = scan.nextLine();
			System.out.print("�Ʒ� ������ : ");
			end = scan.nextLine();
			System.out.print("�Ʒ��� �����ϴ� �ּ� : ");
			addr = scan.nextLine();
			
			call = "{call insert_train(?,?,?,?,?,?)}";
			cstmt = con.prepareCall(call);
			cstmt.setString(1, name);
			cstmt.setString(2, co);
			cstmt.setString(3, start);
			cstmt.setString(4, end);
			cstmt.setString(5, addr);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out = cstmt.getString(6);
			System.out.println(result_out);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void delete() {
try {
			
			con = ConMrg.getCon();
			
			String name2, co2;
			System.out.print("������ �Ʒ� �̸� : ");
			name2 = scan.nextLine();
			System.out.print("������ �Ʒ��� �����ϴ� �δ��ȣ : ");
			co2 = scan.nextLine();
			
			call = "{call delete_train(?,?,?)}";
			cstmt = con.prepareCall(call);
			cstmt.setString(1, name2);
			cstmt.setString(2, co2);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out = cstmt.getString(3);
			System.out.println(result_out);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void showMenu(Scanner scan) {
		super.showMenu(scan);
		while (true) {
			System.out.print("1.�Ʒ� ���� ��ȸ  2.�Ʒ� �߰�   3.�Ʒ� ����   4.���ư���\n>>");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				this.infor();
				break;
			case 2:
				this.add();
				break;
			case 3:
				this.delete();
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
