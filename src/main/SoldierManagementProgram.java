package main;

import java.util.Scanner;

import Functions.Functions;
import List.Benefit;
import List.Classes;
import List.Company;
import List.Duty;
import List.Equipment;
import List.Facility;
import List.Family;
import List.Medical;
import List.Oil;
import List.Physical;
import List.Soldier;
import List.Train;
import List.Vacation;
import java.sql.*;

public class SoldierManagementProgram {

	Scanner scan = new Scanner(System.in);
	public static String solNum;
	public static String name;
	
	Connection con = null;
	CallableStatement cstmt = null;

	void myMain() {
		
		try {
			System.out.println("<�� ���� ���α׷��� ���� �մϴ�.>");
			System.out.println();

			con = ConMrg.getCon();
			System.out.println("<�α���>");
			System.out.print("������ �Է��ϼ��� : ");
			solNum = scan.next();
			System.out.print("�̸��� �Է��ϼ��� : ");
			name = scan.next();

			String callname = "{call soldier_login(?,?,?)}";
			cstmt = con.prepareCall(callname);
			cstmt.setString(1, solNum);
			cstmt.setString(2, name);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();

			String result_out = cstmt.getString(3);
			System.out.println();
			System.out.println(result_out);
			System.out.println();

			while (true) {
				Functions f = Functions.getInstance();
				System.out.println();
				System.out.println(">>���� Ű���带 ���� �ϼ���.");
				System.out.println("1.�δ�   2.����   3.�ް�   4.��ȣ��   5.�Ƿ�   6.ü��   7.�Ʒ�");
				System.out.print("8.�ٹ�   9.���   10.���   11.���ǽü�   12.����   13.����   14.����\n>>");
				int menu = scan.nextInt();
				switch (menu) {
				case 1:
					f = new Company();
					break;
				case 2:
					f = new Soldier();
					break;
				case 3:
					f = new Vacation();
					break;
				case 4:
					f = new Family();
					break;
				case 5:
					f = new Medical();
					break;
				case 6:
					f = new Physical();
					break;
				case 7:
					f = new Train();
					break;
				case 8:
					f = new Duty();
					break;
				case 9:
					f = new Equipment();
					break;
				case 10:
					f = new Classes();
					break;
				case 11:
					f = new Facility();
					break;
				case 12:
					f = new Benefit();
					break;
				case 13:
					f = new Oil();
					break;
				case 14:
					System.out.println("���α׷��� �����մϴ�.");
					break;
				default:
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
				if (menu==14)
					break;
				f.showMenu(scan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SoldierManagementProgram pro = new SoldierManagementProgram();
		pro.myMain();
	}
}
