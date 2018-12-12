package scrapy;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup; // 크롤링할 때 쓴 Jsoup.
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawl{
	/*윤지애 : 공지사항 크롤링해주는 class*/
	
	private ArrayList<String> table; // 공지사항 ArrayList
	private ArrayList<String> tableA; // 공지사항 표 중 a tag만 모아둔 ArrayList
	private ArrayList<String> tableAHref; // 공지사항 표 중 a tag의 url들만 모아놓은 제목 ArrayList
	private String url; // url
	private String name; // 어떤 종류의 사이트인지 알려줌.(cnu, dom, sw, com)
	private String str; // table html 가져오는 String
	
	public Crawl() {
	}
	
	public void setting(String name, String url) throws IOException {
		// setting해주는 사이트. 어떤 종류의 사이트인지와 url을 받아온다. 8개의 목록들밖에 가져올 수 없다.
		// 기숙사 백행사, 은행사 공지사항 크롤링할 때 사용하는 메소드.
		this.name = name; // 어떤 종류의 사이트인지.
		this.url = url; // 사이트의 url.
		makeTable(); // table 만들기.
		setAttr(); // tableAHref 만들기.
		if(name == "cnu") {
			cnuTable(); // 충남대학교 table 만들기.
		}else if(name == "dom") {
			domTable(); // 기숙사 table 만들기.
		}else if(name == "sw") {
			swTable(); // 충남대학교 중심대학사업단 table 만들기.
		}else if(name == "com"){
			comTable(); // 컴퓨터공학과 table 만들기.
		}else {
			table.add("게시물이 존재하지 않습니다."); // name이 없으면 table에 게시물이 존재하지 않는다고 출력한다. 
		}
		tableRemoveA(); // 공백인 칸 없애고 table 오류 잡기.
	}
	
	public String printTable(String url) throws IOException {
		// 태그가 포함된 String을 리턴한다. 어떤 종류의 사이트인지 url 받아온다. 사이트에 있는 목록들을 모두 가져온다.
		// 기숙사 공지사항을 제외한 나머지 모든 공지사항을 크롤링할 때 쓰는 메소드.
        Document doc = Jsoup.connect(url).get(); // Jsoup을 이용하여 url의 document들을 모두 가져온다.
        Elements elem = doc.select("tbody"); // tbody에 있는 것들 선택한다.
        this.str=elem.html(); // Jsoup 안에 있는 메소드. tbody 안에 있는 태그를 포함한 html 문서를 모두 가져온다.
        str = str.replace("<td class=\"t_end\">&nbsp;</td>", "");
		str = str.replace("<td class=\"t_end\"><img src=\"/_prog/_board/skin/rwd/img/file_icon.gif\" alt=\"파일있음\">&nbsp;</td>", "");
		str = str.replace("<td class=\"center t_end\">&nbsp;</td>", "");
		str = str.replace("<td class=\"center t_end\"><img src=\"/_prog/_board/skin/rwd/img/file_icon.gif\" alt=\"파일있음\">&nbsp;</td>", "");
        str = str.replace("<td> <span class=\"select itx\"> <select name=\"search_target\"> <option value=\"title_content\">제목+내용</option><option value=\"title\">제목</option><option value=\"content\">내용</option><option value=\"comment\">댓글</option><option value=\"user_name\">이름</option><option value=\"nick_name\">닉네임</option><option value=\"user_id\">아이디</option><option value=\"tag\">태그</option> </select> </span> </td", "");
        str = str.replace("<td class=\"itx_wrp\"> <input type=\"text\" name=\"search_keyword\" value=\"\" class=\"itx srch_itx\"> </td>", "");
        str = str.replace("<td> <button type=\"submit\" onclick=\"jQuery(this).parents('form').submit();return false\" class=\"bd_btn\">검색</button> </td>", "");
        str = str.replace("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=guide_personal\">개인정보 처리방침</a></td>", "");
        str = str.replace("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=guide_email\">이메일 무단수집거부</a></td>", "");
        str = str.replaceAll("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=int_map\">찾아오시는 길</a></td> ", "");
        str = str.replace("<td></td>", "");
        str = str.replace("<td> </td>", "");
        str = str.replace("<td> <span></span> </td>", "");
        str = str.replace("<td> </td> \r\n" + 
        		" <td> <span></span> </td>", "");
        str = str.replace("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=int_map\">찾아오시는 길</a></td>", "");
        // tbody 안에 있는 오류가 있을 만한 태그들을 모두 없애버린다.
        
        Elements elem2 = doc.select(".t_end"); // 클래스 이름이 .t_end인 것들은 table에서 제외시켜야 한다.
        String str2 = elem2.html(); // t_end 클래스의 html을 모두 가져온다.
        ArrayList<String> strs = new ArrayList<String>(Arrays.asList(str2.split("&nbsp;"))); // ' '로 나눠서 ArrayList에 넣는다.
        
        for(int i = 0; i < strs.size(); i++) {
        	str.replace(strs.get(i), ""); // str에 strs ArrayList에 들어있는 것과 같은 것이 있으면 지운다.
        }
        
		return str; // tag가 포함된 string을 반환한다. 이것을 출력하면 표가 그대로 출력된다.
	}
	
	public void goToA() {
		str = str.replace("href=\"./?", "target=\"_blank\" href=\"http://plus.cnu.ac.kr/_prog/_board/?");
	}
	
	public void goToB() {
		str = str.replace("href=\"/community", "target=\"_blank\" href=\"http://wise.cnu.ac.kr/community");
	}
	
	public String printStr(String name) {
		if(name == "cnu")
			goToA();
		else
			goToB();
		return str;
	}
	
	public void setName(String name) { // 무슨 사이트인지 알려줌.
		this.name = name;
	}
	
	public String getName() { // 무슨 사이트인지 얻어옴.
		return name;
	}
	
	public void setUrl(String url) { // 무슨 url인지 알려줌.
		this.url = url;
	}
	
	public String getUrl() { // 무슨 url인지 얻어옴.
		return url;
	}
	
	private void makeTable() throws IOException { 
		// table 만드는 메소드.
        Document doc = Jsoup.connect(url).get(); // JSoup으로 url의 문서 가져오기.
        Elements elem = doc.select("table"); // table 태그 안에 있는 것을 선택한다.
        String str = elem.text(); // table 안에 있는 textnode만 가져온다.
        this.table = new ArrayList<String>(Arrays.asList(str.split(" "))); // textnode로 가져오면 띄워쓰기로 나누어져서 가져오게 된다. 그래서 띄워쓰기로 나눠서 ArrayList로 얻어온다.
        Elements elemA = doc.select("table a"); // table 태그 안에 있는 a tag만 가져온다.
        String strA = elemA.text(); // table 안의 a tag가 있는 것들의 textnode만 가져온다.
        this.tableA = new ArrayList<String>(Arrays.asList(strA.split(" "))); // textnode를 띄워쓰기로 나눠서 ArrayList로 얻어온다.
        int j = 1; // for문과 상관없이 돌아가야 하는 인덱스. tableA를 직접적으로 가르쳐야 한다.
        String removed; // 지울 것과 비교할 String
        int size = tableA.size(); // table의 크기만큼 for문을 돌린다.
        for(int i = 0; i < size-1; i++) { // tableA에 공백이 너무 많아서 그것을 지우기 위해 만든 포문.
        	removed = tableA.get(j-1) + tableA.get(j); // 전 것과 이번 것을 더한 것.
        	if(removed.equals(tableA.get(j))) { // 만약 전 것과 이번 것을 더한 것이 같으면
        		tableA.remove(j-1); // tableA에서 그 칸을 지운다.
        	}else { // 전 것과 이번 것을 더한 것이 틀리면
        		j++; // tableA칸에서 그 칸을 지우지 않고 j 인덱스를 높인다.
        	}
        	
        }
	}
	
	public void cnuTable() {
		// 충남대학교 table 초기화
		for(int i=0; i<29; i++) {
			table.remove(0); // 불필요한 것 지우기.
		}
	}
	
	public void domTable() {
		// 기숙사 table 초기화
		for(int i=0; i<10; i++) {
			table.remove(0); // 불필요한 것 지우기.
		}
		for(int i=0; i<4; i++) {
			tableA.remove(0); // 불필요한 것 지우기.
		}
		for(int i=0; i<4; i++) {
			tableAHref.remove(0); // 불필요한 것 지우기.
		}
		for(int i = 0; i < tableAHref.size(); i++) {
			tableAHref.set(i,tableAHref.get(i).replace("href=\"./?", "target=\"_blank\" href=\"http://dorm.cnu.ac.kr/_prog/_board/?")); // 기숙사 홈페이지의 경로 올바르게 지정하기. 새 창에서 공지 뜨게 하기.
		}
	}
	
	public void swTable() {
		// sw중심대학사업단 table 초기화
		for(int i=0; i<5; i++) {
			table.remove(0); // 불필요한 것 지우기.
		}
	}
	
	public void comTable() {
		// 컴퓨터공학과 table 초기화
		for(int i=0; i<11; i++) {
			table.remove(0); // 불필요한 것 지우기.
		}
		for(int i=0; i<5; i++) {
			tableA.remove(0); // 불필요한 것 지우기.
		}
		for(int i=0; i<5; i++) {
			tableAHref.remove(0); // 불필요한 것 지우기.
		}
	}
	
	public void tableRemoveA() {
		// a tag들의 분리되어 있는 것들을 하나로 줄이기.
		int size = table.size(); // table의 크기.
		int j = 0; // table의 인덱스.
		boolean change = false; // 바뀌었는지 아닌지 알려주는 boolean형 변수.
		int removeI = 0; // remove 인덱스.
		String a = "'"; // 제목 넣는 String
		for(int i=0; i<size; i++) {
			if(table.get(removeI).equals(tableA.get(j))) { // 같으면 제목 안에 String 넣고 table 없애기.
				change = true;
				a += tableA.get(j) + " ";
				table.remove(removeI);
				j++; // table 인덱스 올리기.
			}else {
				if(change == true) { // 만약 이전에 바뀌었으면 a tag 만들고 table 안에 넣고 change와 a 초기화하기.
					a += "'";
					table.add(removeI, a);
					a = "'";
					change = false;
				}
				removeI++; // remove한 것 올리기.
			}
		}
	}
	
	public void setAttr() throws IOException { // atag인 것들 가져오기.
		Document doc = Jsoup.connect(url).get();
		Elements elemA = doc.select("table td.title"); // a tag인  td들 중 클래스가 title인 것만 받아오기.
        String strA = elemA.html(); // jsoup의 메소드를 이용해서 html 가져오기.
        tableAHref = new ArrayList<String>(Arrays.asList(strA.split("\n"))); // enter를 기점으로 나눠서 ArrayList에 넣기.
		
	}
	
	public ArrayList<String> getTable() throws IOException{ // table 가져오기.
		return table;
	}
	
	public ArrayList<String> getAttr() throws IOException{ // 제목 table 가져오기.
		return tableAHref;
	}
	
}