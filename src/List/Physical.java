package List;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Functions.Functions;
import main.ConMrg;
import main.SoldierManagementProgram;

public class Physical extends Functions {
	CallableStatement cstmt = null;
	Scanner scan = new Scanner(System.in);
	
	protected void infor() { // ü�� ���� ���
		try {
			
			con = ConMrg.getCon();
			
			call = "{call physical_infor(?,?)}";
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
			
			int pdocunum,pu,su,run,fire;
			System.out.print("������ȣ�� �Է��ϼ��� : ");
			pdocunum = scan.nextInt();
			System.out.print("�ȱ������ ������ �Է��ϼ��� : ");
			pu = scan.nextInt();
			System.out.print("��������Ű�� ������ �Է��ϼ��� : ");
			su = scan.nextInt();
			System.out.print("�ܰ��� �ð��� �Է��ϼ��� : ");
			run = scan.nextInt();
			System.out.print("��� ������ �Է��ϼ��� : ");
			fire = scan.nextInt();
			call = "{call insert_physical(?,?,?,?,?,?)}";
			cstmt = con.prepareCall(call);
			cstmt.setInt(1, pdocunum);
			cstmt.setInt(2, pu);
			cstmt.setInt(3, su);
			cstmt.setInt(4, run);
			cstmt.setInt(5, fire);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.execute();
			String result = cstmt.getString(6);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showMenu(Scanner scan) {
		super.showMenu(scan);
		while (true) {
			System.out.print("1.ü�� ���� ��ȸ   2.���� �߰�   3.���ư���\n>>");
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
