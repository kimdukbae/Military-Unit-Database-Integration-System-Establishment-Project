package List;

import Functions.Functions;
import main.ConMrg;
import java.sql.*;
import java.util.*;

public class Benefit extends Functions {
	Scanner scan = new Scanner(System.in);

	Connection con = null;
	CallableStatement cstmt = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	protected void infor() {
		try {
			con = ConMrg.getCon();

			String query = "SELECT b_name, b_class, b_con FROM benefit";
			st = con.prepareStatement(query);
			rs = st.executeQuery(query);

			System.out.println("�������� �̸�\t ���\t ���ó���");
			while (rs.next()) {
				String b_name = rs.getString(1);
				String b_class = rs.getString(2);
				String b_con = rs.getString(3);

				System.out.printf("%s\t\t %s\t %s", b_name, b_class, b_con);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void add() {
		try {
			con = ConMrg.getCon();
			System.out.print("�߰��� �����̸� : ");
			String b_name2 = scan.nextLine();
			System.out.print("������ ������ �ִ� ��� : ");
			String b_class2 = scan.nextLine();
			System.out.print("�������� ���� : ");
			String b_con2 = scan.nextLine();
			
			String callname2 = "{call insert_benefit(?,?,?,?)}";
			cstmt = con.prepareCall(callname2);
			cstmt.setString(1, b_name2);
			cstmt.setString(2, b_class2);
			cstmt.setString(3, b_con2);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out2 = cstmt.getString(4);
			System.out.println(result_out2);
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void delete() {
		try {
			con = ConMrg.getCon();
			
			System.out.print("������ ���������̸� : ");
			String b_name3 = scan.nextLine();
			
			String callname3 = "{call delete_benefit(?,?)}";
			cstmt = con.prepareCall(callname3);
			cstmt.setString(1, b_name3);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out3 = cstmt.getNString(2);
			System.out.println(result_out3);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void showMenu(Scanner scan) {
		while (true) {
			System.out.printf("1.������ƽ ��ȸ   2.������å �߰�   3.������å ����   4.���ư���\n>>");
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
