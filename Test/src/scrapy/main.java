package scrapy;
import java.io.IOException;

public class main {
	public static void main(String args[]) throws IOException {
		/*Crawl cnu = new Crawl();
		cnu.setUrl("http://plus.cnu.ac.kr/_prog/_board/?code=sub07_070801&site_dvs_cd=kr&menu_dvs_cd=070801");
		System.out.println(cnu.getCnuPaginate());*/
		
		/*Crawl dom = new Crawl();
		dom.setting("dom","http://dorm.cnu.ac.kr/_prog/_board/?code=sub05_0501&site_dvs_cd=kr&menu_dvs_cd=0501");
		System.out.println(dom.getTable());
		System.out.println(dom.getAttr());
		*/
		
		/*Crawl sw = new Crawl();
		sw.printTable("http://wise.cnu.ac.kr/community/notice");
		System.out.println(sw.printStr("sw"));*/
		/*
		Crawl com = new Crawl();
		com.setting("com", "http://computer.cnu.ac.kr/index.php?mid=saccord");
		//System.out.println(com.getTable());
*/
		SaveData s = new SaveData();
		s.getList();
	}
}
