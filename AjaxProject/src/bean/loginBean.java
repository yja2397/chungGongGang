package bean;

public class loginBean {
	private String userid;
	private String passwd;

	// 사용자 아이디와 비밀번호
	final String _userid = "root";
	final String _passwd = "cnuadmin!0";

	public boolean CheckUser() {
		if (userid.equals(_userid) && passwd.equals(_passwd)) {
			return true;
		} else
			return false;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
