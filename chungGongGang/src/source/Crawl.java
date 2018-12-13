package source;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup; // ũ�Ѹ��� �� �� Jsoup.
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawl{
	/*������ : �������� ũ�Ѹ����ִ� class*/
	
	private ArrayList<String> table; // �������� ArrayList
	private ArrayList<String> tableA; // �������� ǥ �� a tag�� ��Ƶ� ArrayList
	private ArrayList<String> tableAHref; // �������� ǥ �� a tag�� url�鸸 ��Ƴ��� ���� ArrayList
	private String url; // url
	private String name; // � ������ ����Ʈ���� �˷���.(cnu, dom, sw, com)
	private String str; // table html �������� String
	
	public Crawl() {
	}
	
	public void setting(String name, String url) throws IOException {
		// setting���ִ� ����Ʈ. � ������ ����Ʈ������ url�� �޾ƿ´�. 8���� ��ϵ�ۿ� ������ �� ����.
		// ����� �����, ����� �������� ũ�Ѹ��� �� ����ϴ� �޼ҵ�.
		this.name = name; // � ������ ����Ʈ����.
		this.url = url; // ����Ʈ�� url.
		makeTable(); // table �����.
		setAttr(); // tableAHref �����.
		if(name == "cnu") {
			cnuTable(); // �泲���б� table �����.
		}else if(name == "dom") {
			domTable(); // ����� table �����.
		}else if(name == "sw") {
			swTable(); // �泲���б� �߽ɴ��л���� table �����.
		}else if(name == "com"){
			comTable(); // ��ǻ�Ͱ��а� table �����.
		}else {
			table.add("�Խù��� �������� �ʽ��ϴ�."); // name�� ������ table�� �Խù��� �������� �ʴ´ٰ� ����Ѵ�. 
		}
		tableRemoveA(); // ������ ĭ ���ְ� table ���� ���.
	}
	
	public String printTable(String url) throws IOException {
		// �±װ� ���Ե� String�� �����Ѵ�. � ������ ����Ʈ���� url �޾ƿ´�. ����Ʈ�� �ִ� ��ϵ��� ��� �����´�.
		// ����� ���������� ������ ������ ��� ���������� ũ�Ѹ��� �� ���� �޼ҵ�.
        Document doc = Jsoup.connect(url).get(); // Jsoup�� �̿��Ͽ� url�� document���� ��� �����´�.
        Elements elem = doc.select("tbody"); // tbody�� �ִ� �͵� �����Ѵ�.
        this.str=elem.html(); // Jsoup �ȿ� �ִ� �޼ҵ�. tbody �ȿ� �ִ� �±׸� ������ html ������ ��� �����´�.
        str = str.replace("<td class=\"t_end\">&nbsp;</td>", "");
		str = str.replace("<td class=\"t_end\"><img src=\"/_prog/_board/skin/rwd/img/file_icon.gif\" alt=\"��������\">&nbsp;</td>", "");
		str = str.replace("<td class=\"center t_end\">&nbsp;</td>", "");
		str = str.replace("<td class=\"center t_end\"><img src=\"/_prog/_board/skin/rwd/img/file_icon.gif\" alt=\"��������\">&nbsp;</td>", "");
        str = str.replace("<td> <span class=\"select itx\"> <select name=\"search_target\"> <option value=\"title_content\">����+����</option><option value=\"title\">����</option><option value=\"content\">����</option><option value=\"comment\">���</option><option value=\"user_name\">�̸�</option><option value=\"nick_name\">�г���</option><option value=\"user_id\">���̵�</option><option value=\"tag\">�±�</option> </select> </span> </td", "");
        str = str.replace("<td class=\"itx_wrp\"> <input type=\"text\" name=\"search_keyword\" value=\"\" class=\"itx srch_itx\"> </td>", "");
        str = str.replace("<td> <button type=\"submit\" onclick=\"jQuery(this).parents('form').submit();return false\" class=\"bd_btn\">�˻�</button> </td>", "");
        str = str.replace("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=guide_personal\">�������� ó����ħ</a></td>", "");
        str = str.replace("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=guide_email\">�̸��� ���ܼ����ź�</a></td>", "");
        str = str.replaceAll("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=int_map\">ã�ƿ��ô� ��</a></td> ", "");
        str = str.replace("<td></td>", "");
        str = str.replace("<td> </td>", "");
        str = str.replace("<td> <span></span> </td>", "");
        str = str.replace("<td> </td> \r\n" + 
        		" <td> <span></span> </td>", "");
        str = str.replace("<td><a href=\"http://computer.cnu.ac.kr/index.php?mid=int_map\">ã�ƿ��ô� ��</a></td>", "");
        // tbody �ȿ� �ִ� ������ ���� ���� �±׵��� ��� ���ֹ�����.
        
        Elements elem2 = doc.select(".t_end"); // Ŭ���� �̸��� .t_end�� �͵��� table���� ���ܽ��Ѿ� �Ѵ�.
        String str2 = elem2.html(); // t_end Ŭ������ html�� ��� �����´�.
        ArrayList<String> strs = new ArrayList<String>(Arrays.asList(str2.split("&nbsp;"))); // ' '�� ������ ArrayList�� �ִ´�.
        
        for(int i = 0; i < strs.size(); i++) {
        	str.replace(strs.get(i), ""); // str�� strs ArrayList�� ����ִ� �Ͱ� ���� ���� ������ �����.
        }
        
		return str; // tag�� ���Ե� string�� ��ȯ�Ѵ�. �̰��� ����ϸ� ǥ�� �״�� ��µȴ�.
	}
	
	public void goToA() { // �泲���б� Ȩ�������� ��� �ùٸ��� �����ϱ�. �� â���� ���� �߰� �ϱ�.
		str = str.replace("href=\"./?", "target=\"_blank\" href=\"http://plus.cnu.ac.kr/_prog/_board/?");
	}
	
	public void goToB() { // ����Ʈ�����߽ɴ��л���� Ȩ�������� ��� �ùٸ��� �����ϱ�. �� â���� ���� �߰� �ϱ�.
		str = str.replace("href=\"/community", "target=\"_blank\" href=\"http://wise.cnu.ac.kr/community");
	}
	
	public void goToC() {
		str = str.replace("href=", "target=\"_blank\" href=");
	}
	
	public String printStr(String name) {
		if(name == "cnu")
			goToA();
		else if(name == "sw")
			goToB();
		else
			goToC();
		return str;
	}
	
	public void setName(String name) { // ���� ����Ʈ���� �˷���.
		this.name = name;
	}
	
	public String getName() { // ���� ����Ʈ���� ����.
		return name;
	}
	
	public void setUrl(String url) { // ���� url���� �˷���.
		this.url = url;
	}
	
	public String getUrl() { // ���� url���� ����.
		return url;
	}
	
	private void makeTable() throws IOException { 
		// table ����� �޼ҵ�.
        Document doc = Jsoup.connect(url).get(); // JSoup���� url�� ���� ��������.
        Elements elem = doc.select("table"); // table �±� �ȿ� �ִ� ���� �����Ѵ�.
        String str = elem.text(); // table �ȿ� �ִ� textnode�� �����´�.
        this.table = new ArrayList<String>(Arrays.asList(str.split(" "))); // textnode�� �������� �������� ���������� �������� �ȴ�. �׷��� �������� ������ ArrayList�� ���´�.
        Elements elemA = doc.select("table a"); // table �±� �ȿ� �ִ� a tag�� �����´�.
        String strA = elemA.text(); // table ���� a tag�� �ִ� �͵��� textnode�� �����´�.
        this.tableA = new ArrayList<String>(Arrays.asList(strA.split(" "))); // textnode�� �������� ������ ArrayList�� ���´�.
        int j = 1; // for���� ������� ���ư��� �ϴ� �ε���. tableA�� ���������� �����ľ� �Ѵ�.
        String removed; // ���� �Ͱ� ���� String
        int size = tableA.size(); // table�� ũ�⸸ŭ for���� ������.
        for(int i = 0; i < size-1; i++) { // tableA�� ������ �ʹ� ���Ƽ� �װ��� ����� ���� ���� ����.
        	removed = tableA.get(j-1) + tableA.get(j); // �� �Ͱ� �̹� ���� ���� ��.
        	if(removed.equals(tableA.get(j))) { // ���� �� �Ͱ� �̹� ���� ���� ���� ������
        		tableA.remove(j-1); // tableA���� �� ĭ�� �����.
        	}else { // �� �Ͱ� �̹� ���� ���� ���� Ʋ����
        		j++; // tableAĭ���� �� ĭ�� ������ �ʰ� j �ε����� ���δ�.
        	}
        	
        }
	}
	
	public void cnuTable() {
		// �泲���б� table �ʱ�ȭ
		for(int i=0; i<29; i++) {
			table.remove(0); // ���ʿ��� �� �����.
		}
	}
	
	public void domTable() {
		// ����� table �ʱ�ȭ
		for(int i=0; i<10; i++) {
			table.remove(0); // ���ʿ��� �� �����.
		}
		for(int i=0; i<4; i++) {
			tableA.remove(0); // ���ʿ��� �� �����.
		}
		for(int i=0; i<4; i++) {
			tableAHref.remove(0); // ���ʿ��� �� �����.
		}
		for(int i = 0; i < tableAHref.size(); i++) { // ����� Ȩ�������� ��� �ùٸ��� �����ϱ�. �� â���� ���� �߰� �ϱ�.
			tableAHref.set(i,tableAHref.get(i).replace("href=\"./?", "target=\"_blank\" href=\"http://dorm.cnu.ac.kr/_prog/_board/?"));
		}
	}
	
	public void swTable() {
		// sw�߽ɴ��л���� table �ʱ�ȭ
		for(int i=0; i<5; i++) {
			table.remove(0); // ���ʿ��� �� �����.
		}
	}
	
	public void comTable() {
		// ��ǻ�Ͱ��а� table �ʱ�ȭ
		for(int i=0; i<11; i++) {
			table.remove(0); // ���ʿ��� �� �����.
		}
		for(int i=0; i<5; i++) {
			tableA.remove(0); // ���ʿ��� �� �����.
		}
		for(int i=0; i<5; i++) {
			tableAHref.remove(0); // ���ʿ��� �� �����.
		}
	}
	
	public void tableRemoveA() {
		// a tag���� �и��Ǿ� �ִ� �͵��� �ϳ��� ���̱�.
		int size = table.size(); // table�� ũ��.
		int j = 0; // table�� �ε���.
		boolean change = false; // �ٲ������ �ƴ��� �˷��ִ� boolean�� ����.
		int removeI = 0; // remove �ε���.
		String a = "'"; // ���� �ִ� String
		for(int i=0; i<size; i++) {
			if(table.get(removeI).equals(tableA.get(j))) { // ������ ���� �ȿ� String �ְ� table ���ֱ�.
				change = true;
				a += tableA.get(j) + " ";
				table.remove(removeI);
				j++; // table �ε��� �ø���.
			}else {
				if(change == true) { // ���� ������ �ٲ������ a tag ����� table �ȿ� �ְ� change�� a �ʱ�ȭ�ϱ�.
					a += "'";
					table.add(removeI, a);
					a = "'";
					change = false;
				}
				removeI++; // remove�� �� �ø���.
			}
		}
	}
	
	public void setAttr() throws IOException { // atag�� �͵� ��������.
		Document doc = Jsoup.connect(url).get();
		Elements elemA = doc.select("table td.title"); // a tag��  td�� �� Ŭ������ title�� �͸� �޾ƿ���.
        String strA = elemA.html(); // jsoup�� �޼ҵ带 �̿��ؼ� html ��������.
        tableAHref = new ArrayList<String>(Arrays.asList(strA.split("\n"))); // enter�� �������� ������ ArrayList�� �ֱ�.
		
	}
	
	public ArrayList<String> getTable() throws IOException{ // table ��������.
		return table;
	}
	
	public ArrayList<String> getAttr() throws IOException{ // ���� table ��������.
		return tableAHref;
	}
	
}