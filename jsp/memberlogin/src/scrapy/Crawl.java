package scrapy;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Crawl{
	
	ArrayList<String> table;
	ArrayList<String> tableA;
	String url;
	String name;
	
	public Crawl() {
	}
	
	public void setting(String name, String url) throws IOException {
		this.name = name;
		this.url = url;
		makeTable();
		if(name == "cnu") {
			cnuTable();
		}else if(name == "dom") {
			domTable();
		}else if(name == "sw") {
			swTable();
		}else if(name == "com"){
			comTable();
		}else {
			table.add("게시물이 존재하지 않습니다.");
		}
		tableRemoveA();
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
	
	public ArrayList<String> getTable() throws IOException{
		return table;
	}
	
}