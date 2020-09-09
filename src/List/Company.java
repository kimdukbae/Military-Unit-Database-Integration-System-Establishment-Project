package List;

import java.util.Scanner;
import Functions.Functions;
import main.ConMrg;

import java.util.*;
import java.sql.*;

public class Company extends Functions {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	protected void infor() {
		try {
			
			con = ConMrg.getCon();
			
			String query = "select * from company";
			
			st = con.prepareStatement(query);
			rs = st.executeQuery(query);
			
			System.out.println("�δ��ȣ\t\t\t �δ��̸�\t\t �ּ�\t ��������\t �δ�Ը�\t �����ο�");
			while(rs.next()) {
				String co_id = rs.getString(1);
				String co_name = rs.getString(2);
				String co_addr = rs.getString(3);
				String co_area = rs.getString(4);
				String co_scale = rs.getString(5);
				String co_capacity = rs.getString(6);
				
				System.out.printf("%s\t %s\t\t %s\t %s\t %s\t %s\t", co_id, co_name, co_addr, co_area, co_scale, co_capacity);
				System.out.println();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showMenu(Scanner scan) {
		super.showMenu(scan);
		while (true) {
			System.out.print("1.��ȸ   2.���ư���\n>>");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				this.infor();
				break;
			case 2:
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
	}
}
