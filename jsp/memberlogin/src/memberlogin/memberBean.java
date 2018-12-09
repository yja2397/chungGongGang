package memberlogin;

public class memberBean {

	// getParameter()를 이용해 넘겨진 파라미터 값을 얻어올 수 있다.
	// 파라미터 값을 얻을때 name= 에 지정해둔 값과 동일한 값을 인자로 지정해야 된다.
	private String id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String birthday;
	private String subject;
	private String keyword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
