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

/*윤지애 : 회원가입 database 생성, 가져오기.*/
public class SaveData {
	
	private ArrayList<String> a;
	
	/*public void dataSave(memberBean bean){
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
	}*/
	
	
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
			} // table의 한 행으로 모두 출력한다. 
			
			System.out.println(a.get(0));
			
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
	
	/*아이디와 비밀번호를 비교하여 아이디와 비밀번호가 일치하면 true, 아이디가 등록되지 않았거나 비밀번호가 틀리면 false를 반환하는 메소드.*/
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
	
	/*아이디 입력하면 이메일 주소 받아오는 메소드*/
	public String getEmail(String id){
		dataOpen();
		for(int i = 1; i < a.size(); i+=9) {
			if(a.get(i) == id) {
				return a.get(i+3); // 이메일 주소 반환
			}
		}
		return "";
	}
}
