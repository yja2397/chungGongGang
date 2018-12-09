package scrapy;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Crawl{
	
	ArrayList<String> table;
	ArrayList<String> tableA;
	ArrayList<String> tableAHref;
	String url;
	String name;
	
	public Crawl() {
	}
	
	public void setting(String name, String url) throws IOException {
		this.name = name;
		this.url = url;
		makeTable();
		setAttr();
		if(name == "cnu") {
			cnuTable();
		}else if(name == "dom") {
			domTable();
		}else if(name == "sw") {
			swTable();
		}else if(name == "com"){
			comTable();
		}else {
			table.add("�Խù��� �������� �ʽ��ϴ�.");
		}
		tableRemoveA();
	}
	
	public String printTable(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elem = doc.select("tbody");
        String str=elem.html();
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
        
        Elements elem2 = doc.select(".t_end");
        String str2 = elem2.html();
        ArrayList<String> strs = new ArrayList<String>(Arrays.asList(str2.split("&nbsp;")));
        
        for(int i = 0; i < strs.size(); i++) {
        	str.replace(strs.get(i), "");
        }
		return str;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	private void makeTable() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elem = doc.select("table");
        String str = elem.text();
        this.table = new ArrayList<String>(Arrays.asList(str.split(" ")));
        Elements elemA = doc.select("table a");
        String strA = elemA.text();
        this.tableA = new ArrayList<String>(Arrays.asList(strA.split(" ")));
        int j = 1;
        String removed;
        int size = tableA.size();
        for(int i = 0; i < size-1; i++) {
        	removed = tableA.get(j-1) + tableA.get(j);
        	if(removed.equals(tableA.get(j))) {
        		tableA.remove(j-1);
        	}else {
        		j++;
        	}
        	
        }
	}
	
	public void cnuTable() {
		for(int i=0; i<29; i++) {
			table.remove(0);
		}
	}
	
	public void domTable() {
		for(int i=0; i<10; i++) {
			table.remove(0);
		}
		for(int i=0; i<4; i++) {
			tableA.remove(0);
		}
		for(int i=0; i<4; i++) {
			tableAHref.remove(0);
		}
	}
	
	public void swTable() {
		for(int i=0; i<5; i++) {
			table.remove(0);
		}
	}
	
	public void comTable() {
		for(int i=0; i<11; i++) {
			table.remove(0);
		}
		for(int i=0; i<5; i++) {
			tableA.remove(0);
		}
		for(int i=0; i<5; i++) {
			tableAHref.remove(0);
		}
	}
	
	public void tableRemoveA() {
		int size = table.size();
		int j = 0;
		boolean change = false;
		int removeI = 0;
		String a = "'";
		for(int i=0; i<size; i++) {
			if(table.get(removeI).equals(tableA.get(j))) {
				change = true;
				a += tableA.get(j) + " ";
				table.remove(removeI);
				j++;
			}else {
				if(change == true) {
					a += "'";
					table.add(removeI, a);
					a = "'";
					change = false;
				}
				removeI++;
			}
		}
	}
	
	public void setAttr() throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements elemA = doc.select("table a");
        String strA = elemA.outerHtml();
        tableAHref = new ArrayList<String>(Arrays.asList(strA.split("\n")));
		
	}
	
	public ArrayList<String> getTable() throws IOException{
		return table;
	}
	
	public ArrayList<String> getAttr() throws IOException{
		return tableAHref;
	}
	
}