package memberlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*윤지애 : 회원가입 database 생성, 가져오기.*/
public class SaveData {
	
	private ArrayList<String> a;
	
	public void dataSave(memberBean bean){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chung?serverTimezone=UTC", "root", "0726");
			 // 객체를 생성한다.
			
			Statement stmt = conn.createStatement(); // stmt 객체.
			
			String sql = "INSERT INTO c1 (id, userName, userPass, phone, email,"
					+ " birthday, userSub, keyword) VALUES ('" + bean.getId()  + "', '"  
					+ bean.getName()  + "', '"  + 
					bean.getPassword()  + "', '"  + bean.getPhone()  + "', '"  + bean.getEmail()  + "', '"  + 
			bean.getBirthday()  + "', '"  + bean.getSubject()  + "', '"  + bean.getKeyword() + "')";
			
			if(stmt.executeUpdate(sql) == 1)
				System.out.println("삽입 성공");
			else
				System.out.println("삽입 실패");
			
			conn.close();
			stmt.close(); // Connection과 Statement 닫아주기.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*회원정보 열람*/
	public void dataOpen() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chung?serverTimezone=UTC", "root", "0726");
			 // 객체를 생성한다.
			
			Statement stmt = conn.createStatement(); // stmt 객체.
			
			String sql2 = "SELECT * FROM c1;"; // chung 테이블을 선택
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			
			ResultSet rs = pstmt.executeQuery(); // Resultset활용.
			
			a = new ArrayList<String>();
			
			while(rs.next()) {
				a.add("<tr><td>"+ rs.getString(1) + "</td>	<td>" + rs.getString(2) + "</td>"+
						"<td>"+ rs.getString(3) + "</td>	<td>" + rs.getString(4) + "</td>"+
						"<td>"+ rs.getString(5) + "</td>	<td>" + rs.getString(6) + "</td>"+
						"<td>"+ rs.getString(7) + "</td>	<td>" + rs.getString(8) + "</td>"+
						"<td>" + rs.getString(8) + "</td></tr>");
			} // table의 한 행으로 모두 출력한다. 
			
			conn.close();
			stmt.close(); // Connection과 Statement 닫아주기.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*가입일을 받아오기 위한 메소드.*/
	public String getToday() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MM/dd a hh:mm:ss");
		String to = date.format(today);
		
		return to;
	}
	
	/*회원정보 table로 받아오는 메소드*/
	public ArrayList<String> getList(){
		dataOpen();
		return a;
	}
}
