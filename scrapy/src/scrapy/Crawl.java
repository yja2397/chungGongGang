package scrapy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Crawl{
    public static void main(String[] args) throws Exception{
        String URL = "http://plus.cnu.ac.kr/_prog/_board/?code=sub07_070801&site_dvs_cd=kr&menu_dvs_cd=070801";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select("table");
        String str = elem.text();
        System.out.println(str);
    }
}