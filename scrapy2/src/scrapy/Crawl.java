package scrapy;
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Crawl{
	
	ArrayList<String> table;
	String url;
	
	public Crawl() {
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	private void makeTable() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elem = doc.select("tr");
        String str = elem.text();
        System.out.println(str);
        table = new ArrayList<String>(Arrays.asList(str.split(" ")));
	}
	
	public ArrayList<String> getTable() throws IOException{
		makeTable();
		return table;
	}
	
}