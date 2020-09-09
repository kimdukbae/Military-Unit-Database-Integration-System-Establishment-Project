package List;

import Functions.Functions;
import main.ConMrg;

import java.sql.*;
import java.util.*;

public class Facility extends Functions {
	Scanner scan = new Scanner(System.in);

	Connection con = null;
	CallableStatement cstmt = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	protected void infor() {
		try {
			con = ConMrg.getCon();

			String query = "SELECT fac_name, fac_manager FROM facility";
			st = con.prepareStatement(query);
			rs = st.executeQuery(query);
			
			System.out.println("�ü���\t\t �ü�������");
			while(rs.next()) {
				String fac_name = rs.getString(1);
				String fac_manager = rs.getString(2);
				
				System.out.printf("%s\t\t %s",fac_name, fac_manager);
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
			System.out.print("�߰��� �ü� �̸� : ");
			String facName = scan.nextLine();
			System.out.print("�߰��� �ü� ������ ���� : ");
			String facManager = scan.nextLine();
			
			String callname = "{call add_facility(?,?,?)}";
			cstmt = con.prepareCall(callname);
			cstmt.setString(1, facName);
			cstmt.setString(2, facManager);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String result_out = cstmt.getString(3);
			System.out.println(result_out);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showMenu(Scanner scan) {
		while (true) {
			System.out.printf("1.���ǽü� ��ȸ   2.���ǽü� �߰�   3.���ư���\n>>");
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
