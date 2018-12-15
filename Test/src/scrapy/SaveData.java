package scrapy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*������ : ȸ������ database ����, ��������.*/
public class SaveData {
	
	private ArrayList<String> a;
	
	/*public void dataSave(memberBean bean){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chung?serverTimezone=UTC", "root", "0726");
			 // ��ü�� �����Ѵ�.
			
			Statement stmt = conn.createStatement(); // stmt ��ü.
			
			String sql = "INSERT INTO c1 (id, userName, userPass, phone, email,"
					+ " birthday, userSub, keyword) VALUES ('" + bean.getId()  + "', '"  
					+ bean.getName()  + "', '"  + 
					bean.getPassword()  + "', '"  + bean.getPhone()  + "', '"  + bean.getEmail()  + "', '"  + 
			bean.getBirthday()  + "', '"  + bean.getSubject()  + "', '"  + bean.getKeyword() + "')";
			
			if(stmt.executeUpdate(sql) == 1)
				System.out.println("���� ����");
			else
				System.out.println("���� ����");
			
			conn.close();
			stmt.close(); // Connection�� Statement �ݾ��ֱ�.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	
	/*ȸ������ ����*/
	public void dataOpen() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chung?serverTimezone=UTC", "root", "0726");
			 // ��ü�� �����Ѵ�.
			
			Statement stmt = conn.createStatement(); // stmt ��ü.
			
			String sql2 = "SELECT * FROM c1;"; // chung ���̺��� ����
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			
			ResultSet rs = pstmt.executeQuery(); // ResultsetȰ��.
			
			a = new ArrayList<String>();
			
			while(rs.next()) {
				a.add(rs.getString(1));
				System.out.println(rs.getString(1));
				a.add(rs.getString(2));
				a.add(rs.getString(3));
				a.add(rs.getString(4));
				a.add(rs.getString(5));
				a.add(rs.getString(6));
				a.add(rs.getString(7));
				a.add(rs.getString(8));
				a.add(rs.getString(9));
			} // table�� �� ������ ��� ����Ѵ�. 
			
			System.out.println(a.get(0));
			
			conn.close();
			stmt.close(); // Connection�� Statement �ݾ��ֱ�.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*�������� �޾ƿ��� ���� �޼ҵ�.*/
	public String getToday() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MM/dd a hh:mm:ss");
		String to = date.format(today);
		
		return to;
	}
	
	/*ȸ������ table�� �޾ƿ��� �޼ҵ�*/
	public ArrayList<String> getList(){
		dataOpen();
		
		return a;
	}
	
	/*���̵�� ��й�ȣ�� ���Ͽ� ���̵�� ��й�ȣ�� ��ġ�ϸ� true, ���̵� ��ϵ��� �ʾҰų� ��й�ȣ�� Ʋ���� false�� ��ȯ�ϴ� �޼ҵ�.*/
	public String getPassword(String id){
		dataOpen();
		for(int i = 0; i < a.size(); i+=9) {
			if(a.get(i+1) == id) {
				return a.get(i+3).toString();
			}else {
				return "it is not a password";
			}
		}
		return "it is not a password";
	}
	
	/*���̵� �Է��ϸ� �̸��� �ּ� �޾ƿ��� �޼ҵ�*/
	public String getEmail(String id){
		dataOpen();
		for(int i = 1; i < a.size(); i+=9) {
			if(a.get(i) == id) {
				return a.get(i+3); // �̸��� �ּ� ��ȯ
			}
		}
		return "";
	}
}
