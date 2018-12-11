package alarm;
/*윤지애 : 알람 설정*/

public class alarm {
	private String notice_board; // 게시판 종류
	private String system; // 알림 종류  : 전체 / 키워드
	private String keyword; // 키워드

	public String getNotice_board() {
		return notice_board;
	}
	public void setNotice_board(String notice_board) {
		this.notice_board = notice_board;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
